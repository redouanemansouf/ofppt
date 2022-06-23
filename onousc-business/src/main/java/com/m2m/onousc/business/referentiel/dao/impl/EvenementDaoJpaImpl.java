/*
 * CarteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.EvenementCriteria;
import com.m2m.onousc.business.referentiel.criteria.ProduitCriteria;
import com.m2m.onousc.business.referentiel.dao.EvenementDaoJpa;
import com.m2m.onousc.business.referentiel.dao.ProduitDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Evenement;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.model.Produit;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("evenementDao")
public class EvenementDaoJpaImpl extends GenericDaoJpaImpl<Evenement, Long>
		implements EvenementDaoJpa {

	@Override
	public List<Evenement> findEvenementtByCriteria(EvenementCriteria criteria) {
		
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getEtat(), criteria.getDateDebut(),
				criteria.getDateFin()};
		String queryString = Queries.FIND_EVENEMENT_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

/*	@Override
	public List<Produit> findProduitByCriteria(ProduitCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getMontant(),
				criteria.getTva(), criteria.getCodeBar(),
				criteria.getFamilleProd() };
		String queryString = Queries.FIND_PRODUIT_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Produit> findProduitByFamille(Long id) {
		Object[] parameters = new Object[] { id };
		String queryString = Queries.FIND_PRODUIT_BY_FAMILLE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public Produit findProduitByCodeBar(String codeBar) {
		Object[] parameters = new Object[] { codeBar };
		Produit result=null;
		try {
			String queryString = Queries.FIND_Produit_BY_CODEBAR;
			result=executeQuerySingleResult(queryString, parameters);
		} catch (NoResultException e) {
			result=null;
		}
		return result;
	}
*/
}
