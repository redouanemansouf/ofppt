/*
 * ReservationParSemaineVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class ReservationParSemaine.
 * 
 * @version 1.0 10 oct. 2015
 * @author mbenboubkker
 */
public class ReservationParSemaineVO implements ValueObject, ISearchResultVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3833938130323903139L;

	/** The id. */
	private Long id;

	/** The semaine. */
	private String semaine;

	/** The date debut. */
	private Date dateDebut;

	/** The date fin. */
	private Date dateFin;

	/** The service midi. */
	private Boolean serviceMidi = true;

	/** The service soir. */
	private Boolean serviceSoir = true;

	/** The services. */
	private List<String> services = new ArrayList<String>();

	/**
	 * Instantiates a new reservation par semaine vo.
	 */
	public ReservationParSemaineVO() {
		super();
	}
	
	
	/**
	 * Instantiates a new reservation par semaine vo.
	 * 
	 * @param semaine
	 *            the semaine
	 * @param dateDebut
	 *            the date debut
	 * @param dateFin
	 *            the date fin
	 */
	public ReservationParSemaineVO(String semaine, Date dateDebut, Date dateFin) {
		super();
		this.semaine = semaine;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}



	/**
	 * Instantiates a new reservation par semaine vo.
	 * 
	 * @param semaine
	 *            the semaine
	 * @param dateDebut
	 *            the date debut
	 * @param dateFin
	 *            the date fin
	 * @param serviceMidi
	 *            the service midi
	 * @param serviceSoir
	 *            the service soir
	 */
	public ReservationParSemaineVO(String semaine, Date dateDebut,
			Date dateFin, Boolean serviceMidi, Boolean serviceSoir) {
		super();
		this.semaine = semaine;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.serviceMidi = serviceMidi;
		this.serviceSoir = serviceSoir;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.ISearchResultVO#getIdForSearch()
	 */
	@Override
	public String getIdForSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ValueObject#getTransformer()
	 */
	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		// TODO Auto-generated method stub
		return null;
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
	 * Gets the semaine.
	 * 
	 * @return the semaine
	 */
	public String getSemaine() {
		return semaine;
	}

	/**
	 * Sets the semaine.
	 * 
	 * @param semaine
	 *            the new semaine
	 */
	public void setSemaine(String semaine) {
		this.semaine = semaine;
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

}
