package com.m2m.onousc.business.referentiel.rule;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * 
 * @author abousnane
 * 
 */
public class TarifBusinessRuleManager extends BusinessRuleManagerBase {

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
		if (sousCommand.equals("creerTarif")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;
		}
		if (sousCommand.equals("creerTarif")
				|| sousCommand.equals("editerTarif")) {
			processResult = rule2();
			if (processResult.isMsgError())
				return processResult;
		}

		if (sousCommand.equals("supprimerTarif")) {
			processResult = rule3();
			if (processResult.isMsgError())
				return processResult;
		}

		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		Tarif model = (Tarif) subject;
		List<Tarif> listtarif = referentielService.findTarifByCode(model
				.getCode());

		if (listtarif.size() != 0) {
			processResult
					.addMessage(new ProcessMsg(
							"code.rule1",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}

		return processResult;
	}

	private ProcessResult rule2() {
		ProcessResult processResult = new ProcessResult();
		Tarif model = (Tarif) subject;
		List<Tarif> listtarif = referentielService.findAllTarifForCombo();
		for (Tarif tr : listtarif) {
			if (!tr.getCode().equals(model.getCode()))
				if (tr.getService().getCode()
						.equals(model.getService().getCode())
						&& tr.getCategoriePorteur().getCode()
								.equals(model.getCategoriePorteur().getCode())) {
					processResult
							.addMessage(new ProcessMsg(
									"tarif.rule2",
									null,
									com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
									FacesMessage.SEVERITY_ERROR));
					return processResult;
				}
		}

		return processResult;
	}

	private ProcessResult rule3() {
		ProcessResult processResult = new ProcessResult();
		Tarif model = (Tarif) subject;
		List<Tarif> listtr = referentielService
				.findTarifInReservationDetail(model.getCode());

		if (listtr.size() != 0) {
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
