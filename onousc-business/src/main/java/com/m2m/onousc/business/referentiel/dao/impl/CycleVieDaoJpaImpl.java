/*
 * CanalVenteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.dao.CycleVieDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.web.SearchConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("cycleDao")
public class CycleVieDaoJpaImpl extends GenericDaoJpaImpl<CycleVie, Long> implements CycleVieDaoJpa {

	@Override
	public List<CycleVie> findByCriteria(CycleVieCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getNumSerie(), criteria.getOperation(),
				criteria.getDateOperation(),

				criteria.getOperateur(), criteria.getStatut(), criteria.getNumPorteur(), criteria.getCin(),
				criteria.getCodeMassar(), criteria.getIdSite() };
		String queryString = Queries.FIND_CYCLE_VIE__BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<CycleVie> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_CYCLEVIE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<CycleVie> findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CYCLE_VIE_BY_CODE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<CycleVie> findByCycleVieByDate(Date dateDebut, Date dateFin) {
		Object[] parameters = new Object[] { dateDebut, dateFin };
		String queryString = Queries.FIND_CYCLE_VIE__BY_DATE;
		String orderByClause = "";
		return findByCriteria(queryString, orderByClause, new SearchConfig(), parameters);
	}

	@Override
	public List<CycleVie> findCycleByDeliv(CycleVieCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getNumSerie(), criteria.getOperation(),
				criteria.getDateOperation(),

				criteria.getOperateur(), criteria.getStatut(), criteria.getNumPorteur() };
		String queryString = Queries.FIND_CYCLE_VIE__BY_CRITERIA_FABR;
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, true, orderByClause, criteria.getSearchConfig(), parameters);
	}

}
