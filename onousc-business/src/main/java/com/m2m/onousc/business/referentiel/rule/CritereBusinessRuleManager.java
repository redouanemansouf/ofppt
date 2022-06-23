package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.Critere;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class CritereBusinessRuleManager extends BusinessRuleManagerBase{
	
	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	
	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if(sousCommand.equals("creerCritere")){
			processResult = rule1();
			if(processResult.isMsgError())
				return processResult;
			
			processResult = rule2();
			if(processResult.isMsgError())
				return processResult;
		}
		return processResult;
	}
	
	private ProcessResult rule1(){
		ProcessResult processResult = new ProcessResult();
		Critere model = (Critere) subject;
		List<Critere> listcat =  referentielService.findCritereByCode(model.getCode());
		
			if(listcat.size() != 0){
				processResult.addMessage(new ProcessMsg("code.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		

		
		return processResult;
	}
	
	private ProcessResult rule2(){
		ProcessResult processResult = new ProcessResult();
		Critere model = (Critere) subject;
		List<Critere> listcat =  referentielService.findAllCritereForCombo();
		for(Critere param : listcat)
			if(param.getLibelle().equals(model.getLibelle())){
				processResult.addMessage(new ProcessMsg("param.rule2",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		

		
		return processResult;
	}

}
