package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.ParametreGeneral;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class ParametreGeneralBusinessRuleManager extends BusinessRuleManagerBase{
	
	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	
	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if(sousCommand.equals("creerParametreGeneral")){
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
		ParametreGeneral model = (ParametreGeneral) subject;
		List<ParametreGeneral> listcat =  referentielService.findParametreGeneralByCode(model.getCode());
		
			if(listcat.size() != 0){
				processResult.addMessage(new ProcessMsg("code.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		

		
		return processResult;
	}
	
	private ProcessResult rule2(){
		ProcessResult processResult = new ProcessResult();
		ParametreGeneral model = (ParametreGeneral) subject;
		List<ParametreGeneral> listcat =  referentielService.findAllParametreGeneralForCombo();
		for(ParametreGeneral param : listcat)
			if(param.getLibelle().equals(model.getLibelle())){
				processResult.addMessage(new ProcessMsg("param.rule2",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		

		
		return processResult;
	}

}
