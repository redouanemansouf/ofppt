/*
 * UserEntityDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.technicalservices.dao.GenericDaoJpa;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Interface NationaliteDaoJpa.
 * 
 * @version 1.0 09 fev. 201r
 * @author msadik
 */
public interface UserEntityDaoJpa extends GenericDaoJpa<UserEntity, Long> {

	/**
	 * Find by criteria.
	 * 
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param username
	 *            the username
	 * @param email
	 *            the email
	 * @param statut
	 *            the statut
	 * @param config
	 *            the config
	 * @param sortField
	 *            the sort field
	 * @param sortOrder
	 *            the sort order
	 * @return the list
	 */
	public List<UserEntity> findByCriteria(String firstName, String lastName,
			String username, String email, String statut,String group, SearchConfig config,
			String sortField, String sortOrder);

	/**
	 * Find users not admin.
	 * 
	 * @param config
	 *            the config
	 * @return the list
	 */
	public List<UserEntity> findUsersNotAdmin(SearchConfig config);

	/**
	 * Find by code.
	 * 
	 * @param code
	 *            the code
	 * @return the user entity
	 */
	
	public List<UserEntity> findUserByGroup(String group);

	public UserEntity findByCode(String code);

	List<UserEntity> findAllUsersExceptDeleted();

	public String encrypt(String pwd) throws Exception;

}