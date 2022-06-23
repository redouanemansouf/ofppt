package com.m2m.onousc.web.referentiel.mbean;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.text.DateFormat;
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
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.primefaces.event.FileUploadEvent;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.DetailProfilVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.web.commons.mbean.UtilsMBean;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.search.TourniquetSearchMBean;
import com.m2m.onousc.web.referentiel.webbean.PersonnelWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.SpecificParams;
import com.m2m.technicalservices.web.UserSessionHelper;

/**
 * The Class PersonnelMBean Author :msadik
 */
@ManagedBean
@ViewScoped
public class PersonnelMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8050066106750127207L;

	private PersonnelWebBean webBean;

	private String matrSearch;

	private static final String cipherTransformation = "AES/CBC/PKCS5PADDING";
	private static final String aesEncryptionAlgorithem = "AES";

	private String tramEncoding, tramVersionDll, tramPhoto;

	private PersonnelCriteria personnelCriteria;
	private String chemincarterectoapplet = "";
	private String chemincarteversoapplet = "";
	private String cheminrecupphotoapplet = "";
	private String cheminprotorectoapplet = "";
	private String cheminprotoversoapplet = "";
	private String cheminrectoServeur = "";
	private boolean show = false;
	List<String> params;
	private String dateExpiration, solde;

	ReferentielService referentielSrc = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	@ManagedProperty("#{tourniquetSearchMBean}")
	private TourniquetSearchMBean tourniquetSearchMBean;

	public void init() {
		personnelCriteria = new PersonnelCriteria();
		webBean = new PersonnelWebBean();
		webBean.setVillevos(referentielService.findAllVille());
		webBean.setCategorievos(referentielService
				.findAllCategoriePorteurForCombo());
		webBean.setProfilvos(referentielService.findAllCritereForCombo());
		webBean.setPerso("DISABLED");
		// webBean.setDetailProfilVOs(referentielService.findDetailProfilByprofil(webBean.getVo().getProfil().getLibelle()));

		// List<String> data = referentielService.getDataConnection();
		// chemincarterectoapplet = data.get(2);
		// chemincarteversoapplet = data.get(3);
		// cheminrecupphotoapplet = data.get(1);
		// cheminprotorectoapplet = data.get(5);
		// cheminprotoversoapplet = data.get(5);
		// cheminrectoServeur = data.get(7);
		// webBean.getVo().setCheminExePhoto(data.get(0));
		// webBean.getVo().setCheminEnregPhoto(data.get(1));
		// webBean.getVo().setCheminRecupPhoto(data.get(1));
		// webBean.getVo().setCheminRecupImage(data.get(1));
		// webBean.getVo().setCheminProtoRecto(data.get(5));
		// webBean.getVo().setCheminProtoVerso(data.get(5));
		// webBean.getVo().setCheminCarteRecto(data.get(2));
		// webBean.getVo().setCheminCarteVerso(data.get(2));
		// webBean.getVo().setCheminExeImpression(data.get(4));

	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new PersonnelVO());
	}

	public void showUpload() {
		show = true;
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<PersonnelVO>());
	}

	public void getdetailbyprofil() {
		System.out.println(webBean.getVo().getProfil().getCode());
		webBean.setDetailProfilVOs(referentielService
				.findDetailProfilByprofil(webBean.getVo().getProfil().getCode()));
	}

	/**
	 * Creer.
	 * 
	 * @throws IOException
	 */

	public void parcourir() throws IOException {
		Desktop.getDesktop().open(
				new File("C:\\Carte_OCP\\Photos_Porteurs\\Personnel"));
	}

	public void creer() {

		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		webBean.getVo().getDateNaissance();
		webBean.getVo().getDateExpiration();
		PersonnelVO prs = referentielService.findPersonnelByMatr(webBean.getVo().getMatr());
		if(webBean.getVo().getCategorie() != null && prs == null){
		error = delegate.creerPersonnel(webBean);
		}
		
		else if(webBean.getVo().getCategorie() == null)
		{
			error=true;
			FacesContext
			.getCurrentInstance()
			.addMessage(
					null,
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Champ profil est requis",
							null));


		}
		else if(prs != null)
		{
			error=true;
			FacesContext
			.getCurrentInstance()
			.addMessage(
					null,
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Matricule Doublons",
							null));
		}
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE", null);
			
			// resetWebBeanVO();
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
		error = referentielBusDelegate.modifierPersonnel(webBean);
		if (!isError()) {
			JSFUtils.contextExecute("_hideDialog()");
		}

		feedReport();
		resetWebBeanVO();
	}

	public void findPersonnelByMatr() {

		// String trancheLundi = "";
		// String trancheMardi = "";
		// String trancheMerdredi = "";
		// String trancheJeudi = "";
		// String trancheVendredi = "";
		// String trancheSamedi = "";
		// String trancheDimanche = "";
		// System.out.println("Matr :" + matrSearch);
		if (matrSearch != null) {
			// webBean.setVo(referentiel
			// Service.findCarteNapsByMatricule(matrSearch));
			CarteNapsVO mtr = referentielService
					.findCarteNapsByMatricule(matrSearch);
			PersonnelVO pvo = referentielService
					.findPersonnelByMatr(matrSearch);
			
			if (pvo != null) {
				webBean.getVo().setNom(pvo.getNom());
				webBean.getVo().setPrenom(pvo.getPrenom());
				webBean.getVo().setNumidentite(pvo.getNumidentite());
				webBean.getVo().setTelephone(pvo.getTelephone());
				webBean.getVo().setEtab(pvo.getEtab());
				webBean.getVo().setMatr(pvo.getMatr());
				webBean.getVo().setSexe(pvo.getSexe());
				webBean.getVo().setDateDeliv(pvo.getDateDeliv());
				webBean.getVo().setDateNaissance(pvo.getDateNaissance());
				webBean.getVo().setDateExpiration(pvo.getDateExpiration());
				webBean.getVo().setLieuNaissance(pvo.getLieuNaissance());
				webBean.getVo().setCategorie(pvo.getCategorie());
				webBean.getVo().setDateEmbauche(pvo.getDateEmbauche());
				webBean.getVo().setId(pvo.getId());
//				webBean.getVo().setNumcarte(UtilsMBean.displayCard(pvo.getNumcarte()));
				String hiddenNumCarte = UtilsMBean.displayCard(pvo.getNumCarte());
				 webBean.getVo().setNumCarte(hiddenNumCarte);
				/** SET STAT **/
				if (pvo.getStatut().getStatusCode().contains("ENABLED")) {
					webBean.setPerso("ENABLED");
				} else {
					webBean.setPerso("DISABLED");
				}

			} else if (pvo == null && mtr != null) {
				webBean.getVo().setNom(mtr.getNom());
				webBean.getVo().setPrenom(mtr.getPrenom());
				webBean.getVo().setNumidentite(mtr.getNumidentite());
				webBean.getVo().setTelephone(mtr.getTel());
				webBean.getVo().setEtab(mtr.getEtab());
				webBean.getVo().setMatr(mtr.getMatr());
				webBean.getVo().setNumCarte(UtilsMBean.displayCard(mtr.getNumcarte()));
				/** SET STAT **/
				webBean.setPerso("DISABLED");
			}

		}
		// if(webBean.getVo().getNumCarte()==null)
		// {
		// if (matrSearch.contains("H") || matrSearch.contains("A"))
		// webBean.getVo().setNumCarte(
		// 147851
		// + ""
		// + String.format("%010d",
		// webBean.getVo().getId()));
		// else
		// webBean.getVo().setNumCarte(
		// 147851
		// + ""
		// + String.format("%010d", webBean.getVo().getId()));
		// }
		// if (webBean.getVo().getProfil() != null) {
		// List<String> trancheLundiList = referentielSrc
		// .getTrancheByProfil("Lundi", webBean.getVo()
		// .getProfil().getId());
		// System.out.println(webBean.getVo().getProfil().getCode());
		// //
		// webBean.setDetailProfilVOs(referentielService.findDetailProfilByprofil(webBean.getVo().getProfil().getCode()));
		// for (String temp : trancheLundiList) {
		// trancheLundi += temp;
		// }
		//
		// List<String> trancheMardiiList = referentielSrc
		// .getTrancheByProfil("Mardi", webBean.getVo()
		// .getProfil().getId());
		// for (String temp : trancheMardiiList) {
		// trancheMardi += temp;
		// }
		// List<String> trancheMercrediList = referentielSrc
		// .getTrancheByProfil("Mercredi", webBean.getVo()
		// .getProfil().getId());
		// for (String temp : trancheMercrediList) {
		// trancheMerdredi += temp;
		// }
		// List<String> trancheJeudiList = referentielSrc
		// .getTrancheByProfil("Jeudi", webBean.getVo()
		// .getProfil().getId());
		// for (String temp : trancheJeudiList) {
		// trancheJeudi += temp;
		// }
		// List<String> trancheVendrediList = referentielSrc
		// .getTrancheByProfil("Vendredi", webBean.getVo()
		// .getProfil().getId());
		// for (String temp : trancheVendrediList) {
		// trancheVendredi += temp;
		// }
		// List<String> trancheSamediList = referentielSrc
		// .getTrancheByProfil("Samedi", webBean.getVo()
		// .getProfil().getId());
		// for (String temp : trancheSamediList) {
		// trancheSamedi += temp;
		// }
		// List<String> trancheDimancheList = referentielSrc
		// .getTrancheByProfil("Dimanche", webBean.getVo()
		// .getProfil().getId());
		// for (String temp : trancheDimancheList) {
		// trancheDimanche += temp;
		// }
		// System.out.println("Tranche Lundi:" + trancheLundi);
		// System.out.println("Tranche Mardi:" + trancheMardi);
		// System.out.println("Tranche Mercredi:" + trancheMerdredi);
		// System.out.println("Tranche Jeudi:" + trancheJeudi);
		// System.out.println("Tranche Vendredi:" + trancheVendredi);
		// webBean.getVo().setTranLundi(trancheLundi);
		// webBean.getVo().setTranMardi(trancheMardi);
		// webBean.getVo().setTranMercredi(trancheMerdredi);
		// webBean.getVo().setTranJeudi(trancheJeudi);
		// webBean.getVo().setTranVendredi(trancheVendredi);
		// webBean.getVo().setTranSamdi(trancheSamedi);
		// webBean.getVo().setTranDimanche(trancheDimanche);
		// }
		// }
		//
		// List<String> data = referentielService.getDataConnection();
		// chemincarterectoapplet = data.get(2);
		// chemincarteversoapplet = data.get(3);
		// cheminrecupphotoapplet = data.get(1);
		// cheminprotorectoapplet = data.get(5);
		// cheminprotoversoapplet = data.get(5);
		//
		// webBean.getVo().setCheminExePhoto(data.get(0));
		// webBean.getVo().setCheminEnregPhoto(data.get(1));
		// webBean.getVo().setCheminRecupPhoto(data.get(1));
		// webBean.getVo().setCheminRecupImage(data.get(1));
		// webBean.getVo().setCheminProtoRecto(data.get(5));
		// webBean.getVo().setCheminProtoVerso(data.get(5));
		// webBean.getVo().setCheminCarteRecto(data.get(2));
		// webBean.getVo().setCheminCarteVerso(data.get(2));
		// webBean.getVo().setCheminExeImpression(data.get(4));
	}

	// public void preparationCarte() {
	//
	// try {
	// List<String> data = referentielService.getDataConnection();
	// chemincarterectoapplet = data.get(2);
	// chemincarteversoapplet = data.get(3);
	// cheminrecupphotoapplet = data.get(1);
	// cheminprotorectoapplet = data.get(5);
	// cheminprotoversoapplet = data.get(5);
	// cheminrectoServeur = data.get(7);
	// webBean.getVo().setCheminExePhoto(data.get(0));
	// webBean.getVo().setCheminEnregPhoto(data.get(1));
	// webBean.getVo().setCheminRecupPhoto(data.get(1));
	// webBean.getVo().setCheminRecupImage(data.get(1));
	// webBean.getVo().setCheminProtoRecto(data.get(5));
	// webBean.getVo().setCheminProtoVerso(data.get(5));
	// webBean.getVo().setCheminCarteRecto(data.get(2));
	// webBean.getVo().setCheminCarteVerso(data.get(2));
	// webBean.getVo().setCheminExeImpression(data.get(4));
	//
	// String imageGenereRecto = null;
	// String imageGenereVerso = null;
	//
	// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	// String strDate = formatter.format(webBean.getVo()
	// .getDateNaissance());
	//
	// imageGenereRecto = chemincarterectoapplet
	// + "\\Carte_Personnel_Recto_" + webBean.getVo().getMatr()
	// + ".bmp";
	// imageGenereVerso = chemincarteversoapplet
	// + "\\Carte_Personnel_Verso_" + webBean.getVo().getMatr()
	// + ".bmp";
	//
	// String Recupphoto = cheminrecupphotoapplet + "\\"
	// + webBean.getVo().getMatr() + ".bmp";
	//
	// PreparationCarte pi = new PreparationCarte();
	//
	// if (webBean.getVo().getCategorie().getCode().equals("S")) {
	// if (webBean.getVo().getType().equals("A")) {
	// pi.PreparerImage(cheminprotorectoapplet
	// + "\\Prototype_PersonnelRA_Recto.bmp", Recupphoto,
	// imageGenereRecto, cheminprotoversoapplet
	// + "\\Prototype_PersonnelRA_Verso.bmp",
	// Recupphoto, imageGenereVerso);
	// } else {
	// if (webBean.getVo().getType().equals("R"))
	// pi.PreparerImage(cheminprotorectoapplet
	// + "\\Prototype_PersonnelReA_Recto.bmp",
	// Recupphoto, imageGenereRecto,
	// cheminprotoversoapplet
	// + "\\Prototype_PersonnelRA_Verso.bmp",
	// Recupphoto, imageGenereVerso);
	// else
	// pi.PreparerImage(cheminprotorectoapplet
	// + "\\Prototype_PersonnelSA_Recto.bmp",
	// Recupphoto, imageGenereRecto,
	// cheminprotoversoapplet
	// + "\\Prototype_PersonnelRA_Verso.bmp",
	// Recupphoto, imageGenereVerso);
	// }
	// } else {
	// if (webBean.getVo().getType().equals("A")) {
	// pi.PreparerImage(cheminprotorectoapplet
	// + "\\Prototype_PersonnelR_Recto.bmp", Recupphoto,
	// imageGenereRecto, cheminprotoversoapplet
	// + "\\Prototype_PersonnelR_Verso.bmp",
	// Recupphoto, imageGenereVerso);
	// } else {
	// if (webBean.getVo().getType().equals("R"))
	//
	// pi.PreparerImage(cheminprotorectoapplet
	// + "\\Prototype_PersonnelRe_Recto.bmp",
	// Recupphoto, imageGenereRecto,
	// cheminprotoversoapplet
	// + "\\Prototype_PersonnelR_Verso.bmp",
	// Recupphoto, imageGenereVerso);
	// else
	// pi.PreparerImage(cheminprotorectoapplet
	// + "\\Prototype_PersonnelS_Recto.bmp",
	// Recupphoto, imageGenereRecto,
	// cheminprotoversoapplet
	// + "\\Prototype_PersonnelR_Verso.bmp",
	// Recupphoto, imageGenereVerso);
	// }
	// }
	//
	// /*
	// * pi.ecrireInformations(300, 460, 29, 22,
	// * webBean.getVo().getMatr(),
	// * webBean.getVo().getNom()+" "+webBean.getVo() .getPrenom(),"" ,
	// * strDate, webBean.getVo().getLieuNaissance().getLibelle(), "");
	// */
	//
	// if (webBean.getVo().getType().equals("A"))
	// pi.ecrireRectoEtudiant(480, 230, 29, 28, webBean.getVo()
	// .getNom(), webBean.getVo().getPrenom(), webBean.getVo()
	// .getMatr(), "", "", "", "", "", "", "");
	//
	// else if (webBean.getVo().getType().equals("R"))
	// pi.ecrireRectoEtudiantR(480, 230, 29, 28, webBean.getVo()
	// .getNom(), webBean.getVo().getPrenom(), webBean.getVo()
	// .getMatr(), "", "", "", "", "", "", "");
	// else
	//
	// pi.ecrireRectoAdherentEnff(480, 230, 29, 28, webBean.getVo()
	// .getNom(), webBean.getVo().getPrenom(), webBean.getVo()
	// .getCni(), webBean.getVo().getFonction(), "", webBean
	// .getVo().getGestionDeleg(), webBean.getVo()
	// .getLieuNaissance().getLibelle(), "", "", "");
	//
	// pi.ecrireVersoPerso("", "", "", "");
	//
	// FacesMessage message = new FacesMessage(
	// "Préparation de la Carte Terminée");
	// FacesContext.getCurrentInstance().addMessage(null, message);
	//
	// } catch (Exception e) {
	//
	// FacesMessage message = new FacesMessage(
	// FacesMessage.SEVERITY_ERROR,
	// "Erreur Préparation de la Carte : " + e,
	// "Erreur Préparation de la Carte : " + e);
	// FacesContext.getCurrentInstance().addMessage(null, message);
	//
	// }
	//
	// }

	// public void preparationCarte1() {
	//
	// try {
	// List<String> data = referentielService.getDataConnection();
	//
	// chemincarterectoapplet = data.get(2);
	// chemincarteversoapplet = data.get(3);
	// cheminrecupphotoapplet = data.get(6);
	// cheminprotorectoapplet = data.get(5);
	// cheminprotoversoapplet = data.get(5);
	//
	// String imageGenereRecto = null;
	// String imageGenereVerso = null;
	//
	// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	// String strDate = formatter.format(webBean.getVo()
	// .getDateNaissance());
	//
	// imageGenereRecto = chemincarterectoapplet
	// + "\\Carte_Personnel_Recto_" + webBean.getVo().getMatr()
	// + ".bmp";
	// imageGenereVerso = chemincarteversoapplet
	// + "\\Carte_Personnel_Verso_" + webBean.getVo().getMatr()
	// + ".bmp";
	//
	// String Recupphoto = cheminrecupphotoapplet + "\\"
	// + webBean.getVo().getMatr() + ".bmp";
	//
	// PreparationCarte pi = new PreparationCarte();
	//
	// pi.PreparerImage(cheminprotorectoapplet
	// + "\\Prototype_Personnel_Recto.bmp", Recupphoto,
	// imageGenereRecto, cheminprotoversoapplet
	// + "\\Prototype_Personnel_Verso.bmp", Recupphoto,
	// imageGenereVerso);
	//
	// /*
	// * pi.ecrireInformations(300, 460, 29, 22,
	// * webBean.getVo().getMatr(),
	// * webBean.getVo().getNom()+" "+webBean.getVo() .getPrenom(),"" ,
	// * strDate, webBean.getVo().getLieuNaissance().getLibelle(), "");
	// */
	//
	// pi.ecrireRectoEtudiant(480, 460, 29, 28, webBean.getVo().getMatr(),
	// webBean.getVo().getNom(), webBean.getVo().getPrenom(), "",
	// "", strDate, webBean.getVo().getLieuNaissance()
	// .getLibelle(), "", "", "");
	//
	// pi.ecrireVersoPerso("", "", "", "");
	//
	// FacesMessage message = new FacesMessage(
	// "Préparation de la Carte Terminée");
	// FacesContext.getCurrentInstance().addMessage(null, message);
	//
	// } catch (Exception e) {
	//
	// FacesMessage message = new FacesMessage(
	// FacesMessage.SEVERITY_ERROR,
	// "Erreur Préparation de la Carte : " + e,
	// "Erreur Préparation de la Carte : " + e);
	// FacesContext.getCurrentInstance().addMessage(null, message);
	//
	// }
	//
	// }

	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		webBean.getSelectedVOs();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();

		error = delegate.modifierPersonnel(webBean);

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);

		}
		feedReport();
	}

	public void modifiermass() {
		clearReport();

		webBean.getVo().getCategorie();
		// webBean.getVo().getCategorie().getCode();
		// webBean.getVo().getCategorie().getLibelle();
		for (PersonnelVO personnelle : webBean.getSelectedVOs()) {
			personnelle.setCategorie(webBean.getVo().getCategorie());

			// personnelle.getCategorie().setCategorie(webBean.getCategoriecode());
			// personnelle.getCategorie().setCategorie(webBean.getVo().getCategorie());
			// webBean.getSelectedVOs().get(0).getCategorie().getCode();
			personnelle.getCategorie();

			ReferentielBusDelegate delegate = new ReferentielBusDelegate();

			delegate.modifierPersonnelMass(personnelle);

		}

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			
		}
		feedReport();
	}

	/**
	 * Activer.
	 */

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerPersonnel(webBean);
		if (error) {

		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}

	public void validerDem() {

		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.validatePersonnel(webBean);
		if (error) {

		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_VALIDATE", null);
		}
		feedReport();
		// System.out.println("Validate");
		List<String> data = referentielService.getDataConnection();
		chemincarterectoapplet = data.get(2);
		chemincarteversoapplet = data.get(3);
		cheminrecupphotoapplet = data.get(1);
		cheminprotorectoapplet = data.get(5);
		cheminprotoversoapplet = data.get(5);

		webBean.getVo().setCheminExePhoto(data.get(0));
		webBean.getVo().setCheminEnregPhoto(data.get(1));
		webBean.getVo().setCheminRecupPhoto(data.get(1));
		webBean.getVo().setCheminRecupImage(data.get(1));
		webBean.getVo().setCheminProtoRecto(data.get(5));
		webBean.getVo().setCheminProtoVerso(data.get(5));
		webBean.getVo().setCheminCarteRecto(data.get(2));
		webBean.getVo().setCheminCarteVerso(data.get(2));
		webBean.getVo().setCheminExeImpression(data.get(4));
	}

	public void validerDemOp() {

		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.validatePersonnelOp(webBean);
		if (error) {

		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_VALIDATE", null);
		}
		feedReport();
		// System.out.println("Validate");
		List<String> data = referentielService.getDataConnection();
		chemincarterectoapplet = data.get(2);
		chemincarteversoapplet = data.get(3);
		cheminrecupphotoapplet = data.get(1);
		cheminprotorectoapplet = data.get(5);
		cheminprotoversoapplet = data.get(5);

		webBean.getVo().setCheminExePhoto(data.get(0));
		webBean.getVo().setCheminEnregPhoto(data.get(1));
		webBean.getVo().setCheminRecupPhoto(data.get(1));
		webBean.getVo().setCheminRecupImage(data.get(1));
		webBean.getVo().setCheminProtoRecto(data.get(5));
		webBean.getVo().setCheminProtoVerso(data.get(5));
		webBean.getVo().setCheminCarteRecto(data.get(2));
		webBean.getVo().setCheminCarteVerso(data.get(2));
		webBean.getVo().setCheminExeImpression(data.get(4));
	}

	public void OnchangeProfil() {
		String trancheLu = "";
		String trancheMa = "";
		String trancheMe = "";
		String trancheJe = "";
		String trancheVe = "";
		String trancheSa = "";
		String trancheDi = "";
		System.out.println("code" + webBean.getVo().getProfil().getCode());
		webBean.setDetailProfilVOs(referentielService
				.findDetailProfilByprofil(webBean.getVo().getProfil().getCode()));

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

	// public void personnaliser() {
	//
	// clearReport();
	// ReferentielBusDelegate delegate = new ReferentielBusDelegate();
	// error = delegate.personnaliserPersonnel(webBean);
	// if (error) {
	//
	// } else {
	// addPrezMsgInfo("MESSAGE_SUCCESS_PERSONNALIS", null);
	// }
	// feedReport();
	//
	// // AppletWeb.lancerLectureElectrique(1);
	// }

	public void personnaliser() {

		clearReport();
		String tramString = webBean.getVo().getNumCarte() + "|"
				+ webBean.getVo().getId() + "|" + webBean.getVo().getNom()
				+ "|" + webBean.getVo().getMatr() + "|"
				+ webBean.getVo().getPrenom() + "|0|";

		tramEncoding = encrypt(tramString);

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
		// parameters.put("dataVEncoding", tramVersionEncoding);
		// parameters.put("dataVPrint", tramVersionPrint);
		// parameters.put("dataVDll", tramVersionDll);
		// parameters.put("dataVPrinterApp", tramVersionPrinterApp);
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
			// JSFUtils.contextExecute("_errorDialog()");
		} else {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.personnaliserPersonnel(webBean);
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

	private static String encrypt(String plainText) {
		String encryptedText = "";
		try {
			Cipher cipher;

			System.out.println(String.valueOf(cipherTransformation));
			cipher = Cipher.getInstance(cipherTransformation);

			KeyGenerator keyGen = KeyGenerator
					.getInstance(aesEncryptionAlgorithem);
			System.out.println(String.valueOf(aesEncryptionAlgorithem));
			keyGen.init(256); // for example
			SecretKey secretKey = keyGen.generateKey();
			Random rand = new SecureRandom();
			byte[] bytes = new byte[16];
			rand.nextBytes(bytes);
			IvParameterSpec ivSpec = new IvParameterSpec(bytes);
			System.out.println(String.valueOf(secretKey));
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
			System.out.println(String.valueOf(ivSpec));
			byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));

			encryptedText = Base64.encodeBase64String(cipherText) + "|"
					+ Base64.encodeBase64String(secretKey.getEncoded()) + "|"
					+ Base64.encodeBase64String(ivSpec.getIV());

		} catch (Exception E) {
			System.out.println("Encrypt Exception : " + E.getMessage());
		}
		return encryptedText;
	}

	public String retour() {
		return "/public/login.xhtml?faces-redirect=true";
	}

	public PersonnelWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(PersonnelWebBean webBean) {
		this.webBean = webBean;
	}

	public PersonnelCriteria getPersonnelCriteria() {
		return personnelCriteria;
	}

	public void setPersonnelCriteria(PersonnelCriteria personnelCriteria) {
		this.personnelCriteria = personnelCriteria;
	}

	public String getMatrSearch() {
		return matrSearch;
	}

	public void setMatrSearch(String matrSearch) {
		this.matrSearch = matrSearch;
	}

	public void recharger() {

		System.out.println("solde" + webBean.getVo().getSolde());

		System.out.println("matricule" + webBean.getVo().getMatricule());

		System.out.println("montant" + webBean.getVo().getMontant());

		referentielSrc.persisthisto(webBean.getVo().getMatricule(),
				Float.parseFloat(webBean.getVo().getMontant()),
				Float.parseFloat(webBean.getVo().getSolde()));

		/*
		 * clearReport(); ReferentielBusDelegate delegate = new
		 * ReferentielBusDelegate(); error =
		 * delegate.rechargerPersonnel(webBean); if (error) {
		 * 
		 * } else { addPrezMsgInfo("MESSAGE_SUCCESS_PERSONNALIS", null); }
		 * feedReport();
		 */

	}

	public static Date currentDate() {
		return DateUtil.currentDate();
	}

	public void decharger() {

		System.out.println("solde" + webBean.getVo().getSolde());

		webBean.getVo().setSolde(webBean.getVo().getSolde().replace(',', '.'));

		System.out.println("matricule" + webBean.getVo().getMatricule());

		System.out.println("montant" + webBean.getVo().getMontant());
		referentielSrc.persisthistoDecharge(webBean.getVo().getMatricule(),
				Float.parseFloat(webBean.getVo().getMontant()),
				Float.parseFloat(webBean.getVo().getSolde()));

	}

	public String getCheminrectoServeur() {
		return cheminrectoServeur;
	}

	public void setCheminrectoServeur(String cheminrectoServeur) {
		this.cheminrectoServeur = cheminrectoServeur;
	}

	public void upload(FileUploadEvent event) {
		/*
		 * FacesMessage msg = new FacesMessage(event.getFile().getFileName() +
		 * "  a été téléchargée avec succés", "");
		 * FacesContext.getCurrentInstance().addMessage(null, msg);
		 */
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());
			webBean.getVo().setImage(event.getFile().getFileName());

			File oldfile = new File(webBean.getVo().getCheminEnregPhoto()
					+ webBean.getVo().getImage());
			File newImage = new File(webBean.getVo().getCheminEnregPhoto()
					+ webBean.getVo().getMatr() + ".bmp");
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
			OutputStream out = new FileOutputStream(new File(webBean.getVo()
					.getCheminEnregPhoto() + fileName));

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

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public void lecture_Card() {
		String fichier = "C:\\Carte_OCP\\Divers\\Params.txt";
		params = new ArrayList<String>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {

			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				params.add(ligne);
			}

			br.close();

			webBean.getVo().setNumCarte(params.get(1).trim());
			webBean.getVo().setNom(params.get(3).trim());
			webBean.getVo().setPrenom(params.get(4).trim());
			webBean.getVo().setMatr(params.get(2).trim());
			setSolde(params.get(5).trim());
			setDateExpiration(params.get(7));
			webBean.setVo(referentielService.findPersonnelByMatr(params.get(2)
					.trim()));
			FacesMessage msg = new FacesMessage(
					"Lecture de Carte Personnel Terminée", "");
			File file = new File(fichier);
			file.delete();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void getTourniquet() {
		webBean.getSelectedTourniquets().clear();
		webBean.getSelectedTourniquets().addAll(
				webBean.getVo().getTourniquetVO());

		// referentielService.findPersonnelByMatr(webBean.getVo().getMatr());
	}

	public String getSolde() {
		return solde;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public TourniquetSearchMBean getTourniquetSearchMBean() {
		return tourniquetSearchMBean;
	}

	public void setTourniquetSearchMBean(
			TourniquetSearchMBean tourniquetSearchMBean) {
		this.tourniquetSearchMBean = tourniquetSearchMBean;
	}

	public void setstat(AjaxBehaviorEvent event) {
		System.out.println(webBean.getVo().getDateNaissance());
		webBean.getVo().getDateNaissance();
	}

	public void recupselect() {
		webBean.getSelectedVOs();
	}
	
	@Override
	protected boolean isAutorise() {
		return hasEcran(Constantes.CODE_ENROL_P);  
	}

}
