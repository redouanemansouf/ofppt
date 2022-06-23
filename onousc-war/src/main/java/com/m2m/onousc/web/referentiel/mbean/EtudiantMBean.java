package com.m2m.onousc.web.referentiel.mbean;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.security.SecureRandom;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.ParametreGeneralVO;
import com.m2m.onousc.business.referentiel.vo.PlafondVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.onousc.web.commons.DimensionCarte;
import com.m2m.onousc.web.commons.PreparerImage;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CarteWebBean;
import com.m2m.onousc.web.referentiel.webbean.EtudiantWebBean;
import com.m2m.onousc.web.reservation.ReservationSrvPresentation;
import com.m2m.technicalservices.core.User;
import com.m2m.technicalservices.reporting.ReportSpecification;
import com.m2m.technicalservices.reporting.ReportType;
import com.m2m.technicalservices.reporting.impl.JasperReportExporter;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.tools.StringUtils;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.SpecificParams;
import com.m2m.technicalservices.web.UserSession;
import com.m2m.technicalservices.web.UserSessionHelper;

/**
 * The Class CanalVenteMBean.
 */
@ManagedBean
@ViewScoped
public class EtudiantMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1733777706292548410L;
	/** The web bean. */
	private EtudiantWebBean webBean;

	private UploadedFile uploadedFile;
	public BufferedImage prototypeRecto;
	public BufferedImage prototypeVerso;
	private EtudiantCriteria etudiantCriteria;
	private Integer lengthTab = 0;
	private Long nbrDemande;
	private DimensionCarte  dimension ;
	private DimensionCarte  dimensionNAPS ;
//	@ManagedProperty("#{etudiantSearchMBean}")
//	private EtudiantSearchMBean etudiantSearchMBean;

	private static final String cipherTransformation = "AES/CBC/PKCS5PADDING";
	private static final String aesEncryptionAlgorithem = "AES";

	private String tramEncoding, tramVersionDll, tramPhoto;
	private String tramVersionPrint;
	private String cheminexeimpression, chemincarteverso, chemincarterecto, versionDllEncoding, cheminftp, userftp,
			passftp, portftp, cheminftpPhoto, versionExePrint, versionExeEncoding, cheminexeEncoding,
			versionExePrinterApp;

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	private String tramVersionEncoding, tramVersionPrinterApp;
	//private String destination = "C:\\Carte_UCAD\\Photos_Porteurs\\Etudiants\\";
	private String destination = "/opt/Carte_UCAD/Photos_Porteurs/Etudiants/";

	private StreamedContent streamedContent;

	ReservationSrvPresentation reservationService = (ReservationSrvPresentation) BeansLookuper
			.lookup("reservationSrvPresentation");
	private String nomImage;
	private String statImage;
	private CarteWebBean carteWebBean;

	public void init() { 
	 
		 
		ParametreGeneralVO pram1 = referentielService.findParametreGeneralByCode("0009").get(0);
		ParametreGeneralVO pram2 = referentielService.findParametreGeneralByCode("0010").get(0);
		
		String XYName = referentielService.findParametreGeneralByCode("0063").get(0).getValeur();
		String HWphoto = referentielService.findParametreGeneralByCode("0064").get(0).getValeur();
		String XYphoto = referentielService.findParametreGeneralByCode("0067").get(0).getValeur();
		String XYdate = referentielService.findParametreGeneralByCode("0068").get(0).getValeur();
		String XYImat = referentielService.findParametreGeneralByCode("0066").get(0).getValeur();
		String XYExpdate = referentielService.findParametreGeneralByCode("0065").get(0).getValeur();
		
		
		  dimension = new DimensionCarte();
		  dimensionNAPS = new DimensionCarte();
		dimension.setXYName( XYName.trim().split("\\|")[0]);
		dimension.setHWphoto( HWphoto.trim().split("\\|")[0]);
		dimension.setXYphoto( XYphoto.trim().split("\\|")[0]);
		dimension.setXYdate( XYdate.trim().split("\\|")[0]); 
		dimension.setXYImat( XYImat.trim().split("\\|")[0]);
		dimension.setXYExpdate( XYExpdate.trim().split("\\|")[0]);
		
		//DimensionCarte dimension = new DimensionCarte();
		dimensionNAPS.setXYName( XYName.trim().split("\\|")[1]);
		dimensionNAPS.setHWphoto( HWphoto.trim().split("\\|")[1]);
		dimensionNAPS.setXYphoto( XYphoto.trim().split("\\|")[1]);
		dimensionNAPS.setXYdate( XYdate.trim().split("\\|")[1]);
		dimensionNAPS.setXYImat( XYImat.trim().split("\\|")[1]);
		dimensionNAPS.setXYExpdate( XYExpdate.trim().split("\\|")[1]);
		 	
		
		webBean = new EtudiantWebBean();
		webBean.setVilleVOs(referentielService.findAllVille());
		webBean.setListCategoriePorteurForCombo(referentielService.findAllCategoriePorteurForCombo());
		// webBean.setCiteVOs(referentielService.findAllCiteForCombo());CategoriePorteur
		webBean.setListSiteForCombo(referentielService.findAllSite());
		webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
		webBean.setRevenuVO(referentielService.findNoteCritereByCodeCritere(pram1.getValeur()));
		webBean.setNbreEnfentsVO(referentielService.findNoteCritereByCodeCritere(pram2.getValeur()));
		webBean.setAnneUniversitaireVO(referentielService.findActuelAnneeUniversitaire());

		cheminexeimpression = "C:/Carte_UCAD/Exe_Impression";
		chemincarteverso = referentielService.findParametreGeneralByCode("0050").get(0).getValeur();
		chemincarterecto = referentielService.findParametreGeneralByCode("0050").get(0).getValeur();
		cheminftp = referentielService.findParametreGeneralByCode("0051").get(0).getValeur();
		userftp = referentielService.findParametreGeneralByCode("0052").get(0).getValeur();
		passftp = referentielService.findParametreGeneralByCode("0053").get(0).getValeur();
		portftp = referentielService.findParametreGeneralByCode("0054").get(0).getValeur();
		versionExePrint = referentielService.findParametreGeneralByCode("0056").get(0).getValeur();
		versionExeEncoding = referentielService.findParametreGeneralByCode("0057").get(0).getValeur();
		versionExePrinterApp = referentielService.findParametreGeneralByCode("0060").get(0).getValeur();
		cheminexeEncoding = referentielService.findParametreGeneralByCode("0058").get(0).getValeur();
		versionDllEncoding = referentielService.findParametreGeneralByCode("0059").get(0).getValeur();

		UserSession userSession = (UserSession) JSFUtils.getSession("userSession");
		UserEntityVO groupename = referentielService.findUserByCode(userSession.getUserConecte().getCode());
//    	String groupa = groupe.
		webBean.setGroupe(groupename.getGroupname());

		// initialiser le serveur:port et idsession pour le demarage de l'exe
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		webBean.setServerNameAndPort(
				origRequest.getServerName() + ":" + origRequest.getServerPort() + origRequest.getContextPath());

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		webBean.setjSessionID(session.getId());

		cheminftpPhoto = referentielService.findParametreGeneralByCode("0055").get(0).getValeur();

//		if (JSFUtils.getRequestURI().contains("renouvellement/listerDemande.xhtml")) {
//
//			this.etudiantSearchMBean.getEtudiantCriteria().setStatus("PERSONALIZED");
//
//			this.setNbrDemande(referentielService.findNbreEtudiantByStatust(EntityStatus.PERSONALIZED));
//
//			// this.etudiantSearchMBean.getEtudiantCriteria().setRenouvellement(true);
//		} else {
//			this.etudiantSearchMBean.getEtudiantCriteria().setStatus("ENABLED");
//			this.setNbrDemande(referentielService.findNbreEtudiantByStatust(EntityStatus.ENABLED));
//
//			//this.etudiantSearchMBean.getEtudiantCriteria().setRenouvellement(false);
//		}
		UserSessionHelper.putSpecificParam(SpecificParams.DATA_TO_SEND, null);
		UserSessionHelper.putSpecificParam(SpecificParams.CARD_UID, null);
		UserSessionHelper.putSpecificParam(SpecificParams.STATE_FINISHED, true);
		UserSessionHelper.putSpecificParam(SpecificParams.ERROR_MESSAGE, " ");
		UserSessionHelper.putSpecificParam(SpecificParams.READY, null);
		UserSessionHelper.putSpecificParam("CONTINUE", Integer.valueOf(1));
		carteWebBean = new CarteWebBean();
		// this.webBean.getVo().setRenouvellement(true);
		if (JSFUtils.getRequestURI().contains("enrolement_carte/listerDmdEnCours.xhtml")) {
			this.setNbrDemande(referentielService.findNbreEtudiantByStatust(EntityStatus.ENABLED));
		} else if (JSFUtils.getRequestURI().contains("enrolement_carte/listerDmdValidees.xhtml"))
			this.setNbrDemande(referentielService.findNbreEtudiantByStatust(EntityStatus.VALIDATED));
		else if (JSFUtils.getRequestURI().contains("enrolement_carte/listerDmdAnnulees.xhtml"))
			this.setNbrDemande(referentielService.findNbreEtudiantByStatust(EntityStatus.DELETED));

	}
	public void updatePhoto() {
		clearReport();

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

		parameters.put("operation", "IMG");
		parameters.put("data", webBean.getVo().getId());
		parameters.put("dataVEncoding", tramVersionEncoding);
		parameters.put("dataVPrint", tramVersionPrint);
		parameters.put("dataVDll", tramVersionDll);
		parameters.put("dataVPrinterApp", tramVersionPrinterApp);
		
		
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
	 	
	 	
	 	// gerer les erreurs en provonance de l'exe

	 	
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		
		webBean.getVo().setImage("" + webBean.getVo().getId() + ".jpg");
		error = delegate.modifierEtudiant(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_PHOTO", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new EtudiantVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<EtudiantVO>());
	}

	/**
	 * Creer.
	 * 
	 * @throws IOException
	 */
	public void creer() throws IOException {
		User user = new User(String.valueOf(webBean.getVo().getId()), webBean.getVo().getNCIN());
		UserSession userSesion = new UserSession();
		userSesion.setUserConecte(user);
		JSFUtils.putSession("userSession", userSesion);
		userSession = (UserSession) JSFUtils.getSession("userSession");
		clearReport();
		webBean.getVo().setAnneeUniversitaireVO(webBean.getAnneUniversitaireVO());
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.creerEtudiant(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_CREATE", null);
			File oldfile = new File(destination + webBean.getVo().getImage());
			File newImage = new File(destination + webBean.getVo().getId() + ".jpg");
			oldfile.renameTo(newImage);
			// generateReport();

			// JSFUtils.contextExecute("_hideDialog()");
		}

		feedReport();
		userSession.setUserConecte(null);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getSessionMap().clear();
		// resetWebBeanVO();

	}

	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.modifierEtudiant(webBean);
		File oldfile = new File(destination + webBean.getVo().getImage());
		if (oldfile.exists()) {
			File newImage = new File(destination + webBean.getVo().getId() + ".jpg");
			newImage.delete();
			oldfile.renameTo(new File(destination + webBean.getVo().getId() + ".jpg"));
		}

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Activer.
	 */

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerEtudiant(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
		}
		feedReport();
	}

	public void supprimerCollection() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.supprimerCollectionEtudiant(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_DELETE", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	public void validerCollectionEtudiant() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		//String photo = "C:\\Carte_UCAD\\Photos_Porteurs\\Etudiants\\" + this.webBean.getVo().getId() + ".jpg";
		String photo = "/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + this.webBean.getVo().getId() + ".jpg";

		File f = new File(photo);
		if (f.exists()) {
			this.error = delegate.validateEtudiant(webBean);
			if (this.error) {
				addInfoMessage("PHOTO_ERROR", FacesMessage.SEVERITY_ERROR);
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_VALIDATE", null);
			}
		} else {
			addInfoMessage("PHOTO_ERROR", FacesMessage.SEVERITY_ERROR);

		}

		feedReport();
	}

	public void upload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage(event.getFile().getFileName() + "  a été téléchargée avec succés", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
			webBean.getVo().setImage(event.getFile().getFileName());
			this.nomImage = event.getFile().getFileName();
			if (this.nomImage != null) {
				this.statImage = "Photo téléchargée";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void valider() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();

		File f = new File(destination + webBean.getVo().getId() + ".jpg");
		if (f.exists()) {
			this.error = delegate.validateEtudiant(this.webBean);
			if (this.error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_VALIDATE", null);
			}
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Probléme de Photo",
					"Probléme de Photo");
			FacesContext.getCurrentInstance().addMessage(null, message);
			error = true;
		}
		feedReport();
	}

	public void validerRnv() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.validateEtudiantRNV(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_VALIDATE", null);
		}
		feedReport();
	}

	public void annuler() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.desactiverEtudiant(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_DISABLE", null);
		}
		feedReport();
	}

	public void personnaliser() {
		clearReport();

		// initialisation des paramètres de communication
		UserSessionHelper.putSpecificParam(SpecificParams.DATA_TO_SEND, null);
		UserSessionHelper.putSpecificParam(SpecificParams.CARD_UID, null);
		UserSessionHelper.putSpecificParam(SpecificParams.STATE_FINISHED, null);
		UserSessionHelper.putSpecificParam(SpecificParams.ERROR_MESSAGE, null);
		UserSessionHelper.putSpecificParam(SpecificParams.READY, null);
		UserSessionHelper.putSpecificParam("CONTINUE", Integer.valueOf(1));
		JSONObject jsonData = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> parameterData = new HashMap<String, Object>();

		parameters.put("operation", "PRINT");
		parameters.put("data", tramEncoding);
		parameters.put("dataVEncoding", tramVersionEncoding);
		parameters.put("dataVPrint", tramVersionPrint);
		parameters.put("dataVDll", tramVersionDll);
		parameters.put("dataVPrinterApp", tramVersionPrinterApp);

		prepareCarte();
		parameterData = new HashMap<String, Object>(parameters);
		jsonArray.put(parameterData);
		try {
			jsonData.put("data", jsonArray);
		} catch (JSONException e) {
			System.out.println("prepare json error: " + e);
		}

		UserSessionHelper.putSpecificParam(SpecificParams.DATA_TO_SEND,
				jsonData.toString().replaceAll("\"", "%22").replaceAll(" ", "%20"));

		UserSessionHelper.putSpecificParam(SpecificParams.READY, true);

		UserSessionHelper.putSpecificParam(SpecificParams.STATE_FINISHED, false);
		while (!(Boolean) UserSessionHelper.getSpecificParam(SpecificParams.STATE_FINISHED)) {
			try {
				TimeUnit.MILLISECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.out.println("doPost error :" + e);
			}
		}
		UserSessionHelper.putSpecificParam("CONTINUE", Integer.valueOf(0));
		if (UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE) != null) {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					(String) UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE),
					(String) UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE));
			FacesContext.getCurrentInstance().addMessage(null, message);
			// JSFUtils.contextExecute("_errorDialog()");
		} else {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.personnaliserEtudiant(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_PERSONNALIS", null);
				JSFUtils.contextExecute("_hideDialog()");
			}
		}
		feedReport();
	}

	public void personnaliserCollection() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.personnaliserCollectionEtudiant(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			addPrezMsgInfo("MESSAGE_SUCCESS_COLLECTION_PERSONNALISER", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();

		// AppletWeb.lancerLectureElectrique(1);
	}

	public EtudiantWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(EtudiantWebBean webBean) {
		this.webBean = webBean;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public void prepareCarte() {
		String imageGenereRecto = null;
		String tramString;
		/*
		 * recupérer le N° de la carte
		 */

		CarteVO carte = referentielService.findCarteByEtud(webBean.getVo().getId());
		if (carte != null) {
			webBean.getVo().setNumCarte(carte.getNumeroCarte());
		}

		imageGenereRecto = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Recto_"
				+ webBean.getVo().getId() + ".bmp";
		String imageGenereVerso = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Verso_"
				+ webBean.getVo().getId() + ".bmp";

	//	String photo = "file:C:/Carte_UCAD/Photos_Porteurs/Etudiants/" + webBean.getVo().getId() + ".jpg";
		String photo = "file:/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + webBean.getVo().getId() + ".jpg";

		//String photocheck = "C:\\Carte_UCAD\\Photos_Porteurs\\Etudiants\\" + this.webBean.getVo().getId() + ".jpg";
		String photocheck = "/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + this.webBean.getVo().getId() + ".jpg";
		
		File f = new File(photocheck);
		if (!f.exists()) {
			return;
		}

		PreparerImage pi = null;
		String chemin = "";

		 	chemin = "file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Recto.bmp";
		 
		String cheminVerso = "file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Verso.bmp";

		pi = new PreparerImage(chemin, photo, imageGenereRecto, cheminVerso, imageGenereVerso);

		if (webBean.getVo().getTypeCarte()=="N")
				pi.ecrireInformationsCMC(dimensionNAPS, webBean.getVo().getNom(), webBean.getVo().getPrenom(),  webBean.getVo().getCodeMassar(),webBean.getVo().getTypeCarte());
		else
			pi.ecrireInformationsCMC(dimension, webBean.getVo().getNom(), webBean.getVo().getPrenom(),  webBean.getVo().getCodeMassar(),webBean.getVo().getTypeCarte());
		
		List<PlafondVO> plafondVO = referentielService.findAllPlafondForCombo();
		String plafond = "0";
		for (PlafondVO plafondVO2 : plafondVO) {
			if (plafondVO2.getCode().equals("0005")) {
				plafond = String.valueOf(plafondVO2.getMax());
			}
		}

		//pi.ecrireVerso(webBean.getVo().getAnneeUniversitaireVO().getLibelle(), "", "");
		tramString = carte.getNumeroCarte() + "|" + webBean.getVo().getId() + "|" + webBean.getVo().getNom()
				+ "|" + webBean.getVo().getPrenom() + "|" + plafond + "|" + webBean.getVo().getEmail() + "|"
				+ webBean.getVo().getNCIN() + "|" + webBean.getVo().getCodeMassar()  + "|" +"" + "|||"
				+ webBean.getVo().getRestaurantVO().getId() + "|" + webBean.getVo().getSiteVO().getLibelle() + "|"
				+ webBean.getVo().getRestaurantVO().getLibelle() + "|" + webBean.getVo().getSiteVO().getCode() + "|"
				+ webBean.getVo().getAnneeUniversitaireVO().getLibelle() + "|"
				+ webBean.getVo().getAnneeUniversitaireVO().getDate_fin() + "|" + cheminexeimpression + "|"
				+ chemincarteverso + "|" + chemincarterecto + "|" + cheminftp + "|" + userftp + "|" + passftp + "|"
				+ "";

		String tramVersionEncodingString = cheminftp + "|" + versionExeEncoding + "|" + userftp + "|" + passftp + "|"
				+ cheminexeEncoding + "|GetCartePreimprime.exe";
		String tramVersionPrinterAppString = cheminftp + "|" + versionExePrinterApp + "|" + userftp + "|" + passftp
				+ "|" + cheminexeEncoding + "|PrinterApp.exe";
		String tramVersionDllEncodingString = cheminftp + "|" + versionDllEncoding + "|" + userftp + "|" + passftp + "|"
				+ cheminexeEncoding + "|card.dll";
		String tramVersionPrintString = cheminftp + "|" + versionExePrint + "|" + userftp + "|" + passftp + "|"
				+ cheminexeimpression + "|IMPRESSION_CARTE.exe";
		String tramPhotoString = cheminftpPhoto + "|" + webBean.getVo().getId() + "|" + userftp + "|" + passftp + "|";

		tramEncoding = encrypt(tramString);
		tramVersionEncoding = encrypt(tramVersionEncodingString);
		tramVersionPrinterApp = encrypt(tramVersionPrinterAppString);
		tramVersionPrint = encrypt(tramVersionPrintString);
		tramVersionDll = encrypt(tramVersionDllEncodingString);
		tramPhoto = encrypt(tramPhotoString);

	}

	public void prepareCarteSelected() {
		String imageGenereRecto = null;
		String imageGenereVerso = null;

		List<EtudiantVO> vos = webBean.getSelectedVOs();
		lengthTab = webBean.getSelectedVOs().size();

		if (!webBean.getSelectedVOs().isEmpty()) {
			for (EtudiantVO vo : vos) {

				imageGenereRecto = "/opt//Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Recto_" + vo.getId()
						+ ".bmp";

				String photo = "file:/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + vo.getId() + ".jpg";

				imageGenereVerso = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Verso_" + vo.getId()
						+ ".bmp";

				String chemin = "";
				if (vo.getResident())
					chemin = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte-Etudiant_Recto_R.bmp";

				if (!vo.getResident())
					chemin = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte-Etudiant_Recto_N.bmp";

				PreparerImage pi = new PreparerImage(chemin, photo, imageGenereRecto,
						"file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Verso.bmp", imageGenereVerso);

				pi.ecrireInformations(300, 460, 29, 22, "", vo.getNom() + " " + vo.getPrenom(), "",
						vo.getSiteVO().getLibelle(), "", "", "");

			}
		}

	}

	public void onCiteChange1() {
		if (webBean.getVo().getSiteVO().getLibelle() != null && !webBean.getVo().getSiteVO().getLibelle().equals("")) {
			webBean.setRestaurantVOs(
					referentielService.findAllRestaurantByLibelleCite(webBean.getVo().getSiteVO().getLibelle()));
		}

	}

	public void visualiserCarte() {
		try {

			System.out.println("debut visualisation******");

			AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() {
				public Boolean run() throws Exception {

					String imageGenereRecto = null;
					String imageGenereVerso = null;

					String idEtudiant = webBean.getVo().getId().toString();
					String chemincarterecto = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants";
					String chemincarteverso = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants";

					imageGenereRecto = chemincarterecto + "\\Carte_Etudiant_Recto_" + idEtudiant + ".bmp";
					imageGenereVerso = chemincarteverso + "\\Carte_Etudiant_Verso_" + idEtudiant + ".bmp";

					prototypeRecto = ImageIO.read(new File(imageGenereRecto));
					prototypeVerso = ImageIO.read(new File(imageGenereVerso));

					JFrame frameVerso = new JFrame("Aperçu Carte Etudiant Verso");
					frameVerso.getContentPane().add(new JLabel(new ImageIcon(prototypeVerso)));
					frameVerso.pack();
					frameVerso.setVisible(true);

					JFrame frameRecto = new JFrame("Aperçu Carte Etudiant Recto");
					frameRecto.getContentPane().add(new JLabel(new ImageIcon(prototypeRecto)));
					frameRecto.pack();
					frameRecto.setVisible(true);

					return true;
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();

			JOptionPane.showMessageDialog(null, "Erreur de Chargement de Carte : " + ex, "MX-CAMPUS", 1);

		}

	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination + fileName));

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

	public String retour() {
		return "/public/login.xhtml?faces-redirect=true";
	}

	public void generateReport() throws IOException {

		JasperReportExporter jasperExporter = new JasperReportExporter();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String author = "M2MGroup";
		String path = "resources/reports/";
		String fileOutput = "formulaire";
		String destinationImg = "/opt/Carte_UCAD/Photos_Porteurs/Etudiants/";
		// OutputStream os = null;
		// try {
		// os = new FileOutputStream(destinationImg + fileOutput + ".pdf");
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		List<Reservation> beanList = new ArrayList<Reservation>();
		ReportType reportType = ReportType.PDF;
		String img = webBean.getVo().getImage();
		if (StringUtils.isEmpty(img)) {
			img = "defaultUser.png";
		}
		String fileJrxml = "formulaire.jrxml";

		if (!webBean.getVo().getResident()) {
			dataMap.put("resident", "Non");
			fileJrxml = "formulaire.jrxml";
		} else {
			dataMap.put("resident", "Oui");
		}

		dataMap.put("boursier", webBean.getVo().getBoursier());

		if ("M".equals(webBean.getVo().getSexe())) {
			dataMap.put("sexe", "Masculin");
		} else {
			dataMap.put("sexe", "Féminin");
		}
		java.text.DateFormat dateFormatLong = new java.text.SimpleDateFormat("dd/MM/yyyy");
		dataMap.put("author", author);

		dataMap.put("imageURL", destinationImg + img);
		// if(webBean.getVo().getAnneeUniversitaireVO().getLibelle()!=null)
		dataMap.put("annee", referentielService.findActuelAnneeUniversitaire().getLibelle());
		dataMap.put("Nom", webBean.getVo().getNom());
		dataMap.put("Prenom", webBean.getVo().getPrenom());
		dataMap.put("Cin", webBean.getVo().getNCIN());
		dataMap.put("ville", webBean.getVo().getVille());
		dataMap.put("dateNaissance", dateFormatLong.format(webBean.getVo().getDate_naissance()));

		dataMap.put("etablissement", webBean.getVo().getEtablissement());
		dataMap.put("email", webBean.getVo().getEmail());
		dataMap.put("cite", webBean.getVo().getSiteVO().getLibelle());
		dataMap.put("restaurant", webBean.getVo().getRestaurantVO().getLibelle());
		System.out.println(webBean.getVo().getRevenu());

		// dataMap.put("revenuParent", webBean.getVo().getRevenu());
		// dataMap.put("nbreFreres", webBean.getVo().getNbrfresoeur());
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/images/");
		dataMap.put("realPath", realPath);

		// ReportSpecification reportSpec = new ReportSpecification(path
		// + fileJrxml, os);
		// ReportSpecification reportSpec = new
		// ReportSpecification(path+fileJrxml, path+fileOutput);
		// jasperExporter.export(reportSpec, beanList, reportType, dataMap);

		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();

		ec.responseReset();
		ec.setResponseContentType("application/pdf");
		String fileName = "Formulaire Inscription.pdf";
		ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName);

		OutputStream output = ec.getResponseOutputStream();

		ReportSpecification reportSpec = new ReportSpecification(path + fileJrxml, output);
		dataMap.put("author", author);

		jasperExporter.export(reportSpec, beanList, reportType, dataMap);
		fc.responseComplete();

		// InputStream inputStream = new
		// FileInputStream(FacesContext.getCurrentInstance().getExternalContext().getRealPath(path+fileOutput
		// + ".pdf")) ;
		// streamedContent= new
		// DefaultStreamedContent(inputStream,"application/pdf",webBean.getVo().getNom()+"
		// "+webBean.getVo().getPrenom()+".pdf");
	}

	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}

//	@Override
//	protected boolean isAutorise() {
//		if (JSFUtils.getRequestURI().contains("prenrolement.xhtml"))
//			return true;
//		return hasEcran(Constantes.CODE_ENR_ET);
//	}

	public void onCiteChange() {
		if (webBean.getVo().getSiteVO().getLibelle() != null && !webBean.getVo().getSiteVO().getLibelle().equals("")) {
			webBean.setRestaurantVOs(
					referentielService.findAllRestaurantByLibelleCite(webBean.getVo().getSiteVO().getLibelle()));
		} else
			webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
	}

	public Integer getLengthTab() {
		return lengthTab;
	}

	public void setLengthTab(Integer lengthTab) {
		this.lengthTab = lengthTab;
	}

	public static Date currentDate() {
		return DateUtil.currentDate();
	}

	public EtudiantCriteria getEtudiantCriteria() {
		return etudiantCriteria;
	}

	public void setEtudiantCriteria(EtudiantCriteria etudiantCriteria) {
		this.etudiantCriteria = etudiantCriteria;
	}

	public Long getNbrDemande() {
		return nbrDemande;
	}

	public void setNbrDemande(Long nbrDemande) {
		this.nbrDemande = nbrDemande;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void visualiser() {

		String imageGenereRecto = null;
		String tramString;
		/*
		 * recupérer le N° de la carte
		 */

		CarteVO carte = referentielService.findCarteByEtud(webBean.getVo().getId());
		if (carte != null) {
			webBean.getVo().setNumCarte(carte.getNumeroCarte());
		}

		imageGenereRecto = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Recto_"
				+ webBean.getVo().getId() + ".bmp";
		String imageGenereVerso = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Verso_"
				+ webBean.getVo().getId() + ".bmp";

		String photo = "file:/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + webBean.getVo().getId() + ".jpg";

		PreparerImage pi = null;
		String chemin = "";

		if (webBean.getVo().getResident())
			chemin = "file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Recto_R.bmp";
		if (!webBean.getVo().getResident())
			chemin = "file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Recto_N.bmp";

		String cheminVerso = "file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Verso.bmp";

		pi = new PreparerImage(chemin, photo, imageGenereRecto, cheminVerso, imageGenereVerso);

		pi.ecrireInformations(360, 400, 29, 22, "", webBean.getVo().getNom() + " " + webBean.getVo().getPrenom(), "",
				webBean.getVo().getSiteVO().getLibelle(), "", "getCodeMassar()", webBean.getVo().getNCIN());

		//pi.ecrireVerso(webBean.getVo().getAnneeUniversitaireVO().getLibelle(), "", "");
		String tramPhotoStringDownload = cheminftp + "|" + webBean.getVo().getId() + "|" + userftp + "|" + passftp
				+ "|";

		tramPhoto = encrypt(tramPhotoStringDownload);

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

		parameters.put("operation", "VISUALIZE");
		parameters.put("data", tramPhoto);
		parameters.put("IdEtu", webBean.getVo().getId());
		parameters.put("dataVEncoding", tramVersionEncoding);
		parameters.put("dataVPrint", tramVersionPrint);
		parameters.put("dataVDll", tramVersionDll);
		parameters.put("dataVPrinterApp", tramVersionPrinterApp);

		parameterData = new HashMap<String, Object>(parameters);
		jsonArray.put(parameterData);
		try {
			jsonData.put("data", jsonArray);
		} catch (JSONException e) {
			System.out.println("prepare json error: " + e);
		}

		UserSessionHelper.putSpecificParam(SpecificParams.DATA_TO_SEND,
				jsonData.toString().replaceAll("\"", "%22").replaceAll(" ", "%20"));

		UserSessionHelper.putSpecificParam(SpecificParams.READY, true);

		UserSessionHelper.putSpecificParam(SpecificParams.STATE_FINISHED, false);
		while (!(Boolean) UserSessionHelper.getSpecificParam(SpecificParams.STATE_FINISHED)) {
			try {
				TimeUnit.MILLISECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.out.println("doPost error :" + e);
			}
		}

		if (UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE) != null) {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					(String) UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE),
					(String) UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE));
			FacesContext.getCurrentInstance().addMessage(null, message);
			// JSFUtils.contextExecute("_errorDialog()");
		} else {
		}
	}

	private static String encrypt(String plainText) {
		String encryptedText = "";
		try {
			Cipher cipher;

			System.out.println(String.valueOf(cipherTransformation));
			cipher = Cipher.getInstance(cipherTransformation);

			KeyGenerator keyGen = KeyGenerator.getInstance(aesEncryptionAlgorithem);
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

	public void personnaliserLot() {
		clearReport();

		this.webBean.getVo();
		this.webBean.getVos();
		int cout = this.webBean.getSelectedVOs().size();

		UserSessionHelper.putSpecificParam("WHILE", Integer.valueOf(cout));

		int i = cout;
		for (EtudiantVO iterable_element : this.webBean.getSelectedVOs()) {
			prepareCarte(iterable_element);
			this.webBean.setVo(iterable_element);
			UserSessionHelper.putSpecificParam("DATA_TO_SEND", null);
			UserSessionHelper.putSpecificParam("CARD_UID", null);
			UserSessionHelper.putSpecificParam("STATE_FINISHED", null);
			UserSessionHelper.putSpecificParam("ERROR_MESSAGE", null);
			UserSessionHelper.putSpecificParam("READY", null);

			JSONObject jsonData = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			Map<String, Object> parameters = new HashMap();
			Map<String, Object> parameterData = new HashMap();

			parameters.put("operation", "PRINT");
			parameters.put("data", this.tramEncoding);
			parameters.put("dataVEncoding", this.tramVersionEncoding);
			parameters.put("dataVPrint", this.tramVersionPrint);
			parameters.put("dataVDll", this.tramVersionDll);
			parameters.put("dataVPrinterApp", this.tramVersionPrinterApp);
			UserSessionHelper.putSpecificParam("CONTINUE", Integer.valueOf(i));
			i--;

			parameterData = new HashMap(parameters);
			jsonArray.put(parameterData);
			try {
				jsonData.put("data", jsonArray);
			} catch (JSONException e) {
				System.out.println("prepare json error: " + e);
			}
			UserSessionHelper.putSpecificParam("DATA_TO_SEND",
					jsonData.toString().replaceAll("\"", "%22").replaceAll(" ", "%20"));

			UserSessionHelper.putSpecificParam("READY", Boolean.valueOf(true));

			UserSessionHelper.putSpecificParam("STATE_FINISHED", Boolean.valueOf(false));
			while (!((Boolean) UserSessionHelper.getSpecificParam("STATE_FINISHED")).booleanValue()) {
				try {
					TimeUnit.MILLISECONDS.sleep(2L);
				} catch (InterruptedException e) {
					System.out.println("doPost error :" + e);
				}
			}
			UserSessionHelper.putSpecificParam("CONTINUE", Integer.valueOf(i));
			if (UserSessionHelper.getSpecificParam("ERROR_MESSAGE") != null) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						(String) UserSessionHelper.getSpecificParam("ERROR_MESSAGE"),
						(String) UserSessionHelper.getSpecificParam("ERROR_MESSAGE"));
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				ReferentielBusDelegate delegate = new ReferentielBusDelegate();
				this.error = delegate.personnaliserEtudiant(this.webBean);
				if (this.error) {
					JSFUtils.contextExecute("_errorDialog()");
				} else {
					addPrezMsgInfo("MESSAGE_SUCCESS_PERSONNALIS", null);
					JSFUtils.contextExecute("_hideDialogLot()");
				}
			}
		}
		feedReport();
	}

	public void applyRenewal() {
		clearReport();
		
		// initialisation des paramètres de communication
		UserSessionHelper.putSpecificParam(SpecificParams.DATA_TO_SEND, null);
		UserSessionHelper.putSpecificParam(SpecificParams.CARD_UID, null);
		UserSessionHelper.putSpecificParam(SpecificParams.STATE_FINISHED, null);
		UserSessionHelper.putSpecificParam(SpecificParams.ERROR_MESSAGE, null);
		UserSessionHelper.putSpecificParam(SpecificParams.READY, null);
		UserSessionHelper.putSpecificParam("CONTINUE", Integer.valueOf(1));
		JSONObject jsonData = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> parameterData = new HashMap<String, Object>();
		prepareCarte();
		parameters.put("operation", "REN");
		parameters.put("data", tramEncoding);
		parameters.put("dataVEncoding", tramVersionEncoding);
		parameters.put("dataVPrint", tramVersionPrint);
		parameters.put("dataVDll", tramVersionDll);
		parameters.put("dataVPrinterApp", tramVersionPrinterApp);

		parameterData = new HashMap<String, Object>(parameters);
		jsonArray.put(parameterData);
		try {
			jsonData.put("data", jsonArray);
		} catch (JSONException e) {
			System.out.println("prepare json error: " + e);
		}

		UserSessionHelper.putSpecificParam(SpecificParams.DATA_TO_SEND,
				jsonData.toString().replaceAll("\"", "%22").replaceAll(" ", "%20"));

		UserSessionHelper.putSpecificParam(SpecificParams.READY, true);

		UserSessionHelper.putSpecificParam(SpecificParams.STATE_FINISHED, false);
		while (!(Boolean) UserSessionHelper.getSpecificParam(SpecificParams.STATE_FINISHED)) {
			try {
				TimeUnit.MILLISECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.out.println("doPost error :" + e);
			}
		}
		UserSessionHelper.putSpecificParam("CONTINUE", Integer.valueOf(0));
		if (UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE) != null) {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					(String) UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE),
					(String) UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE));
			FacesContext.getCurrentInstance().addMessage(null, message);
			// JSFUtils.contextExecute("_errorDialog()");
		} else {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.applyRnvEtudiant(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_PERSONNALIS", null);
				JSFUtils.contextExecute("_hideDialog()");
			}
		}
		feedReport();
	}

	public void resetCarteWebBeanVO() {
		carteWebBean.setVo(new CarteVO());
	}

	public void prepareCarte(EtudiantVO vo) {
		String imageGenereRecto = null;

		CarteVO carte = this.referentielService.findCarteByEtud(vo.getId());
		if (carte != null) {
			vo.setNumCarte(carte.getNumeroCarte());
		}
		imageGenereRecto = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Recto_" + vo.getId() + ".bmp";
		String imageGenereVerso = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Verso_" + vo.getId()
				+ ".bmp";

		String photo = "file:/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + vo.getId() + ".jpg";

		String photocheck = "/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + vo.getId() + ".jpg";
		File f = new File(photocheck);
		if (!f.exists()) {
			return;
		}
		PreparerImage pi = null;
		String chemin = "";
		if (vo.getResident().booleanValue()) {
			chemin = "file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Recto_R.bmp";
		}
		if (!vo.getResident().booleanValue()) {
			chemin = "file:/opt//Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Recto_N.bmp";
		}
		String cheminVerso = "file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Verso.bmp";

		pi = new PreparerImage(chemin, photo, imageGenereRecto, cheminVerso, imageGenereVerso);

		pi.ecrireInformations(360, 400, 29, 22, "", vo.getNom() + " " + vo.getPrenom(), "", vo.getSiteVO().getLibelle(),
				"", "CodeMassar", vo.getNCIN());

		List<PlafondVO> plafondVO = this.referentielService.findAllPlafondForCombo();
		String plafond = "0";
		for (PlafondVO plafondVO2 : plafondVO) {
			if (plafondVO2.getCode().equals("0005")) {
				plafond = String.valueOf(plafondVO2.getMax());
			}
		}
		//pi.ecrireVerso(vo.getAnneeUniversitaireVO().getLibelle(), "", "");
		String tramString = vo.getNumCarte() + "|" + vo.getId() + "|" + vo.getNom() + "|" + vo.getPrenom() + "|"
				+ plafond + "|" + vo.getEmail() + "|" + vo.getNCIN() + "|" + "CodeMassar" + "|" + "vo.getHandicape()"
				+ "|||" + vo.getRestaurantVO().getId() + "|" + vo.getSiteVO().getLibelle() + "|"
				+ vo.getRestaurantVO().getLibelle() + "|" + vo.getSiteVO().getCode() + "|"
				+ vo.getAnneeUniversitaireVO().getLibelle() + "|" + vo.getAnneeUniversitaireVO().getDate_fin() + "|"
				+ this.cheminexeimpression + "|" + this.chemincarteverso + "|" + this.chemincarterecto + "|"
				+ this.cheminftp + "|" + this.userftp + "|" + this.passftp + "|";

		String tramVersionEncodingString = this.cheminftp + "|" + this.versionExeEncoding + "|" + this.userftp + "|"
				+ this.passftp + "|" + this.cheminexeEncoding + "|GetCartePreimprime.exe";
		String tramVersionPrinterAppString = this.cheminftp + "|" + this.versionExePrinterApp + "|" + this.userftp + "|"
				+ this.passftp + "|" + this.cheminexeEncoding + "|PrinterApp.exe";
		String tramVersionDllEncodingString = this.cheminftp + "|" + this.versionDllEncoding + "|" + this.userftp + "|"
				+ this.passftp + "|" + this.cheminexeEncoding + "|card.dll";
		String tramVersionPrintString = this.cheminftp + "|" + this.versionExePrint + "|" + this.userftp + "|"
				+ this.passftp + "|" + this.cheminexeimpression + "|IMPRESSION_CARTE.exe";
		String tramPhotoString = this.cheminftpPhoto + "|" + vo.getId() + "|" + this.userftp + "|" + this.passftp + "|";

		this.tramEncoding = encrypt(tramString);
		this.tramVersionEncoding = encrypt(tramVersionEncodingString);
		this.tramVersionPrinterApp = encrypt(tramVersionPrinterAppString);
		this.tramVersionPrint = encrypt(tramVersionPrintString);
		this.tramVersionDll = encrypt(tramVersionDllEncodingString);
		this.tramPhoto = encrypt(tramPhotoString);
	}

	public void reload() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	public String getCheminexeimpression() {
		return cheminexeimpression;
	}

	public void setCheminexeimpression(String cheminexeimpression) {
		this.cheminexeimpression = cheminexeimpression;
	}

	public String getChemincarteverso() {
		return chemincarteverso;
	}

	public void setChemincarteverso(String chemincarteverso) {
		this.chemincarteverso = chemincarteverso;
	}

	public String getChemincarterecto() {
		return chemincarterecto;
	}

	public void setChemincarterecto(String chemincarterecto) {
		this.chemincarterecto = chemincarterecto;
	}

	public BufferedImage getPrototypeRecto() {
		return prototypeRecto;
	}

	public void setPrototypeRecto(BufferedImage prototypeRecto) {
		this.prototypeRecto = prototypeRecto;
	}

	public BufferedImage getPrototypeVerso() {
		return prototypeVerso;
	}

	public void setPrototypeVerso(BufferedImage prototypeVerso) {
		this.prototypeVerso = prototypeVerso;
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

	public String getTramVersionPrint() {
		return tramVersionPrint;
	}

	public void setTramVersionPrint(String tramVersionPrint) {
		this.tramVersionPrint = tramVersionPrint;
	}

	public String getVersionDllEncoding() {
		return versionDllEncoding;
	}

	public void setVersionDllEncoding(String versionDllEncoding) {
		this.versionDllEncoding = versionDllEncoding;
	}

	public String getCheminftp() {
		return cheminftp;
	}

	public void setCheminftp(String cheminftp) {
		this.cheminftp = cheminftp;
	}

	public String getUserftp() {
		return userftp;
	}

	public void setUserftp(String userftp) {
		this.userftp = userftp;
	}

	public String getPassftp() {
		return passftp;
	}

	public void setPassftp(String passftp) {
		this.passftp = passftp;
	}

	public String getPortftp() {
		return portftp;
	}

	public void setPortftp(String portftp) {
		this.portftp = portftp;
	}

	public String getCheminftpPhoto() {
		return cheminftpPhoto;
	}

	public void setCheminftpPhoto(String cheminftpPhoto) {
		this.cheminftpPhoto = cheminftpPhoto;
	}

	public String getVersionExePrint() {
		return versionExePrint;
	}

	public void setVersionExePrint(String versionExePrint) {
		this.versionExePrint = versionExePrint;
	}

	public String getVersionExeEncoding() {
		return versionExeEncoding;
	}

	public void setVersionExeEncoding(String versionExeEncoding) {
		this.versionExeEncoding = versionExeEncoding;
	}

	public String getCheminexeEncoding() {
		return cheminexeEncoding;
	}

	public void setCheminexeEncoding(String cheminexeEncoding) {
		this.cheminexeEncoding = cheminexeEncoding;
	}

	public String getVersionExePrinterApp() {
		return versionExePrinterApp;
	}

	public void setVersionExePrinterApp(String versionExePrinterApp) {
		this.versionExePrinterApp = versionExePrinterApp;
	}

	public String getTramVersionEncoding() {
		return tramVersionEncoding;
	}

	public void setTramVersionEncoding(String tramVersionEncoding) {
		this.tramVersionEncoding = tramVersionEncoding;
	}

	public String getTramVersionPrinterApp() {
		return tramVersionPrinterApp;
	}

	public void setTramVersionPrinterApp(String tramVersionPrinterApp) {
		this.tramVersionPrinterApp = tramVersionPrinterApp;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public String getStatImage() {
		return statImage;
	}

	public void setStatImage(String statImage) {
		this.statImage = statImage;
	}

	public CarteWebBean getCarteWebBean() {
		return carteWebBean;
	}

	public void setCarteWebBean(CarteWebBean carteWebBean) {
		this.carteWebBean = carteWebBean;
	}

	public void refabriquerCarte() {

		clearReport();

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
		UserSessionHelper.putSpecificParam("CONTINUE", Integer.valueOf(1));
		parameters.put("operation", "PRINT");
		parameters.put("data", tramEncoding);
		parameters.put("dataVEncoding", tramVersionEncoding);
		parameters.put("dataVPrint", tramVersionPrint);
		parameters.put("dataVDll", tramVersionDll);
		parameters.put("dataVPrinterApp", tramVersionPrinterApp);
		prepareCarte();

		parameterData = new HashMap<String, Object>(parameters);
		jsonArray.put(parameterData);
		try {
			jsonData.put("data", jsonArray);
		} catch (JSONException e) {
			System.out.println("prepare json error: " + e);
		}

		UserSessionHelper.putSpecificParam(SpecificParams.DATA_TO_SEND,
				jsonData.toString().replaceAll("\"", "%22").replaceAll(" ", "%20"));

		UserSessionHelper.putSpecificParam(SpecificParams.READY, true);

		UserSessionHelper.putSpecificParam(SpecificParams.STATE_FINISHED, false);
		while (!(Boolean) UserSessionHelper.getSpecificParam(SpecificParams.STATE_FINISHED)) {
			try {
				TimeUnit.MILLISECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.out.println("doPost error :" + e);
			}
		}
		UserSessionHelper.putSpecificParam("CONTINUE", Integer.valueOf(0));
		if (UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE) != null) {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					(String) UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE),
					(String) UserSessionHelper.getSpecificParam(SpecificParams.ERROR_MESSAGE));
			FacesContext.getCurrentInstance().addMessage(null, message);
			// JSFUtils.contextExecute("_errorDialog()");
		} else {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.refabriquerCarte(carteWebBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_PERSONNALIS", null);
				JSFUtils.contextExecute("_hideDialog()");
			}
		}
		feedReport();

		// AppletWeb.lancerLectureElectrique(1);
	}

	public void generateNumCarte() {

		String imageGenereRecto = null;
		String imageGenereVerso = null;

		imageGenereRecto = "/opt/Carte_UCAD/Cartes_PreImprimees/Etudiants/Carte_Etudiant_Recto_"
				+ carteWebBean.getVo().getEtudiantvo().getId() + ".bmp";
 

		String photo = "file:/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + carteWebBean.getVo().getEtudiantvo().getId()
				+ ".jpg";

		String chemin = "";

		 	chemin = "file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Recto.bmp";

	 
		PreparerImage pi = new PreparerImage(chemin, photo, imageGenereRecto,
				"file:/opt/Carte_UCAD/Prototypes/Etudiants/Carte-Etudiant_Verso.bmp", imageGenereVerso);

		/*
		 * pi.ecrireInformations(360, 400, 29, 22, "",""
		 * carteWebBean.getVo().getEtudiantvo().getNom() + " " +
		 * carteWebBean.getVo().getEtudiantvo().getPrenom(), "",
		 * carteWebBean.getVo().getEtudiantvo().getSiteVO().getLibelle(), "",
		 * carteWebBean.getVo().getEtudiantvo().getCodeMassar(),
		 * webBean.getVo().getNCIN());
		 */
		if (webBean.getVo().getTypeCarte()=="N")
			pi.ecrireInformationsCMC(dimensionNAPS, carteWebBean.getVo().getEtudiantvo().getNom(),carteWebBean.getVo().getEtudiantvo().getPrenom(), carteWebBean.getVo().getEtudiantvo().getCodeMassar(),carteWebBean.getVo().getEtudiantvo().getTypeCarte());
	else
		pi.ecrireInformationsCMC(dimension,carteWebBean.getVo().getEtudiantvo().getNom(),carteWebBean.getVo().getEtudiantvo().getPrenom(), carteWebBean.getVo().getEtudiantvo().getCodeMassar(),carteWebBean.getVo().getEtudiantvo().getTypeCarte());

		//pi.ecrireVerso("", "", "");

		/***********************/
		String sequence = this.carteWebBean.getVo().getNumeroCarte()
				.replaceAll(1697 + "" + this.carteWebBean.getVo().getEtudiantvo().getSiteVO().getCode(), "");
		sequence = "" + (Long.valueOf(sequence).longValue() + 1);
		this.carteWebBean.setNouveauNumCarte(
				1697 + "" + this.carteWebBean.getVo().getEtudiantvo().getSiteVO().getCode() + sequence);

		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<ReservationVO> lstReservation = reservationService
				.findReservationByIdPorteur("" + this.carteWebBean.getVo().getEtudiantvo().getId());
		List<String> listResultat = new ArrayList<String>();

		for (ReservationVO reservationVO : lstReservation) {
			listResultat.add(formatter.format(reservationVO.getDateOperation()) + "" + reservationVO.getLibelle());

		}

		Set<String> checkDuplicates = new HashSet<String>();
		List<String> newListResultat = new ArrayList<String>();

		for (int i = 0; i < listResultat.size(); i++) {
			String items = listResultat.get(i);
			if (!checkDuplicates.add(items.substring(0, items.length() - 1))) {
				newListResultat.add(items.substring(0, items.length() - 1) + "T");

			} else {
				newListResultat.add(items);
			}
		}
		checkDuplicates.clear();
		listResultat.clear();
		for (int i = newListResultat.size() - 1; i >= 0; i--) {
			String items = newListResultat.get(i);
			if (checkDuplicates.add(items.substring(0, items.length() - 1))) {
				listResultat.add(items);
			}
		}

		webBean.getVo().setListReservation(org.apache.commons.lang3.StringUtils.join(listResultat, "@"));
		String tramString = carteWebBean.getNouveauNumCarte() + "|" + carteWebBean.getVo().getEtudiantvo().getId() + "|"
				+ carteWebBean.getVo().getEtudiantvo().getNom() + "|" + carteWebBean.getVo().getEtudiantvo().getPrenom()
				+ "|" + carteWebBean.getVo().getSolde() + "|" + carteWebBean.getVo().getEtudiantvo().getEmail() + "|"
				+ carteWebBean.getVo().getEtudiantvo().getNCIN() + "|"
				+ carteWebBean.getVo().getEtudiantvo().getCodeMassar() + "|" + "1" + "|||"
				+ carteWebBean.getVo().getEtudiantvo().getRestaurantVO().getId() + "|"
				+ carteWebBean.getVo().getEtudiantvo().getSiteVO().getLibelle() + "|"
				+ carteWebBean.getVo().getEtudiantvo().getRestaurantVO().getLibelle() + "|"
				+ carteWebBean.getVo().getEtudiantvo().getSiteVO().getCode() + "|"
				+ carteWebBean.getVo().getEtudiantvo().getAnneeUniversitaireVO().getLibelle() + "|"
				+ carteWebBean.getVo().getEtudiantvo().getAnneeUniversitaireVO().getDate_fin() + "|"
				+ cheminexeimpression + "|" + chemincarteverso + "|" + chemincarterecto + "|" + cheminftp + "|"
				+ userftp + "|" + passftp + "|" + webBean.getVo().getListReservation();

		String tramVersionEncodingString = cheminftp + "|" + versionExeEncoding + "|" + userftp + "|" + passftp + "|"
				+ cheminexeEncoding + "|GetCartePreimprime.exe";
		String tramVersionPrinterAppString = cheminftp + "|" + versionExePrinterApp + "|" + userftp + "|" + passftp
				+ "|" + cheminexeEncoding + "|PrinterApp.exe";
		String tramVersionDllEncodingString = cheminftp + "|" + versionDllEncoding + "|" + userftp + "|" + passftp + "|"
				+ cheminexeEncoding + "|card.dll";
		String tramVersionPrintString = cheminftp + "|" + versionExePrint + "|" + userftp + "|" + passftp + "|"
				+ cheminexeimpression + "|IMPRESSION_CARTE.exe";
		String tramPhotoString = cheminftpPhoto + "|" + carteWebBean.getVo().getId() + "|" + userftp + "|" + passftp + "|";

		tramEncoding = encrypt(tramString);
		tramVersionEncoding = encrypt(tramVersionEncodingString);
		tramVersionPrinterApp = encrypt(tramVersionPrinterAppString);
		tramVersionPrint = encrypt(tramVersionPrintString);
		tramVersionDll = encrypt(tramVersionDllEncodingString);
		tramPhoto = encrypt(tramPhotoString);

	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}
