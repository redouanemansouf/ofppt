/*
 * ReservationParMoisVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Class ReservationParMois.
 * 
 * @version 1.0 10 oct. 2015
 * @author mbenboubker
 */
public class ReservationParMoisVO {

	/** The id. */
	private Long id;

	/** The mois. */
	private Integer code;

	/** The mois. */
	private String mois;

	/** The service midi. */
	private Boolean serviceMidi;

	/** The service soir. */
	private Boolean serviceSoir;

	/** The date debut. */
	private Date dateDebut;

	/** The date fin. */
	private Date dateFin;

	/** The services. */
	private List<String> services = new ArrayList<String>();

	/**
	 * Instantiates a new reservation par mois.
	 */
	public ReservationParMoisVO() {
		super();
	}

	/**
	 * Instantiates a new reservation par mois vo.
	 * 
	 * @param code
	 *            the code
	 * @param mois
	 *            the mois
	 * @param serviceMidi
	 *            the service midi
	 * @param serviceSoir
	 *            the service soir
	 */
	public ReservationParMoisVO(Integer code, String mois, Boolean serviceMidi,
			Boolean serviceSoir) {
		super();
		this.code = code;
		this.mois = mois;
		this.serviceMidi = serviceMidi;
		this.serviceSoir = serviceSoir;
	}

	/**
	 * Instantiates a new reservation par mois vo.
	 * 
	 * @param code
	 *            the code
	 * @param mois
	 *            the mois
	 * @param dateDebut
	 *            the date debut
	 * @param dateFin
	 *            the date fin
	 */
	public ReservationParMoisVO(Integer code, String mois, Date dateDebut,
			Date dateFin) {
		super();
		this.code = code;
		this.mois = mois;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the service midi.
	 * 
	 * @return the service midi
	 */
	public Boolean getServiceMidi() {
		return serviceMidi;
	}

	/**
	 * Sets the service midi.
	 * 
	 * @param serviceMidi
	 *            the new service midi
	 */
	public void setServiceMidi(Boolean serviceMidi) {
		this.serviceMidi = serviceMidi;
	}

	/**
	 * Gets the service soir.
	 * 
	 * @return the service soir
	 */
	public Boolean getServiceSoir() {
		return serviceSoir;
	}

	/**
	 * Sets the service soir.
	 * 
	 * @param serviceSoir
	 *            the new service soir
	 */
	public void setServiceSoir(Boolean serviceSoir) {
		this.serviceSoir = serviceSoir;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code
	 *            the new code
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Gets the mois.
	 * 
	 * @return the mois
	 */
	public String getMois() {
		return mois;
	}

	/**
	 * Sets the mois.
	 * 
	 * @param mois
	 *            the new mois
	 */
	public void setMois(String mois) {
		this.mois = mois;
	}

	/**
	 * Gets the services.
	 * 
	 * @return the services
	 */
	public List<String> getServices() {
		return services;
	}

	/**
	 * Sets the services.
	 * 
	 * @param services
	 *            the new services
	 */
	public void setServices(List<String> services) {
		this.services = services;
	}

	/**
	 * Gets the date debut.
	 * 
	 * @return the date debut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * Sets the date debut.
	 * 
	 * @param dateDebut
	 *            the new date debut
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Gets the date fin.
	 * 
	 * @return the date fin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * Sets the date fin.
	 * 
	 * @param dateFin
	 *            the new date fin
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
