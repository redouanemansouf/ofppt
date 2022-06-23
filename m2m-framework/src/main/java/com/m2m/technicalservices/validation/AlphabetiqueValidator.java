package com.m2m.technicalservices.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphabetiqueValidator implements ConstraintValidator<Alphabetique, String> {

	@Override
	public void initialize(Alphabetique Alphabetique) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || value.matches("[\\p{L}_  ]*");
	}
}