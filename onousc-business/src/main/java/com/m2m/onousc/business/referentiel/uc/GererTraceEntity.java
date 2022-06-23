/*
* GererTraceEntity.java
*
* Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.onousc.business.referentiel.uc;

import org.springframework.stereotype.Service;

import com.m2m.technicalservices.core.IBusinessRuleManager;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.UseCaseController;



/**
 * The Class GererTraceEntity.
 *
 * @version 1.0 24 nov. 2014
 * @author iissouani
 */
@Service("ADMINISTRATION_GererTraceEntity_UC")
public class GererTraceEntity extends UseCaseController {

	
	@Override
	protected IBusinessRuleManager getBusinessRuleManager() {
		return  null;
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalServices.core.UseCaseController#business()
	 */
	@Override
	protected ProcessResult business() {
		return null;
	}
}  
