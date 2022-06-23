/*
 * SemaineUniversitaireDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.model.SemaineUniversitaire;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface ReservationDaoJpa.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenboubker
 */
public interface SemaineUniversitaireDaoJpa extends
		GenericDaoJpa<SemaineUniversitaire, Long> {

	/**
	 * Find for combo.
	 * 
	 * @return the list
	 */
	List<SemaineUniversitaire> findForCombo();

	/**
	 * Find by id.
	 *
	 * @param idSemaineUniversitaire the id semaine universitaire
	 * @return the semaine universitaire
	 */
	SemaineUniversitaire findById(long idSemaineUniversitaire);

}
