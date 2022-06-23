package com.m2m.technicalservices.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public void initialize(Email email) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || value.matches(EMAIL_PATTERN);
	}
}