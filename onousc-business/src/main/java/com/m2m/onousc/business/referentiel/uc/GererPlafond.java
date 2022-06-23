package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.PlafondBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;

@Service("REFERENTIEL_GererPlafond_UC")
public class GererPlafond extends UseCaseController{

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new PlafondBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		// TODO Auto-generated method stub
		return null;
	}

}
