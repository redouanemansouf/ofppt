/*
 * JoursFerieDao.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.JoursFerieCriteria;
import com.m2m.onousc.business.referentiel.model.JoursFerie;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * 
 * @author abousnane
 * 
 */
public interface JoursFerieDao extends GenericDaoJpa<JoursFerie, Long> {

	/**
	 * Find jours ferie by provided critirea.
	 * 
	 * @param joursferie
	 *            the criteria
	 * @return List of joursferie
	 */
	public List<JoursFerie> findByCriteria(JoursFerieCriteria criteria);

	public List<JoursFerie> findForCombo();

	public List<JoursFerie> findByCode(String code);

	public List<JoursFerie> findByCodeAnneeUniversitaire(String code);

	/**
	 * Checks if is free day.
	 * 
	 * @param date
	 *            the date
	 * @return true, if is free day
	 */
	public boolean isFreeDay(Date date);

}
