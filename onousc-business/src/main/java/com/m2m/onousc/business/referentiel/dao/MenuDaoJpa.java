/*
 * MenuDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.MenuCriteria;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface WinMenuDaoJpa.
 * 
 * @version 1.0 09 fev. 201r
 * @author iissouani
 *
 */
public interface MenuDaoJpa extends GenericDaoJpa<Menu, Long> {

	/**
	 * @param criteria
	 * @return
	 */
	public List<Menu> findByCriteria(String code,String libelle,String abrev);

	/**
	 * @param criteria
	 * @return
	 */
	public List<Menu> findByCriteria(MenuCriteria criteria);

	

}