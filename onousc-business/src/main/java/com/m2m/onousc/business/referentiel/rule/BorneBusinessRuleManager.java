package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class BorneBusinessRuleManager extends BusinessRuleManagerBase {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if (sousCommand.equals("creerBorne")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;
		}

		if (sousCommand.equals("creerBorne")
				|| sousCommand.equals("editerBorne")) {
			processResult = rule2();
			if (processResult.isMsgError())
				return processResult;
		}
		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		Borne model = (Borne) subject;
		List<Borne> listborne = referentielService.findBorneByCode(model
				.getCode());

		if (listborne.size() != 0) {
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
		Borne model = (Borne) subject;
		String ips[] = model.getIp().split("\\.");
		if (ips.length != 4) {
			processResult
					.addMessage(new ProcessMsg(
							"ip.rule",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		} else {
			try {
				Integer a = Integer.parseInt(ips[0]);
				a = Integer.parseInt(ips[1]);
				a = Integer.parseInt(ips[2]);
				a = Integer.parseInt(ips[3]);
			} catch (Exception e) {
				processResult
						.addMessage(new ProcessMsg(
								"ip.rule",
								null,
								com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
								FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		}

		return processResult;
	}

}
