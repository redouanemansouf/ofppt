package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.Plafond;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class PlafondBusinessRuleManager extends BusinessRuleManagerBase {
	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if (sousCommand.equals("creerPlafond")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;

		}
		if (sousCommand.equals("creerPlafond")
				|| sousCommand.equals("editerPlafond")) {
			processResult = rule2();
			if (processResult.isMsgError())
				return processResult;
			processResult = rule3();
			if (processResult.isMsgError())
				return processResult;
		}

		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		Plafond model = (Plafond) subject;
		List<Plafond> listplafond = referentielService.findPlafondByCode(model
				.getCode());

		if (listplafond.size() != 0) {
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
		Plafond model = (Plafond) subject;
		if (model.getMax() < model.getMin()) {
			processResult
					.addMessage(new ProcessMsg(
							"plafond.param",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
		}
		return processResult;
	}

	private ProcessResult rule3() {
		ProcessResult processResult = new ProcessResult();
		Plafond model = (Plafond) subject;
		if (model.getMax() <= 0 || model.getMin() < 0) {
			processResult
					.addMessage(new ProcessMsg(
							"plafond.neg",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
		}
		return processResult;
	}

}
