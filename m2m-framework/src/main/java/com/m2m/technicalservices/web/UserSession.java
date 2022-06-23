package com.m2m.technicalservices.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.m2m.technicalservices.core.User;

public class UserSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String MBEAN_NAME = "userSession";
	private User userConecte;
	private ReportWebBean report;
	private String titreFonctionnalite;

	private Map<String, Object> specificParams = new HashMap<String, Object>();

	public User getUserConecte() {
		return userConecte;
	}

	public void setUserConecte(User userConecte) {
		this.userConecte = userConecte;
	}

	public ReportWebBean getReport() {
		return report;
	}

	public void setReport(ReportWebBean reportWebBean) {
		this.report = reportWebBean;
	}

	public String getTitreFonctionnalite() {
		return titreFonctionnalite;
	}

	public void setTitreFonctionnalite(String titreFonctionnalite) {
		this.titreFonctionnalite = titreFonctionnalite;
	}

	public Map<String, Object> getSpecificParams() {
		return specificParams;
	}

	public void setSpecificParams(Map<String, Object> specificParams) {
		this.specificParams = specificParams;
	}
	
	

}
