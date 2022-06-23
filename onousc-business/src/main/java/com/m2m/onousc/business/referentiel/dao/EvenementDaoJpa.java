/*
 * CanalVenteDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.EvenementCriteria;
import com.m2m.onousc.business.referentiel.model.Evenement;
import com.m2m.technicalservices.dao.GenericDaoJpa;

// TODO: Auto-generated Javadoc
/**
 * The Interface
 * 
 * @version 1.0 18 févr. 2015
 * @author msadik
 */
public interface EvenementDaoJpa extends GenericDaoJpa<Evenement, Long> {

	public List<Evenement> findEvenementtByCriteria(EvenementCriteria criteria);
	

}
