/*
 * CanalVenteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.CanalVenteCriteria;
import com.m2m.onousc.business.referentiel.dao.CanalVenteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 *
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
@Repository("canalVenteDao")
public class CanalVenteDaoJpaImpl extends GenericDaoJpaImpl<CanalVente, Long> implements CanalVenteDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.dao.CanalVenteDaoJpa#findByCriteria
	 * (java.lang.String, java.lang.String,
	 * com.m2m.technicalservices.web.SearchConfig, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<CanalVente> findByCriteria(CanalVenteCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria.getStatut().name();
		Object[] parameters = new Object[] { criteria.getIdSite(), criteria.getLibelle() };
		String queryString = Queries.FIND_CANAL_VENTE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<CanalVente> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_CANAL_VENTE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<CanalVente> findByCode() {
		/* Object[] parameters = new Object[] { code }; */
		String queryString = Queries.FIND_CANAL_VENTE_BY_CLIENT;
		return executeQuery(queryString);
	}

	@Override
	public List<CanalVente> findBySite(Long idSite) {
		Object[] parameters = new Object[] { idSite };
		String queryString = Queries.FIND_CANAL_VENTE_BY_SITE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public CanalVente findCanalByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CANAL_BY_CODE;
		return executeQuerySingleResult(queryString, parameters);
	}

	@Override
	public List<CanalVente> findCanalListByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CANAL_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
