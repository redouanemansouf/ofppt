/*
 * UserEntityDaoImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.m2m.onousc.business.referentiel.criteria.TraceEntityCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.TraceEntityDaoJpa;
import com.m2m.technicalservices.audit.impl.TraceEntity;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * The Class ServiceDaoJpaImpl.
 * 
 * @version 1.0 24 nov. 2014
 * 
 */
@Repository("traceDao")
public class TraceEntityDaoImpl extends GenericDaoJpaImpl<TraceEntity, Long>
		implements TraceEntityDaoJpa {

	@Override
	public List<TraceEntity> findByCriteria(TraceEntityCriteria criteria) {
		Object[] parameters = new Object[] { criteria.getUser(),criteria.getAction(),criteria.getDateDebaction(),criteria.getDateFinaction()};
		String queryString = Queries.FIND_TRACE_BY_CRITERIA;  
		return findByCriteria(queryString, criteria.getSearchConfig(), parameters);
	}
	
	
}
