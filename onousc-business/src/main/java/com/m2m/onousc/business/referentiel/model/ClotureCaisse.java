/*
 * CanalVente.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * The Class CanalVente.
 * 
 * @version 1.0 13 mars 2015
 * @author amtarji
 */
@Entity
@Table(name = "CLOTURE_CAISSE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "CLOT_CAISSE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class ClotureCaisse extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1518644549520968722L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CAISSE_ID", referencedColumnName = "CA_ID")
	private Caisse caisse;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CAISSIER_ID", referencedColumnName = "Id_caissier")
	private Caissier caissier;

	@Column(name = "SOLDE_CLOTURE", length = 300)
	private Double solde;

	@Column(name = "DATE_CLOTURE")
	@Temporal(TemporalType.DATE)
	private Date dateCloture;

	@Column(name = "HEURE_CLOTURE")
	@Temporal(TemporalType.TIME)
	private Date heureCloture;

	/**
	 * Instantiates a new canal vente.
	 */
	public ClotureCaisse() {
		super();
	}

	public ClotureCaisse(Long id, Caisse caisse, Caissier caissier,
			Double solde, Date dateCloture, Date heureCloture) {
		super();
		this.id = id;
		this.caisse = caisse;
		this.caissier = caissier;
		this.solde = solde;
		this.dateCloture = dateCloture;
		this.heureCloture = heureCloture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public Caissier getCaissier() {
		return caissier;
	}

	public void setCaissier(Caissier caissier) {
		this.caissier = caissier;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Date getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

	public Date getHeureCloture() {
		return heureCloture;
	}

	public void setHeureCloture(Date heureCloture) {
		this.heureCloture = heureCloture;
	}

	@Override
	public String toString() {
		return "ClotureCaisse [id=" + id + ", caisse=" + caisse + ", caissier="
				+ caissier + ", solde=" + solde + ", dateCloture="
				+ dateCloture + ", heureCloture=" + heureCloture + "]";
	}

	@Override
	public String getTraceInfo() {
		return toString();
	}

	@Override
	public String getNameEntity() {
		return getClass().getName();
	}

}
