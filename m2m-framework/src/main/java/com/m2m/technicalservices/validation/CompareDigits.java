package com.m2m.technicalservices.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CompareDigitsValidator.class)
@Documented
public @interface CompareDigits {
	String message() default "{custom.validation.constraints.compareDigits.lowerThan}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return The first field
	 */
	String first();

	/**
	 * @return The second field
	 */
	String second();

	Operation operation() default Operation.LOWER_THAN;

	DigitType digitsType() default DigitType.DOUBLE;

	enum DigitType {
		INT, DOUBLE, LONG;
	}

	enum Operation {
		EQUALS, GREATER_THAN, LOWER_THAN;
	}
}
