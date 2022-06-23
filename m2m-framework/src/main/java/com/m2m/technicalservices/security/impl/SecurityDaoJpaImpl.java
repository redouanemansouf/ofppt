package com.m2m.technicalservices.security.impl;

import org.springframework.stereotype.Repository;

import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;
import com.m2m.technicalservices.security.UserEntity;

/**
 * Security DAO implementation
 * 
 * @author Younes SOUTEH.com
 */
@Repository
public class SecurityDaoJpaImpl extends GenericDaoJpaImpl<UserEntity, Integer>                              
		implements SecurityDaoJpa {

	
	public UserEntity findByUserName(String userName) {
		String queryString = "from UserEntity u where UPPER(u.username) =   UPPER('" + userName + "')";
		return getSingleEntity(queryString);
	}
}