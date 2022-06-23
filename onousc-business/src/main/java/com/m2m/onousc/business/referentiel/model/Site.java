/*
 * CanalVente.java
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * The Class CanalVente.
 * 
 * @version 1.0 13 mars 2015
 * @author amtarji
 */
@Entity
@Table(name = "SITE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "SITE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)

public class Site extends GenericEntity implements ITracable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5488990264299496958L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "SITE_ID")
	private Long id;

	/** Libellé du canal de vente. */
	@Column(name = "LIBELLE_SITE", length = 30)
	private String libelle;

	@Column(name = "SITE_ADRESSE", length = 300)
	private String adresse;

	/** Nom responsable. */
	@Column(name = "SITE_NOMRES", length = 100)
	private String nomResponsable;

	/** Prenom responsable. */
	@Column(name = "SITE_PRENRES", length = 100)
	private String prenomResponsable;

	/** Numéro tele. */
	@Column(name = "SITE_NUMTELE", length = 10)
	private String numTele;

	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	@ManyToOne
	@JoinColumn(name = "REF_VILLE", referencedColumnName = "VILL_CODE")
	private Ville ville;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "CODE_SITE")
	private String code;

	public Site(Long id, String libelle, String code) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
	}

	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTraceInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNomResponsable() {
		return nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	public String getPrenomResponsable() {
		return prenomResponsable;
	}

	public void setPrenomResponsable(String prenomResponsable) {
		this.prenomResponsable = prenomResponsable;
	}

	public String getNumTele() {
		return numTele;
	}

	public void setNumTele(String numTele) {
		this.numTele = numTele;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

}
