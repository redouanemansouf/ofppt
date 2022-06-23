/*
 * Carte.java
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * The Class Carte.
 * 
 * @author msadik
 */
@Entity
@Table(name = "CARTE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "CARTE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Carte extends GenericEntity implements ITracable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7011299339949950210L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "CARTE_ID")
	private Long id;

	/** The numero carte. */
	@Column(name = "NUMERO_CARTE")
	private String numeroCarte;

	/** The solde. */
	@Column(name = "SOLDE")
	private Double solde;

	/** The date expiration. */
	@Column(name = "DATE_EXPIRATION")
	@Temporal(TemporalType.DATE)
	private Date dateExpiration;

	/** The num serie. */
	@Column(name = "NUM_SERIE")
	private String numSerie;

	/** The num porteur. */
	@ManyToOne
	@JoinColumn(name = "numporteur", referencedColumnName = "id", nullable=true)
	private Etudiants numPorteur;

	/** The operation. */
	@Column(name = "OPERATION")
	private String operation;

	/** The operateur. */
	@Column(name = "OPERATEUR")
	private String operateur;

	/** The statut. */
	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	/**
	 * Instantiates a new carte.
	 */
	public Carte() {
	}

	/**
	 * Instantiates a new carte.
	 * 
	 * @param id
	 *            the id
	 */
	public Carte(Long id) {
		this.id = id;
	}

	/**
	 * Instantiates a new carte.
	 * 
	 * @param id
	 *            the id
	 * @param numSerie
	 *            the num serie
	 * @param numPorteur
	 *            the num porteur
	 * @param operation
	 *            the operation
	 * @param operateur
	 *            the operateur
	 * @param statut
	 *            the statut
	 */
	public Carte(Long id, String numSerie, Etudiants numPorteur,
			String operation, String operateur, EntityStatus statut) {
		super();
		this.id = id;
		this.numSerie = numSerie;
		// this.numPorteur = numPorteur;
		this.operation = operation;
		this.operateur = operateur;
		this.statut = statut;
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
	 * Gets the num serie.
	 * 
	 * @return the num serie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * Sets the num serie.
	 * 
	 * @param numSerie
	 *            the new num serie
	 */
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * Gets the num porteur.
	 * 
	 * @return the num porteur
	 */
	public Etudiants getNumPorteur() {
		return numPorteur;
	}

	/**
	 * Sets the num porteur.
	 * 
	 * @param numPorteur
	 *            the new num porteur
	 */
	public void setNumPorteur(Etudiants numPorteur) {
		this.numPorteur = numPorteur;
	}

	/**
	 * Gets the operation.
	 * 
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * Sets the operation.
	 * 
	 * @param operation
	 *            the new operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * Gets the operateur.
	 * 
	 * @return the operateur
	 */
	public String getOperateur() {
		return operateur;
	}

	/**
	 * Sets the operateur.
	 * 
	 * @param operateur
	 *            the new operateur
	 */
	public void setOperateur(String operateur) {
		this.operateur = operateur;
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
	 * Gets the numero carte.
	 * 
	 * @return the numero carte
	 */
	public String getNumeroCarte() {
		return numeroCarte;
	}

	/**
	 * Sets the numero carte.
	 * 
	 * @param numeroCarte
	 *            the new numero carte
	 */
	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	/**
	 * Gets the solde.
	 * 
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * Sets the solde.
	 * 
	 * @param solde
	 *            the new solde
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**
	 * Gets the date expiration.
	 * 
	 * @return the date expiration
	 */
	public Date getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * Sets the date expiration.
	 * 
	 * @param dateExpiration
	 *            the new date expiration
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Carte)) {
			return false;
		}
		Carte other = (Carte) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Carte [id=" + id + ", numeroCarte=" + numeroCarte
				+ ", numSerie=" + numSerie + ", numPorteur=" + numPorteur
				+ ", operation=" + operation + ", operateur=" + operateur
				+ ", statut=" + statut + "]";
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
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getNameEntity()
	 */
	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}

}
