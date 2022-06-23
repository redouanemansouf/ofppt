/*
 * CompareDate.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.technicalservices.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * La Interface CompareDate.
 * 
 * @author amtarji
 * 
 *         Annotation pour comparer deux date. La comparison est relative à
 *         l'élément 'first'
 * 
 *         Example, pour vérifir que "dateDebut" est avant (BEFORE) "dateFine"
 * @CompareDate(first = "dateDebut", second = "dateFin", tense=Tense.BEFORE)
 */
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CompareDateValidator.class)
@Documented
public @interface CompareDate {

	/**
	 * Message.
	 * 
	 * @return the string
	 */
	String message() default "{custom.validation.constraints.dateCompare.debutFin}";

	/**
	 * Groups.
	 * 
	 * @return the class[]
	 */
	Class<?>[] groups() default {};

	/**
	 * Payload.
	 * 
	 * @return the class<? extends payload>[]
	 */
	Class<? extends Payload>[] payload() default {};

	/**
	 * First.
	 * 
	 * @return The first field
	 */
	String first();

	/**
	 * Second.
	 * 
	 * @return The second field
	 */
	String second();

	/**
	 * Tense.
	 * 
	 * @return the tense
	 */
	Tense tense() default Tense.EQUALS;

	/**
	 * La Enum Tense.
	 * 
	 * @version 1.0 26 févr. 2015
	 * @author aelhachimi
	 */
	enum Tense {

		/** Le/La equals. */
		EQUALS,
		/** Le/La after. */
		AFTER,
		/** Le/La before. */
		BEFORE,
		/** Le/La equals or before. */
		EQUALS_OR_BEFORE,
		/** Le/La equals or after. */
		EQUALS_OR_AFTER;
	}
}