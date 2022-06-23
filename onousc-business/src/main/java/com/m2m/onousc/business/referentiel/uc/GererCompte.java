/*
 * GererNationalite.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.CompteBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;



// TODO: Auto-generated Javadoc
/**
 * The Class GererNationalite.
 * 
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
@Service("REFERENTIEL_GererCompte_UC")
public class GererCompte extends UseCaseController {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.technicalServices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new CompteBusinessRuleManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalServices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {
		// TODO Auto-generated method stub
		return null;
	}

}
