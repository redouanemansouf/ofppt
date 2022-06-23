/*
 * UserEntityDaoImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class ServiceDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * 
 */
@Repository("userDao")
public class UserEntityDaoImpl extends GenericDaoJpaImpl<UserEntity, Long>
		implements UserEntityDaoJpa {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa#findByCriteria
	 * (java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, com.m2m.technicalservices.web.SearchConfig,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public List<UserEntity> findByCriteria(String firstName, String lastName,
			String username, String email, String statut, String group, SearchConfig config,
			String sortField, String sortOrder) {
		Object[] parameters = new Object[] { firstName, lastName, username,
				email, statut ,group};
		String queryString = Queries.FIND_USER_BY_CRITERIA;
		return findByCriteria(queryString, config, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa#findUsersNotAdmin
	 * (com.m2m.technicalservices.web.SearchConfig)
	 */
	@Override
	public List<UserEntity> findUsersNotAdmin(SearchConfig config) {
		String queryString = Queries.FIND_USER_NOT_ADMIN;
		return findByCriteria(queryString, config);
	}

	@Override
	public List<UserEntity> findAllUsersExceptDeleted() {
		String queryString = Queries.FIND_ALL_USER;
		return executeQuery(queryString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa#findByCode(java
	 * .lang.String)
	 */
	@Override
	public UserEntity findByCode(String code) {
		Object[] parameters = new Object[] { code};
		String queryString = Queries.FIND_USER_BY_CODE;
		UserEntity result = null;
		try{
			result = executeQuerySingleResult(queryString, parameters);
		} catch (NoResultException e) {
		    result=null;
		}
		return result;
	}

	@Override
	public String encrypt(String pwd) throws Exception {
	    java.security.MessageDigest d = null;
	    d = java.security.MessageDigest.getInstance("SHA-1");
	    d.reset();
	    d.update(pwd.getBytes());
	    byte[] digest = d.digest();
	    String hexStr = "";
        for (int i = 0; i < digest.length; i++) {
            hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return hexStr;   
//		ShaPasswordEncoder sha = new ShaPasswordEncoder(256);  
//		sha.setIterations(1000);
//		String salt = "QA487DSDSQ487";
//		String hash = sha.encodePassword(pwd, salt);
//		return hash;
	  }

	@Override
	public List<UserEntity> findUserByGroup(String group) {
		Object[] parameters = new Object[] { group };
		String queryString = Queries.FIND_USER_BY_GROUP;
		return executeQuery(queryString, parameters);
	}
}
