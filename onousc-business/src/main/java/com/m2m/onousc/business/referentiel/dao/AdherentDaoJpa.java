/*
* CanalVenteDaoJpa.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.AdherentCriteria;
import com.m2m.onousc.business.referentiel.criteria.CanalVenteCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionAdhCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.technicalservices.dao.GenericDaoJpa;


// TODO: Auto-generated Javadoc
/**
 * The Interface CanalVenteDaoJpa.
 *
 * @version 1.0 18 févr. 2015
 * @author msadik
 */
public interface AdherentDaoJpa extends GenericDaoJpa<Adherent, Long> {

	
	public List<Adherent> findAdherentByCriteria(AdherentCriteria criteria);
	public Adherent findAdherentByNom(String matr,String nom ,String prenom);
	public List<Adherent> findAdherentByPersonnel(Long id);
	public List<Adherent> findAdherentByAgeNscol(String matr);
	public List<Adherent> findAdherentByAgescol(String matr);
	public List<Adherent> findAllAdherent();
	public List<Adherent> findOppositionAdhByCriteria(OppositionAdhCriteria criteria);


}
