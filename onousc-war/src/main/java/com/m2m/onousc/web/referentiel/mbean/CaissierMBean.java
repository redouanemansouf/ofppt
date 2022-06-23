package com.m2m.onousc.web.referentiel.mbean;

import java.security.SecureRandom;
import java.util.ArrayList;
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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.web.commons.PreparerImage;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CaissierWebBean;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;
import com.m2m.technicalservices.web.SpecificParams;
import com.m2m.technicalservices.web.UserSessionHelper;

/**
 * 
 * @author abousnane
 * 
 */
@ManagedBean
@ViewScoped
public class CaissierMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3481171614216454350L;

	/** The web bean. */
	private CaissierWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	private String tramEncoding, tramVersionDll, tramPhoto;
	private static final String cipherTransformation = "AES/CBC/PKCS5PADDING";
	private static final String aesEncryptionAlgorithem = "AES";

	public void init() {
		webBean = new CaissierWebBean();
		webBean.setListSiteForCombo(referentielService.findAllSite());
		
		if (user.getSiteVO() != null)
			webBean.setCaisseVOs(referentielService.findCaisseListByIdSite(user.getSiteVO().getId()));
		else
			webBean.setCaisseVOs(referentielService.findAllCaisseForCombo());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new CaissierVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<CaissierVO>());
	}

	public CaissierWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(CaissierWebBean webBean) {
		this.webBean = webBean;
	}

	/**
	 * Creer.
	 */
	public void creer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		List<CaissierVO> check = referentielService.findCaissierListByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		} else {
			if (user.getSiteVO() != null)
				webBean.getVo().setSiteVO(user.getSiteVO());

			error = delegate.creeCaissier(webBean);
			if (!error) {
//			FacesContext.getCurrentInstance().addMessage(null,
//					 new FacesMessage(FacesMessage.SEVERITY_INFO,
//					 "Element ajouté avec succès" ,"Succes"));
				JSFUtils.contextExecute("_hideDialog()");
			}
			feedReport();
		}
	}

	/**
	 * Modifier
	 */
	public void modifier() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		if (user.getSiteVO() != null)
			webBean.getVo().setSiteVO(user.getSiteVO());

		error = delegate.modifierCaissier(webBean);
		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_EDIT", null);
			JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();
	}

	/**
	 * Activer.
	 */
	public void activer() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.activerCaissier(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_ENABLE", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	/**
	 * Desactiver.
	 */
	public void desactiver() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.desactiverCaissier(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_DISABLE", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	public void supprimer() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.supprimerCaissier(webBean);
		if (error) {
			JSFUtils.contextExecute("_errorDialog()");
		} else {
			JSFUtils.contextExecute("_showMessage()");
		}
		feedReport();
	}

	public void supprimerCollection() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.supprimerCaissier(webBean);
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

	public void personnaliser() {

		clearReport();
		String tramString = webBean.getVo().getNumCarte() + "|" + webBean.getVo().getId() + "|"
				+ webBean.getVo().getNom() + "|" + webBean.getVo().getCode() + "|" + webBean.getVo().getPrenom()
				+ "|0|";

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
//			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
//			error = delegate.modifierCaissier(webBean);
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			error = delegate.personnaliserCaissier(webBean);
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

	public void prepareCarteCaissierSelected() {
		String imageGenereRecto = null;
		String imageGenereVerso = null;
		List<CaissierVO> vos = webBean.getSelectedVOs();
	//	lengthTab=webBean.getSelectedVOs().size();
		
		
		
		if (!webBean.getSelectedVOs().isEmpty()) {
			for (CaissierVO vo : vos) {

		// Etudiants etud = (Etudiants) obj;
		imageGenereRecto = "C:/Carte_UCAD/Cartes_PreImprimees/Professionnelles/Carte-Caisse_Recto_"
				+ vo.getCode() + ".bmp";

		imageGenereVerso = "C:/Carte_UCAD/Cartes_PreImprimees/Professionnelles/Carte-Caisse_Verso_"
				+ vo.getCode() + ".bmp";

		
		PreparerImage pi = new PreparerImage(
				"file:C:/Carte_UCAD/Prototypes/Professionnelles/Carte-Caisse_Recto.bmp",
				imageGenereRecto);
		pi.ecrireInformationsCaissier(300, 460, 29, 22, "", "", ""
				, "", "", "");
		// appercuCarte( webBean.getVo().getId().toString(),
		// "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants",
		// "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants");
		
		pi.ecrireVerso("", "","");
		
			}
		}

	}
	public void codevalidator() {

		List<CaissierVO> check = referentielService.findCaissierListByCode(webBean.getVo().getCode());
		if (check.size() != 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le Code doit être unique", "Doublons"));
		}

	}

	public void showMessage() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Operation effectuée avec succès"));
		feedReport();
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_REF_ANNEE_UNIV);  
//	}
}