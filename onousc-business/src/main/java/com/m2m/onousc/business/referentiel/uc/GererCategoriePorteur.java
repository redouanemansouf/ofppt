package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.CategoriePorteurBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;

@Service("REFERENTIEL_GererCategoriePorteur_UC")
public class GererCategoriePorteur extends UseCaseController{

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new CategoriePorteurBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		// TODO Auto-generated method stub
		return null;
	}

}
