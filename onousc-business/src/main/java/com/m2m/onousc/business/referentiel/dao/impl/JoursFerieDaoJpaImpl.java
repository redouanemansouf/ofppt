/*
 * JoursFerieDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.JoursFerieCriteria;
import com.m2m.onousc.business.referentiel.dao.JoursFerieDao;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.JoursFerie;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * 
 * @author abousnane
 * 
 */
@Repository("joursferieDao")
public class JoursFerieDaoJpaImpl extends GenericDaoJpaImpl<JoursFerie, Long>
		implements JoursFerieDao {

	@Override
	public List<JoursFerie> findByCriteria(JoursFerieCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getDate_debut(),
				criteria.getDate_fin(), criteria.getAnnee(),
				criteria.getAnneeUniv(), statusCode };
		String queryString = Queries.FIND_JOURS_FERIE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<JoursFerie> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_JOURS_FERIE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<JoursFerie> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_JOURS_FERIE_BY_CODE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<JoursFerie> findByCodeAnneeUniversitaire(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_JOURS_FERIE_BY_CODE_ANNEE_UNIVERSITAIRE;
		return executeQuery(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.JoursFerieDao#isFreeDay(java.
	 * util.Date)
	 */
	@Override
	public boolean isFreeDay(Date date) {
		Object[] parameters = new Object[] { date };
		String queryString = Queries.FIND_JOUR_FERIE_BY_DATE;
		Query countQuery = createQuerySingleResult(queryString, parameters);
		long x = (Long) countQuery.getSingleResult();
		if (x == 0) {
			return false;
		} else {
			return true;
		}
	}

}
