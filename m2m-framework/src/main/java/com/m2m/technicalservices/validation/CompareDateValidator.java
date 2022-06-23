package com.m2m.technicalservices.validation;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.m2m.technicalservices.tools.ConvertUtil;
import com.m2m.technicalservices.validation.CompareDate.Tense;

public class CompareDateValidator implements
		ConstraintValidator<CompareDate, Object> {
	private String firstFieldName;
	private String secondFieldName;
	private Tense tense;

	@Override
	public void initialize(final CompareDate constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		tense = constraintAnnotation.tense();
	}

	@Override
	public boolean isValid(final Object value,
			final ConstraintValidatorContext context) {

		try {

			boolean result = false;
			final String firstObj = BeanUtils
					.getProperty(value, firstFieldName);
			final String secondObj = BeanUtils.getProperty(value,
					secondFieldName);
			Date date1 = ConvertUtil.defaultENGStringToDate(firstObj);
			Date date2 = ConvertUtil.defaultENGStringToDate(secondObj);
			if (tense.equals(Tense.EQUALS)) {
				result = date1.equals(date2);
			}
			if (tense.equals(Tense.AFTER)) {
				result = date1.after(date2);
			}
			if (tense.equals(Tense.BEFORE)) {
				result = date1.before(date2);
			}
			if (tense.equals(Tense.EQUALS_OR_AFTER)) {
				result = date1.equals(date2) || date1.after(date2);
			}
			if (tense.equals(Tense.EQUALS_OR_BEFORE)) {
				result = date1.equals(date2) || date1.before(date2);
			}
			return result;
		} catch (final Exception ignore) {
			return false;
		}
	}
}