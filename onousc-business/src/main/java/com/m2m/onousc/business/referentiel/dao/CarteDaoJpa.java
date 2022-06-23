/*
 * CarteDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.CarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.EtudiantCriteria;
import com.m2m.onousc.business.referentiel.criteria.LotCarteCriteria;
import com.m2m.onousc.business.referentiel.criteria.OppositionCriteria;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface CanalVenteDaoJpa.
 * 
 * @version 1.0 18 févr. 2015
 * @author msadik
 */
public interface CarteDaoJpa extends GenericDaoJpa<Carte, Long> {

	/**
	 * Find by numero.
	 * 
	 * @param numeroCarte
	 *            the numero carte
	 * @return the carte
	 */
	Carte findByNumero(String numeroCarte);
	
	List<Carte> find_Etud_ByCarte(Long id);
	
	public List<Carte> findCarteByCriteria(CarteCriteria criteria);
	
	public List<Carte> findLotCarteByCriteria(LotCarteCriteria lotcriteria);
	
	public void modifierCarte(Carte carte);
	
	public String  findMaxLotCarte(String  code);
	
	List<Carte> find_Carte_By_Lot(String  code);

	List<Carte> findOppositionByCriteria(OppositionCriteria criteria);

	List<Carte> findToRefabricateByCriteria(EtudiantCriteria criteria);

}
