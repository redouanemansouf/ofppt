/*
 * Service.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * The Class Service.
 * 
 * @author abousnane
 */
@Entity
@Table(name = "SERVICE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "SERVICE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Service extends GenericEntity implements ITracable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6933704477408370080L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	/** Libellé du service. */
	@Column(name = "LIBELLE")
	private String libelle;

	/** The code. */
	@Column(name = "CODE")
	private String code;

	/** The heure debut. */
	@Column(name = "HEURE_DEBUT")
	@Temporal(TemporalType.TIME)
	private Date heureDebut;

	/** The heure fin. */
	@Column(name = "HEURE_FIN")
	@Temporal(TemporalType.TIME)
	private Date heureFin;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "JOUR")
	private String jour;
	
	@Column(name = "PRIX")
	private Double prix;
	
	/** Statut du service. */
	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	/**
	 * Instantiates a new service.
	 */
	public Service() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getTraceInfo()
	 */
	@Override
	public String getTraceInfo() {
		return Utils.serializeObjectToJsonString(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getNameEntity()
	 */
	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}

	/**
	 * Gets the libelle.
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 * 
	 * @param libelle
	 *            the new libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the statut.
	 * 
	 * @return the statut
	 */
	public EntityStatus getStatut() {
		return statut;
	}

	/**
	 * Sets the statut.
	 * 
	 * @param statut
	 *            the new statut
	 */
	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the heure debut.
	 * 
	 * @return the heure debut
	 */
	public Date getHeureDebut() {
		return heureDebut;
	}

	/**
	 * Sets the heure debut.
	 * 
	 * @param heureDebut
	 *            the new heure debut
	 */
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	/**
	 * Gets the heure fin.
	 * 
	 * @return the heure fin
	 */
	public Date getHeureFin() {
		return heureFin;
	}

	/**
	 * Sets the heure fin.
	 * 
	 * @param heureFin
	 *            the new heure fin
	 */
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	
}
