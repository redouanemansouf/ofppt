/*
 * ReservationBusinessRuleManager.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.rule;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.service.ReservationService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * The Class ReservationBusinessRuleManager.
 */
public class ReservationBusinessRuleManager extends BusinessRuleManagerBase {

	/** The reservation service. */
	ReservationService reservationService = (ReservationService) BeansLookuper
			.lookup("reservationService");

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.IBusinessRuleManager#doValidation()
	 */
	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if (sousCommand.equals(Constantes.SOUS_COMMAND_CREER_RESERVATION)) {
			processResult = rule1();
		}
		return processResult;
	}

	/**
	 * Rule1: réservation déjà effectuée
	 * 
	 * @return the process result
	 */
	public ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		if (subject != null) {
			Reservation reservation = (Reservation) subject;
			// String code = reservation.getLibelle();
			// Date date date = r
			for (ReservationDetail reservationDetail : reservation
					.getReservationDetail()) {
				long x = reservationService
						.countReservationDetailByDateByService(
								reservationDetail.getDateService(),
								reservationDetail.getService().getId(),reservationDetail.getReservation().getCarte().getNumeroCarte());
				if (x != 0) {
					String[] infos = {};
					processResult
							.addMessage(new ProcessMsg(
									"reservation.rule1",
									infos,
									com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
									FacesMessage.SEVERITY_ERROR));
					return processResult;
				}
			}
		}
		return processResult;
	}
}
