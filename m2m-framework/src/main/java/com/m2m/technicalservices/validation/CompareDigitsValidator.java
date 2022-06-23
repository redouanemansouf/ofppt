package com.m2m.technicalservices.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.m2m.technicalservices.validation.CompareDigits.DigitType;
import com.m2m.technicalservices.validation.CompareDigits.Operation;

public class CompareDigitsValidator implements
		ConstraintValidator<CompareDigits, Object> {

	private String firstFieldName;
	private String secondFieldName;
	private DigitType digitType;
	private Operation operation;

	@Override
	public void initialize(CompareDigits constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		digitType = constraintAnnotation.digitsType();
		operation = constraintAnnotation.operation();

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {

			boolean result = false;
			int compareResult = 0;
			final String firstObj = BeanUtils
					.getProperty(value, firstFieldName);
			final String secondObj = BeanUtils.getProperty(value,
					secondFieldName);

			if (firstObj == null && secondObj == null) {
				return true;
			}

			compareResult = compare(firstObj, secondObj);

			switch (operation) {
			case EQUALS:
				result = compareResult == 0;
				break;

			case GREATER_THAN:
				result = compareResult > 0;
				break;

			case LOWER_THAN:
				result = compareResult < 0;
				break;
			}

			return result;

		} catch (final Exception ignore) {
			return false;
		}
	}

	private int compare(final String firstObj, final String secondObj) {
		int compareResult = 0;
		if (digitType.equals(DigitType.DOUBLE)) {
			Double d1 = Double.parseDouble(firstObj);
			Double d2 = Double.parseDouble(secondObj);
			compareResult = Double.compare(d1, d2);

		} else if (digitType.equals(DigitType.LONG)) {
			Long d1 = Long.parseLong(firstObj);
			Long d2 = Long.parseLong(secondObj);
			compareResult = Long.compare(d1, d2);
		} else if (digitType.equals(DigitType.INT)) {
			Integer d1 = Integer.parseInt(firstObj);
			Integer d2 = Integer.parseInt(secondObj);
			compareResult = Integer.compare(d1, d2);
		}
		return compareResult;
	}

}
