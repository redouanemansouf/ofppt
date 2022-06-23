/*
 * Reservation.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.reservation.vo.EtatReservation;
import com.m2m.onousc.business.reservation.vo.TypeReservation;
import com.m2m.technicalservices.dao.impl.GenericEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class Reservation.
 * 
 * @author user
 * @version 1.0 12 oct. 2015
 */
@Entity
@Table(name = "RESERVATION")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "RESERVATION_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Reservation extends GenericEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1118181868685009422L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	/** The date operation. */
	@Column(name = "DATE_OPERATION")
	@Temporal(TemporalType.DATE)
	private Date dateOperation;

	/** The type reservation. */
	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private TypeReservation typeReservation;

	/** The reservation. */
	@Column(name = "LIBELLE")
	private String libelle;

	/** The etat. */
	@Column(name = "ETAT")
	@Enumerated(EnumType.STRING)
	private EtatReservation etat;

	/** The reservation details. */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "reservation")
	private List<ReservationDetail> reservationDetail;

	/** The montant. */
	@Column(name = "MONTANT")
	private Double montant;

	/** The porteur. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARTE")
	private Carte carte;

	@Column(name = "USER")
	private String user;

	/** The restaurant. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESTAURANT")
	private Restaurant restaurant;

	/** The borne. */
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "BORNE")
	// private Borne borne;

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
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @param typeReservation the new type reservation
	 */
	public void setTypeReservation(TypeReservation typeReservation) {
		this.typeReservation = typeReservation;
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
	 * @param dateOperation the new date operation
	 */
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	/**
	 * Gets the reservation detail.
	 * 
	 * @return the reservation detail
	 */
	public List<ReservationDetail> getReservationDetail() {
		return reservationDetail;
	}

	/**
	 * Sets the reservation detail.
	 * 
	 * @param reservationDetail the new reservation detail
	 */
	public void setReservationDetail(List<ReservationDetail> reservationDetail) {
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
	 * @param montant the new montant
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * Gets the carte.
	 * 
	 * @return the carte
	 */
	public Carte getCarte() {
		return carte;
	}

	/**
	 * Sets the carte.
	 * 
	 * @param carte the new carte
	 */
	public void setCarte(Carte carte) {
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
	 * @param libelle the new libelle
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
	 * @param etat the new etat
	 */
	public void setEtat(EtatReservation etat) {
		this.etat = etat;
	}

	/**
	 * Gets the restaurant.
	 * 
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * Sets the restaurant.
	 * 
	 * @param restaurant the new restaurant
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
