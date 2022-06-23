package com.m2m.technicalservices.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphaNumValidator implements ConstraintValidator<AlphaNum, String> {

	@Override
	public void initialize(AlphaNum Alphanum) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || value.matches("[\\p{L}0-9_  ']*");
	}
}