package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.model.OperationCaisse;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class CaisseBusinessRuleManager extends BusinessRuleManagerBase {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if (sousCommand.equals("creerCaisse")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;
		}
		if (sousCommand.equals("supprimerCaisse")) {
			processResult = rule2();
			if (processResult.isMsgError())
				return processResult;
		}
		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		Caisse model = (Caisse) subject;
		List<Caisse> listcaisse = referentielService.findCaisseByCode(model
				.getCode());

		if (listcaisse.size() != 0) {
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
		Caisse model = (Caisse) subject;
		List<OperationCaisse> listoper = referentielService
				.findOperationCaisseByCodeCaisse(model.getCode());

		if (listoper.size() != 0) {
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
