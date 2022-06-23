/*
 * ReservationDetailDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.dao;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.vo.EtatReservation;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface ReservationDetailDaoJpa.
 * 
 * @version 1.0 12 oct. 2015
 * @author user
 */
public interface ReservationDetailDaoJpa extends
		GenericDaoJpa<ReservationDetail, Long> {

	/**
	 * Find by reservation.
	 * 
	 * @param id
	 *            the id
	 * @return the list
	 */
	List<ReservationDetail> findByReservation(Long id);

	/**
	 * Find by reservation by etat.
	 * 
	 * @param etat
	 *            the etat
	 * @return the list
	 */
	List<ReservationDetail> findByReservationByEtat(EtatReservation etat, String carte);

	/**
	 * Count by date by service.
	 * 
	 * @param dateService
	 *            the date service
	 * @param id
	 *            the id
	 * @return the long
	 */
	 Long countByDateByService(Date dateService, Long id,String carte);

	List<ReservationDetail> findByReservationDetailByService(String code);
	
	

}
