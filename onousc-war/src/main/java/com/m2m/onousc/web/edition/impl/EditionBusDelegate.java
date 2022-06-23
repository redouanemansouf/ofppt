/*
 * ReferentielBusDelegate.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.edition.impl;

import java.util.List;

import javax.validation.groups.Default;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.onousc.web.edition.IEditionBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CanalVenteWebBean;
import com.m2m.onousc.web.reservation.IReservationBusDelegate;
import com.m2m.onousc.web.reservation.webbean.ReservationWebBean;
import com.m2m.technicalservices.core.UserContext;
import com.m2m.technicalservices.web.BaseBusDelegate;

public class EditionBusDelegate extends BaseBusDelegate implements
		IEditionBusDelegate {

	/**
	 * Instantiates a new referentiel bus delegate.
	 */
	public EditionBusDelegate() {

		domaine = "EDITION";
		/*
		 * Toujours initier le groupe de validation
		 */
		Class<?>[] groups = { Default.class };
		UserContext.setValidationGroups(groups);
	}

}
