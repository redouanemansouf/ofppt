/*
* CanalVenteDaoJpa.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CanalVenteCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.criteria.PersonnelCriteria;
import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.technicalservices.dao.GenericDaoJpa;


// TODO: Auto-generated Javadoc
/**
 * The Interface CanalVenteDaoJpa.
 *
 * @version 1.0 18 févr. 2015
 * @author msadik
 */
public interface PersonnelDaoJpa extends GenericDaoJpa<Personnel, Long> {

	
	public List<Personnel> findPersonnelByCriteria(PersonnelCriteria criteria);
	public Personnel findPersonnelByMatr(String matr);
	public List<Personnel> findAllPersonnel();
	public List<String>  getTrancheByProfil(String jour,Long profil);
	public List<Personnel> findOppositionPersoByCriteria(OppositionCriteria criteria);
	
	public List<Personnel> findForCombo();


}
