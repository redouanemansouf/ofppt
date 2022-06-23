package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.model.Adherent;
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
public class AdherentBusinessRuleManager extends BusinessRuleManagerBase {

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
		if(sousCommand.equals(Constantes.SOUS_COMMAND_CREER_ADHERENT)){
			processResult = rule2();
			if(processResult.isMsgError())
				return processResult;
		}
		if(sousCommand.equals(Constantes.SOUS_COMMAND_CREER_ADHERENT)){
			processResult = rule3();
			if(processResult.isMsgError())
				return processResult;
		}
		if(sousCommand.equals("creerEtudiant")){
			processResult = rule3();
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

	private ProcessResult rule2(){
		ProcessResult processResult = new ProcessResult();
		Adherent model = (Adherent) subject;
		List<Adherent> list_Adhe_Nscol=referentielService.findAdherentByAgeNscol(model.getMatr());
		if(list_Adhe_Nscol.size() > 0){
			processResult.addMessage(new ProcessMsg("adh.rule2",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
					FacesMessage.SEVERITY_ERROR));
			return processResult;
		}



		return processResult;
	}
	private ProcessResult rule3(){
		ProcessResult processResult = new ProcessResult();
		Adherent model = (Adherent) subject;
		List<Adherent> list_Adhe_scol=referentielService.findAdherentByAgescol(model.getMatr());
		if(list_Adhe_scol.size() > 0){
			processResult.addMessage(new ProcessMsg("adh.rule3",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
					FacesMessage.SEVERITY_ERROR));
			return processResult;
		}



		return processResult;
	}

}
