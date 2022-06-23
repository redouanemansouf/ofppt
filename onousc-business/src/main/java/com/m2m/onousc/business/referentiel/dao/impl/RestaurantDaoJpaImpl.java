/*
 * RestaurantDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.RestaurantCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.RestaurantDaoJpa;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * The Class RestaurantDaoJpaImpl.
 * 
 * @version 1.0 28 oct. 2015
 * @author user
 */
@Repository("restaurantDao")
public class RestaurantDaoJpaImpl extends GenericDaoJpaImpl<Restaurant, Long>
		implements RestaurantDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.RestaurantDaoJpa#findByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.RestaurantCriteria)
	 */
	@Override
	public List<Restaurant> findByCriteria(RestaurantCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getLibcite(),
				criteria.getNomResponsable(), criteria.getPrenomResponsable(),
				criteria.getNumTele(), criteria.getAdresseEmail(),
				 criteria.getAdresse(), statusCode ,criteria.getIdSite()};
		String queryString = Queries.FIND_RESTAURANT_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.RestaurantDaoJpa#findForCombo()
	 */
	@Override
	public List<Restaurant> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_RESTAURANT_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.RestaurantDaoJpa#findByCode(java
	 * .lang.String)
	 */
	@Override
	public Restaurant findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_RESTAURANT_BY_CODE;
		return executeQuerySingleResult(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.RestaurantDaoJpa#findByLibelleCite
	 * (java.lang.String)
	 */
	@Override
	public List<Restaurant> findByLibelleCite(String libelle) {
		Object[] parameters = new Object[] { libelle };
		String queryString = Queries.FIND_RESTAURANT_BY_CITE;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<Restaurant> findByCodeCite(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_RESTAURANT_BY_CODE_CITE;
		return executeQuery(queryString, parameters);
	}
	
	@Override
	public List<Restaurant> findByIdSite(Long idSite) {
		Object[] parameters = new Object[] { idSite };
		String queryString = Queries.FIND_RESTAURANT_BY_IDSITE;
		return executeQuery(queryString, parameters);
	}


	@Override
	public List<Restaurant> findAllRestaurant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> findRestaurantByIdProduit(Long idProd) {
		Object[] parameters = new Object[] { idProd };
		String queryString = Queries.FIND_ALL_RESTAURANT_BY_PRODUIT;
		return executeQuery(queryString, parameters);
		
	}

	@Override
	public Restaurant findRestaurantByLongId(Long id) {
		Object[] parameters = new Object[] { id };
		String queryString = Queries.FIND_RESTAURANT_BY_CODE;
		return executeQuerySingleResult(queryString, parameters);
	}

	@Override
	public List<Restaurant> findRestaurantListByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_RESTAURANT_LIST_BY_CODE;
		return executeQuery(queryString, parameters);
	}

}
