/*
 * NationaliteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class NationaliteVO.
 * 
 * @version 1.0 24 nov. 2014
 */
/**
 * @author iissouani
 *
 */
public class TraceEntityVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// user
	private String userID;

	private int action;

	private Date actionWhen;

	// id de l'objet a trace
	private Long idEntity;

	private String nameEntity;
	
	private String actionName;

	public TraceEntityVO() {

	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public Date getActionWhen() {
		return actionWhen;
	}

	public void setActionWhen(Date actionWhen) {
		this.actionWhen = actionWhen;
	}

	public Long getIdEntity() {
		return idEntity;
	}

	public void setIdEntity(Long idEntity) {
		this.idEntity = idEntity;
	}

	public String getNameEntity() {
		return nameEntity;
	}

	public void setNameEntity(String nameEntity) {
		this.nameEntity = nameEntity;
	}

	public String getActionName() {
		switch (action) {
		case 0:
			return "Insertion";
		case 1:
			return "Modification";
		case 2:  
			return "Suppression";

		default:
			break;
		}  
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Override
	public String getIdForSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		// TODO Auto-generated method stub
		return null;
	}
}
