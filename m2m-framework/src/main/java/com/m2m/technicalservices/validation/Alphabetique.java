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
 * Annotation pour verifier si le champ est un mot sans caractére spécial 
 * @author yaalou
 *
 */
@Documented
@Constraint(validatedBy = AlphabetiqueValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Alphabetique {

	String message() default "{custom.validation.constraints.Alphabetique.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
