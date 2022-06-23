/*
 * CanalVente.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * The Class CanalVente.
 * 
 * @version 1.0 13 mars 2015
 * @author amtarji
 */
@Entity
@Table(name = "REF_FAMILLE_PRODUIT")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "CANAL_VENTE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
//@SecondaryTable(name="ref_canalvente_restaurant" , pkJoinColumns={
//        @PrimaryKeyJoinColumn(name="CV_CODE"),
//        @PrimaryKeyJoinColumn(name="canal_vente_id"), 
//        @PrimaryKeyJoinColumn(name="RS_CODE"),
//        @PrimaryKeyJoinColumn(name="restaurant_id")
//        })
//@SecondaryTable(name="ref_canalvente_restaurant" , pkJoinColumns = { @PrimaryKeyJoinColumn(name = "canal_vente_id", referencedColumnName = "CV_ID"),
//
//})
// @PrimaryKeyJoinColumn(name="restaurant_id", referencedColumnName="RS_ID")
public class CanalVente extends GenericEntity implements ITracable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5488990264299496958L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "CV_ID")
	private Long id;

	/** Libellé du canal de vente. */
	@Column(name = "CV_LIBELLE", length = 30)
	private String libelle;

	@Column(name = "CV_CODE")
	private String code;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "REF_CANALVENTE_RESTAURANT", joinColumns = { @JoinColumn(name = "canal_vente_id") }, inverseJoinColumns = { @JoinColumn(name = "restaurant_id") })
//	@JoinColumn(name = "REF_CANALVENTE_RESTAURANT", columnDefinition = "", table = "")
	private List<Restaurant> restaurant;

	// /** Description du canal de vente. */
	// @Column(name = "CV_DESCRIPTION", length = 300)
	// private String description;

	/** Statut du canal de vente. */
	@Column(name = "CV_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;
	
	
	@ManyToOne
	@JoinColumn(name = "CV_SITE", referencedColumnName = "SITE_id")
	private Site site;

	/**
	 * Instantiates a new canal vente.
	 */
	public CanalVente() {
		super();
	}

	/**
	 * Instantiates a new canal vente.
	 * 
	 * @param libelle
	 *            the libelle
	 * @param description
	 *            the description
	 */
	public CanalVente(String libelle, String description) {
		super();
		this.libelle = libelle;
		// this.description = description;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the id to set
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
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	// public String getDescription() {
	// return description;
	// }
	//
	// /**
	// * Sets the description.
	// *
	// * @param description
	// * the description to set
	// */
	// public void setDescription(String description) {
	// this.description = description;
	// }

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
	 *            the statut to set
	 */
	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	// @Override
	// public String toString() {
	// return "CanalVente [id=" + id + ", libelle=" + libelle
	// + ", descpription=" + description + "]";
	// }

	@Override
	public String toString() {
		return "CanalVente [id=" + id + ", libelle=" + libelle + "]";

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}
