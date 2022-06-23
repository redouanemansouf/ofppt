/*
 * AdministrationServiceImpl.java
 *
 * Copyright (c) 1990-2017 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria;
import com.m2m.onousc.business.referentiel.criteria.WinMenuCriteria;
import com.m2m.onousc.business.referentiel.dao.GroupUserDaoJpa;
import com.m2m.onousc.business.referentiel.dao.MenuDaoJpa;
import com.m2m.onousc.business.referentiel.dao.TraceEntityDaoJpa;
import com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa;
import com.m2m.onousc.business.referentiel.dao.WinMenuDaoJpa;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.onousc.business.referentiel.service.AdministrationService;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.security.WinMenu;

/**
 * The Class TransportServiceImpl.
 * 
 * @version 1.0 16 mars 2015
 * @author iissouani
 * 
 */
@Service("administrationService")
public class AdministrationServiceImpl implements AdministrationService,
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4129155773280227470L;

	/** The groupe dao jpa. */
	@Autowired
	private GroupUserDaoJpa groupeDaoJpa;

	/** The user entity dao jpa. */
	@Autowired
	private UserEntityDaoJpa userEntityDaoJpa;

	/** The win menu dao jpa. */
	@Autowired
	private WinMenuDaoJpa winMenuDaoJpa;

	/** The menu dao jpa. */
	@Autowired
	private MenuDaoJpa menuDaoJpa;

	/** The trace entity dao. */
	@Autowired
	private TraceEntityDaoJpa traceEntityDao;

	@Override
	public List<GroupUser> findGroupByCode(String groupName) {
		return groupeDaoJpa.findGroupBycode(groupName);
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.AdministrationService#
	 * findGroupByCodeOrLibelle(java.lang.Long, java.lang.String)
	 */
	

	@Override
	public List<GroupUser> findOnlyGroupByCriteria(GroupUserCriteria criteria) {
		return groupeDaoJpa.findOnlyGrouByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.AdministrationService#
	 * findGroupByCriteria
	 * (com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria)
	 */
	@Override
	public List<GroupUser> findGroupByCriteria(GroupUserCriteria criteria) {
		return groupeDaoJpa.findGrouByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.AdministrationService#
	 * finGroupBycode(java.lang.Long)
	 */
	
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.service.AdministrationService#
	 * findGroupByCriteriaCS
	 * (com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria)
	 */
	@Override
	public List<GroupUser> findGroupByCriteriaCS(GroupUserCriteria criteria) {
		return groupeDaoJpa.findGrouByCriteria(criteria);
	}

	
	
	

	
//	@Override
//	public List<UserEntity> findUserByGroup(String group) {
//		return  userEntityDaoJpa.findUserByGroup(group);
//	}

	@Override
	public List<WinMenu> findWinMenuByCriteria(WinMenuCriteria criteria) {
		return winMenuDaoJpa.findByCriteria(criteria);
	}


//	@Override
//	public List<WinMenu> getWinMenuByCriteria(WinMenuCriteria criteria) {
//		return winMenuDaoJpa.getByCriteria(criteria);
//	}

	

	

	@Override
	public List<Menu> findAllMenu() {
		return menuDaoJpa.findAll();
	}


	@Override
	public List<UserEntity> findUserByGroup(String group) {
		return  userEntityDaoJpa.findUserByGroup(group);
	}


	@Override
	public List<WinMenu> getWinMenuByCriteria(WinMenuCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<WinMenu> findWinMenuByGroupList(String groupname) {
		return winMenuDaoJpa.findWinMenuByGroupList(groupname);
	}


	@Override
	public GroupUser findGroupUserByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public List<GroupUser> findGroupUserByID(long id) {
//		return groupeDaoJpa.findGroupUserByID(id);
//	}


//	@Override
//	public List<WinMenu> findWinMenusByGroupe(Long groupeCode) {
//		return winMenuDaoJpa.getWinMenuByGroupe(groupeCode);
//	}



}
