/*
 * CanalVenteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.DelivranceCriteria;
import com.m2m.onousc.business.referentiel.dao.DelivranceDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.DelivranceCarte;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("delicCarteDao")
public class DelivCarteDaoJpaImpl extends
		GenericDaoJpaImpl<DelivranceCarte, Long> implements DelivranceDaoJpa {

	@Override
	public List<DelivranceCarte> findDelivByCriteria(DelivranceCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getDateDelivrance(),criteria.getDateDelivranceAu(),
				criteria.getCategorie(), criteria.getEtudiant(),criteria.getIdSite() };
		String queryString = Queries.FIND_DELIVRANCE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<DelivranceCarte> findDelivForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_DELIVRANCE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<DelivranceCarte> findDelivByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
