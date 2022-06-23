/*
 * AdministrationSrvPresentationImpl.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.web.administration.UserEntitySrvPresentation;

/**
 * The Class AdministrationSrvPresentationImpl. 
 * 	
 * @version 1.0 9 oct. 2015
 * @author iissouani
 */
@Service("winMenuSrvPresentation") 
@Transactional(readOnly = true) 
public class WinMenuSrvPresentationImpl implements
			UserEntitySrvPresentation, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7634666256645513198L;

	/** The reservation service. */
	@Autowired 
	private ReferentielService referentielService;


}
