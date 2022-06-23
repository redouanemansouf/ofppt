/*
 * AdministrationSrvPresentationImpl.java
 *
 * Copyright (c) 1990-2017 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria;
import com.m2m.onousc.business.referentiel.service.AdministrationService;
import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.onousc.business.referentiel.vo.transformer.GroupUserVOTransformer;
import com.m2m.onousc.web.administration.AdministrationSrvPresentation;

/**
 * The Class AdministrationSrvPresentationImpl.
 * 
 * @version 1.0 9 oct. 2015
 * @author iissouani
 */
@Service("administrationSrvPresentationGRP")
public class AdministrationSrvPresentationImpl implements
		AdministrationSrvPresentation, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7634666256645513198L;

	/** The reservation service. */
	@Autowired
	private AdministrationService administrationService;

	@Override
	public List<GroupUserVO> findGroupByCriteria(GroupUserCriteria criteria) {

		return new GroupUserVOTransformer().model2VO(administrationService
				.findGroupByCriteria(criteria));
	
	}

	@Override
	public List<GroupUserVO> findOnlyGroupByCriteria(GroupUserCriteria criteria) {
		return new GroupUserVOTransformer().model2VO(administrationService
				.findOnlyGroupByCriteria(criteria));
	}

	@Override
	public List<GroupUserVO> findGroupBycode(String groupeName) {
		return new GroupUserVOTransformer().model2VO(administrationService
				.findGroupByCode(groupeName));
	}

	
	

}
