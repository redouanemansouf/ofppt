/*
 * FiliereDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.FiliereCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.FiliereDaoJpa;
import com.m2m.onousc.business.referentiel.model.Filiere;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * The Class FiliereDaoJpaImpl.
 * 
 * @version 1.0 28 oct. 2015
 * @author user
 */
@Repository("filiereDao")
public class FiliereDaoJpaImpl extends GenericDaoJpaImpl<Filiere, Long> implements FiliereDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.dao.FiliereDaoJpa#findByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.FiliereCriteria)
	 */
	@Override
	public List<Filiere> findByCriteria(FiliereCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(), criteria.getLibelle(), statusCode,
				criteria.getIdSite() };
		String queryString = Queries.FIND_FILIERE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.dao.FiliereDaoJpa#findForCombo()
	 */
	@Override
	public List<Filiere> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_FILIERE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.dao.FiliereDaoJpa#findByCode(java
	 * .lang.String)
	 */
	@Override
	public Filiere findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_FILIERE_BY_CODE;
		return executeQuerySingleResult(queryString, parameters);
	}

	@Override
	public List<Filiere> findByIdSite(Long idSite) {
		Object[] parameters = new Object[] { idSite };
		String queryString = Queries.FIND_FILIERE_BY_IDSITE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Filiere> findAllFiliere() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filiere findFiliereByLongId(Long id) {
		Object[] parameters = new Object[] { id };
		String queryString = Queries.FIND_FILIERE_BY_CODE;
		return executeQuerySingleResult(queryString, parameters);
	}

	@Override
	public List<Filiere> findFiliereListByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_FILIERE_LIST_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
