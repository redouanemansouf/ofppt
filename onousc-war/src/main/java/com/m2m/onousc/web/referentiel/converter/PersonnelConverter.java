/*
 * TypeOperationConverter.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;

// TODO: Auto-generated Javadoc
/**
 * The Class TypeOperationConverter.
 *
 * @version 1.0 24 févr. 2015
 * @author msadik
 */
@FacesConverter("personnelConverter")
public class PersonnelConverter implements Converter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.
	 * FacesContext , javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				ReferentielSrvPresentation servicePres = (ReferentielSrvPresentation) BeansLookuper
						.lookup("referentielSrvPresentation");
				return servicePres.findPersonnel(Long.parseLong(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur de conversion",
						"Veuillez choisir un personnel "));
			}
		} else {
			return null;
		}
	}


	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((PersonnelVO) value).getId());
		} else {
			return null;
		}
	}

}
