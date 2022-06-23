/*
 * LongConverter.java
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
 * The Class IdConverter.
 * 
 * @version 1.0 11 mars 2015
 * @author amtarji
 */
@FacesConverter("longConverter")
public class LongConverter implements Converter {

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
				return Long.parseLong(value);
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur de conversion",
						"Id n'est pas valide"));
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
