/*
 * ReservationSrvPresentationImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.edition.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.onousc.business.referentiel.model.SemaineUniversitaire;
import com.m2m.onousc.business.referentiel.vo.SemaineUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.transformer.SemaineUniversitaireVOTransformer;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.service.ReservationService;
import com.m2m.onousc.business.reservation.vo.ReservationDetailVO;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.onousc.business.reservation.vo.transformer.ReservationDetailVOTransformer;
import com.m2m.onousc.business.reservation.vo.transformer.ReservationVOTransformer;
import com.m2m.onousc.web.edition.EditionSrvPresentation;

/**
 * The Class ReservationSrvPresentationImpl.
 * 
 * @version 1.0 19 oct. 2015
 * @author iissouani
 */
@Service("editionSrvPresentation")
@Transactional(readOnly = true)
public class EditionSrvPresentationImpl implements
		EditionSrvPresentation, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7634666256645513198L;

	/** The reservation service. */
	@Autowired
	private ReservationService reservationService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.web.reservation.ReservationSrvPresentation#
	 * findAllSemaineUniversitaireForCombo()
	 */
	@Override
	public List<SemaineUniversitaireVO> findAllSemaineUniversitaireForCombo() {
		List<SemaineUniversitaire> models = reservationService
				.findAllSemaineUniversitaireForCombo();
		return new SemaineUniversitaireVOTransformer().model2VO(models, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.web.reservation.ReservationSrvPresentation#
	 * findSemaineUniversitaireById(long)
	 */
	@Override
	public SemaineUniversitaireVO findSemaineUniversitaireById(
			long idSemaineUniversitaire) {
		SemaineUniversitaire model = reservationService
				.findSemaineUniversitaireById(idSemaineUniversitaire);
		return new SemaineUniversitaireVOTransformer().model2VO(model, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.web.reservation.ReservationSrvPresentation#
	 * findReservationByUser(java.lang.String)
	 */
	@Override
	public List<ReservationVO> findReservationByUser(String user) {
		List<Reservation> models = reservationService
				.findReservationByUser(user);
		return new ReservationVOTransformer().model2VO(models, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.onousc.web.reservation.ReservationSrvPresentation#
	 * findDetailByReservation(java.lang.Long)
	 */
	@Override
	public List<ReservationDetailVO> findDetailByReservation(Long id) {
		List<ReservationDetail> models = reservationService
				.findDetailByReservation(id);
		return new ReservationDetailVOTransformer().model2VO(models, false);
	}

}
