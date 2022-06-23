/*
 * ReservationParJourVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.ServiceVO;

/**
 * The Class ReservationParJourVO.
 * 
 * @version 1.0 12 oct. 2015
 * @author mbenboubker
 */
/**
 * @author user
 * 
 */
public class ReservationParJourVO {

	/** The id. */
	private Long id;

	/** The date reservation. */
	private Date dateReservation;

	/** The jour semaine. */
	private Integer jourSemaine;

	/** The service midi. */
	private Boolean serviceMidi = true;

	/** The service soir. */
	private Boolean serviceSoir = true;

	/** The service vo. */
	private ServiceVO serviceVO = new ServiceVO();

	/** The services. */
	private List<ServiceVO> services = new ArrayList<ServiceVO>();

	/**
	 * Instantiates a new reservation par jour vo.
	 */
	public ReservationParJourVO() {
		super();
	}

	/**
	 * Instantiates a new reservation par jour vo.
	 * 
	 * @param dateReservation
	 *            the date reservation
	 * @param jourSemaine
	 *            the jour semaine
	 */
	public ReservationParJourVO(Date dateReservation, Integer jourSemaine) {
		super();
		this.dateReservation = dateReservation;
		this.jourSemaine = jourSemaine;
	}

	/**
	 * Instantiates a new reservation par jour vo.
	 * 
	 * @param dateReservation
	 *            the date reservation
	 */
	public ReservationParJourVO(Date dateReservation) {
		super();
		this.dateReservation = dateReservation;
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
	 * Gets the date reservation.
	 * 
	 * @return the date reservation
	 */
	public Date getDateReservation() {
		return dateReservation;
	}

	/**
	 * Sets the date reservation.
	 * 
	 * @param dateReservation
	 *            the new date reservation
	 */
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
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
	public List<ServiceVO> getServices() {
		return services;
	}

	/**
	 * Sets the services.
	 * 
	 * @param services
	 *            the new services
	 */
	public void setServices(List<ServiceVO> services) {
		this.services = services;
	}

	/**
	 * Gets the jour semaine.
	 * 
	 * @return the jour semaine
	 */
	public Integer getJourSemaine() {
		return jourSemaine;
	}

	/**
	 * Sets the jour semaine.
	 * 
	 * @param jourSemaine
	 *            the new jour semaine
	 */
	public void setJourSemaine(Integer jourSemaine) {
		this.jourSemaine = jourSemaine;
	}

	/**
	 * Gets the service vo.
	 * 
	 * @return the service vo
	 */
	public ServiceVO getServiceVO() {
		return serviceVO;
	}

	/**
	 * Sets the service vo.
	 * 
	 * @param serviceVO
	 *            the new service vo
	 */
	public void setServiceVO(ServiceVO serviceVO) {
		this.serviceVO = serviceVO;
	}

}
