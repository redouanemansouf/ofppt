package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.MotifOpposition;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class MotifOppositionBusinessRuleManager extends BusinessRuleManagerBase{
	
	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	
	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if(sousCommand.equals("creerMotifOpposition")){
			processResult = rule1();
			if(processResult.isMsgError())
				return processResult;
		}
		return processResult;
	}
	
	private ProcessResult rule1(){
		ProcessResult processResult = new ProcessResult();
		MotifOpposition model = (MotifOpposition) subject;
		List<MotifOpposition> listopp =  referentielService.findMotifOppositionByCode(model.getCode());
		
			if(listopp.size() != 0){
				processResult.addMessage(new ProcessMsg("code.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		

		
		return processResult;
	}

}
