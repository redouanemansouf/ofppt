/*
* CanalVenteDaoJpa.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.technicalservices.dao.GenericDaoJpa;

public interface EtudiantDaoJpa extends GenericDaoJpa<Etudiants, Long> {

	public List<Etudiants> findByCriteria(EtudiantCriteria criteria);

	public List<Etudiants> findForCombo();

	/**
	 * @param status
	 * @return
	 */
	List<Etudiants> findEtudiantByStatus(String status);
	
	public List<Etudiants> findByLibelleCite(String libelle);
	
	public List<Etudiants> findByCodeRestaurant(String code);
	
	public List<Etudiants> findByCIN(String cin);

	Long findNbrByStatus(EntityStatus status);
	
	Long findNbrDemande();
	
	List<Etudiants> findResidentStudentForInscription(String cin);
	
	List<Etudiants> findResidentStudentForInscriptionByMassar(String codeMassar);

	Etudiants findEtudiantByMassar(String codeMassar);

}
