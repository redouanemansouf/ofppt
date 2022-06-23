package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.UniversiteBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;


/**
 * 
 * @author abousnane
 *
 */
@Service("REFERENTIEL_GererUniversite_UC")
public class GererUniversite extends UseCaseController{

	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new UniversiteBusinessRuleManager();
	}

	@Override
	protected ProcessResult business() {
		// TODO Auto-generated method stub
		return null;
	}

}
