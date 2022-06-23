/*
 * ReservationBorneDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.ReservationBorneCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.ReservationBorneDaoJpa;
import com.m2m.onousc.business.referentiel.model.ReservationBorne;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

@Repository("reservationBorneDao")
public class ReservationBorneDaoJpaImpl extends GenericDaoJpaImpl<ReservationBorne, Long>
		implements ReservationBorneDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.ReservationBorneDaoJpa#findByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.ReservationBorneCriteria)
	 */
	@Override
	public List<ReservationBorne> findByCriteria(ReservationBorneCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria.getStatut().name();
		Object[] parameters = new Object[] { criteria.getMontant(), criteria.getCartePorteur(), criteria.getIdBorne(),
				criteria.getIdSite() };
		String queryString = Queries.FIND_RESERVATION_BORNE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

	@Override
	public ReservationBorne findReservationBorneById(Long id) {
		Object[] parameters = new Object[] { id };
//		String queryString = Queries.FIND_RESERVATION_BORNE_BY_CODE;
		String queryString = null;
		return executeQuerySingleResult(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.ReservationBorneDaoJpa#findForCombo()
	 */
	@Override
	public List<ReservationBorne> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_RESERVATION_BORNE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.ReservationBorneDaoJpa#findByCode(
	 * java .lang.String)
	 */
	@Override
	public ReservationBorne findByCarte(String code) {
		Object[] parameters = new Object[] { code };
//		String queryString = Queries.FIND_RESERVATION_BORNE_BY_CODE;
		String queryString = null;
		return executeQuerySingleResult(queryString, parameters);
	}

	@Override
	public List<ReservationBorne> findReservationBorneByIdBorne(Long idSite) {
		Object[] parameters = new Object[] { idSite };
		// String queryString = Queries.FIND_RESERVATION_BORNE_BY_IDSITE;
		String queryString = null;
		return executeQuery(queryString, parameters);
	}

}
