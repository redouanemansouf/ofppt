package com.m2m.onousc.business.referentiel.uc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.CycleVieDaoJpa;
import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.rule.CaissierBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;

@Service("REFERENTIEL_GererCaissier_UC")
public class GererCaissier extends UseCaseController {
	
	@Autowired
	CarteDaoJpa carteDaoJpa;
	
	@Autowired
	CycleVieDaoJpa cycleVieDaoJpa;

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new CaissierBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_PERSONNALISER_CAISSIER)) {
			Carte carte = new Carte();
//			Personnel subjet = (Personnel) UserContext.getSubject();
			Caissier subjet = (Caissier) UserContext.getSubject();
			//carte.setNumPorteur(subjet);
			carte.setNumSerie((subjet.getId() * 43) + "");
			carte.setOperation("Fabrication");
//			carte.setNumeroCarte(147851 + ""
//					+ String.format("%010d", Integer.parseInt(subjet.getMatr())) + "0");
			carte.setNumeroCarte(147851 + ""
					+ String.format("%010d", subjet.getId()));
			carte.setOperateur(subjet.getCode());
		//	carte.setDateExpiration(subjet.getAnneeUniversitaire().getDate_fin());
			carte.setStatut(EntityStatus.ENABLED);
//			carte.setSolde(0.0);
			carteDaoJpa.persist(carte);

		}
		
		
		if (UserContext.getClientParameters().getSousCommand()
				.equals(Constantes.SOUS_COMMAND_PERSONNALISER_CAISSIER)) {

			CycleVie cycleVie = new CycleVie();
			Personnel subjet = (Personnel) UserContext.getSubject();
			cycleVie.setDateOperation(new Date());
			cycleVie.setOperateur(subjet.getMatr());
			cycleVie.setNumSerie((subjet.getId() * 43) + "");
			cycleVie.setOperation("Fabrication");
			cycleVie.setStatut(EntityStatus.ENABLED);
			cycleVieDaoJpa.persist(cycleVie);
			
		}
		
		
		return null;
		
	}

}
