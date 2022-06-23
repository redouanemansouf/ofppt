/*
 * LongConverter.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.commons.converter;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.m2m.technicalservices.tools.ConvertUtil;

@FacesConverter("timeOnlyConverter")
public class TimeOnlyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				String heure = value.substring(0, 2);
				String minute = value.substring(3, 5);

				if (Integer.valueOf(heure) > 24 || Integer.valueOf(minute) > 59) {
					throw new ConverterException(new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Erreur de conversion", "Heure invalide"));
				} else {
					return ConvertUtil.stringToTime(value);
				}
			} catch (Exception e) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur de conversion",
						"Heure invalide"));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			return ConvertUtil.dateToString((Date) value, "HH:mm");
		} else {
			return null;
		}
	}

}
