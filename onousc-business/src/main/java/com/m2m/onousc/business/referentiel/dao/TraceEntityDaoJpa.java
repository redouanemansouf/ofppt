/*
 * UserEntityDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.TraceEntityCriteria;
import com.m2m.technicalservices.audit.impl.TraceEntity;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface NationaliteDaoJpa.
 * 
 * @version 1.0 09 fev. 201r
 * @author iissouani
 *
 */
public interface TraceEntityDaoJpa extends GenericDaoJpa<TraceEntity, Long> {

	List<TraceEntity> findByCriteria(TraceEntityCriteria criteria);


}