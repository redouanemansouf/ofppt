/*
 * WebUtilsMBean.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.web.commons.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.openqa.selenium.browserlaunchers.Sleeper;
import org.springframework.security.core.context.SecurityContextHolder;

import com.m2m.onousc.business.common.ActiviteMetierEnum;
import com.m2m.onousc.business.common.BooleanRadio;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class WebUtilsMBean.
 * 
 * @version 1.0 12 mars 2015
 * @author amtarji
 */
@ManagedBean
@ApplicationScoped
public class WebUtilsMBean extends BaseMBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677883915859481532L;

	/** The tri state radio. */
	private List<BooleanRadio> triStateRadio;

	private List<BooleanRadio> triStateRadioPointPassage;

	/** The entity status user list. */
	private List<EntityStatus> entityStatusUserList;

	/** The entity status user list. */
	private List<ActiviteMetierEnum> activiteMetierList;

	/** The oui. */
	private static String OUI = "OUI";

	/** The non. */
	private static String NON = "NON";

	/** The tous. */
	private static String TOUS = "TOUS";

	private static String AGENCE = "AGENCE";

	private static String POINT_PASSAGE = "POINT_PASSAGE";

	/**
	 * Instantiates a new web utils m bean.
	 */
	public WebUtilsMBean() {
		super();
		setTriStateRadio(new ArrayList<BooleanRadio>());
	}

	/**
	 * On session expire.
	 */
	public void onSessionExpire() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"",
						"Attention Votre session a expiré, veuillez vous authentifier à nouveau."));
		JSFUtils.putSession("userSession", null); 
		SecurityContextHolder.clearContext();      
	}

	/**
	 * Gets the entity status user list.
	 * 
	 * @return the entity status user list
	 */
	public List<EntityStatus> getEntityStatusUserList() {
		List<EntityStatus> list = new ArrayList<EntityStatus>();

		for (EntityStatus status : EntityStatus.values()) {
			if (!EntityStatus.DELETED.equals(status)
					&& !EntityStatus.INCOMPLETE.equals(status)
					&& !EntityStatus.CLOSED.equals(status)
					&& !EntityStatus.SUSPENDED.equals(status)) {
				list.add(status);
			}
		}
		this.entityStatusUserList = list;
		return entityStatusUserList;
	}

	/**
	 * Sets the entity status user list.
	 * 
	 * @param entityStatusUserList
	 *            the new entity status user list
	 */
	public void setEntityStatusUserList(List<EntityStatus> entityStatusUserList) {
		this.entityStatusUserList = entityStatusUserList;
	}

	/**
	 * Gets the tri state radio.
	 * 
	 * @return the tri state radio
	 */
	public List<BooleanRadio> getTriStateRadio() {
		List<BooleanRadio> list = new ArrayList<BooleanRadio>();
		list.add(new BooleanRadio(null, TOUS, TOUS));
		list.add(new BooleanRadio(true, OUI, OUI));
		list.add(new BooleanRadio(false, NON, NON));

		this.triStateRadio = list;
		return triStateRadio;
	}

	/**
	 * Sets the tri state radio.
	 * 
	 * @param triStateRadio
	 *            the new tri state radio
	 */
	public void setTriStateRadio(List<BooleanRadio> triStateRadio) {
		this.triStateRadio = triStateRadio;
	}

	/**
	 * Gets the activite metier list.
	 * 
	 * @return the activite metier list
	 */
	public List<ActiviteMetierEnum> getActiviteMetierList() {
		List<ActiviteMetierEnum> list = new ArrayList<ActiviteMetierEnum>();

		for (ActiviteMetierEnum activiteMetier : ActiviteMetierEnum.values()) {
			list.add(activiteMetier);
		}
		this.activiteMetierList = list;
		return activiteMetierList;
	}

	/**
	 * Sets the activite metier list.
	 * 
	 * @param List
	 *            the new activite metier list
	 */
	public void setActiviteMetierList(List<ActiviteMetierEnum> List) {
		this.activiteMetierList = List;
	}

	public List<BooleanRadio> getTriStateRadioPointPassage() {
		List<BooleanRadio> list = new ArrayList<BooleanRadio>();
		list.add(new BooleanRadio(null, TOUS, TOUS));
		list.add(new BooleanRadio(true, OUI, POINT_PASSAGE));
		list.add(new BooleanRadio(false, NON, AGENCE));

		this.triStateRadioPointPassage = list;
		return triStateRadioPointPassage;
	}

	public void setTriStateRadioPointPassage(
			List<BooleanRadio> triStateRadioPointPassage) {
		this.triStateRadioPointPassage = triStateRadioPointPassage;
	}
}
