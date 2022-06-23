/*
 * GererCanalVente.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.uc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CycleVieDaoJpa;
import com.m2m.onousc.business.referentiel.dao.EtudiantDaoJpa;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.rule.CanalVenteBusinessRuleManager;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * The Class GererCanalVente.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Service("REFERENTIEL_GererCarte_UC")
public class GererCarte extends UseCaseController {

	ReferentielService referentielService = (ReferentielService) BeansLookuper.lookup("referentielService");

	@Autowired
	private CycleVieDaoJpa cycleVieDaoJpa;

	@Autowired
	private CarteDaoJpa carteDaoJpa;

	@Autowired
	private EtudiantDaoJpa etudiantDaoJpa;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.technicalservices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new CanalVenteBusinessRuleManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {

		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_METTRE_CARTE_EN_OPPOSITION)) {

			// carte
			Carte sub = (Carte) UserContext.getSubject();

			if (sub.getStatut().equals(EntityStatus.DELIVRED)) {
				sub.setStatut(EntityStatus.DELIVREDOPPO);
			} else if (sub.getStatut().equals(EntityStatus.PERSONALIZED)) {
				sub.setStatut(EntityStatus.PERSONALIZEDOPPO);
			} else if (sub.getStatut().equals(EntityStatus.ACTIVATED)) {
				sub.setStatut(EntityStatus.ACTIVATEDOPPO);
			}

			UserContext.setSubject(sub);

			// cycle de vie
			CycleVie cycle = new CycleVie();
			cycle.setDateOperation(new Date());
			cycle.setNumPorteur(sub.getNumPorteur());
			cycle.setNumSerie(sub.getNumSerie());
			cycle.setOperateur(sub.getNumeroCarte());
			cycle.setOperation("Mise en opposition /" + sub.getOperation());
			cycle.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycle);

		}

		if (UserContext.getClientParameters().getSousCommand().equals(Constantes.SOUS_COMMAND_CARTE_MAIN_LEVEE)) {

			// carte
			Carte sub = (Carte) UserContext.getSubject();

			if (sub.getStatut().equals(EntityStatus.DELIVREDOPPO)) {
				sub.setStatut(EntityStatus.DELIVRED);
			} else if (sub.getStatut().equals(EntityStatus.PERSONALIZEDOPPO)) {
				sub.setStatut(EntityStatus.PERSONALIZED);
			} else if (sub.getStatut().equals(EntityStatus.ACTIVATEDOPPO)) {
				sub.setStatut(EntityStatus.ACTIVATED);
			}

			UserContext.setSubject(sub);

			// cycle de vie
			CycleVie cycle = new CycleVie();
			cycle.setDateOperation(new Date());
			cycle.setNumPorteur(sub.getNumPorteur());
			cycle.setNumSerie(sub.getNumSerie());
			cycle.setOperateur(sub.getNumeroCarte());
			cycle.setOperation("Main Levée /" + sub.getOperation());
			cycle.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycle);

		}

		if (UserContext.getClientParameters().getSousCommand().equals(Constantes.SOUS_COMMAND_REFABRIQUER_CARTE)) {

			Carte carte = new Carte();
			CycleVie cycleVie = new CycleVie();
			Carte subjet = (Carte) UserContext.getSubject();

			String sequence = "";
			sequence = subjet.getNumeroCarte().replaceAll(1697 + "" + subjet.getNumPorteur().getSite().getCode(), "");
			sequence = "" + (Long.valueOf(sequence).longValue() + 1);
			carte.setNumeroCarte(1697 + "" + subjet.getNumPorteur().getSite().getCode() + sequence);

			carte.setNumPorteur(subjet.getNumPorteur());
			carte.setNumSerie((subjet.getNumPorteur().getId() * 43) + "0");
			carte.setOperation("ENCOURS");
			carte.setDateExpiration(subjet.getNumPorteur().getAnneeUniversitaire().getDate_fin());
			carte.setStatut(EntityStatus.PERSONALIZED);
			carte.setSolde(subjet.getSolde());
			carteDaoJpa.persist(carte);

			cycleVie.setDateOperation(new Date());
			cycleVie.setNumPorteur(subjet.getNumPorteur());
			cycleVie.setNumSerie(subjet.getNumSerie());
			cycleVie.setOperateur(subjet.getNumeroCarte());
			cycleVie.setOperation("Re-Fabrication");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);

		}

		return null;

	}

}
