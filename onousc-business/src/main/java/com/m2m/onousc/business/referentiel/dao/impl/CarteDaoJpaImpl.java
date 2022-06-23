/*
 * CarteDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.CarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.business.referentiel.criteria.LotCarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Repository("carteDao")
public class CarteDaoJpaImpl extends GenericDaoJpaImpl<Carte, Long> implements CarteDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.dao.CarteDaoJpa#findByNumero(java
	 * .lang.String)
	 */
	@Override
	public Carte findByNumero(String numeroCarte) {
		Object[] parameters = new Object[] { numeroCarte };
		String queryString = Queries.FIND_CARTE_BY_NUMERO;
		Carte result = null;
		try {
			result = executeQuerySingleResult(queryString, parameters);
		} catch (NoResultException e) {
			result = null;
		}
		return result;
	}

	@Override
	public List<Carte> find_Etud_ByCarte(Long id) {
		Object[] parameters = new Object[] { id };
		String queryString = Queries.FIND_CARTE_BY_PORTEUR;
		return executeQuery(queryString, parameters);

	}

	@Override
	public List<Carte> findCarteByCriteria(CarteCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getNumeroCarte(), criteria.getNumSerie(), criteria.getOperation(),
				criteria.getNumPorteur(), criteria.getIdSite(), criteria.getCin(), criteria.getCodeMassar() };
		String queryString = Queries.FIND_CARTE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

	@Override
	public void modifierCarte(Carte carte) {
		getEm().merge(carte);

	}

	@Override
	public String findMaxLotCarte(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_MAX_LOT_CARTE;
		return (String) createQuerySingleResult(queryString, parameters).getSingleResult();
		// return executeQuerySingleResult(queryString, parameters).toString();
	}

	@Override
	public List<Carte> findLotCarteByCriteria(LotCarteCriteria lotcriteria) {
		Object[] parameters = new Object[] { lotcriteria.getNumeroCarte(), lotcriteria.getNumSerie(),
				lotcriteria.getOperation(), lotcriteria.getNumPorteur(), lotcriteria.getIdCite(),
				lotcriteria.getOperateur() };
		String queryString = Queries.FIND_LOT_CARTE_BY_CRITERIA;
		String orderByClause = lotcriteria.getSortField() != null
				? " order by " + lotcriteria.getSortField() + " " + lotcriteria.getSortOrder()
				: "";
		return findByCriteria(queryString, true, orderByClause, lotcriteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Carte> find_Carte_By_Lot(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_CARTE_BY_LOT;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Carte> findToRefabricateByCriteria(EtudiantCriteria criteria) {

		Object[] parameters = new Object[] { criteria.getAnn_universitaire(), criteria.getNom(), criteria.getPrenom(),
				criteria.getNCIN(), criteria.getEmail(), criteria.getIdSite() };
		String queryString = Queries.FIND_DEMANDE_TO_REFABRICARTE_BY_CRITERIA;

		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Carte> findOppositionByCriteria(OppositionCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getCin(), criteria.getNumPorteur(),
				criteria.getStatut() != null ? criteria.getStatut().getStatusCode() : null, criteria.getCodeMassar(),
				criteria.getIdSite() };
		String queryString = Queries.FIND_OPPOSITION_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null
				? " order by " + criteria.getSortField() + " " + criteria.getSortOrder()
				: "";
		return findByCriteria(queryString, orderByClause, criteria.getSearchConfig(), parameters);
	}

}
