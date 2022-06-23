package com.m2m.technicalservices.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * verifie si une chaine de caractère est ne contient que des chiffre
 * 
 * @author aelhachimi
 * 
 */
@Documented
@Constraint(validatedBy = NumberValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Number {

	NumType type() default NumType.INT;

	String message() default "{custom.validation.constraints.Number.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	enum NumType {
		INT, DOUBLE, LONG;
	}
}
