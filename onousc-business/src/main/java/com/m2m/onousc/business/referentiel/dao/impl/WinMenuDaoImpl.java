/*
 * UserEntityDaoImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.WinMenuCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.WinMenuDaoJpa;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.security.WinMenu;

/**
 * The Class WinMenuDaoImpl.
 * 
 * @version 1.0 24 nov. 2014
 * 
 */
@Repository("winDao")
public class WinMenuDaoImpl extends GenericDaoJpaImpl<WinMenu, Long>
		implements WinMenuDaoJpa {

	@Override
	public List<WinMenu> findByCriteria(WinMenuCriteria criteria) {
//		Object[] parameters = new Object[] { criteria.getCode(), criteria.getLibelle(),
//				criteria.getAbbrev(), criteria.getOperateur(),criteria.getType()};
//		String queryString = Queries.FIND_WINMENU_BY_CRITERIA;  
//		return findByCriteria(queryString, criteria.getSearchConfig(), parameters);
		
		
		String codeEcran=null;
		if(criteria.getCode()!=null){
			codeEcran =  "%00"+StringUtils.stripStart(criteria.getCode(), "0") + "%";
		}
		
		Object[] parameters = new Object[] { codeEcran,
				criteria.getLibelle(), criteria.getAbbrev(),
				criteria.getOperateur(), criteria.getType() };
		String queryString = Queries.FIND_WINMENU_BY_CRITERIA;
		return findByCriteria(queryString, criteria.getSearchConfig(),
				parameters);
	}
	
	@Override
	public List<WinMenu> findModuleWinMenu(){
		String queryString = Queries.FIND_WINMENU_LIBELLE;
		return executeQuery(queryString);   
	}

	@Override
	public List<WinMenu> findWinMenuByGroup(String operateur) {
		Object[] parameters = new Object[] {operateur};
		String queryString = Queries.FIND_WINMENU_BY_GROUPUSER;
		return executeQuery(queryString, parameters); 
	}

	@Override
	public List<WinMenu> findWinMenuByGroupList(String groupname) {
		Object[] parameters = new Object[] {groupname};
		String queryString = Queries.FIND_WINMENU_BY_GROUPUSER;
		return executeQuery(queryString, parameters); 
	}

}
