package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.onousc.business.referentiel.model.JoursFerie;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class JoursFerieRuleManager extends BusinessRuleManagerBase{

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	
	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if(sousCommand.equals("creerJoursFerie")){
			processResult = rule1();
			if(processResult.isMsgError())
				return processResult;
			
		}
		if(sousCommand.equals("creerJoursFerie") || sousCommand.equals("editerJoursFerie")){
			processResult = rule2();
			if(processResult.isMsgError())
				return processResult;
			
			processResult = rule3();
			if(processResult.isMsgError())
				return processResult;
		}
		
		return processResult;
	}

	private ProcessResult rule1(){
		ProcessResult processResult = new ProcessResult();
		JoursFerie model = (JoursFerie) subject;
		List<JoursFerie> listjoursferie =  referentielService.findJoursFerieByCode(model.getCode());
		
			if(listjoursferie.size() != 0){
				processResult.addMessage(new ProcessMsg("code.rule1",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	                    FacesMessage.SEVERITY_ERROR));
				return processResult;
			}

		
		return processResult;
	}
	
	private ProcessResult rule2(){
		ProcessResult processResult = new ProcessResult();
		JoursFerie model = (JoursFerie) subject;
		if(model.getDate_fin().before(model.getDate_debut())){
			processResult.addMessage(new ProcessMsg("date.rule2",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
                    FacesMessage.SEVERITY_ERROR));
			return processResult;
		}
		
		return processResult;
	}
	
	private ProcessResult rule3(){
		ProcessResult processResult = new ProcessResult();
		JoursFerie model = (JoursFerie) subject;
		AnneeUniversitaire anneeUniv = model.getAnneeUniversitaire();
		if(model.getDate_debut().compareTo(anneeUniv.getDate_debut()) < 0 || model.getDate_fin().compareTo(anneeUniv.getDate_fin()) > 0){
			processResult.addMessage(new ProcessMsg("date.jf.rule3",null,com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
                    FacesMessage.SEVERITY_ERROR));
			return processResult;
		}
		return processResult;
	}
}
