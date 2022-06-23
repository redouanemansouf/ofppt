/*
 * ReservationDetailVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.vo.transformer.ReservationDetailVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class ReservationDetailVO.
 * 
 * @version 1.0 12 oct. 2015
 * @author mbenboubker
 */
public class ReservationDetailVO implements ValueObject, ISearchResultVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1040737447349570238L;

	/** The id. */
	private Long id;

	/** The services. */
	private ServiceVO service = new ServiceVO();

	/** The date service. */
	private Date dateService;

	/** The etat. */
	private EtatReservation etat;

	/** The reservation. */
	private ReservationVO reservation;

	/**
	 * Instantiates a new reservation detail vo.
	 */
	public ReservationDetailVO() {
		super();
	}

	/**
	 * Instantiates a new reservation detail vo.
	 * 
	 * @param service
	 *            the service
	 * @param dateService
	 *            the date service
	 * @param etat
	 *            the etat
	 * @param reservation
	 *            the reservation
	 */
	public ReservationDetailVO(ServiceVO service, Date dateService,
			EtatReservation etat, ReservationVO reservation) {
		super();
		this.service = service;
		this.dateService = dateService;
		this.etat = etat;
		this.reservation = reservation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ValueObject#getTransformer()
	 */
	@Override
	public ITransformer<ReservationDetail, ReservationDetailVO> getTransformer() {
		return new ReservationDetailVOTransformer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.ISearchResultVO#getIdForSearch()
	 */
	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return String.valueOf(id) + " " + service.getLibelle() + " "
				+ formatter.format(dateService) + " "
				+ etat.getEtatReservation();
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
	 * Gets the service.
	 * 
	 * @return the service
	 */
	public ServiceVO getService() {
		return service;
	}

	/**
	 * Sets the service.
	 * 
	 * @param service
	 *            the new service
	 */
	public void setService(ServiceVO service) {
		this.service = service;
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
	 * Gets the reservation.
	 * 
	 * @return the reservation
	 */
	public ReservationVO getReservation() {
		return reservation;
	}

	/**
	 * Sets the reservation.
	 * 
	 * @param reservation
	 *            the new reservation
	 */
	public void setReservation(ReservationVO reservation) {
		this.reservation = reservation;
	}

}
