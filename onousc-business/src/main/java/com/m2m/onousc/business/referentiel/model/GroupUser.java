/*
 * UserEntity.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * The Class UserEntity.
 * 
 * @version 1.0 22 oct. 2015
 * @author user
 */
@Entity
@Table(name = "GROUPUSER")  
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "GROUPE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class GroupUser extends GenericEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2760169331320919480L;


	/** The groupname. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;
	@Column(name = "groupname")
	private String groupname;
	
	@Column(name="libelle")
	private String libelle;
	
	/** The statut. */
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}