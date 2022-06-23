/*
 * FiliereDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.FiliereCriteria;
import com.m2m.onousc.business.referentiel.model.Filiere;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface FiliereDaoJpa.
 * 
 * @version 1.0 28 oct. 2015
 * @author user
 */
public interface FiliereDaoJpa extends GenericDaoJpa<Filiere, Long> {

	/**
	 * Find Filiere by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of filiere
	 */
	public List<Filiere> findByCriteria(FiliereCriteria criteria);
	
	public Filiere findFiliereByLongId(Long id);

	/**
	 * Find for combo.
	 * 
	 * @return the list
	 */
	public List<Filiere> findForCombo();

	/**
	 * Find by code.
	 * 
	 * @param code
	 *            the code
	 * @return the filiere
	 */
	public Filiere findByCode(String code);


	
	public List<Filiere> findAllFiliere();
	
	
	public List<Filiere> findFiliereListByCode(String code);

	List<Filiere> findByIdSite(Long idSite);
	
	

}
