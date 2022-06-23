/*
 * ReservationService.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.service;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.SemaineUniversitaire;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.vo.EtatReservation;

/**
 * The Interface ReservationService.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenboubker
 */
public interface ReservationService {

	/**
	 * Find all semaine universitaire for combo.
	 * 
	 * @return the list
	 */
	List<SemaineUniversitaire> findAllSemaineUniversitaireForCombo();

	/**
	 * Find semaine universitaire by id.
	 * 
	 * @param idSemaineUniversitaire
	 *            the id semaine universitaire
	 * @return the semaine universitaire
	 */
	SemaineUniversitaire findSemaineUniversitaireById(
			long idSemaineUniversitaire);

	/**
	 * Find reservation by user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Reservation> findReservationByUser(String user);

	/**
	 * Find detail by reservation.
	 * 
	 * @param id
	 *            the id
	 * @return the list
	 */
	List<ReservationDetail> findDetailByReservation(Long id);

	/**
	 * Find reservation.
	 * 
	 * @param dateDebut
	 *            the date debut
	 * @param dateFin
	 *            the date fin
	 * @return the list
	 */
	List<Reservation> findReservation(Date dateDebut, Date dateFin);

	/**
	 * Find reservation by etat.
	 * 
	 * @param etat
	 *            the etat
	 * @return the list
	 */
	List<ReservationDetail> findReservationByEtat(EtatReservation etat,String carte);

	Carte findCarteByNumero(String numeroCarte);

	/**
	 * Find reservation by numero carte.
	 * 
	 * @param numeroCarte
	 *            the numero carte
	 * @return the list
	 */
	List<Reservation> findReservationByNumeroCarte(String numeroCarte);

	/**
	 * Count reservation by code.
	 * 
	 * @param code
	 *            the code
	 * @return the int
	 */
	Long countReservationByCode(String code);

	/**
	 * Count reservation detail by date by service.
	 * 
	 * @param dateService
	 *            the date service
	 * @param id
	 *            the id
	 * @return the long
	 */
	 Long countReservationDetailByDateByService(Date dateService, Long id,String carte);

	List<Reservation> findReservationByCodeRestaurant(String code);

	List<ReservationDetail> findReservationDetailByCodeService(String code);

	List<Reservation> findReservationByIdPorteur(String porteur);

}
