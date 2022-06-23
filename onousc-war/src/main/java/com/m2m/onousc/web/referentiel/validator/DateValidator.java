/*
 * CarnetManuelValidator.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.referentiel.validator;

import java.text.ParseException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;
import com.m2m.technicalservices.tools.DateUtil;
import com.m2m.technicalservices.web.MessageHelper;

/**
 * La Class CarnetManuelValidator.
 * 
 * @version 1.0 3 mars 2015
 * @author aelhachimi
 */
@FacesValidator(value = "dateValidator")
public class DateValidator implements Validator {

	/** Le/La Constant FORMAT_DE_DATE_INCORRECTE. */
	private static final String FORMAT_DE_DATE_INCORRECTE = "Format de date incorrecte";

	/** Le/La Constant LOGGER. */
	private static final ILogger LOGGER = SL4JLogger
			.getInstance(DateValidator.class);

	/** Le/La Constant VALIDATION_ERROR_MESSAGE. */
	private static final String VALIDATION_ERROR_MESSAGE = "dateBebut.inferieur.dateFin";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.validator.Validator#validate(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) {

		UIInput input1 = (UIInput) component.getAttributes().get("dateDebut");
		UIInput input2 = (UIInput) component.getAttributes().get("dateFin");
		// input3 true: pour permetere la validité d'un intervalle constitué
		// d'une seule journé
		String input3 = (String) component.getAttributes().get("ouEgale");

		try {
			Date dateDebut = DateUtil.format(
					(String) input1.getSubmittedValue(), "dd/MM/yy");
			Date dateFin = DateUtil.format((String) input2.getSubmittedValue(),
					"dd/MM/yy");

			boolean equals = "true".equals(input3);

			if (dateDebut.after(dateFin)
					|| (!equals && dateDebut.equals(dateFin))) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								getErrorMessage(), null));

				FacesContext.getCurrentInstance().addMessage(
						input2.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								getErrorMessage(), null));

				throw new ValidatorException(
						new FacesMessage(getErrorMessage()));
			}

		} catch (ParseException e) {
			LOGGER.error(FORMAT_DE_DATE_INCORRECTE, e);
		}

	}

	/**
	 * Recupère le error message.
	 * 
	 * @return le error message
	 */
	private String getErrorMessage() {
		return MessageHelper.getResourceBundleString(VALIDATION_ERROR_MESSAGE,
				null, MessageHelper.BUS_BUNDLE);
	}
}
