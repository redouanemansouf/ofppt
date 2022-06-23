/*
 * ReservationWebBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.edition.webbean;

import java.util.Date;

import com.m2m.technicalservices.web.BaseWebBean;

/**
 * The Class ReservationWebBean.
 * 
 * @version 1.0 19 oct. 2015
 * @author iissouani
 */
public class EditionWebBean extends BaseWebBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7224833772283479772L;

	private Date date_debut;
	private Date date_fin;
	private String type_fichier;
	private String Status;
	
	/**
	 * @return
	 */
	public String getStatus() {
		return Status;
	}
	/**
	 * @param status
	 */
	public void setStatus(String status) {
		Status = status;
	}
	
	/**
	 * @return
	 */
	public Date getDate_debut() {
		return date_debut;
	}
	
	/**
	 * @param date_debut
	 */
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	/**
	 * @return
	 */
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public String getType_fichier() {
		return type_fichier;
	}
	public void setType_fichier(String type_fichier) {
		this.type_fichier = type_fichier;
	}
}
