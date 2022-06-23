/*
 * MenuDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface WinMenuDaoJpa.
 * 
 * @version 1.0 09 fev. 201r
 * @author iissouani
 *
 */
public interface GroupUserDaoJpa extends GenericDaoJpa<GroupUser, Long> {
	
	List<GroupUser> findGroupUserByID(Long id);

	List<GroupUser> findOnlyGrouByCriteria(GroupUserCriteria criteria);

	List<GroupUser> findGroupBycode(String groupName);

	List<GroupUser> findGrouByCriteria(GroupUserCriteria criteria);
	
	List<GroupUser> findAllGroupNotDeleted();
	
	

}