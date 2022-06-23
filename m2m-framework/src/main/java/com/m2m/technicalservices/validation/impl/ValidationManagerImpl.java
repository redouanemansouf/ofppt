package com.m2m.technicalservices.validation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.m2m.technicalservices.validation.CustomTraversableResolver;
import com.m2m.technicalservices.validation.ValidationError;
import com.m2m.technicalservices.validation.ValidationManager;

/**
 * service de validation basé sur les annotations JSR303
 * 
 * @author souteh
 * 
 */
@Component("validationManager")
public class ValidationManagerImpl<T> implements ValidationManager<T> {

	private Validator validator;

	public List<ValidationError> validate(T bean,Class<?>[] groups) {
		/**
		 * @author amtarji Ajout d'un CustomTraversableResolver pour fixer
		 *         l'interaction entre Hibernate validation et JPA 2.0
		 */
		Configuration<?> configuration = Validation.byDefaultProvider()
				.configure();
		ValidatorFactory factory = configuration.traversableResolver(
				new CustomTraversableResolver()).buildValidatorFactory();
		validator = factory.getValidator();
		List<ValidationError> errors = new ArrayList<ValidationError>();

		Set<ConstraintViolation<T>> violations = validator.validate(bean,groups);

		for (ConstraintViolation constraintViolation : violations) {
			ValidationError error = new ValidationError(constraintViolation
					.getPropertyPath().toString(), constraintViolation
					.getPropertyPath().toString(),
					constraintViolation.getMessage());
			errors.add(error);
		}
		return errors;
	}

}
