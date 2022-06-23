/*
 * ReservationDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.dao;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface ReservationDaoJpa.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenboubker
 */
public interface ReservationDaoJpa extends GenericDaoJpa<Reservation, Long> {

	/**
	 * Find by user.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<Reservation> findByUser(String user);

	/**
	 * @param dateDebut
	 * @param dateFin
	 * @return
	 */
	List<Reservation> findReservationByDate(Date dateDebut, Date dateFin);

	/**
	 * Find by numero carte.
	 * 
	 * @param numeroCarte
	 *            the numero carte
	 * @return the list
	 */
	List<Reservation> findByNumeroCarte(String numeroCarte);

	/**
	 * Count by code.
	 * 
	 * @param code
	 *            the code
	 * @return the int
	 */
	Long countByCode(String code);

	// public List<CanalVente> findByCriteria(CanalVenteCriteria criteria);
	List<Reservation> findByCodeRestaurant(String code);

	List<Reservation> findReservationByIdPorteur(String porteur);

}
