/*
 * ReservationServiceImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.SemaineUniversitaire;
import com.m2m.onousc.business.reservation.dao.ReservationDaoJpa;
import com.m2m.onousc.business.reservation.dao.ReservationDetailDaoJpa;
import com.m2m.onousc.business.reservation.dao.SemaineUniversitaireDaoJpa;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.service.ReservationService;
import com.m2m.onousc.business.reservation.vo.EtatReservation;

/**
 * The Class ReservationServiceImpl.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenboubker
 */
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1822661457460845384L;

	/** The reservation dao jpa. */
	@Autowired
	private ReservationDaoJpa reservationDaoJpa;

	/** The reservation detail dao jpa. */
	@Autowired
	private ReservationDetailDaoJpa reservationDetailDaoJpa;

	/** The semaine universitaire dao jpa. */
	@Autowired
	private SemaineUniversitaireDaoJpa semaineUniversitaireDaoJpa;

	@Autowired
	private CarteDaoJpa carteDaoJpa;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.referentiel.service.ReferentielService#
	 * findAllSemaineUniversitaireForCombo()
	 */
	@Override
	public List<SemaineUniversitaire> findAllSemaineUniversitaireForCombo() {
		return semaineUniversitaireDaoJpa.findForCombo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.service.ReservationService#
	 * findSemaineUniversitaireById(long)
	 */
	@Override
	public SemaineUniversitaire findSemaineUniversitaireById(
			long idSemaineUniversitaire) {
		return semaineUniversitaireDaoJpa.findById(idSemaineUniversitaire);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.service.ReservationService#
	 * findReservationByUser(java.lang.String)
	 */
	@Override
	public List<Reservation> findReservationByUser(String user) {
		return reservationDaoJpa.findByUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.service.ReservationService#
	 * findReservation(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Reservation> findReservation(Date dateDebut, Date dateFin) {
		return reservationDaoJpa.findReservationByDate(dateDebut, dateFin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.service.ReservationService#
	 * findDetailByReservation(java.lang.Long)
	 */
	@Override
	public List<ReservationDetail> findDetailByReservation(Long id) {
		return reservationDetailDaoJpa.findByReservation(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.service.ReservationService#
	 * findReservationByEtat
	 * (com.m2m.onousc.business.reservation.vo.EtatReservation)
	 */
	@Override
	public List<ReservationDetail> findReservationByEtat(EtatReservation etat,String carte) {
		return reservationDetailDaoJpa.findByReservationByEtat(etat,carte);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.service.ReservationService#
	 * findCarteByNumero(java.lang.String)
	 */
	@Override
	public Carte findCarteByNumero(String numeroCarte) {
		return carteDaoJpa.findByNumero(numeroCarte);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.service.ReservationService#
	 * findReservationByNumeroCarte(java.lang.String)
	 */
	@Override
	public List<Reservation> findReservationByNumeroCarte(String numeroCarte) {
		return reservationDaoJpa.findByNumeroCarte(numeroCarte);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.service.ReservationService#
	 * countReservationByCode(java.lang.String)
	 */
	@Override
	public Long countReservationByCode(String code) {
		return reservationDaoJpa.countByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.business.reservation.service.ReservationService#
	 * countReservationDetailByDateByService(java.util.Date, java.lang.Long)
	 */
	@Override
	public Long countReservationDetailByDateByService(Date dateService, Long id,String carte) {
		return reservationDetailDaoJpa.countByDateByService(dateService, id,carte);
	}

	@Override
	public List<Reservation> findReservationByCodeRestaurant(String code) {
		return reservationDaoJpa.findByCodeRestaurant(code);
	}

	@Override
	public List<ReservationDetail> findReservationDetailByCodeService(
			String code) {
		return reservationDetailDaoJpa.findByReservationDetailByService(code);
	}
	
	@Override
	public List<Reservation> findReservationByIdPorteur(String porteur) {
		return reservationDaoJpa.findReservationByIdPorteur(porteur);
	}

}
