package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.CaissierBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.CarteNapsBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.ProfilPorteurBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;

@Service("REFERENTIEL_GererProfilPorteur_UC")
public class GererProfilPorteur extends UseCaseController {

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new ProfilPorteurBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		// TODO Auto-generated method stub
		return null;
	}

}
