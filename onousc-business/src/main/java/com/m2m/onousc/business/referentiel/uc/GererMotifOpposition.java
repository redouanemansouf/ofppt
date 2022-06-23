package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.MotifOppositionBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;

@Service("REFERENTIEL_GererMotifOpposition_UC")
public class GererMotifOpposition extends UseCaseController{

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new MotifOppositionBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		// TODO Auto-generated method stub
		return null;
	}

}
