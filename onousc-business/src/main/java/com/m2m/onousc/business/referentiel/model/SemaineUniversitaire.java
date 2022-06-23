/*
 * SemaineUniversitaire.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * The Class SemaineUniversitaire.
 * 
 * @version 1.0 9 oct. 2015
 * @author mbenboubker
 */
@Entity
@Table(name = "SEMAINE_UNIVERSITAIRE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "SEMAINE_UNIVERSITAIRE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class SemaineUniversitaire extends GenericEntity implements ITracable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3477002658564491672L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	/** The libelle. */
	@Column(name = "LIBELLE")
	private String libelle;

	/** The debut debut. */
	@Column(name = "DATE_DEBUT")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	/** The date fin. */
	@Column(name = "DATE_FIN")
	@Temporal(TemporalType.DATE)
	private Date dateFin;

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
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getNameEntity()
	 */
	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SemaineUniversitaire [id=" + id + ", libelle=" + libelle
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getId()
	 */
	public Long getId() {
		return id;
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
	 * Gets the date debut.
	 * 
	 * @return the date debut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * Sets the date debut.
	 * 
	 * @param dateDebut
	 *            the new date debut
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Gets the date fin.
	 * 
	 * @return the date fin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * Sets the date fin.
	 * 
	 * @param dateFin
	 *            the new date fin
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
