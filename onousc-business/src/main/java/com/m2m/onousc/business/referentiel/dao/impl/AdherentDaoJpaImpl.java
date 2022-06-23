/*
 * CarteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.AdherentCriteria;
import com.m2m.onousc.business.referentiel.criteria.CarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.LotCarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionAdhCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.dao.AdherentDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.PersonnelDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("adherentDao")
public class AdherentDaoJpaImpl extends GenericDaoJpaImpl<Adherent, Long> implements
		AdherentDaoJpa {
	
	@Override
	public List<Adherent> findAdherentByCriteria(AdherentCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getMatr(),
				criteria.getNom(), criteria.getPrenom(),criteria.getPersonnel(),
				criteria.getCni() };
		String queryString = Queries.FIND_ADHERNT_BY_CRIERIA;
		String orderByClause=" order by matr DESC ";
		return findByCriteria(queryString ,orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public Adherent findAdherentByNom(String matr, String nom, String prenom) {

		Object[] parameters = new Object[] { matr,nom,prenom  };
		Adherent adh=null;
		try {
			String queryString = Queries.FIND_ADHERENT_BY_MATRICULE;
			adh=executeQuerySingleResult(queryString, parameters);
		} catch (NoResultException e) {
			adh=null;
		}
		return adh;
	}

	@Override
	public List<Adherent> findAdherentByPersonnel(Long id) {
		Object[] parameters = new Object[] { id };
		String queryString = Queries.FIND_ADHERENT_BY_PERSONNEL;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Adherent> findAdherentByAgeNscol(String matr) {
		Object[] parameters = new Object[] { matr };
		String queryString = Queries.FIND_ADH_AGE_NSCOLARISE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Adherent> findAdherentByAgescol(String matr) {
		Object[] parameters = new Object[] { matr };
		String queryString = Queries.FIND_ADH_AGE_SCOLARISE;
		return executeQuery(queryString, parameters);
	}

	
	@Override
	public List<Adherent> findAllAdherent() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_ADHERENT_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}
	
	@Override
	public List<Adherent> findOppositionAdhByCriteria(OppositionAdhCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getMatrAdh(),
				criteria.getNom(), criteria.getStatut()!= null? criteria.getStatut().getStatusCode():null,
				criteria.getPrenom()};
		String queryString = Queries.FIND_OPPOSITION_ADH_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString ,orderByClause,
				criteria.getSearchConfig(), parameters);
	}	
	
}
