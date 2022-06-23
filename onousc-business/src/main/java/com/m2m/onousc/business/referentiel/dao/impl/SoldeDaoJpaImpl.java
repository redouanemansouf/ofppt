/*
 * CarteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.SoldeCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.SoldeDaoJpa;
import com.m2m.onousc.business.referentiel.model.Solde;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("soldeDao")
public class SoldeDaoJpaImpl extends GenericDaoJpaImpl<Solde, Long> implements SoldeDaoJpa {

	@Override
	public List<Solde> findSoldeByCriteria(SoldeCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getMatr(), criteria.getDated(), criteria.getDatef(),
				criteria.getIdSite() };
		String queryString = Queries.FIND_SOLDE_BY_CRITERIA;
//		String orderByClause = criteria.getSortField() != null ? " order by "
//				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

}
