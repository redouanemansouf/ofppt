/*
 * BooleanRadioConverter.java
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

import com.m2m.onousc.business.common.BooleanRadio;

/**
 * La Class BooleanRadioConverter.
 * 
 * @version 1.0 13 mars 2015
 * @author amtarji
 */
@FacesConverter("booleanRadioConverter")
public class BooleanRadioConverter implements Converter {

	/** Le/La oui. */
	private static String OUI = "OUI";

	/** Le/La non. */
	private static String NON = "NON";

	/** Le/La tous. */
	private static String TOUS = "TOUS";

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
				return buildBooleanRadio(value.trim());
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur de conversion",
						"TrisStateCheckbox n'est pas valide"));
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
		return value == null ? null : ((BooleanRadio) value).getCode();

	}

	/**
	 * Builds the boolean radio.
	 * 
	 * @param code
	 *            the code
	 * @return the boolean radio
	 */
	private BooleanRadio buildBooleanRadio(String code) {
		if (OUI.equals(code)) {
			return new BooleanRadio(true, OUI, OUI);
		} else if (NON.equals(code)) {
			return new BooleanRadio(false, NON, NON);
		} else {
			return new BooleanRadio(null, TOUS, TOUS);
		}
	}
}
