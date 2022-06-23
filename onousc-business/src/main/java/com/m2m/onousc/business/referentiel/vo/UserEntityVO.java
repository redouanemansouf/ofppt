/*
 * NationaliteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.m2m.onousc.business.referentiel.vo.transformer.UserEntityVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

// TODO: Auto-generated Javadoc
/**
 * The Class NationaliteVO.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class UserEntityVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String username;
	@NotNull
	@Size(min = 8)
	private String password;

	private String password1;
	@NotNull
	@Email
	private String email;
	private String statut;
	
	private String groupname;
	
	private boolean firstConnection;
	
	private Date pwdAffectation;
	
	private SiteVO siteVO;

	public UserEntityVO() {

	}

	public UserEntityVO(String firstName, String lastName, String username, String password, String email,
			String statut,String groupname) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setStatut(statut);
		this.setGroupname(groupname);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Override
	public String getIdForSearch() {

		return null;
	}

	

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		return new UserEntityVOTransformer();
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public boolean isFirstConnection() {
		return firstConnection;
	}

	public void setFirstConnection(boolean firstConnection) {
		this.firstConnection = firstConnection;
	}

	public Date getPwdAffectation() {
		return pwdAffectation;
	}

	public void setPwdAffectation(Date pwdAffectation) {
		this.pwdAffectation = pwdAffectation;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}
}
