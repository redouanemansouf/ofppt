package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.MonitoringBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;

@Service("REFERENTIEL_GererMonitoringEchange_UC")
public class GererMonitoringEchange  extends UseCaseController{

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new MonitoringBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		return null;
	}

}
