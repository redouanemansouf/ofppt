package com.m2m.technicalservices.web;

import java.util.Collection;
import java.util.List;

import com.m2m.technicalservices.core.ClientParameters;
import com.m2m.technicalservices.core.FacadeControllerImpl;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.core.User;
import com.m2m.technicalservices.core.ValueObject;

public class BaseBusDelegate {
	protected boolean error;
	protected ProcessResult result;
	protected String domaine;

	@SuppressWarnings("unchecked")
	final protected Object executeCommand(Object data, String command) {
		User user = UserSessionHelper.getUserConecte();
		ClientParameters clientParameters;
		if (data instanceof Collection) {
			List<ValueObject> vos = (List<ValueObject>) data;
			clientParameters = new ClientParameters(domaine, command, user, vos);
		} else {
			ValueObject vo = (ValueObject) data;
			clientParameters = new ClientParameters(domaine, command, user, vo);

		}
		return execute(clientParameters);
	}

	@SuppressWarnings("unchecked")
	final protected Object executeCommand(Object data, String command, String sousCommand) {
		User user = UserSessionHelper.getUserConecte();
//		User user= new User();
		ClientParameters clientParameters;
		if (data instanceof Collection) {
			List<ValueObject> vos = (List<ValueObject>) data;
			clientParameters = new ClientParameters(domaine, command, sousCommand, user, vos);
		} else {
			ValueObject vo = (ValueObject) data;
			clientParameters = new ClientParameters(domaine, command, sousCommand, user, vo);

		}
		return execute(clientParameters);
	}

	private Object execute(ClientParameters clientParameters) {
		error = false;
		Object returnData = null;
		final ProcessResult processResult = (new FacadeControllerImpl(clientParameters)).useCaseProcess();

		if (processResult.isMsgError()) {
			error = true;
			this.result = processResult;
		} else {
			returnData = processResult.getData();
		}
		MessageHelper.processBusinessMesssage(processResult);
		return returnData;
	}

	@SuppressWarnings("unchecked")
	final protected Object executeCommandThreadSeperated(Object data, String command, String sousCommand, User user) {
		// User user = UserSessionHelper.getUserConecte();
		ClientParameters clientParameters;
		if (data instanceof Collection) {
			List<ValueObject> vos = (List<ValueObject>) data;
			clientParameters = new ClientParameters(domaine, command, sousCommand, user, vos);
		} else {
			ValueObject vo = (ValueObject) data;
			clientParameters = new ClientParameters(domaine, command, sousCommand, user, vo);

		}
		return executeCommandThreadSeperated(clientParameters);
	}

	private Object executeCommandThreadSeperated(ClientParameters clientParameters) {
		error = false;
		Object returnData = null;
		final ProcessResult processResult = (new FacadeControllerImpl(clientParameters)).useCaseProcess();

		if (processResult.isMsgError()) {
			error = true;
			this.result = processResult;
		} else {
			returnData = processResult.getData();
		}
		// MessageHelper.processBusinessMesssage(processResult);
		return returnData;
	}

}
