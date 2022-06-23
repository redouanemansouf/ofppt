package com.m2m.technicalservices.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FixedSizeValidator implements
		ConstraintValidator<FixedSize, String> {

	int size;

	@Override
	public void initialize(FixedSize fixedSize) {
		this.size = fixedSize.size();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0) {
			return true;
		}
		return value.length() == size;
	}
}