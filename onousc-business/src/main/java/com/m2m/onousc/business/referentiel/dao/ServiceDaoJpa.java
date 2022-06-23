/*
 * ServiceDaoJpa.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.ServiceCriteria;
import com.m2m.onousc.business.referentiel.model.Service;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.technicalservices.dao.GenericDaoJpa;

/**
 * 
 * @author abousnane
 * 
 */
public interface ServiceDaoJpa extends GenericDaoJpa<Service, Long> {

	/**
	 * Find Service by provided critirea.
	 * 
	 * @param criteria
	 *            the criteria
	 * @return List of Service
	 */
	public List<Service> findByCriteria(ServiceCriteria criteria);

	public List<Service> findForCombo();
	
	public List<Service> findByType(String type);

	/**
	 * Find by code.
	 * 
	 * @param code
	 *            the code
	 * @return the service
	 */
	public Service findByCode(String code);
	
	
	public  void persistReservationDetail(Service idService,Reservation reservation);
	public  void persistReservation(String libelle,Double montant);
	public  void  persistReserv(Reservation reservation);
}
