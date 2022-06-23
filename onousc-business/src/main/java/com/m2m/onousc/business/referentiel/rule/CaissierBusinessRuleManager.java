package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class CaissierBusinessRuleManager extends BusinessRuleManagerBase {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if (sousCommand.equals("creerCaissier")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;

		}
		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		Caissier model = (Caissier) subject;
		List<Caissier> listannu = referentielService.findCaissierByCode(model
				.getCode());
		List<Caissier> listnumc = referentielService.findCaissierByNumcarte(model.getNumCarte());
	
		if (listannu.size() != 0 || listnumc.size() != 0) {
			if(listannu.size() != 0)
			{
				processResult
				.addMessage(new ProcessMsg(
						"code.rule1",
						null,
						com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
						FacesMessage.SEVERITY_ERROR));
		return processResult;
			}
			
			if(listnumc.size() != 0)
			{
				processResult
				.addMessage(new ProcessMsg(
						"numcarte.rule1",
						null,
						com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
						FacesMessage.SEVERITY_ERROR));
		return processResult;
			}
			
		}
		
		

		return processResult;
	}
}
