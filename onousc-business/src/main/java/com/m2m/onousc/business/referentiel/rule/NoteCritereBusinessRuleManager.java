package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.NoteCritere;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class NoteCritereBusinessRuleManager extends BusinessRuleManagerBase {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if (sousCommand.equals("creerNoteCritere")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;
		}

		if (sousCommand.equals("creerNoteCritere")
				|| sousCommand.equals("editerNoteCritere")) {
			
//			processResult = rule2();
//			if (processResult.isMsgError())
//				return processResult;

			processResult = rule3();
			if (processResult.isMsgError())
				return processResult;

		}
		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		NoteCritere model = (NoteCritere) subject;
		List<NoteCritere> listcat = referentielService
				.findNoteCritereByCode(model.getCode());

		if (listcat.size() != 0) {
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
		NoteCritere model = (NoteCritere) subject;
		List<NoteCritere> listcat = referentielService
				.findAllNoteCritereForCombo();

		for (NoteCritere nc : listcat) {
			if (!nc.getCode().equals(model.getCode())) {
				if ((model.getMin() >= nc.getMin() && model.getMin() <= model
						.getMax())
						|| (model.getMax() >= nc.getMin() && model.getMax() <= nc
								.getMax())) {
					processResult
							.addMessage(new ProcessMsg(
									"critere.rule2",
									null,
									com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
									FacesMessage.SEVERITY_ERROR));
					return processResult;
				}
			}
		}

		return processResult;
	}

	private ProcessResult rule3() {
		ProcessResult processResult = new ProcessResult();
		NoteCritere model = (NoteCritere) subject;

		if (model.getMin() > model.getMax()) {
			processResult
					.addMessage(new ProcessMsg(
							"critere.rule3",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}
		return processResult;
	}

}
