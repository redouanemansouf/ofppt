package com.m2m.onousc.business.referentiel.rule;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.security.WinMenu;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * 
 * @author abousnane
 *
 */
public class WinMenuBusinessRuleManager extends BusinessRuleManagerBase{

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
		if(sousCommand.equals("modifierWinMenu")){
			processResult = rule1();
			if(processResult.isMsgError())
				return processResult;
		}

		return processResult;  
	}
	
	private ProcessResult rule1(){
		ProcessResult processResult = new ProcessResult();
		WinMenu model = (WinMenu) subject;
		boolean consult = model.isDroitConsult();
		boolean creat = model.isDroitCreat();
		boolean modif = model.isDroitModif();
		boolean suppr = model.isDroitSuppr();
			if(!consult && (creat || modif || suppr)){
				processResult.addMessage(new ProcessMsg("winMenu.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult; 
			}
		

		return processResult;
	}

	
}
