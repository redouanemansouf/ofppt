/*
 * GroupUserConverter.java
 *
 * Copyright (c) 1990-2017 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.onousc.web.administration.AdministrationSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * The Class GroupUserConverter.
 *
 * @version 1.0 16 mars 2017
 * @author SYSTEM
 */
@FacesConverter("groupUserConverter")
public class GroupUserConverter implements Converter {

	/** The admin service. */
	AdministrationSrvPresentation adminService = (AdministrationSrvPresentation) BeansLookuper
			.lookup("administrationSrvPresentationGRP");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,

	String value) {

		if (value != null && value.trim().length() > 0) {

			List<GroupUserVO> groupUserVO = adminService.findGroupBycode(value);
			if (groupUserVO != null && !groupUserVO.isEmpty()) {
				return groupUserVO.get(0);
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			return ((GroupUserVO) value).getGroupname();
		} else {

			return null;
		}

	}

}
