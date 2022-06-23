/*
 * CanalVenteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.business.referentiel.dao.EtudiantDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.web.SearchConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("etudiantDao")
public class EtudiantsDaoJpaImpl extends GenericDaoJpaImpl<Etudiants, Long> implements EtudiantDaoJpa {

	@Override
	public List<Etudiants> findByCriteria(EtudiantCriteria criteria) {

		Object[] parameters = new Object[] { criteria.getAnn_universitaire(), criteria.getNdemande(), criteria.getNom(),
				criteria.getPrenom(), criteria.getNCIN(), criteria.getBoursier(), criteria.getEmail(),
				criteria.getResident(), criteria.getEtablissement(), criteria.getStatus(), criteria.getIdSite(),
				criteria.getRestaurant() };
		String queryString = Queries.FIND_DEMANDE_BY_CRITERIA;

		String orderByClause = " order by note DESC ";

		// String orderByClause = criteria.getSortField() != null ? " order by "
		// + criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Etudiants> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_ETUDIANT_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Etudiants> findEtudiantByStatus(String status) {
		Object[] parameters = new Object[] { status };
		String queryString = Queries.FIND_ALL_ETUDIANT_BY_STATUS;
		String orderByClause = "";
		return findByCriteria(queryString, orderByClause, new SearchConfig(), parameters);
	}

	@Override
	public List<Etudiants> findByLibelleCite(String libelle) {
		Object[] parameters = new Object[] { libelle };
		String queryString = Queries.FIND_ETUDIANT_BY_CITE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Etudiants> findByCodeRestaurant(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_ETUDIANTS_BY_CODE_RESTAURANT;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Etudiants> findByCIN(String cin) {
		Object[] parameters = new Object[] { cin };
		String queryString = Queries.FIND_ETUDIANT_BY_CIN;
		String orderByClause = "";
		return findByCriteria(queryString, orderByClause, new SearchConfig(), parameters);
	}

	@Override
	public Long findNbrByStatus(EntityStatus status) {
		Object[] parameters = new Object[] { status };
		String queryString = Queries.FIND_NB_ETUDIANT_BY_STATUS;
		Query countQuery = createQuerySingleResult(queryString, parameters);
		return (Long) countQuery.getSingleResult();
	}

	@Override
	public Long findNbrDemande() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_NBR_DEMANDE;
		Query countQuery = createQuerySingleResult(queryString, parameters);
		return (Long) countQuery.getSingleResult();
	}

	@Override
	public List<Etudiants> findResidentStudentForInscription(String cin) {
		Object[] parameters = new Object[] { cin };
		String queryString = Queries.FIND_RESIDENT_STUDENT_FOR_INSCRIPTION;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Etudiants> findResidentStudentForInscriptionByMassar(String codeMassar) {
		Object[] parameters = new Object[] { codeMassar };
		String queryString = Queries.FIND_RESIDENT_STUDENT_FOR_INSCRIPTION_BY_MASSAR;
		return executeQuery(queryString, parameters);
	}
	
	@Override
	public Etudiants findEtudiantByMassar(String codeMassar) {
		
		Object[] parameters = new Object[] { codeMassar };
		String Query =Queries.FIND_BY_CODE_MASSAR;
		return executeQuerySingleResult(Query, parameters);
	}

}
