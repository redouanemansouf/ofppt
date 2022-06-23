/*
 * AbstractDaoTest.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.common;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.m2m.technicalservices.core.ClientParameters;
import com.m2m.technicalservices.core.User;
import com.m2m.technicalservices.core.UserContext;

/**
 * The Class AbstractDaoTest: class abstraite de laquelle vont hériter les
 * classes de test DAO.
 * 
 * @version 1.0 20 nov. 2014
 * @author aelhachimi
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true)
@Transactional
@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "classpath:/dbunit/dataset-sequence-generator.xml")
public abstract class AbstractDaoTest {

	/**
	 * Inits tests .
	 */
	@Before
	public void init() {
		User user = new User("1", "CODE03");
		// preparation ds parametres
		ClientParameters clientParameters = new ClientParameters();
		clientParameters.setUser(user);
		UserContext.setClientParameters(clientParameters);

	}

}
