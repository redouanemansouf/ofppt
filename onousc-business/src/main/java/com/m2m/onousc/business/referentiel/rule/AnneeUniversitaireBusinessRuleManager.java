package com.m2m.onousc.business.referentiel.rule;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;

import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.onousc.business.referentiel.model.JoursFerie;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class AnneeUniversitaireBusinessRuleManager extends
		BusinessRuleManagerBase {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		if (sousCommand.equals("creerAnneeUniversitaire")) {
			processResult = rule1();
			if (processResult.isMsgError())
				return processResult;

		}

		if (sousCommand.equals("creerAnneeUniversitaire")
				|| sousCommand.equals("editerAnneeUniversitaire")) {
			processResult = rule2();
			if (processResult.isMsgError())
				return processResult;
			// processResult = rule3();
			// if (processResult.isMsgError())
			// return processResult;
			processResult = rule4();
			if (processResult.isMsgError())
				return processResult;
			processResult = rule6();
			if (processResult.isMsgError())
				return processResult;
			processResult = rule7();
			if (processResult.isMsgError())
				return processResult;
		}
		if (sousCommand.equals("supprimerAnneeUniversitaire")) {
			processResult = rule5();
			if (processResult.isMsgError())
				return processResult;
		}
		return processResult;
	}

	private ProcessResult rule1() {
		ProcessResult processResult = new ProcessResult();
		AnneeUniversitaire model = (AnneeUniversitaire) subject;
		List<AnneeUniversitaire> listannu = referentielService
				.findAnneUniversitaireByCode(model.getCode());

		if (listannu.size() != 0) {
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
		AnneeUniversitaire model = (AnneeUniversitaire) subject;
		if (model.getDate_fin().before(model.getDate_debut())) {
			processResult
					.addMessage(new ProcessMsg(
							"date.rule2",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}

		return processResult;
	}

	/*
	 * public ProcessResult rule3() { ProcessResult processResult = new
	 * ProcessResult(); AnneeUniversitaire model = (AnneeUniversitaire) subject;
	 * Calendar date_fin = Calendar.getInstance(); Calendar date_debut =
	 * Calendar.getInstance(); date_fin.setTime(model.getDate_fin());
	 * date_debut.setTime(model.getDate_debut()); if
	 * (date_fin.get(Calendar.YEAR) - date_debut.get(Calendar.YEAR) != 1) {
	 * processResult .addMessage(new ProcessMsg( "date.rule3", null,
	 * com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
	 * FacesMessage.SEVERITY_ERROR)); return processResult; } return
	 * processResult; }
	 */

	public ProcessResult rule4() {
		ProcessResult processResult = new ProcessResult();
		AnneeUniversitaire model = (AnneeUniversitaire) subject;
		List<AnneeUniversitaire> listannu = referentielService
				.findAllAnneeUniversitaireForCombo();
		Calendar date_fin = Calendar.getInstance();
		Calendar date_debut = Calendar.getInstance();
		Calendar date_fin2 = Calendar.getInstance();
		Calendar date_debut2 = Calendar.getInstance();
		date_fin.setTime(model.getDate_fin());
		date_debut.setTime(model.getDate_debut());
		for (AnneeUniversitaire u : listannu) {
			date_fin2.setTime(u.getDate_fin());
			date_debut2.setTime(u.getDate_debut());
			if (!u.getCode().equals(model.getCode()))
				if (date_fin.get(Calendar.YEAR) == date_fin2.get(Calendar.YEAR)
						|| date_debut.get(Calendar.YEAR) == date_debut2
								.get(Calendar.YEAR)) {
					processResult
							.addMessage(new ProcessMsg(
									"date.rule4",
									null,
									com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
									FacesMessage.SEVERITY_ERROR));
					return processResult;
				}
		}
		return processResult;
	}

	private ProcessResult rule5() {
		ProcessResult processResult = new ProcessResult();
		AnneeUniversitaire model = (AnneeUniversitaire) subject;
		List<JoursFerie> listjours = referentielService
				.findJoursFerieByCodeAnneeUniversitaire(model.getCode());

		if (listjours.size() != 0) {
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

	private ProcessResult rule6() {
		ProcessResult processResult = new ProcessResult();
		AnneeUniversitaire model = (AnneeUniversitaire) subject;
		Calendar date_fin = Calendar.getInstance();
		Calendar date_debut = Calendar.getInstance();
		date_fin.setTime(model.getDate_fin());
		date_debut.setTime(model.getDate_debut());
		if (date_debut.get(Calendar.YEAR) != Calendar.getInstance().get(
				Calendar.YEAR)
				|| date_fin.get(Calendar.YEAR) != Calendar.getInstance().get(
						Calendar.YEAR) + 1) {
			processResult
					.addMessage(new ProcessMsg(
							"annee.rule6",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}

		return processResult;
	}

	private ProcessResult rule7() {
		ProcessResult processResult = new ProcessResult();
		AnneeUniversitaire model = (AnneeUniversitaire) subject;
		Calendar date_fin = Calendar.getInstance();
		Calendar date_debut = Calendar.getInstance();
		date_fin.setTime(model.getDate_fin());
		date_debut.setTime(model.getDate_debut());
		int mois = date_fin.get(Calendar.MONTH) + 1;
		int a = 12 - date_debut.get(Calendar.MONTH);
		if ((a + mois) <= 9 || (a + mois) > 12) {
			processResult
					.addMessage(new ProcessMsg(
							"date.rule3",
							null,
							com.m2m.technicalservices.core.Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));
			return processResult;
		}
		return processResult;
	}
}
