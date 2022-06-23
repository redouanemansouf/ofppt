package com.m2m.technicalservices.security.impl;

import org.springframework.dao.DataAccessException;

import com.m2m.technicalservices.dao.GenericDaoJpa;
import com.m2m.technicalservices.exception.NotFoundException;
import com.m2m.technicalservices.exception.TechnicalException;
import com.m2m.technicalservices.security.UserEntity;



/**
 * SecurityDAO interface
 * 
 * @author Younes SOUTEH.com
 */
public interface SecurityDaoJpa extends GenericDaoJpa<UserEntity, Integer> {

	/**
	 * Find User with provided userName.
	 * 
	 * @return the list of trace found
	 * @throws NotFoundException
	 * @throws DataAccessException
	 * @throws TechnicalException
	 */
	public UserEntity findByUserName(String userName);

}