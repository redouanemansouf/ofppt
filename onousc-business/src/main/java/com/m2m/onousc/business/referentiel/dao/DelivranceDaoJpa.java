/*
* CanalVenteDaoJpa.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.criteria.DelivranceCriteria;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.DelivranceCarte;
import com.m2m.technicalservices.dao.GenericDaoJpa;

// TODO: Auto-generated Javadoc
/**
 * The Interface CanalVenteDaoJpa.
 *
 * @version 1.0 18 févr. 2015
 * @author msadik
 */
public interface DelivranceDaoJpa extends GenericDaoJpa<DelivranceCarte, Long> {

	/**
	 * Find Canal Vente by provided critirea.
	 *
	 * @param criteria
	 *            the criteria
	 * @return List of Canal Vente
	 */
	public List<DelivranceCarte> findDelivByCriteria(DelivranceCriteria criteria);

	public List<DelivranceCarte> findDelivForCombo();

	public List<DelivranceCarte> findDelivByCode(String code);
}
