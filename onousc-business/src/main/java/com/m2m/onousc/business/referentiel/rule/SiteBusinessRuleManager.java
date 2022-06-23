/*
 * CanalVenteBusinessRuleManager.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.rule;

import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.technicalservices.core.BusinessRuleManagerBase;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public class SiteBusinessRuleManager extends BusinessRuleManagerBase {

	/** The service. */
	ReferentielService referentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	/**
	 * validate business rule.
	 * 
	 * @return the process result
	 */
	@Override
	public ProcessResult doValidation() {
		ProcessResult processResult = new ProcessResult();
		return processResult;
	}

}
