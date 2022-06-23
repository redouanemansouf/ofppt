/*
 * ReservationSrvPresentation.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.edition;

import java.util.List;

import com.m2m.onousc.business.referentiel.vo.SemaineUniversitaireVO;
import com.m2m.onousc.business.reservation.vo.ReservationDetailVO;
import com.m2m.onousc.business.reservation.vo.ReservationVO;

/**
 * The Interface ReservationSrvPresentation.
 */
public interface EditionSrvPresentation {

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

	/**
	 * Find detail by reservation.
	 *
	 * @param id the id
	 */
	List<ReservationDetailVO>  findDetailByReservation(Long id);

}
