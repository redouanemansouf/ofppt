/*
 * WinMenuDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.WinMenuCriteria;
import com.m2m.technicalservices.dao.GenericDaoJpa;
import com.m2m.technicalservices.security.WinMenu;

/**
 * The Interface WinMenuDaoJpa.
 * 
 * @version 1.0 09 fev. 201r
 * @author iissouani
 *
 */
public interface WinMenuDaoJpa extends GenericDaoJpa<WinMenu, Long> {

	/**
	 * @param criteria
	 * @return
	 */
	public List<WinMenu> findByCriteria(WinMenuCriteria criteria);

	public List<WinMenu> findModuleWinMenu();
	
	public List<WinMenu> findWinMenuByGroup(String operateur);

	public List<WinMenu> findWinMenuByGroupList(String groupname);

}