/*
 * GererReservation.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.rule.ReservationBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * The Class GererReservation.
 * 
 * @version 1.0 29 oct. 2015
 * @author user
 */
@Service("RESERVATION_GererReservation_UC")
public class GererReservation extends UseCaseController {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.technicalservices.core.UseCaseController#getBusinessRuleManager()
	 */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new ReservationBusinessRuleManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {
		String sousCommande = UserContext.getClientParameters()
				.getSousCommand();
		if (sousCommande.equals(Constantes.SOUS_COMMAND_CREER_RESERVATION)) {
			this.calculerMontant();
			this.debiterSolde();
		}
		if (sousCommande.equals(Constantes.SOUS_COMMAND_ANNULER_RESERVATION)) {
			this.crediterSolde();
		}
		return null;
	}

	/**
	 * Calculer montant. Le tarif des services est parametrable
	 * 
	 * @return the double
	 */
	private void calculerMontant() {
		Reservation reservation = (Reservation) UserContext.getSubject();
		Tarif tarifS = new Tarif();
		double montant = 0.0;
		for (ReservationDetail resdet : reservation.getReservationDetail()) {
			if (referentielService.findTarifByCodeService(
					resdet.getService().getCode()).size() != 0)
				tarifS = referentielService.findTarifByCodeService(
						resdet.getService().getCode()).get(0);
			montant += tarifS.getTarif();
		}
		montant = (double) Math.round(montant * 100) / 100;
		// montant = reservation.getReservationDetail().size() * 1.40;
		reservation.setMontant(montant);
	}

	/**
	 * Debiter solde.
	 */
	private void debiterSolde() {
	}

	/**
	 * Crediter solde.
	 */
	private void crediterSolde() {
	}
}
