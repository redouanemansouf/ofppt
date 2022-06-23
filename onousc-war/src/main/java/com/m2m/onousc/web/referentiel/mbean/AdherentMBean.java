package com.m2m.onousc.web.referentiel.mbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.primefaces.event.FileUploadEvent;
import org.springframework.binding.message.Severity;

import com.m2m.onousc.business.referentiel.criteria.AdherentCriteria;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.transformer.AdherentVOTransformer;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.search.TourniquetSearchMBean;
import com.m2m.onousc.web.referentiel.webbean.AdherentWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.SpecificParams;
import com.m2m.technicalservices.web.UserSessionHelper;

/**
 * The Class PersonnelMBean.
 */
@ManagedBean
@ViewScoped
public class AdherentMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8050066106750127207L;

	private AdherentWebBean webBean;
	private String matrSearch;
	private AdherentCriteria adherentCriteria ;
	private String nomSearch,prenomSearch;
	private String chemincarterectoapplet = "";
	private String chemincarteversoapplet = "";
	private String cheminrecupphotoapplet="";
	private String cheminprotorectoapplet="";
	private String cheminprotoversoapplet="";
	private String cheminrectoServeur="";
	private String  solde;
	private String tramEncoding,tramVersionDll,tramPhoto;	

	private static final String cipherTransformation    = "AES/CBC/PKCS5PADDING";
    private static final String aesEncryptionAlgorithem = "AES";
   


	ReferentielService referentielSrc = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	
	public ReferentielSrvPresentation getReferentielService() {
		return referentielService;
	}

	public void setReferentielService(ReferentielSrvPresentation referentielService) {
		this.referentielService = referentielService;
	}

	public TourniquetSearchMBean getTourniquetSearchMBean() {
		return tourniquetSearchMBean;
	}

	public void setTourniquetSearchMBean(TourniquetSearchMBean tourniquetSearchMBean) {
		this.tourniquetSearchMBean = tourniquetSearchMBean;
	}

	@ManagedProperty("#{tourniquetSearchMBean}")
	private TourniquetSearchMBean tourniquetSearchMBean;

	public void init() {
		adherentCriteria=new  AdherentCriteria();
		webBean = new AdherentWebBean();
		webBean.setVillevos(referentielService.findAllVille());
		webBean.setCategorievos(referentielService
				.findAllCategoriePorteurForCombo());
		webBean.setPersonnelvos(referentielService.findAllPersonnel());
		webBean.setProfilvos(referentielService.findAllCritereForCombo());
		System.out.println("Size Personnel"+referentielService.findAllPersonnel().size());
		
		List<String> data = referentielService.getDataConnection();
		chemincarterectoapplet = data.get(2);
		chemincarteversoapplet = data.get(3);
		cheminrecupphotoapplet =data.get(1);
		cheminprotorectoapplet =data.get(5);
		cheminprotoversoapplet =data.get(5);
		cheminrectoServeur=data.get(7);
		webBean.getVo().setCheminExePhoto(data.get(0));
		webBean.getVo().setCheminEnregPhoto(data.get(1));
		webBean.getVo().setCheminRecupPhoto(data.get(1));
		webBean.getVo().setCheminRecupImage(data.get(1));
		webBean.getVo().setCheminProtoRecto(data.get(5));
		webBean.getVo().setCheminProtoVerso(data.get(5));
		webBean.getVo().setCheminCarteRecto(data.get(2));
		webBean.getVo().setCheminCarteVerso(data.get(2));
		webBean.getVo().setCheminExeImpression(data.get(4));
		
		// initialiser le serveur:port et idsession pour le demarage de l'exe
				HttpServletRequest origRequest = (HttpServletRequest) FacesContext
						.getCurrentInstance().getExternalContext().getRequest();
				webBean.setServerNameAndPort(origRequest.getServerName() + ":"
						+ origRequest.getServerPort() + origRequest.getContextPath());

				HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
						.getExternalContext().getSession(false);
				webBean.setjSessionID(session.getId());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new AdherentVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<AdherentVO>());
	}

	/**
	 * Creer.
	 * 
	 * @throws IOException
	 */
	public void creer()  {

		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.creerAdherent(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE", null);
			//resetWebBeanVO();
		}

		feedReport();


	}
	
	public void validerOpp()  {

		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.validateAdherentOp(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE", null);
			//resetWebBeanVO();
		}

		feedReport();


	}	
	
	public void creerTourniquet() {
		clearReport();
		ReferentielBusDelegate referentielBusDelegate = new ReferentielBusDelegate();
		webBean.setVo(webBean.getVo());
		webBean.getVo().getTourniquetVO().clear();
		webBean.getVo().getTourniquetVO()
				.addAll(webBean.getSelectedTourniquets());
		error = referentielBusDelegate.modifierAdherent(webBean);
		if (!isError()) {
			JSFUtils.contextExecute("_hideDialog()");
		}

		feedReport();
		resetWebBeanVO();
	}	

	public void findAdherentByMatr()
	{

		String trancheLundi = "";
		String trancheMardi = "";
		String trancheMerdredi = "";
		String trancheJeudi = "";
		String trancheVendredi = "";
		String trancheSamedi = "";
		String trancheDimanche = "";
		System.out.println("matrsearch"+matrSearch);

		if(matrSearch!=null && !matrSearch.equals(""))
		{
        webBean.setSolde(referentielService.findSoldeByMatricule(matrSearch));
		webBean.setVo(new AdherentVOTransformer().model2VO(referentielSrc.findAdherentByNom(matrSearch, nomSearch, prenomSearch)));
		List<AdherentVO> listNscol=new AdherentVOTransformer().model2VO(referentielSrc.findAdherentByAgeNscol(matrSearch));
	
		if(listNscol.size()>0)
		{
			addInfoMessage("adher.rule2", FacesMessage.SEVERITY_ERROR);
			
		}
		List<AdherentVO> listscol=new AdherentVOTransformer().model2VO(referentielSrc.findAdherentByAgescol(matrSearch));
		
		if(listscol.size()>0)
		{
			addInfoMessage("adher.rule3", FacesMessage.SEVERITY_ERROR);
			
		}
		
		//webBean.getVo().setNumCarte(147851 + ""
			//	+ String.format("%010d", Integer.parseInt(webBean.getVo().getMatr())));
		
		List<String> data = referentielService.getDataConnection();
		chemincarterectoapplet = data.get(2);
		chemincarteversoapplet = data.get(3);
		cheminrecupphotoapplet =data.get(1);
		cheminprotorectoapplet =data.get(5);
		cheminprotoversoapplet =data.get(5);
		cheminrectoServeur=data.get(7);
		webBean.getVo().setCheminExePhoto(data.get(0));
		webBean.getVo().setCheminEnregPhoto(data.get(1));
		webBean.getVo().setCheminRecupPhoto(data.get(1));
		webBean.getVo().setCheminRecupImage(data.get(1));
		webBean.getVo().setCheminProtoRecto(data.get(5));
		webBean.getVo().setCheminProtoVerso(data.get(5));
		webBean.getVo().setCheminCarteRecto(data.get(2));
		webBean.getVo().setCheminCarteVerso(data.get(2));
		webBean.getVo().setCheminExeImpression(data.get(4));
		System.out.println("VO"+webBean.getVo().getProfil());
		
		if(webBean.getVo().getNumCarte()==null)
		{
			webBean.getVo().setNumCarte(
					147851
							+ ""
							+ String.format("%010d", webBean.getVo().getId()));
		}
		
		if(webBean.getVo().getProfil()!=null)
		{
		List<String> trancheLundiList = referentielSrc.getTrancheByProfil(
				"Lundi", webBean.getVo().
				getProfil().getId());
		for (String temp : trancheLundiList) {
			trancheLundi += temp;
		}

		List<String> trancheMardiiList = referentielSrc.getTrancheByProfil(
				"Mardi", webBean.getVo().getProfil().getId());
		for (String temp : trancheMardiiList) {
			trancheMardi += temp;
		}
		List<String> trancheMercrediList = referentielSrc.getTrancheByProfil(
				"Mercredi", webBean.getVo().getProfil().getId());
		for (String temp : trancheMercrediList) {
			trancheMerdredi += temp;
		}
		List<String> trancheJeudiList = referentielSrc.getTrancheByProfil(
				"Jeudi", webBean.getVo().getProfil().getId());
		for (String temp : trancheJeudiList) {
			trancheJeudi += temp;
		}
		List<String> trancheVendrediList = referentielSrc.getTrancheByProfil(
				"Vendredi", webBean.getVo().getProfil().getId());
		for (String temp : trancheVendrediList) {
			trancheVendredi += temp;
		}
		List<String> trancheSamediList = referentielSrc.getTrancheByProfil(
				"Samedi", webBean.getVo().getProfil().getId());
		for (String temp : trancheSamediList) {
			trancheSamedi += temp;
		}
		List<String> trancheDimancheList = referentielSrc.getTrancheByProfil(
				"Dimanche", webBean.getVo().getProfil().getId());
		for (String temp : trancheDimancheList) {
			trancheDimanche += temp;
		}
		System.out.println("Tranche Lundi:" + trancheLundi);
		System.out.println("Tranche Mardi:" + trancheMardi);
		System.out.println("Tranche Mercredi:" + trancheMerdredi);
		System.out.println("Tranche Jeudi:" + trancheJeudi);
		System.out.println("Tranche Vendredi:" + trancheVendredi);
		webBean.getVo().setTranLundi(trancheLundi);
		webBean.getVo().setTranMardi(trancheMardi);
		webBean.getVo().setTranMercredi(trancheMerdredi);
		webBean.getVo().setTranJeudi(trancheJeudi);
		webBean.getVo().setTranVendredi(trancheVendredi);
		webBean.getVo().setTranSamdi(trancheSamedi);
		webBean.getVo().setTranDimanche(trancheDimanche);
		
		}
		}

	}

	public void OnchangeMatr()
	{
		int size=referentielService.findAdherentByPersonnel(webBean.getVo().getPersonnel().getId()).size()+1;
		System.out.println("size===="+size);
		webBean.getVo().setMatr(webBean.getVo().getPersonnel().getMatr()+"00"+size);

	}

	public void preparationCarte() {

		try {
			List<String> data = referentielService.getDataConnection();
			chemincarterectoapplet = data.get(2);
			chemincarteversoapplet = data.get(3);
			cheminrecupphotoapplet =data.get(1);
			cheminprotorectoapplet =data.get(5);
			cheminprotoversoapplet =data.get(5);
			cheminrectoServeur=data.get(7);
			webBean.getVo().setCheminExePhoto(data.get(0));
			webBean.getVo().setCheminEnregPhoto(data.get(1));
			webBean.getVo().setCheminRecupPhoto(data.get(1));
			webBean.getVo().setCheminRecupImage(data.get(1));
			webBean.getVo().setCheminProtoRecto(data.get(5));
			webBean.getVo().setCheminProtoVerso(data.get(5));
			webBean.getVo().setCheminCarteRecto(data.get(2));
			webBean.getVo().setCheminCarteVerso(data.get(2));
			webBean.getVo().setCheminExeImpression(data.get(4));

			String imageGenereRecto = null;
			String imageGenereVerso = null;
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(webBean.getVo().getDateNaissance());

			imageGenereRecto = chemincarterectoapplet
					+ "\\Carte_Personnel_Recto_" + webBean.getVo().getMatr()
					+ ".bmp";
			imageGenereVerso = chemincarteversoapplet
					+ "\\Carte_Personnel_Verso_" + webBean.getVo().getMatr()
					+ ".bmp";

			String Recupphoto = cheminrecupphotoapplet + "\\"
					+ webBean.getVo().getMatr() + ".bmp";

			PreparationCarte pi = new PreparationCarte();
			
			
			
			/* Début  SETATI Le 21/02/2017 */
			
			if(webBean.getVo().getPersonnel().getType().equals("A"))
			{	
				if(webBean.getVo().getCategorie().getCode().equals("S"))
				{
					if(webBean.getVo().getType().equals("C"))
					{
						
						if(webBean.getVo().getSexe().equals("M"))
							pi.PreparerImage(cheminprotorectoapplet
							+ "\\Prototype_PersonnelCMAA_Recto.bmp", Recupphoto,
							imageGenereRecto, cheminprotoversoapplet
							+ "\\Prototype_PersonnelRA_Verso.bmp", Recupphoto,
							imageGenereVerso);
						else
							pi.PreparerImage(cheminprotorectoapplet
							+ "\\Prototype_PersonnelCFAA_Recto.bmp", Recupphoto,
							imageGenereRecto, cheminprotoversoapplet
							+ "\\Prototype_PersonnelRA_Verso.bmp", Recupphoto,
							imageGenereVerso);						

					}
					else if (webBean.getVo().getType().equals("E"))
					{
							if(webBean.getVo().getSexe().equals("M"))
										pi.PreparerImage(cheminprotorectoapplet
										+ "\\Prototype_PersonnelEMAA_Recto.bmp", Recupphoto,
										imageGenereRecto, cheminprotoversoapplet
										+ "\\Prototype_PersonnelRA_Verso.bmp", Recupphoto,
										imageGenereVerso);
							
							else
										pi.PreparerImage(cheminprotorectoapplet
										+ "\\Prototype_PersonnelEFAA_Recto.bmp", Recupphoto,
										imageGenereRecto, cheminprotoversoapplet
										+ "\\Prototype_PersonnelRA_Verso.bmp", Recupphoto,
										imageGenereVerso);
					}
				}else{			
					if(webBean.getVo().getType().equals("C"))
					{
						
						if(webBean.getVo().getSexe().equals("M"))
							pi.PreparerImage(cheminprotorectoapplet
							+ "\\Prototype_PersonnelCMPA_Recto.bmp", Recupphoto,
							imageGenereRecto, cheminprotoversoapplet
							+ "\\Prototype_PersonnelR_Verso.bmp", Recupphoto,
							imageGenereVerso);
						else
							pi.PreparerImage(cheminprotorectoapplet
							+ "\\Prototype_PersonnelCFPA_Recto.bmp", Recupphoto,
							imageGenereRecto, cheminprotoversoapplet
							+ "\\Prototype_PersonnelR_Verso.bmp", Recupphoto,
							imageGenereVerso);	
						
					}
					else if (webBean.getVo().getType().equals("E"))
						{
							if(webBean.getVo().getSexe().equals("M"))
										pi.PreparerImage(cheminprotorectoapplet
										+ "\\Prototype_PersonnelEMPA_Recto.bmp", Recupphoto,
										imageGenereRecto, cheminprotoversoapplet
										+ "\\Prototype_PersonnelR_Verso.bmp", Recupphoto,
										imageGenereVerso);
							
							else
										pi.PreparerImage(cheminprotorectoapplet
										+ "\\Prototype_PersonnelEFPA_Recto.bmp", Recupphoto,
										imageGenereRecto, cheminprotoversoapplet
										+ "\\Prototype_PersonnelR_Verso.bmp", Recupphoto,
										imageGenereVerso);	
						}
				}
			}
			else
			{
				if(webBean.getVo().getCategorie().getCode().equals("S"))
				{
					if(webBean.getVo().getType().equals("C"))
					{
						
						if(webBean.getVo().getSexe().equals("M"))
							pi.PreparerImage(cheminprotorectoapplet
							+ "\\Prototype_PersonnelCMAR_Recto.bmp", Recupphoto,
							imageGenereRecto, cheminprotoversoapplet
							+ "\\Prototype_PersonnelRA_Verso.bmp", Recupphoto,
							imageGenereVerso);
						else
							pi.PreparerImage(cheminprotorectoapplet
							+ "\\Prototype_PersonnelCFAR_Recto.bmp", Recupphoto,
							imageGenereRecto, cheminprotoversoapplet
							+ "\\Prototype_PersonnelRA_Verso.bmp", Recupphoto,
							imageGenereVerso);						

					}
					else if (webBean.getVo().getType().equals("E"))
					{
							if(webBean.getVo().getSexe().equals("M"))
										pi.PreparerImage(cheminprotorectoapplet
										+ "\\Prototype_PersonnelEMAR_Recto.bmp", Recupphoto,
										imageGenereRecto, cheminprotoversoapplet
										+ "\\Prototype_PersonnelRA_Verso.bmp", Recupphoto,
										imageGenereVerso);
							
							else
										pi.PreparerImage(cheminprotorectoapplet
										+ "\\Prototype_PersonnelEFAR_Recto.bmp", Recupphoto,
										imageGenereRecto, cheminprotoversoapplet
										+ "\\Prototype_PersonnelRA_Verso.bmp", Recupphoto,
										imageGenereVerso);
					}
				}else{			
					if(webBean.getVo().getType().equals("C"))
					{
						
						if(webBean.getVo().getSexe().equals("M"))
							pi.PreparerImage(cheminprotorectoapplet
							+ "\\Prototype_PersonnelCMPR_Recto.bmp", Recupphoto,
							imageGenereRecto, cheminprotoversoapplet
							+ "\\Prototype_PersonnelR_Verso.bmp", Recupphoto,
							imageGenereVerso);
						else
							pi.PreparerImage(cheminprotorectoapplet
							+ "\\Prototype_PersonnelCFPR_Recto.bmp", Recupphoto,
							imageGenereRecto, cheminprotoversoapplet
							+ "\\Prototype_PersonnelR_Verso.bmp", Recupphoto,
							imageGenereVerso);	
						
					}
					else if (webBean.getVo().getType().equals("E"))
						{
							if(webBean.getVo().getSexe().equals("M"))
										pi.PreparerImage(cheminprotorectoapplet
										+ "\\Prototype_PersonnelEMPR_Recto.bmp", Recupphoto,
										imageGenereRecto, cheminprotoversoapplet
										+ "\\Prototype_PersonnelR_Verso.bmp", Recupphoto,
										imageGenereVerso);
							
							else
										pi.PreparerImage(cheminprotorectoapplet
										+ "\\Prototype_PersonnelEFPR_Recto.bmp", Recupphoto,
										imageGenereRecto, cheminprotoversoapplet
										+ "\\Prototype_PersonnelR_Verso.bmp", Recupphoto,
										imageGenereVerso);	
						}
				}				
			}
				
			/* Fin  SETATI Le 21/02/2017 */
						
			
			/*pi.ecrireInformations(300, 460, 29, 22, webBean.getVo().getMatr(), webBean.getVo().getNom()+" "+webBean.getVo()
					.getPrenom(),"" ,
					strDate, webBean.getVo().getLieuNaissance().getLibelle(), "");*/
			
			if(webBean.getVo().getType().equals("E"))
			 pi.ecrireRectoAdherentEnf(480, 230, 29, 28, webBean.getVo().getNom(), webBean.getVo().getPrenom(),webBean.getVo()
						.getPersonnel().getMatr(), "Enfant","",
						strDate, webBean.getVo().getLieuNaissance().getLibelle(), "","","");
			

		/*	else
				if(webBean.getVo().getType().equals("F"))
					pi.ecrireRectoAdherentEnf(480, 230, 29, 28, webBean.getVo().getNom(), webBean.getVo().getPrenom(),webBean.getVo()
							.getPersonnel().getMatr(), "Enfant","",
							strDate, webBean.getVo().getLieuNaissance().getLibelle(), "","","");*/
				else
				
				 pi.ecrireRectoAdherent(480, 230, 29, 28, webBean.getVo().getNom(), webBean.getVo().getPrenom(),webBean.getVo()
							.getPersonnel().getMatr(), "Conjoint","",
							"", "", "","","");
			
			
			pi.ecrireVersoPerso("", "", "",
					"");


			FacesMessage message = new FacesMessage(
					"Préparation de la Carte Terminée");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erreur Préparation de la Carte : " + e,
					"Erreur Préparation de la Carte : " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);

		}

	
		
	}
	
	public void OnchangeProfil() {
		String trancheLu = "";
		String trancheMa = "";
		String trancheMe = "";
		String trancheJe = "";
		String trancheVe = "";
		String trancheSa = "";
		String trancheDi = "";

		List<String> trancheLundiList = referentielSrc.getTrancheByProfil(
				"Lundi", webBean.getVo().getProfil().getId());
		List<String> trancheMardiiList = referentielSrc.getTrancheByProfil(
				"Mardi", webBean.getVo().getProfil().getId());
		List<String> trancheMercrediList = referentielSrc.getTrancheByProfil(
				"Mercredi", webBean.getVo().getProfil().getId());
		List<String> trancheJeudiList = referentielSrc.getTrancheByProfil(
				"Jeudi", webBean.getVo().getProfil().getId());
		List<String> trancheVendrediList = referentielSrc.getTrancheByProfil(
				"Vendredi", webBean.getVo().getProfil().getId());
		List<String> trancheSamediList = referentielSrc.getTrancheByProfil(
				"Samedi", webBean.getVo().getProfil().getId());
		List<String> trancheDimancheList = referentielSrc.getTrancheByProfil(
				"Dimanche", webBean.getVo().getProfil().getId());

		System.out.println("Tranche Lundi:" + trancheLu);
		for (String tempL : trancheLundiList) {
			trancheLu += tempL;
		}
		for (String tempMa : trancheMardiiList) {
			trancheMa += tempMa;
		}
		for (String tempMe : trancheMercrediList) {
			trancheMe += tempMe;
		}
		for (String tempJe : trancheJeudiList) {
			trancheJe += tempJe;
		}
		for (String tempVe : trancheVendrediList) {
			trancheVe += tempVe;
		}
		for (String tempSa : trancheSamediList) {
			trancheSa += tempSa;
		}

		for (String tempDi : trancheDimancheList) {
			trancheDi += tempDi;
		}
		System.out.println("Tranche Lundi:" + trancheLu);
		System.out.println("Tranche Mardi:" + trancheLu);
		System.out.println("Tranche Mercredi:" + trancheLu);
		System.out.println("Tranche Jeudi:" + trancheLu);
		System.out.println("Tranche Vendredi:" + trancheLu);
		System.out.println("Tranche Samedi:" + trancheLu);
		System.out.println("Tranche Dimanche:" + trancheLu);

		webBean.getVo().setTranLundi(trancheLu);
		webBean.getVo().setTranMardi(trancheMa);
		webBean.getVo().setTranMercredi(trancheMe);
		webBean.getVo().setTranJeudi(trancheJe);
		webBean.getVo().setTranVendredi(trancheVe);
		webBean.getVo().setTranSamdi(trancheSa);
		webBean.getVo().setTranDimanche(trancheDi);

	}
	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.modifierAdherent(webBean);

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);

		}
		feedReport();
	}
	
	public void upload(FileUploadEvent event) {
		List<String> data = referentielService.getDataConnection();
		chemincarterectoapplet = data.get(2);
		chemincarteversoapplet = data.get(3);
		cheminrecupphotoapplet =data.get(1);
		cheminprotorectoapplet =data.get(5);
		cheminprotoversoapplet =data.get(5);
		cheminrectoServeur=data.get(7);
		webBean.getVo().setCheminExePhoto(data.get(0));
		webBean.getVo().setCheminEnregPhoto(data.get(1));
		webBean.getVo().setCheminRecupPhoto(data.get(1));
		webBean.getVo().setCheminRecupImage(data.get(1));
		webBean.getVo().setCheminProtoRecto(data.get(5));
		webBean.getVo().setCheminProtoVerso(data.get(5));
		webBean.getVo().setCheminCarteRecto(data.get(2));
		webBean.getVo().setCheminCarteVerso(data.get(2));
		webBean.getVo().setCheminExeImpression(data.get(4));
		try {
			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());
			webBean.getVo().setImage(event.getFile().getFileName());
			
			File oldfile = new File(webBean.getVo().getCheminEnregPhoto() + webBean.getVo().getImage());
			File newImage = new File(webBean.getVo().getCheminEnregPhoto() + webBean.getVo().getMatr()
					+ ".bmp");
			oldfile.renameTo(newImage);
			FacesMessage msg = new FacesMessage(event.getFile().getFileName()
			+ "  a été téléchargée avec succés", "");
	         FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		
		public void copyFile(String fileName, InputStream in) {
			try {

				// write the inputStream to a FileOutputStream
				OutputStream out = new FileOutputStream(new File(webBean.getVo().getCheminEnregPhoto()
						+ fileName));

				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = in.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}

				in.close();
				out.flush();
				out.close();

				System.out.println("New file created!");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	/**
	 * Activer.
	 */

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerAdherent(webBean);
		if (error) {

		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}

	public void valider() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.validateAdherent(webBean);
		if (error) {

		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_VALIDATE", null);
		}
		feedReport();
	}

	
	
	private static String encrypt(String plainText) {
        String encryptedText = "";
        try {
        	Cipher cipher;
       
        	System.out.println(String.valueOf(cipherTransformation) );
        	cipher  = Cipher.getInstance(cipherTransformation);
       
      
            KeyGenerator keyGen = KeyGenerator.getInstance(aesEncryptionAlgorithem);
            System.out.println(String.valueOf(aesEncryptionAlgorithem) );
            keyGen.init(256); // for example
            SecretKey secretKey = keyGen.generateKey();
            Random rand = new SecureRandom();
            byte[] bytes = new byte[16];
            rand.nextBytes(bytes);
            IvParameterSpec ivSpec = new IvParameterSpec(bytes);
            System.out.println(String.valueOf(secretKey) );
             cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
             System.out.println(String.valueOf(ivSpec) );
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
             
             encryptedText = Base64.encodeBase64String(cipherText)+"|"+Base64.encodeBase64String(secretKey.getEncoded())+"|"+Base64.encodeBase64String(ivSpec.getIV());

        } catch (Exception E) {
             System.out.println("Encrypt Exception : "+E.getMessage());
        }
        return encryptedText;
    }

	public void personnaliser() {

		clearReport();
		
		
		
		/********************************************************************************
		 * 
		 */
		
		
		
		/********************************************************************************
		 * 
		 */
		
//		String tramString =webBean.getVo().getNumCarte()+"|"
//				+webBean.getVo().getId()+"|"+webBean.getVo().getNom()+"|"+webBean.getVo().getPrenom()+"|0|";
				/* +webBean.getVo().getEmail()+"|"+webBean.getVo().getNCIN()+"|"
				+webBean.getVo().getCodeMassar()+"|"+webBean.getVo().getHandicape()+"|||"
				+webBean.getVo().getRestaurantVO().getCode()+"|"+webBean.getVo().getCitovo().getLibelle()+"|"
				+webBean.getVo().getRestaurantVO().getLibelle()+"|"+webBean.getVo().getCitovo().getCode()+"|"
				+webBean.getVo().getAnneeUniversitaireVO().getLibelle()+"|"
				+webBean.getVo().getAnneeUniversitaireVO().getDate_fin()+"|"
				+cheminexeimpression+"|"+chemincarteverso+"|"+chemincarterecto+"|"+cheminftp+"|"+userftp+"|"+passftp+"|"
				+"";*/
		String tramString =webBean.getVo().getNumCarte()+"|"
				+webBean.getVo().getId()+"|"+webBean.getVo().getNom()+"|"+webBean.getVo().getMatr()+"|"+webBean.getVo().getPrenom()+"|0|";
		
		
		
		
		 tramEncoding =encrypt(tramString);

		// initialisation des paramètres de communication
		UserSessionHelper.putSpecificParam(SpecificParams.DATA_TO_SEND, null);
		UserSessionHelper.putSpecificParam(SpecificParams.CARD_UID, null);
		UserSessionHelper.putSpecificParam(SpecificParams.STATE_FINISHED, null);
		UserSessionHelper.putSpecificParam(SpecificParams.ERROR_MESSAGE, null);
		UserSessionHelper.putSpecificParam(SpecificParams.READY, null);

		JSONObject jsonData = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> parameterData = new HashMap<String, Object>();

		parameters.put("operation", "PRINT");
		parameters.put("data", tramEncoding);
//		parameters.put("dataVEncoding", tramVersionEncoding);
//		parameters.put("dataVPrint", tramVersionPrint);
//		parameters.put("dataVDll", tramVersionDll);
//		parameters.put("dataVPrinterApp", tramVersionPrinterApp);
//		  
		
		parameterData = new HashMap<String, Object>(parameters);
		jsonArray.put(parameterData);
		try {
			jsonData.put("data", jsonArray);
		} catch (JSONException e) {
			System.out.println("prepare json error: " + e);
		}

		UserSessionHelper.putSpecificParam(
				SpecificParams.DATA_TO_SEND,
				jsonData.toString().replaceAll("\"", "%22")
						.replaceAll(" ", "%20"));

		UserSessionHelper.putSpecificParam(SpecificParams.READY, true);

		UserSessionHelper
				.putSpecificParam(SpecificParams.STATE_FINISHED, false);
	 	while (!(Boolean) UserSessionHelper
				.getSpecificParam(SpecificParams.STATE_FINISHED)) {
			try {
				TimeUnit.MILLISECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.out.println("doPost error :" + e);
			}
		}
	 	
	 	if (UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE) != null) {

			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					(String) UserSessionHelper
							.getSpecificParam(SpecificParams.ERROR_MESSAGE),
					(String) UserSessionHelper
							.getSpecificParam(SpecificParams.ERROR_MESSAGE));
			FacesContext.getCurrentInstance().addMessage(null, message);
			//JSFUtils.contextExecute("_errorDialog()");
		}else{
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.personnaliserAdherent(webBean);
		if (error) {

		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_PERSONNALIS", null);
		}
		}
		
		
		
		
		
		
		
		
		/********************************************************************************
		 * 
		 */
		
		
		
		feedReport();

		// AppletWeb.lancerLectureElectrique(1);
	}

	
	public void getTourniquet() {
		webBean.getSelectedTourniquets().clear();
		webBean.getSelectedTourniquets().addAll(
				webBean.getVo().getTourniquetVO());

		// referentielService.findPersonnelByMatr(webBean.getVo().getMatr());
	}
	
	public String retour() {
		return "/public/login.xhtml?faces-redirect=true";
	}

	public AdherentWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(AdherentWebBean webBean) {
		this.webBean = webBean;
	}

	public String getMatrSearch() {
		return matrSearch;
	}

	public void setMatrSearch(String matrSearch) {
		this.matrSearch = matrSearch;
	}

	public AdherentCriteria getAdherentCriteria() {
		return adherentCriteria;
	}

	public void setAdherentCriteria(AdherentCriteria adherentCriteria) {
		this.adherentCriteria = adherentCriteria;
	}

	public String getPrenomSearch() {
		return prenomSearch;
	}

	public void setPrenomSearch(String prenomSearch) {
		this.prenomSearch = prenomSearch;
	}

	public String getNomSearch() {
		return nomSearch;
	}

	public void setNomSearch(String nomSearch) {
		this.nomSearch = nomSearch;
	}


	public static Date currentDate(){ 
		return DateUtil.currentDate();
	}

	public String getChemincarterectoapplet() {
		return chemincarterectoapplet;
	}

	public void setChemincarterectoapplet(String chemincarterectoapplet) {
		this.chemincarterectoapplet = chemincarterectoapplet;
	}

	public String getChemincarteversoapplet() {
		return chemincarteversoapplet;
	}

	public void setChemincarteversoapplet(String chemincarteversoapplet) {
		this.chemincarteversoapplet = chemincarteversoapplet;
	}

	public String getCheminrecupphotoapplet() {
		return cheminrecupphotoapplet;
	}

	public void setCheminrecupphotoapplet(String cheminrecupphotoapplet) {
		this.cheminrecupphotoapplet = cheminrecupphotoapplet;
	}

	public String getCheminprotorectoapplet() {
		return cheminprotorectoapplet;
	}

	public void setCheminprotorectoapplet(String cheminprotorectoapplet) {
		this.cheminprotorectoapplet = cheminprotorectoapplet;
	}

	public String getCheminprotoversoapplet() {
		return cheminprotoversoapplet;
	}

	public void setCheminprotoversoapplet(String cheminprotoversoapplet) {
		this.cheminprotoversoapplet = cheminprotoversoapplet;
	}

	public String getCheminrectoServeur() {
		return cheminrectoServeur;
	}

	public void setCheminrectoServeur(String cheminrectoServeur) {
		this.cheminrectoServeur = cheminrectoServeur;
	}

	public String getSolde() {
		return solde;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	public String getTramEncoding() {
		return tramEncoding;
	}

	public void setTramEncoding(String tramEncoding) {
		this.tramEncoding = tramEncoding;
	}

	public String getTramVersionDll() {
		return tramVersionDll;
	}

	public void setTramVersionDll(String tramVersionDll) {
		this.tramVersionDll = tramVersionDll;
	}

	public String getTramPhoto() {
		return tramPhoto;
	}

	public void setTramPhoto(String tramPhoto) {
		this.tramPhoto = tramPhoto;
	}


}
