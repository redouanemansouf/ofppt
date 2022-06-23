/*
 * ReservationBorneDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ReservationBorneCriteria;
import com.m2m.onousc.business.referentiel.model.ReservationBorne;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * The Interface ReservationBorneDaoJpa.
 * 
 * @version 1.0 28 oct. 2015
 * @author user
 */
public interface ReservationBorneDaoJpa extends GenericDaoJpa<ReservationBorne, Long> {

	public List<ReservationBorne> findByCriteria(ReservationBorneCriteria criteria);

	public List<ReservationBorne> findForCombo();

	public ReservationBorne findByCarte(String code);

	public List<ReservationBorne> findReservationBorneByIdBorne(Long idBorne);

	public ReservationBorne findReservationBorneById(Long id);

}
