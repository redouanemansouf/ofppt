/*
 * UserEntityDaoImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.MenuCriteria;
import com.m2m.onousc.business.referentiel.dao.MenuDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class WinMenuDaoImpl.
 * 
 * @version 1.0 24 nov. 2014
 * 
 */
@Repository("menuDao")
public class MenuDaoImpl extends GenericDaoJpaImpl<Menu, Long>
		implements MenuDaoJpa {


	@Override
	public List<Menu> findByCriteria(String code, String libelle, String abrev) {
		Object[] parameters = new Object[] {code,libelle,abrev};
		String queryString = Queries.FIND_MENU_BY_CRITERIA;  
		return findByCriteria(queryString, new SearchConfig(), parameters); 
	}

	@Override
	public List<Menu> findByCriteria(MenuCriteria criteria) {
		Object[] parameters = new Object[] {criteria.getCode(),criteria.getLibelle(),criteria.getAbbrev(),criteria.getPageName()};
		String queryString = Queries.FIND_MENU_BY_CRITERIA2;    
		return findByCriteria(queryString, criteria.getSearchConfig(), parameters); 
	}

}
