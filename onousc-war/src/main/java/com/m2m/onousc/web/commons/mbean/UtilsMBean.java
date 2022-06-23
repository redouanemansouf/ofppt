/*
 * UtilsMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.commons.mbean;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

/**
 * The Class UtilsMBean.
 * 
 * @version 1.0 12 mars 2015
 * @author amtarji
 */
@ManagedBean
@ViewScoped
public class UtilsMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8339692593105566246L;

	/** The validation temp fix. */
	private String validationTempFix;

	public void init() {
		validationTempFix = "";
		new Boolean(true);
	}

	/**
	 * Open rapport erreurs.
	 * 
	 * @param view
	 *            the view
	 * @param windowId
	 *            the window id
	 */
	public void openRapportErreurs(String view, String windowId) {
		JSFUtils.openWindow(view, windowId, 250, 200);
	}

	/**
	 * amtarji recuperer les messages d'erreur pour les tooltips.
	 * 
	 * @param clientId
	 *            the client id
	 * @return the error message
	 */
	public String getErrorMessage(final String clientId) {
		Iterator<FacesMessage> iter = FacesContext.getCurrentInstance()
				.getMessages(clientId);
		if (iter.hasNext()) {
			return iter.next().getDetail();
		}
		return "Not found";
	}

	public String getValidationTempFix() {
		return validationTempFix;
	}

	public void setValidationTempFix(String validationTempFix) {
		this.validationTempFix = validationTempFix;
	}

	public static String displayCard(String numCarte) {
		if (numCarte == null || numCarte.isEmpty()) {
			return null;
		}
		numCarte = numCarte.trim();
		StringBuilder num = new StringBuilder(numCarte);

		if (numCarte.length() == 16) {
			num.replace(6, 12, "******");
			return num.toString();
		} else if (numCarte.length() == 19) {
			if ("???".equals(num.substring(16, 19))) {
				num.delete(16, 19);
				num.replace(6, 12, "******");
				return num.toString();
			} else {
				num.replace(6, 15, "*********");
				return num.toString();
			}

		} else {
			return null;
		}

	}
}