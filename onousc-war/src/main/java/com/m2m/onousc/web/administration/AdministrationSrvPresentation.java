/*
 * AdministrationSrvPresentation.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.administration;

import java.util.List;

import com.m2m.onousc.business.referentiel.criteria.GroupUserCriteria;
import com.m2m.onousc.business.referentiel.vo.GroupUserVO;



/**
 * The Interface ReservationSrvPresentation.
 */
/**
 * @author iissouani
 *
 */
public interface AdministrationSrvPresentation {

List<GroupUserVO> findGroupByCriteria(GroupUserCriteria criteria);
List<GroupUserVO> findOnlyGroupByCriteria(GroupUserCriteria criteria);
List<GroupUserVO> findGroupBycode(String groupeName);
	
}
