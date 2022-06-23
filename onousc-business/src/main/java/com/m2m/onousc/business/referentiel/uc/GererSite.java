package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.SiteBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;

@Service("REFERENTIEL_GererSite_UC")
public class GererSite extends UseCaseController {

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new SiteBusinessRuleManager();
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {
		// TODO Auto-generated method stub
		return null;
	}

}
