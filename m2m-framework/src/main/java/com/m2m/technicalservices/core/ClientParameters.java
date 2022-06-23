package com.m2m.technicalservices.core;

import java.util.List;

/**
 * Classe qui regroupe l'ensemble des paramètres d'un UC
 * 
 * @author Younes SOUTEH
 * 
 */
public class ClientParameters {

	private String domaine;
	private String command;
	private String sousCommand;
	private String subCommand;
	private User user;
	private ValueObject vo;
	/**
	 * @author amtarji ajout d'une list vos en cas de use case sur plusieur
	 *         objet
	 */
	private List<ValueObject> vos;
	/*
	 * boolean pour indiquer a la facade s'il faut prendre le vo oubien la list
	 * des vo
	 */
	private boolean onCollection;

	public String getSubCommand() {
		return subCommand;
	}

	public void setSubCommand(String subCommand) {
		this.subCommand = subCommand;
	}

	public ClientParameters() {
	}

	public ClientParameters(String domaine, String command, User user,
			ValueObject vo) {
		super();
		this.domaine = domaine;
		this.command = command;
		this.user = user;
		this.vo = vo;
	}

	public ClientParameters(String domaine, String command, String sousCommand,
			User user, ValueObject vo) {
		super();
		this.domaine = domaine;
		this.command = command;
		this.sousCommand = sousCommand;
		this.user = user;
		this.vo = vo;
	}

	/**
	 * @author amtarji Overload du constructeur pour prendre en consideration
	 *         une list de vo
	 */
	public ClientParameters(String domaine, String command, User user,
			List<ValueObject> vos) {
		super();
		this.domaine = domaine;
		this.command = command;
		this.user = user;
		this.vos = vos;
		this.onCollection = true;
	}

	/**
	 * @author amtarji Overload du constructeur pour prendre en consideration
	 *         une list de vo
	 */
	public ClientParameters(String domaine, String command, String sousCommand,
			User user, List<ValueObject> vos) {
		super();
		this.domaine = domaine;
		this.command = command;
		this.sousCommand = sousCommand;
		this.user = user;
		this.vos = vos;
		this.onCollection = true;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ValueObject getVo() {
		return vo;
	}

	public void setVo(ValueObject vo) {
		this.vo = vo;
	}

	public String getSousCommand() {
		return sousCommand;
	}

	public void setSousCommand(String sousCommand) {
		this.sousCommand = sousCommand;
	}

	public List<ValueObject> getVos() {
		return vos;
	}

	public void setVos(List<ValueObject> vos) {
		this.vos = vos;
	}

	public boolean isOnCollection() {
		return onCollection;
	}

	public void setOnCollection(boolean onCollection) {
		this.onCollection = onCollection;
	}

}
