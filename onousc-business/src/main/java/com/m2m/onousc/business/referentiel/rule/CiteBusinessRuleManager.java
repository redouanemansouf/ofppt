package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.model.Equipement;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;



public class CiteBusinessRuleManager extends BusinessRuleManagerBase{

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
		if(sousCommand.equals("creerCite")){
			processResult = rule1();
			if(processResult.isMsgError())
				return processResult;
		}
		if (sousCommand.equals("supprimerCite")) {
			processResult = rule2();
			if (processResult.isMsgError())
				return processResult;
		}
		return processResult;
	}
	
	private ProcessResult rule1(){
		ProcessResult processResult = new ProcessResult();
		Cite model = (Cite) subject;
		List<Cite> listcite =  referentielService.findCiteByCode(model.getCode());
		
			if(listcite.size() != 0){
				processResult.addMessage(new ProcessMsg("code.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}
		

		
		return processResult;
	}
	
	private ProcessResult rule2() {
		ProcessResult processResult = new ProcessResult();
		Cite model = (Cite) subject;
		List<Restaurant> listres = referentielService.findRestaurantByCodeCite(model
				.getCode());
		List<Equipement> listeq = referentielService.findEquipementByCodeCite(model
				.getCode());

		if (listres.size() != 0 || listeq.size() != 0) {
			processResult
					.addMessage(new ProcessMsg(
							"supp.rule1",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}

		return processResult;
	}

}
