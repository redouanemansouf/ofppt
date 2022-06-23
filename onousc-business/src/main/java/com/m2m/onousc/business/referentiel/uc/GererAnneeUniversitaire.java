package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.AnneeUniversitaireBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;

@Service("REFERENTIEL_GererAnneeUniversitaire_UC")
public class GererAnneeUniversitaire extends UseCaseController{

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new AnneeUniversitaireBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		// TODO Auto-generated method stub
		return null;
	}

}
