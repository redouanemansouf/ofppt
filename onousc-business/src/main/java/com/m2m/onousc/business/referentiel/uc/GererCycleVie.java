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
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CycleVieDaoJpa;
import com.m2m.onousc.business.referentiel.dao.DelivranceDaoJpa;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.DelivranceCarte;
import com.m2m.onousc.business.referentiel.rule.CanalVenteBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.CycleVieBusinessRuleManager;
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
@Service("REFERENTIEL_GererCycleVie_UC")
public class GererCycleVie extends UseCaseController {

	@Autowired
	private CycleVieDaoJpa cycleVieDaoJpa;

	@Autowired
	private DelivranceDaoJpa delivdao;
	
	@Autowired
	private CarteDaoJpa carteDaoJpa;
	


	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
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
/*
		if (UserContext.getClientParameters().getSousCommand()
				.equals("delivrerCycleVie")) {
			DelivranceCarte deliv = new DelivranceCarte();
			CycleVie subjet = (CycleVie) UserContext.getSubject();
			deliv.setDateDelivrance(new Date());
			
			deliv.setEtudiant(subjet.getNumPorteur());
			deliv.setStatut(EntityStatus.ENABLED);
			deliv.setCategorie("E");
			delivdao.persist(deliv);
		}
		if (UserContext.getClientParameters().getSousCommand()
				.equals("delivrerCycleVie")) {
			CycleVie cycle = new CycleVie();
			CycleVie sub = (CycleVie) UserContext.getSubject();
			cycle.setDateOperation(new Date());
			cycle.setNumPorteur(sub.getNumPorteur());
			cycle.setNumSerie(sub.getNumSerie());
			cycle.setOperation("Distribution");
			cycle.setOperateur(sub.getOperateur());
			cycle.setStatut(EntityStatus.DILVRED);

			cycleVieDaoJpa.persist(cycle);

		}
		if (UserContext.getClientParameters().getSousCommand()
				.equals("metterEnOpposition")) {
			CycleVie cycle = new CycleVie();
			CycleVie sub = (CycleVie) UserContext.getSubject();
			cycle.setDateOperation(new Date());
			cycle.setNumPorteur(sub.getNumPorteur());
			cycle.setNumSerie(sub.getNumSerie());
			cycle.setOperateur(sub.getOperateur());
			cycle.setOperation("Mise en opposition /"+sub.getOperation());
			cycle.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycle);

		}
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals("delivrerCycleVie")) {
			Carte carte = new Carte();
			CycleVie subjet = (CycleVie) UserContext.getSubject();
		carte=referentielService.findCarteByEtud(subjet.getNumPorteur().getId());
			carte.setStatut(EntityStatus.DILVRED);
			carteDaoJpa.modifierCarte(carte);
			
		}
		*/
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals("delivrerCycleVie")) {
			DelivranceCarte deliv = new DelivranceCarte();
			Carte subjet = (Carte) UserContext.getSubject();
			deliv.setDateDelivrance(new Date());
			deliv.setEtudiant(subjet.getNumPorteur());
			deliv.setStatut(EntityStatus.ENABLED);
			deliv.setCategorie("E");
			delivdao.persist(deliv);
		}
		if (UserContext.getClientParameters().getSousCommand()
				.equals("delivrerCycleVie")) {
			CycleVie cycle = new CycleVie();
			Carte sub = (Carte) UserContext.getSubject();
			cycle.setDateOperation(new Date());
			cycle.setNumPorteur(sub.getNumPorteur());
			cycle.setNumSerie(sub.getNumSerie());
			cycle.setOperation("Distribution");
			cycle.setOperateur(sub.getNumeroCarte());
			cycle.setStatut(EntityStatus.DELIVRED);

			cycleVieDaoJpa.persist(cycle);

		}
		
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals("delivrerCycleVie")) {
			//CycleVie cycle = new CycleVie();
			Carte sub = (Carte) UserContext.getSubject();
			sub.setOperation("DELIVRANCE");
			cycleVieDaoJpa.getEm().merge(sub);

		}
		if (UserContext.getClientParameters().getSousCommand()
				.equals("metterEnOpposition")) {
			CycleVie cycle = new CycleVie();
			CycleVie sub = (CycleVie) UserContext.getSubject();
			cycle.setDateOperation(new Date());
			cycle.setNumPorteur(sub.getNumPorteur());
			cycle.setNumSerie(sub.getNumSerie());
			cycle.setOperateur(sub.getOperateur());
			cycle.setOperation("Mise en opposition /"+sub.getOperation());
			cycle.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycle);

		}
		
//		if (UserContext.getClientParameters().getSousCommand()
//				.equals("delivrerCycleVie")) {
//			Carte carte = new Carte();
//			CycleVie subjet = (CycleVie) UserContext.getSubject();
//		carte=referentielService.findCarteByEtud(subjet.getNumPorteur().getId());
//			carte.setStatut(EntityStatus.DILVRED);
//			carteDaoJpa.modifierCarte(carte);
//			
//		}
		
		
		return null;

	}
	

}
