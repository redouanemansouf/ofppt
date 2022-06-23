package com.m2m.technicalservices.core;

import java.io.Serializable;

import javax.faces.application.FacesMessage.Severity;

public class ProcessMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8517713345874278871L;

	/**
	 * Clé du Message
	 */
	private String key;

	/**
	 * L'information du message (paramétres à passer au message)
	 */
	private String[] infos;

	private boolean keyIsMessage;

	/**
	 * Le type du message
	 */
	protected int typeMessage = Constantes.TYPE_MESSAGE_ERREUR;

	/**
	 * severity pour faces message
	 */
	private Severity severity;

	/**
	 * Constructeur
	 * 
	 * @param cle
	 */
	public ProcessMsg(String cle) {
		this.key = cle;
	}

	public ProcessMsg(String cle, boolean keyIsMessage) {
		this.key = cle;
		this.keyIsMessage = keyIsMessage;

	}

	/**
	 * Constructeur
	 * 
	 * @param cle
	 * @param inf
	 */
	public ProcessMsg(String cle, String[] infos) {
		this.key = cle;
		this.infos = infos;
	}

	/**
	 * Constructeur pour message JSF #amtarji
	 * 
	 * @param key
	 * @param severity
	 * @param jsfMessage
	 */

	public ProcessMsg(String key, Severity severity) {
		super();
		this.key = key;
		this.severity = severity;
	}

	/**
	 * Constructeur #amtarji
	 * 
	 * @param key
	 *            key in businessMessages
	 * @param infos
	 *            paramétres à passer au message
	 * @param typeMessage
	 * @param severity
	 */
	public ProcessMsg(String key, String[] infos, int typeMessage,
			Severity severity) {
		super();
		this.key = key;
		this.infos = infos;
		this.typeMessage = typeMessage;
		this.severity = severity;
	}

	/**
	 * 
	 * @param key
	 * @param infos
	 * @param severity
	 */
	public ProcessMsg(String key, String[] infos, Severity severity) {
		super();
		this.key = key;
		this.infos = infos;
		this.severity = severity;
	}

	/**
	 * constructeur keyismessage
	 * 
	 * @param key
	 * @param keyIsMessage
	 * @param severity
	 */
	public ProcessMsg(String key, Severity severity, boolean keyIsMessage) {
		super();
		this.key = key;
		this.keyIsMessage = keyIsMessage;
		this.severity = severity;
	}

	/*
	 * amtarji
	 * Constructeur pour le validateur
	 */
	public ProcessMsg(String key, boolean keyIsMessage, int typeMessage,
			Severity severity) {
		super();
		this.key = key;
		this.keyIsMessage = keyIsMessage;
		this.typeMessage = typeMessage;
		this.severity = severity;
	}

	/**
	 * @return key
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * @return infos
	 */
	public String[] getInfos() {
		return infos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = "MsgInfo KEY: " + key;
		return str;
	}

	/**
	 * @return typeMessage
	 */
	public int getTypeMessage() {
		return typeMessage;
	}

	public boolean isKeyIsMessage() {
		return keyIsMessage;
	}

	public void setKeyIsMessage(boolean keyIsMessage) {
		this.keyIsMessage = keyIsMessage;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setInfos(String[] infos) {
		this.infos = infos;
	}

	public void setTypeMessage(int typeMessage) {
		this.typeMessage = typeMessage;
	}

	/**
	 * 
	 * @return facesContext severity type
	 */
	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

}
