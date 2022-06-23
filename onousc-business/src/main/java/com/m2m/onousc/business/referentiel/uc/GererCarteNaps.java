package com.m2m.onousc.business.referentiel.uc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.dao.CarteDaoJpa;
import com.m2m.onousc.business.referentiel.dao.PersonnelDaoJpa;
import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.rule.CaissierBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.CarteNapsBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;
import com.m2m.technicalservices.core.UserContext;

@Service("REFERENTIEL_gererCarteNaps_UC")
public class GererCarteNaps extends UseCaseController {
	
	@Autowired
	PersonnelDaoJpa personnelDaoJpa;

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new CarteNapsBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
//		if (UserContext.getClientParameters().getSousCommand()
//				.equals(Constantes.SOUS_COMMAND_MODIFIER_CARTENAPS)) {
//			Personnel perso = new Personnel();
//			CarteNaps subjet = (CarteNaps) UserContext.getSubject();
//			perso.setNom(subjet.getNom());
//			perso.setPrenom(subjet.getPrenom());
//			perso.setNumidentite(subjet.getNumidentite());
//			perso.setTelephone(subjet.getTel());
//			perso.setEtab(subjet.getEtab());
//			perso.setMatr(subjet.getMatr());
//			perso.setNumCarte(subjet.getNumcarte());
//			
//			personnelDaoJpa.persist(perso);
//
//		}
		return null;
	}

}
