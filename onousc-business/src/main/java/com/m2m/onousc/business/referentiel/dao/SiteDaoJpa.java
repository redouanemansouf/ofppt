/*
* CanalVenteDaoJpa.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.SiteCriteria;
import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.technicalservices.dao.GenericDaoJpa;


// TODO: Auto-generated Javadoc
/**
 * The Interface CanalVenteDaoJpa.
 *
 * @version 1.0 18 févr. 2015
 * @author amtarji
 */
public interface SiteDaoJpa extends GenericDaoJpa<Site, Long> {


	public List<Site> findByCriteria(SiteCriteria criteria);

	public List<Site> findForCombo();

	public List<Site> findByCode();
	
	public Site findSiteByCode(String code);
	
	public List<Site> findSiteListByCode(String code);
	
}
