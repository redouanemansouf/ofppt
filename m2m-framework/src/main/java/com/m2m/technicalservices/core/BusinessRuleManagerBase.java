package com.m2m.technicalservices.core;

import java.util.List;

import com.m2m.technicalservices.dao.impl.GenericEntity;

public abstract class BusinessRuleManagerBase implements IBusinessRuleManager {
	/**
	 * #amtarji ajout de sousCommand et du subjects
	 */
	protected String sousCommand;
	protected String command;
	protected String domaine;
	protected GenericEntity subject;
	protected List<GenericEntity> subjects;

	@SuppressWarnings("unchecked")
	public BusinessRuleManagerBase() {
		super();
		domaine = UserContext.getClientParameters().getDomaine();
		command = UserContext.getClientParameters().getCommand();
		sousCommand = UserContext.getClientParameters().getSousCommand();

		if (UserContext.getClientParameters().isOnCollection()) {
			subjects = (List<GenericEntity>) UserContext.getSubject();
		} else {
			subject = (GenericEntity) UserContext.getSubject();
		}
	}
}
