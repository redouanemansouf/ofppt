package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * 
 * @author msadik
 * 
 */
public class EtudiantBusinessRuleManager extends BusinessRuleManagerBase {

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
		if(sousCommand.equals("creerEtudiant")){
			processResult = rule1();
			if(processResult.isMsgError())
				return processResult;
		}

		return processResult;
	}
	
	
	private ProcessResult rule1(){
		ProcessResult processResult = new ProcessResult();
		Etudiants model = (Etudiants) subject;
		List<Etudiants> listetudBycin =  referentielService.findByCIN(model.getNCIN());
			if(listetudBycin.size() > 0){
				processResult.addMessage(new ProcessMsg("cin.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		

		
		return processResult;
	}

}
