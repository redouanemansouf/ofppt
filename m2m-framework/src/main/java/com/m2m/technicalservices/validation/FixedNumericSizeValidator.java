package com.m2m.technicalservices.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FixedNumericSizeValidator implements
		ConstraintValidator<FixedNumeric, String> {

	int size;

	@Override
	public void initialize(FixedNumeric FixedNumeric) {
		this.size = FixedNumeric.size();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0) {
			return true;
		}
		return value.length() == size;
	}
}