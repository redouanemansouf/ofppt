/*
 * UserEntity.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.technicalservices.security;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * The Class UserEntity.
 * 
 * @version 1.0 22 oct. 2015
 * @author user
 */
@Entity
@Table(name = "USER_ENTITY")
public class UserEntity extends GenericEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2760169331320919480L;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The username. */
	@Id
	private String username;

	/** The password. */
	private String password;

	private String groupname;
	
	private boolean firstConnection;
	
	private Date pwdAffectation;
	/** The roles. */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "authority"))
	private Set<RoleEntity> roles;

	/** The email. */
	private String email;

	/** The statut. */
	private String statut;

	/** The etat. */
	private String etat;
	
	@Column(name = "FK_SITE")
	protected Long  site ;
	
	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the roles.
	 * 
	 * @return the roles
	 */
	public Set<RoleEntity> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 * 
	 * @param roles
	 *            the new roles
	 */
	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the statut.
	 * 
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * Sets the statut.
	 * 
	 * @param statut
	 *            the new statut
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	/**
	 * Gets the etat.
	 * 
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * Sets the etat.
	 * 
	 * @param etat
	 *            the new etat
	 */
	public void setEtat(String etat) {
		this.etat = etat;
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

	public Long getSite() {
		return site;
	}

	public void setSite(Long site) {
		this.site = site;
	}
}