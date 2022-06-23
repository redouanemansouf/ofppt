/*
* GererCanalVente.java
*
* Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.AdherentBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.CanalVenteBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.ProduitBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;

/**
 * The Class GererCanalVente.
 *
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Service("REFERENTIEL_GererEvenement_UC")
public class GererEvenement extends UseCaseController {

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new ProduitBusinessRuleManager();
	}

	
	@Override
	protected ProcessResult business() {
	
		return null;
	}

}
