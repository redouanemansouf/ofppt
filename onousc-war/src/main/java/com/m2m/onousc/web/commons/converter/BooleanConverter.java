/*
 * BooleanConverter.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.commons.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * La Class BooleanConverter.
 * 
 * @version 1.0 13 mars 2015
 * @author aelhachimi
 */
@FacesConverter("booleanConverter")
public class BooleanConverter implements Converter {

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
			try {
				if ("true".equals(value)) {
					return Boolean.TRUE;

				}
				if ("false".equals(value)) {
					return Boolean.FALSE;

				} else {
					return null;
				}
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur de conversion",
						"valeur boolean n'est pas valide"));
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
			return String.valueOf(value);
		} else {
			return null;
		}
	}

}
