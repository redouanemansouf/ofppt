package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.dao.EmptyResultDataAccessException;

import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.onousc.business.referentiel.model.Equipement;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.service.ReservationService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class RestaurantBusinessRuleManager extends BusinessRuleManagerBase {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	ReservationService reservationService = (ReservationService) BeansLookuper
			.lookup("reservationService");

	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if (sousCommand.equals("creerRestaurant")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;
		}

		if (sousCommand.equals("creerRestaurant")
				|| sousCommand.equals("editerRestaurant")) {
			processResult = rule2();
			if (processResult.isMsgError())
				return processResult;
		}

		if (sousCommand.equals("supprimerRestaurant")) {
			processResult = rule3();
			if (processResult.isMsgError())
				return processResult;
		}
		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		Restaurant model = (Restaurant) subject;
		Restaurant listrest = null;
		try {
			listrest = referentielService.findRestaurantByCode(model.getCode());
		} catch (EmptyResultDataAccessException e) {

		}

		if (listrest != null) {
			processResult
					.addMessage(new ProcessMsg(
							"code.rule1",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}

		return processResult;
	}

	private ProcessResult rule2() {
		ProcessResult processResult = new ProcessResult();
		Restaurant model = (Restaurant) subject;

		if (model.getNbreplace() <= 0) {
			processResult
					.addMessage(new ProcessMsg(
							"nbreplace.rule1",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}

		return processResult;
	}

	private ProcessResult rule3() {
		ProcessResult processResult = new ProcessResult();
		Restaurant model = (Restaurant) subject;
		List<Caisse> listres = referentielService
				.findCaisseByCodeRestaurant(model.getCode());
		List<Tourniquet> listt = referentielService
				.findTourniquetByCodeRestaurant(model.getCode());
		List<Equipement> listeq = referentielService
				.findEquipementByCodeRestaurant(model.getCode());
		List<Reservation> listreservation = reservationService
				.findReservationByCodeRestaurant(model.getCode());
		List<Etudiants> listetu = referentielService
				.findEtudiantByCodeRestaurant(model.getCode());

		if (listres.size() != 0 || listt.size() != 0 || listeq.size() != 0
				|| listreservation.size() != 0 || listetu.size() != 0) {
			processResult
					.addMessage(new ProcessMsg(
							"supp.rule1",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}

		return processResult;
	}

}
