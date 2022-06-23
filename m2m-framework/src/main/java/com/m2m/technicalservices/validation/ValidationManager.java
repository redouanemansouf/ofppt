package com.m2m.technicalservices.validation;

import java.util.List;

/**
 * service de validation basé sur les annotations JSR303
 * @author @Younes SOUTEH
 *
 */

public interface ValidationManager<T> {
	List<ValidationError> validate(T bean,Class<?>[] groups);
	
}
