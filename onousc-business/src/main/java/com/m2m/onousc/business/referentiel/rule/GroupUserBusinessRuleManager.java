package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.service.AdministrationService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * 
 * @author iissouani
 *
 */
public class GroupUserBusinessRuleManager extends BusinessRuleManagerBase{

	/** The service. */
	private AdministrationService administrationService = (AdministrationService) BeansLookuper
			.lookup("administrationService");
	
	/**
	 * validate business rule.
	 * 
	 * @return the process result
	 */
	@Override
	public ProcessResult doValidation() {
		
		ProcessResult processResult = new ProcessResult();
		if(sousCommand.equals(Constantes.SOUS_COMMAND_CREER_GROUP_USER)){
			processResult = rule1();
			if(processResult.isMsgError())
				return processResult;

		}
		
		if(sousCommand.equals(Constantes.SOUS_COMMAND_SUPPRIMER_GROUP_USER)){ 
			processResult = rule3();
			if(processResult.isMsgError())
				return processResult;
		}
		return processResult;  
	}
	
	private ProcessResult rule1(){
		ProcessResult processResult = new ProcessResult();
		GroupUser model = (GroupUser) subject; 
		List<GroupUser> groups = administrationService.findGroupByCode(model.getGroupname());
		
			if(groups != null && groups.size()>0){
				processResult.addMessage(new ProcessMsg("group.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		

		return processResult;
	}

	//regle pour verifier si un groupe posséde des utilisateurs
	private ProcessResult rule3(){
		ProcessResult processResult = new ProcessResult();
		GroupUser model = (GroupUser) subject; 

		if(hasUser(model)){  
			processResult.addMessage(new ProcessMsg("group.rule3",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
					FacesMessage.SEVERITY_ERROR));
			return processResult;
		}
		
		
		return processResult;
	}
	
	private boolean hasUser(GroupUser group){

			List<UserEntity> userByGroup = administrationService.findUserByGroup(group.getGroupname());
			if(userByGroup!=null && userByGroup.size()>0){
				return true;
			}
			
		
		return false;
	}

	
}
