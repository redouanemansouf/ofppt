package com.m2m.technicalservices.core;

import java.util.Collection;
import java.util.List;

import com.m2m.technicalservices.spring.BeansLookuper;

public class ValidatorImpl implements IValidator {

	public ProcessResult doValidationSimple() {
		/**
		 * @author amtarji: cas d'un vo ou plusieur
		 */
		IVOValidator voValidator = (IVOValidator) BeansLookuper
				.lookup("VOValidator");
	
		Object subject = UserContext.getSubject();
		/*
		 * Ajout des groupes qui seront pris en consideration par le validateur
		 */
		Class<?>[] groups = (Class<?>[]) UserContext.getValidationGroups();
		if (subject instanceof Collection) {
			@SuppressWarnings("unchecked")
			List<ValueObject> vos = (List<ValueObject>) subject;
			return voValidator.validate(vos, groups);
		} else {
			ValueObject vo = (ValueObject) subject;

			return voValidator.validate(vo, groups);
		}

	}
}
