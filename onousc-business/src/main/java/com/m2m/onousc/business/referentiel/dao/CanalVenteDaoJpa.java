/*
* CanalVenteDaoJpa.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CanalVenteCriteria;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.technicalservices.dao.GenericDaoJpa;


// TODO: Auto-generated Javadoc
/**
 * The Interface CanalVenteDaoJpa.
 *
 * @version 1.0 18 févr. 2015
 * @author amtarji
 */
public interface CanalVenteDaoJpa extends GenericDaoJpa<CanalVente, Long> {

	/**
	 * Find Canal Vente by provided critirea.
	 *
	 * @param criteria the criteria
	 * @return List of Canal Vente
	 */
	public List<CanalVente> findByCriteria(CanalVenteCriteria criteria);

	public List<CanalVente> findForCombo();

	public List<CanalVente> findByCode();
	
	public CanalVente findCanalByCode(String code);
	
	public List<CanalVente> findCanalListByCode(String code);

	List<CanalVente> findBySite(Long idSite);
	
}
