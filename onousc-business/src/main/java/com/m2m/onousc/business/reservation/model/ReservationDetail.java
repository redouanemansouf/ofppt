/*
 * ReservationDetail.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.referentiel.model.Service;
import com.m2m.onousc.business.reservation.vo.EtatReservation;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * The Class ReservationDetail.
 * 
 * @version 1.0 12 oct. 2015
 * @author user
 */
@Entity
@Table(name = "RESERVATION_DETAIL")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "RESERVATION_DETAIL_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class ReservationDetail extends GenericEntity  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3315227542317888280L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	/** The service. */
	@ManyToOne
	@JoinColumn(name = "SERVICE")
	private Service service;

	/** The date service. */
	@Column(name = "DATE_SERVICE")
	@Temporal(TemporalType.DATE)
	private Date dateService;

	/** The etat. */
	@Column(name = "ETAT")
	@Enumerated(EnumType.STRING)
	private EtatReservation etat;

	/** The reservation. */
	@ManyToOne
	@JoinColumn(name = "ID_RESERVATION")
	private Reservation reservation;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getTraceInfo()
	 */
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getNameEntity()
	 */
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getId()
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
	 * Gets the etat.
	 * 
	 * @return the etat
	 */
	public EtatReservation getEtat() {
		return etat;
	}

	/**
	 * Sets the etat.
	 * 
	 * @param etat
	 *            the new etat
	 */
	public void setEtat(EtatReservation etat) {
		this.etat = etat;
	}

	/**
	 * Gets the date service.
	 * 
	 * @return the date service
	 */
	public Date getDateService() {
		return dateService;
	}

	/**
	 * Sets the date service.
	 * 
	 * @param dateService
	 *            the new date service
	 */
	public void setDateService(Date dateService) {
		this.dateService = dateService;
	}

	/**
	 * Gets the reservation.
	 * 
	 * @return the reservation
	 */
	public Reservation getReservation() {
		return reservation;
	}

	/**
	 * Sets the reservation.
	 * 
	 * @param reservation
	 *            the new reservation
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	/**
	 * Gets the service.
	 * 
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * Sets the service.
	 * 
	 * @param service
	 *            the new service
	 */
	public void setService(Service service) {
		this.service = service;
	}

}
