package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.dao.EmptyResultDataAccessException;

import com.m2m.onousc.business.referentiel.model.JoursFerie;
import com.m2m.onousc.business.referentiel.model.Service;
import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.service.ReservationService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class ServiceBusinessRuleManager extends BusinessRuleManagerBase {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	ReservationService reservationService = (ReservationService) BeansLookuper
			.lookup("reservationService");

	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
	/*	if (sousCommand.equals("creerService")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;
		}

		if (sousCommand.equals("creerService")
				|| sousCommand.equals("editerService")) {
			processResult = rule3();
			if (processResult.isMsgError())
				return processResult;
		}

		if (sousCommand.equals("supprimerService")) {
			processResult = rule2();
			if (processResult.isMsgError())
				return processResult;
		}*/
		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		Service model = (Service) subject;
		Service service = null;
		try {
			service = referentielService.findServiceByCode(model.getCode());
		} catch (EmptyResultDataAccessException e) {

		}

		if (service != null) {
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
		Service model = (Service) subject;
		List<Tarif> listtr = referentielService.findTarifByCodeService(model
				.getCode());
		List<ReservationDetail> listres = reservationService
				.findReservationDetailByCodeService(model.getCode());

		if (listtr.size() != 0 || listres.size() != 0) {
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

	public ProcessResult rule3() {
		ProcessResult processResult = new ProcessResult();
		Service model = (Service) subject;

		if (model.getHeureFin().before(model.getHeureDebut())) {
			processResult
					.addMessage(new ProcessMsg(
							"heure.rule2",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}

		return processResult;
	}
}
