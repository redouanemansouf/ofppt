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
import com.m2m.onousc.business.referentiel.dao.AdherentDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CycleVieDaoJpa;
import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.rule.AdherentBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.CanalVenteBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;

/**
 * The Class GererCanalVente.
 *
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Service("REFERENTIEL_GererAdherent_UC")
public class GererAdherent extends UseCaseController {

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Autowired
	CarteDaoJpa carteDaoJpa;
	
	@Autowired
	CycleVieDaoJpa cycleVieDaoJpa;
	
	@Autowired
	AdherentDaoJpa adherentdaoJpa;
	
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new AdherentBusinessRuleManager();
	}

	
	@Override
	protected ProcessResult business() {
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_PERSONNALISER_ADHERENT)) {
			Carte carte = new Carte();
			Adherent subjet = (Adherent) UserContext.getSubject();
			//carte.setNumPorteur(subjet);
			carte.setNumSerie((subjet.getId() * 43) + "");
			carte.setOperation("Fabrication");
			carte.setNumeroCarte(147851 + ""
					+ String.format("%010d",subjet.getId()));
			carte.setOperateur(subjet.getMatr());
		//	carte.setDateExpiration(subjet.getAnneeUniversitaire().getDate_fin());
			carte.setStatut(EntityStatus.ENABLED);
			carte.setSolde(0.0);
			carteDaoJpa.persist(carte);

		}
		
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_PERSONNALISER_ADHERENT)) {

			CycleVie cycleVie = new CycleVie();
			Adherent subjet = (Adherent) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setOperateur(subjet.getMatr());
			cycleVie.setNumSerie((subjet.getId() * 43) + "");
			cycleVie.setOperation("Fabrication");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
		}

		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_VALIDATE_ADHERENT_OPP)) {

			
			CycleVie cycleVie = new CycleVie();
			Adherent subjet = (Adherent) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setOperateur(subjet.getMatr());
			cycleVie.setNumSerie(subjet.getNumCarte());
			cycleVie.setOperation("Refabrication");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
			
			Carte carte = new Carte();
			
			carte.setNumSerie((subjet.getId() * 43) + "");
			carte.setOperation("Refabrication");
			carte.setNumeroCarte(subjet.getNumCarte());
			carte.setOperateur(subjet.getMatr());
			carte.setStatut(EntityStatus.ENABLED);
			carteDaoJpa.persist(carte);			
			
			
		}		
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_METTRE_ADHERENT_OPP)) {

			
			CycleVie cycleVie = new CycleVie();
			Adherent subjet = (Adherent) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setOperateur(subjet.getMatr());
			cycleVie.setNumSerie(subjet.getNumCarte());
			cycleVie.setOperation("Opposition");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
			
			Carte carte = new Carte();

			carte.setNumSerie((subjet.getId() * 43) + "");
			carte.setOperation("Opposition");
			carte.setNumeroCarte(subjet.getNumCarte());
			carte.setOperateur(subjet.getMatr());
			carte.setStatut(EntityStatus.ENABLED);
			carteDaoJpa.persist(carte);
			
			
		}		
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_CARTE_ADH_MAIN_LEVEE)) {

			
			CycleVie cycleVie = new CycleVie();
			Adherent subjet = (Adherent) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setOperateur(subjet.getMatr());
			cycleVie.setNumSerie(subjet.getNumCarte());
			cycleVie.setOperation("Main levee");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
			
			Carte carte = new Carte();

			carte.setNumSerie((subjet.getId() * 43) + "");
			carte.setOperation("Main levee");
			carte.setNumeroCarte(subjet.getNumCarte());
			carte.setOperateur(subjet.getMatr());
			carte.setStatut(EntityStatus.ENABLED);
			carteDaoJpa.persist(carte);
			
			
		}	
		
		return null;
	}

}
