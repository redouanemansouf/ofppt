package com.m2m.technicalservices.web;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import com.m2m.technicalservices.core.Constantes;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.security.impl.AuthManager;

public class BaseMBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected UserSession userSession = (UserSession) JSFUtils
			.getSession("userSession");
	protected boolean error;

	protected static final String HIDE_DIALOG_METHOD = "_hideDialog()";

	protected static final String MESSAGE_SUCCESS_CREATE = "MESSAGE_SUCCESS_CREATE";

	protected static final String MESSAGE_SUCCESS_AFFECT = "MESSAGE_SUCCESS_AFFECT";

	protected static final String MESSAGE_SUCCESS_DELETE = "MESSAGE_SUCCESS_DELETE";

	protected static final String ERROR_DIALOG_METHOD = "_errorDialog()";

	protected static final String MESSAGE_SUCCESS_ENABLE = "MESSAGE_SUCCESS_ENABLE";

	protected static final String MESSAGE_SUCCESS_DISABLE = "MESSAGE_SUCCESS_DISABLE";

	protected static final String AUCUN_ELEMENT_SELECTIONE = "AUCUN_ELEMENT_SELECTIONE";

	protected static final String MESSAGE_SUCCESS_EDIT = "MESSAGE_SUCCESS_EDIT";

	protected static final String UPLOAD_TEMP_FOLDER = System
			.getProperty("com.onousc.UPLOAD_FOLDER");

	protected static final String MESSAGE_SUCCESS_CHANGEMENT = "MESSAGE_SUCCESS_CHANGEMENT";

	protected static final String MESSAGE_SUCCESS_FORFAIT = "MESSAGE_SUCCESS_FORFAIT";

	protected static final String MESSAGE_SUCCESS_FRANCHISE = "MESSAGE_SUCCESS_FRANCHISE";

	protected static final String MESSAGE_SUCCESS_PARAM_GRILLE_TARIFAIRE = "MESSAGE_SUCCESS_PARAM_GRILLE_TARIFAIRE";

	protected Boolean successCreation = false;
	protected static final String SUCCESS_CREATION = "successCreation";
	protected Boolean successEdition = false;
	protected static final String SUCCESS_EDITION = "successEdition";

	@PostConstruct
	final void construct() {
		useCaseSuccess();
		if(!isAutorise()){
			JSFUtils.redirect("/mxcampus/pages/page403.xhtml?faces-redirect=true");    
			return; 
		} 
		init();
	}

	// a définir
	protected void init() {

	}

	private void useCaseSuccess() {
		successCreation = (Boolean) JSFUtils.getFromFlash(SUCCESS_CREATION);

		successEdition = (Boolean) JSFUtils.getFromFlash(SUCCESS_EDITION);

		if (successCreation != null && successCreation) {
			addInfoMessage(MESSAGE_SUCCESS_CREATE, FacesMessage.SEVERITY_INFO);
			successCreation = false;
			JSFUtils.putInFlash(SUCCESS_CREATION, false);
		}
		if (successEdition != null && successEdition) {
			addInfoMessage(MESSAGE_SUCCESS_EDIT, FacesMessage.SEVERITY_INFO);
			successEdition = false;
			JSFUtils.putInFlash(SUCCESS_EDITION, false);
		}
	}

	public void clearReport() {
		userSession.setReport(new ReportWebBean());
	}

	public void addPrezMsgInfo(String key, String[] infos) {
		ProcessMsg msg = new ProcessMsg(key, infos, FacesMessage.SEVERITY_INFO);
		MessageHelper.processPrezMesssage(msg, Constantes.TYPE_MESSAGE_INFO);
	}

	/**
	 * 
	 * Method pour afficher les messages retourné par la validation métier
	 * amtarji
	 */
	public void feedReport() {
		Map<Severity, String> msgs = userSession.getReport().getListMessages();
		Iterator<Entry<Severity, String>> it = msgs.entrySet().iterator();
		while (it.hasNext()) {

			Map.Entry<Severity, String> pairs = (Map.Entry<Severity, String>) it
					.next();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(pairs.getKey(), pairs.getValue(), null));
			it.remove();
		}

	}

	/**
	 * amtarji recuperer les messages d'erreur pour les tooltips
	 * 
	 * @param clientId
	 * @return
	 */
	public String getErrorMessage(final String clientId) {
		Iterator<FacesMessage> iter = FacesContext.getCurrentInstance()
				.getMessages(clientId);
		if (iter.hasNext()) {
			return iter.next().getDetail();
		}
		return "";
	}

	public void addCollectorErrorMessage(String key) {
		String params[] = {};
		String summary = MessageHelper.getResourceBundleString(key, params,
				MessageHelper.BUS_BUNDLE);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null));
	}

	public void addCollectorErrorMessage(String key, String info[]) {
		String summary = MessageHelper.getResourceBundleString(key, info,
				MessageHelper.BUS_BUNDLE);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null));
	}

	public void addInfoMessage(String key, Severity severity) {
		String params[] = {};
		String summary = MessageHelper.getResourceBundleString(key, params,
				MessageHelper.PREZ_BUNDLE);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, summary, null));
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Boolean getSuccessCreation() {
		return successCreation;
	}

	public void setSuccessCreation(Boolean successCreation) {
		this.successCreation = successCreation;
	}

	public Boolean getSuccessEdition() {
		return successEdition;
	}

	public void setSuccessEdition(Boolean successEdition) {
		this.successEdition = successEdition;
	}
	
	protected boolean isAutorise(){
		return true;
	}
	
	protected boolean hasEcran(String codeEcran){
		AuthManager auth= new AuthManager();    
		return auth.hasEcran(codeEcran);
	}
}
