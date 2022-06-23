/*
 * ServiceDaoJpaImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.onousc.business.referentiel.criteria.ServiceCriteria;
import com.m2m.onousc.business.referentiel.dao.Queries;
import com.m2m.onousc.business.referentiel.dao.ServiceDaoJpa;
import com.m2m.onousc.business.referentiel.model.Service;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.vo.EtatReservation;
import com.m2m.technicalservices.dao.impl.GenericDaoJpaImpl;

/**
 * 
 * @author abousnane
 * 
 */
@Repository("serviceDao")
public class ServiceDaoJpaImpl extends GenericDaoJpaImpl<Service, Long>
		implements ServiceDaoJpa {

	@Override
	public List<Service> findByCriteria(ServiceCriteria criteria) {
		String statusCode = criteria.getStatut() == null ? null : criteria
				.getStatut().name();
		Object[] parameters = new Object[] { criteria.getCode(),
				criteria.getLibelle(), criteria.getHeureDebut(),
				criteria.getHeureFin(), statusCode };
		String queryString = Queries.FIND_SERVICE_BY_CRITERIA;
		String orderByClause = criteria.getSortField() != null ? " order by "
				+ criteria.getSortField() + " " + criteria.getSortOrder() : "";
		return findByCriteria(queryString, orderByClause,
				criteria.getSearchConfig(), parameters);
	}

	@Override
	public List<Service> findForCombo() {
		Object[] parameters = new Object[] {};
		String queryString = Queries.FIND_ALL_SERVICE_FOR_COMBO;
		return executeQuery(queryString, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.onousc.business.referentiel.dao.ServiceDaoJpa#findByCode(java
	 * .lang.String)
	 */
	@Override
	public Service findByCode(String code) {
		Object[] parameters = new Object[] { code };
		String queryString = Queries.FIND_SERVICE_BY_CODE;
		return executeQuerySingleResult(queryString, parameters);
	}

	@Override
	public List<Service> findByType(String type) {
		Object[] parameters = new Object[] {type};
		String queryString = Queries.FIND_SERVICE_BY_TYPE;
		return executeQuery(queryString, parameters);
	}

	

	@Override
	@Transactional
	public void persistReservation(String libelle, Double montant) {
		Reservation reservation=new Reservation();
		
		reservation.setDateOperation(new Date());
		reservation.setEtat(EtatReservation.NON_CONSOMEE);
		reservation.setMontant(montant);
		reservation.setLibelle(libelle);
		getEm().merge(reservation);
		
	}

	@Override
	@Transactional
	public void persistReservationDetail(Service idService,
			Reservation reservation) {
		ReservationDetail reservationDetail=new ReservationDetail();
		reservationDetail.setDateService(new Date());
			reservationDetail.setEtat(EtatReservation.NON_CONSOMEE);
			reservationDetail.setService(idService);
			reservationDetail.setReservation(reservation);
			getEm().merge(reservationDetail);
		
	}

	@Override
	@Transactional
	public void persistReserv(Reservation reservation) {
		getEm().persist(reservation);
		
	}

}
