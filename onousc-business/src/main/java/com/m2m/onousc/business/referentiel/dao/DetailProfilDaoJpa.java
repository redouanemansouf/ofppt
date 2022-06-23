/*
* CanalVenteDaoJpa.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CanalVenteCriteria;
import com.m2m.onousc.business.referentiel.criteria.DetailProfilCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.model.DetailProfilAcces;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.technicalservices.dao.GenericDaoJpa;


// TODO: Auto-generated Javadoc
/**
 * The Interface CanalVenteDaoJpa.
 *
 * @version 1.0 18 févr. 2015
 * @author msadik
 */
public interface DetailProfilDaoJpa extends GenericDaoJpa<DetailProfilAcces, Long> {

	
	public List<DetailProfilAcces> findDetailProfilByCriteria(DetailProfilCriteria criteria);
	public List<DetailProfilAcces> findDetailProfilByprofil(String code);
	


}
