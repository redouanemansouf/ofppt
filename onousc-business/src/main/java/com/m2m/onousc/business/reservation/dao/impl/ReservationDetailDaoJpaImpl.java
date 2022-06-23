/*
 * ReservationDetailDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.reservation.dao.ReservationDetailDaoJpa;
import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.vo.EtatReservation;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.tools.DateUtil;

/**
 * The Class ReservationDetailDaoJpaImpl.
 * 
 * @version 1.0 27 oct. 2015
 * @author user
 */
@Repository("reservationDetailDao")
public class ReservationDetailDaoJpaImpl extends
		GenericDaoJpaImpl<ReservationDetail, Long> implements
		ReservationDetailDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.dao.ReservationDetailDaoJpa#
	 * findByReservation(java.lang.Long)
	 */
	@Override
	public List<ReservationDetail> findByReservation(Long id) {
		Object[] parameters = new Object[] { id };
		String queryString = Queries.FIND_RESERVATION_DETAIL_BY_ID_RESERVATION;
		return executeQuery(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.dao.ReservationDetailDaoJpa#
	 * findByReservationByEtat
	 * (com.m2m.onousc.business.reservation.vo.EtatReservation)
	 */
	@Override
	public List<ReservationDetail> findByReservationByEtat(EtatReservation etat, String carte) {
		Object[] parameters = new Object[] { etat ,carte };
		String queryString = Queries.FIND_RESERVATION_DETAIL_BY_ETAT;
		return executeQuery(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.dao.ReservationDetailDaoJpa#
	 * countByDateByService(java.util.Date, java.lang.Long)
	 */
	@Override
	public Long countByDateByService(Date dateService, Long id,String carte) {
		int day = DateUtil.getDay(dateService);
		int month = DateUtil.getMonth(dateService);
		int year = DateUtil.getYear(dateService);
		Object[] parameters = new Object[] { day, month, year, id,carte };
		String queryString = Queries.FIND_RESERVATION_DETAIL_BY_DATE_BY_SERVICE;
		Query countQuery = createQuerySingleResult(queryString, parameters);
		return (Long) countQuery.getSingleResult();
	}

	@Override
	public List<ReservationDetail> findByReservationDetailByService(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_RESERVATION_DETAIL_BY_CODE_SERVICE;
		return executeQuery(queryString, parameters);
	}

}
