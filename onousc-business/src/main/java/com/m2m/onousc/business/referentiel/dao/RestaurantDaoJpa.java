/*
 * RestaurantDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.RestaurantCriteria;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface RestaurantDaoJpa.
 * 
 * @version 1.0 28 oct. 2015
 * @author user
 */
public interface RestaurantDaoJpa extends GenericDaoJpa<Restaurant, Long> {

	/**
	 * Find Restaurant by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of restaurant
	 */
	public List<Restaurant> findByCriteria(RestaurantCriteria criteria);
	
	public Restaurant findRestaurantByLongId(Long id);

	/**
	 * Find for combo.
	 * 
	 * @return the list
	 */
	public List<Restaurant> findForCombo();

	/**
	 * Find by code.
	 * 
	 * @param code
	 *            the code
	 * @return the restaurant
	 */
	public Restaurant findByCode(String code);

	/**
	 * Find by libelle cite.
	 * 
	 * @param libelle
	 *            the libelle
	 * @return the list
	 */
	public List<Restaurant> findByLibelleCite(String libelle);
	
	public List<Restaurant> findByCodeCite(String code);
	
	public List<Restaurant> findAllRestaurant();
	
	public List<Restaurant> findRestaurantByIdProduit(Long idProd);
	
	public List<Restaurant> findRestaurantListByCode(String code);

	List<Restaurant> findByIdSite(Long idSite);
	
	

}
