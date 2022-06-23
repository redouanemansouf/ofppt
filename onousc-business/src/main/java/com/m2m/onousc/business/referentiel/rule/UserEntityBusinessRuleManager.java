package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * 
 * @author abousnane
 *
 */
public class UserEntityBusinessRuleManager extends BusinessRuleManagerBase{

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
		if(sousCommand.equals("creerUserEntity")){
			processResult = rule1();
			if(processResult.isMsgError())
				return processResult;
		}

		return processResult;  
	}
	
	private ProcessResult rule1(){
		ProcessResult processResult = new ProcessResult();
		UserEntity model = (UserEntity) subject;
		UserEntity user = referentielService.findUserByCode(model.getUsername());
		
			if(user != null){
				processResult.addMessage(new ProcessMsg("user.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		

		return processResult;
	}

	
}
