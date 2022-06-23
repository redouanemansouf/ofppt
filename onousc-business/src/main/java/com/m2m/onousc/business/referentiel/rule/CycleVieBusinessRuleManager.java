package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.criteria.CycleVieCriteria;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class CycleVieBusinessRuleManager extends BusinessRuleManagerBase {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	/**
	 * validate business rule.
	 * 
	 * @return the process result
	 */
	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if (sousCommand.equals("metterEnOpposition")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;
		}
		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		CycleVie model = (CycleVie) subject;
		List<CycleVie> listcycle = referentielService.findCycleVieByCode(model
				.getNumSerie());

		if (listcycle.size() == 0) {
			processResult
					.addMessage(new ProcessMsg(
							"opposition.rule1",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;

		} else {
			model.setDateOperation(listcycle.get(0).getDateOperation());
			model.setNumPorteur(listcycle.get(0).getNumPorteur());
			model.setOperateur(listcycle.get(0).getOperateur());
			model.setOperation(listcycle.get(0).getOperation());
			model.setStatut(EntityStatus.ENABLED);
			
			return processResult;
		}
	}

}
