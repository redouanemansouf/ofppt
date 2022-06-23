/*
 * CarteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.dao.PersonnelDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("personnelDao")
public class PersonnelDaoJpaImpl extends GenericDaoJpaImpl<Personnel, Long> implements
PersonnelDaoJpa {



	@Override
	public List<Personnel> findPersonnelByCriteria(PersonnelCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getMatr(),
				criteria.getNom(), criteria.getPrenom(),
				criteria.getNumidentite() ,criteria.getCategorie(),criteria.getEtab(), criteria.getDatedebut() , criteria.getDatefin()};
		String queryString = Queries.FIND_PERSONNEL_BY_CRIERIA;
//		String orderByClause=" order by matr DESC ";
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString ,orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public Personnel findPersonnelByMatr(String matr) {
		Object[] parameters = new Object[] { matr };
		Personnel result=null;
		try {
			String queryString = Queries.FIND_PERSONNEL_BY_MATRICULE;
			result=executeQuerySingleResult(queryString, parameters);
		} catch (NoResultException e) {
			result=null;
		}
		return result;
	}



	@Override
	public List<Personnel> findAllPersonnel() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_PERSONNEL_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<String> getTrancheByProfil(String jour, Long profil) {
		String queryString = Queries.FIND_TRANCHE_BYPROFIL;
		Query q = getEm().createNativeQuery(queryString);
		q.setParameter("JOUR", jour);
		q.setParameter("PROFIL", profil);
		List<String>  result =  q.getResultList();
		return result;
	}

	@Override
	public List<Personnel> findOppositionPersoByCriteria(OppositionCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getMatr(),
				criteria.getNom(), criteria.getStatut()!= null? criteria.getStatut().getStatusCode():null,
				criteria.getPrenom(),criteria.getIdSite()};
		String queryString = Queries.FIND_OPPOSITION_PERSO_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString ,orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Personnel> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_PERSONNEL_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}


}
