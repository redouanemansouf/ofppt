/*
* GererCanalVente.java
*
* Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.onousc.business.referentiel.rule.AdherentBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.CanalVenteBusinessRuleManager;
import com.m2m.onousc.business.referentiel.rule.DetailProfilBusinessRuleManager;
import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;

/**
 * The Class GererCanalVente.
 *
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
@Service("REFERENTIEL_GererDetailProfil_UC")
public class GererDetailProfil extends UseCaseController {

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.core.UseCaseController#getBusinessRuleManager()
	 */
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return new DetailProfilBusinessRuleManager();
	}

	
	@Override
	protected ProcessResult business() {
		// TODO Auto-generated method stub
		return null;
	}

}
