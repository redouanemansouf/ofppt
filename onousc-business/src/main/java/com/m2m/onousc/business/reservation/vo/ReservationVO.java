/*
 * ReservationVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.vo.transformer.ReservationVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class ReservationVO.
 * 
 * @author mbenboubker
 * @version 1.0 12 oct. 2015
 */
public class ReservationVO implements ValueObject, ISearchResultVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6206239823279278145L;

	/** The id. */
	private Long id;

	/** The date operation. */
	private Date dateOperation;

	/** The type reservation. */
	private TypeReservation typeReservation;

	/** The libelle. */
	private String libelle;

	/** The etat. */
	private EtatReservation etat;

	/** The reservations. */
	private List<ReservationDetailVO> reservationDetail = new ArrayList<ReservationDetailVO>();

	/** The montant. */
	private Double montant;

	/** The porteur. */
	private CarteVO carte = new CarteVO();;

	/** The restaurant. */
	private RestaurantVO restaurant = new RestaurantVO();

	/** The borne. */
	// private BorneVO borne = new BorneVO();

	/**
	 * Instantiates a new reservation vo.
	 */
	public ReservationVO() {
		super();
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
	 * @see com.m2m.technicalservices.core.ValueObject#getTransformer()
	 */
	@Override
	public ITransformer<Reservation, ReservationVO> getTransformer() {
		return new ReservationVOTransformer();
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
	 * Gets the date operation.
	 * 
	 * @return the date operation
	 */
	public Date getDateOperation() {
		return dateOperation;
	}

	/**
	 * Sets the date operation.
	 * 
	 * @param dateOperation
	 *            the new date operation
	 */
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	/**
	 * Gets the type reservation.
	 * 
	 * @return the type reservation
	 */
	public TypeReservation getTypeReservation() {
		return typeReservation;
	}

	/**
	 * Sets the type reservation.
	 * 
	 * @param typeReservation
	 *            the new type reservation
	 */
	public void setTypeReservation(TypeReservation typeReservation) {
		this.typeReservation = typeReservation;
	}

	/**
	 * Gets the reservation detail.
	 * 
	 * @return the reservation detail
	 */
	public List<ReservationDetailVO> getReservationDetail() {
		return reservationDetail;
	}

	/**
	 * Sets the reservation detail.
	 * 
	 * @param reservationDetail
	 *            the new reservation detail
	 */
	public void setReservationDetail(List<ReservationDetailVO> reservationDetail) {
		this.reservationDetail = reservationDetail;
	}

	/**
	 * Gets the montant.
	 * 
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * Sets the montant.
	 * 
	 * @param montant
	 *            the new montant
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * Gets the carte.
	 * 
	 * @return the carte
	 */
	public CarteVO getCarte() {
		return carte;
	}

	/**
	 * Sets the carte.
	 * 
	 * @param carte
	 *            the new carte
	 */
	public void setCarte(CarteVO carte) {
		this.carte = carte;
	}

	/**
	 * Gets the libelle.
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 * 
	 * @param libelle
	 *            the new libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	 * Gets the restaurant.
	 * 
	 * @return the restaurant
	 */
	public RestaurantVO getRestaurant() {
		return restaurant;
	}

	/**
	 * Sets the restaurant.
	 * 
	 * @param restaurant
	 *            the new restaurant
	 */
	public void setRestaurant(RestaurantVO restaurant) {
		this.restaurant = restaurant;
	}

}
