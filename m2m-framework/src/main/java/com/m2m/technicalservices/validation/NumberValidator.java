package com.m2m.technicalservices.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.m2m.technicalservices.validation.Number.NumType;

public class NumberValidator implements ConstraintValidator<Number, String> {
	NumType type;

	@Override
	public void initialize(Number number) {
		this.type = number.type();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
			return true;
		} else if (type.equals(NumType.INT)) {
			try {
				Integer.parseInt(value);
			} catch (NumberFormatException e) {
				return false;
			}
		} else if (type.equals(NumType.DOUBLE)) {
			try {
				Double.parseDouble(value);
			} catch (NumberFormatException e) {
				return false;
			}
		} else if (type.equals(NumType.LONG)) {
			try {
				Long.parseLong(value);
			} catch (NumberFormatException e) {
				return false;
			}
		}

		return true;
	}
}