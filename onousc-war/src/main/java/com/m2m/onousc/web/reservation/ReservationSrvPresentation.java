/*
 * ReservationSrvPresentation.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.reservation;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.SemaineUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.TarifVO;
import com.m2m.onousc.business.reservation.vo.EtatReservation;
import com.m2m.onousc.business.reservation.vo.ReservationDetailVO;
import com.m2m.onousc.business.reservation.vo.ReservationVO;

/**
 * The Interface ReservationSrvPresentation.
 */
public interface ReservationSrvPresentation {

	/** The Constant codeMaroc. */
	static final String codeMaroc = "504";

	/**
	 * Find all semaine universitaire for combo.
	 * 
	 * @return the list
	 */
	List<SemaineUniversitaireVO> findAllSemaineUniversitaireForCombo();

	/**
	 * Find semaine universitaire by id.
	 * 
	 * @param idSemaineUniversitaire
	 *            the id semaine universitaire
	 * @return the semaine universitaire vo
	 */
	SemaineUniversitaireVO findSemaineUniversitaireById(
			long idSemaineUniversitaire);

	/**
	 * Find reservation by user.
	 * 
	 * @param user
	 *            the user
	 */
	List<ReservationVO> findReservationByUser(String user);
	
	List<ReservationVO> findReservationByDate(Date dateDebut,Date dateFin);

	/**
	 * Find detail by reservation.
	 * 
	 * @param id
	 *            the id
	 */
	List<ReservationDetailVO> findDetailByReservation(Long id);

	/**
	 * Find reservation by etat.
	 * 
	 * @param nonConsomee
	 *            the non consomee
	 * @return the list
	 */
	List<ReservationDetailVO> findReservationByEtat(EtatReservation etat,String carte);

	/**
	 * Find carte by numero.
	 * 
	 * @param numeroCarte
	 *            the numero carte
	 * @return the carte vo
	 */
	CarteVO findCarteByNumero(String numeroCarte);

	/**
	 * Find reservation by numero carte.
	 * 
	 * @param numeroCarte
	 *            the numero carte
	 * @return the list
	 */
	List<ReservationVO> findReservationByNumeroCarte(String numeroCarte);
	
	
	public List<TarifVO> findTarifByCodeService(String code);
	
	List<ReservationVO> findReservationByIdPorteur(String porteur);

}
