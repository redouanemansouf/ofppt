/*
 * CanalVenteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.SiteCriteria;
import com.m2m.onousc.business.referentiel.dao.SiteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class SiteDaoJpaImpl.
 *
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
@Repository("siteDaoJpa")
public class SiteDaoJpaImpl extends GenericDaoJpaImpl<Site, Long>
		implements SiteDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.CanalVenteDaoJpa#findByCriteria
	 * (java.lang.String, java.lang.String,
	 * com.m2m.technicalservices.web.SearchConfig, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Site> findByCriteria(SiteCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getLibelle()
				  };
		String queryString = Queries.FIND_SITE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Site> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_CANAL_VENTE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Site> findByCode() {
		/*Object[] parameters = new Object[] { code };*/
		String queryString = Queries.FIND_CANAL_VENTE_BY_CLIENT;
		return executeQuery(queryString);
	}

	@Override
	public Site findSiteByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CANAL_BY_CODE;
		return executeQuerySingleResult(queryString, parameters);
	}

	@Override
	public List<Site> findSiteListByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_SITE_BY_CODE;
		return executeQuery(queryString , parameters);
	}

}
