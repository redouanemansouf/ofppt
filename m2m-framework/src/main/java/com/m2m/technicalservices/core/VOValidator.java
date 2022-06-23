package com.m2m.technicalservices.core;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.springframework.stereotype.Component;

import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.validation.ValidationError;
import com.m2m.technicalservices.validation.ValidationManager;

@Component("VOValidator")
public class VOValidator implements IVOValidator {
	/**
	 * Ajout du support des gorupes qui seront valider
	 * 
	 * @author amtarji
	 */
	@SuppressWarnings("unchecked")
	public ProcessResult validate(ValueObject vo, Class<?>[] groups) {
		ProcessResult processResult = new ProcessResult();
		ValidationManager<ValueObject> validationManager = (ValidationManager<ValueObject>) BeansLookuper
				.lookup("validationManager");
		List<ValidationError> listValidationError = validationManager.validate(
				vo, groups);
		for (ValidationError validationError : listValidationError) {

			String message =validationError.getChamp() +"==>"+ validationError.getMessage();
			processResult
					.addMessage(new ProcessMsg(message, true,
							Constantes.TYPE_MESSAGE_ERREUR,
							FacesMessage.SEVERITY_ERROR));

		}
		return processResult;
	}

	/**
	 * List Vos + Ajout du support des groupes qui seront valider
	 * 
	 * @author amtarji
	 * @param vos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ProcessResult validate(List<ValueObject> vos, Class<?>[] groups) {
		ProcessResult processResult = new ProcessResult();
		ValidationManager<ValueObject> validationManager = (ValidationManager<ValueObject>) BeansLookuper
				.lookup("validationManager");
		List<ValidationError> listValidationError = new ArrayList<ValidationError>();

		for (ValueObject vo : vos) {
			listValidationError = validationManager.validate(vo, groups);
			for (ValidationError validationError : listValidationError) {

				String message = validationError.getMessage();
				processResult.addMessage(new ProcessMsg(message, true,
						Constantes.TYPE_MESSAGE_ERREUR,
						FacesMessage.SEVERITY_ERROR));

			}
		}
		return processResult;
	}
}
