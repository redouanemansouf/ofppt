package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.security.WinMenu;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * 
 * @author abousnane
 *
 */
public class MenuBusinessRuleManager extends BusinessRuleManagerBase{

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
		if(sousCommand.equals(Constantes.SOUS_COMMANDE_CREER_MENU)){
			processResult = rule1();
			if(processResult.isMsgError())
				return processResult; 
		} 

		return processResult;  
	}
	
	private ProcessResult rule1(){
 		ProcessResult processResult = new ProcessResult(); 
		Menu model = (Menu) subject;
		List<Menu> user = referentielService.findMenuByCritere(model.getCode(),model.getLibelle(),model.getAbbrev());
		
		if(user != null && user.size()>0){
			processResult.addMessage(new ProcessMsg("menu.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
                    FacesMessage.SEVERITY_ERROR));
			return processResult;
		}
	

		return processResult;
	}

	
}
