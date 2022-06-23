/*
 * UserEntityDaoImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria;
import com.m2m.onousc.business.referentiel.dao.GroupUserDaoJpa;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * The Class WinMenuDaoImpl.
 * 
 * @version 1.0 24 nov. 2014
 * 
 */
@Repository("groupUserDao")
public class GroupUserDaoImpl extends GenericDaoJpaImpl<GroupUser, Long>
		implements GroupUserDaoJpa {

	@Override
	public List<GroupUser> findOnlyGrouByCriteria(GroupUserCriteria criteria) {
		
		Object[] parameters = new Object[] {criteria.getGroupName()};
		String queryString = Queries.FIND_ONLY_GROUP_BY_CRITERIA;
		return findByCriteria(queryString, criteria.getSearchConfig(),
				parameters);
	}

	@Override
	public List<GroupUser> findGroupBycode(String groupName) {
		Object[] parameters = new Object[] { groupName };
		String queryString = Queries.FIND_ONLY_GROUP_BY_CRITERIA;
		return executeQuery(queryString, parameters);
	}

	@Override
	public List<GroupUser> findGrouByCriteria(GroupUserCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getGroupName() };
		String queryString = Queries.FIND_ONLY_GROUP_BY_CRITERIA;
		return findByCriteria(queryString, criteria.getSearchConfig(),
				parameters);
	}

	@Override
	public List<GroupUser> findAllGroupNotDeleted() {
		String queryString = Queries.FIND_ALL_GROUP_NOT_DELETED;
		return executeQuery(queryString);
	}



	@Override
	public List<GroupUser> findGroupUserByID(Long id) {
		String queryString = Queries.FIND_GROUP_USER_BY_LIBELLE;
		return executeQuery(queryString);
	}


}
