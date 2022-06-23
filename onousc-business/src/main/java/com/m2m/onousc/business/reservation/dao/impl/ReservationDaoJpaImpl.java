/*
 * ReservationDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.reservation.dao.ReservationDaoJpa;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class ReservationDaoJpaImpl.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenboubker
 */
@Repository("reservationDao")
public class ReservationDaoJpaImpl extends GenericDaoJpaImpl<Reservation, Long>
		implements ReservationDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.reservation.dao.ReservationDaoJpa#findByUser(
	 * java.lang.String)
	 */
	@Override
	public List<Reservation> findByUser(String user) {
		Object[] parameters = new Object[] { user };
		String queryString = Queries.FIND_RESERVATION_BY_USER;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Reservation> findReservationByDate(Date dateDebut, Date dateFin) {
		Object[] parameters = new Object[] { dateDebut, dateFin };
		String queryString = Queries.FIND_RESERVATION__BY_DATE;
		String orderByClause = "";
		return findByCriteria(queryString, orderByClause, new SearchConfig(),
				parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.reservation.dao.ReservationDaoJpa#findByNumeroCarte
	 * (java.lang.String)
	 */
	@Override
	public List<Reservation> findByNumeroCarte(String numeroCarte) {
		Object[] parameters = new Object[] { numeroCarte };
		String queryString = Queries.FIND_RESERVATION_BY_PORTEUR;
		return executeQuery(queryString,0,10, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.reservation.dao.ReservationDaoJpa#countByCode
	 * (java.lang.String)
	 */
	@Override
	public Long countByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_COUNT_RESERVATION_BY_CODE;
		Query countQuery = createQuerySingleResult(queryString, parameters);
		return (Long) countQuery.getSingleResult();
	}
	@Override
	public List<Reservation> findByCodeRestaurant(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_RESERVATION_BY_CODE_RESTAURANT;
		return executeQuery(queryString, parameters);
	}

	
	@Override
	public List<Reservation> findReservationByIdPorteur(String porteur) {
		Object[] parameters = new Object[] { porteur };
		String queryString = Queries.FIND_RESERVATION_BY_IDPORTEUR;
		return executeQuery(queryString, parameters);
	}
}
