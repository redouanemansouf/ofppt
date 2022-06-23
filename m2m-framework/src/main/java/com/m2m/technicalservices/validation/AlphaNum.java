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
 * Annotation pour verifier si le champ est un mot sans caract�re sp�cial
 * @author amtarji
 *
 */
@Documented
@Constraint(validatedBy = AlphaNumValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AlphaNum {

	String message() default "{custom.validation.constraints.AlphaNum.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
