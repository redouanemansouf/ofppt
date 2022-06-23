/*
* CanalVenteDaoJpa.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.dao;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.technicalservices.dao.GenericDaoJpa;

// TODO: Auto-generated Javadoc
/**
 * The Interface CanalVenteDaoJpa.
 *
 * @version 1.0 18 févr. 2015
 * @author msadik
 */
public interface CycleVieDaoJpa extends GenericDaoJpa<CycleVie, Long> {

	/**
	 * Find Canal Vente by provided critirea.
	 *
	 * @param criteria
	 *            the criteria
	 * @return List of Canal Vente
	 */
	public List<CycleVie> findByCriteria(CycleVieCriteria criteria);
	
	public List<CycleVie> findCycleByDeliv(CycleVieCriteria criteria);

	public List<CycleVie> findForCombo();

	public List<CycleVie> findByCode(String code);

	/**
	 * @param dateDebut
	 * @param dateFin
	 * @return
	 */
	public List<CycleVie> findByCycleVieByDate(Date dateDebut, Date dateFin);

}
