package com.m2m.technicalservices.core;

import java.util.List;

public interface IVOValidator {
	ProcessResult validate(ValueObject vo,Class<?>[] groups);

	/**
	 * @author amtarji: cas de plusieur VO
	 * @param vos
	 * @return
	 */
	ProcessResult validate(List<ValueObject> vos,Class<?>[] groups);
}
