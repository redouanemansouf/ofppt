package com.m2m.onousc.business.referentiel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.m2m.technicalservices.dao.impl.GenericEntity;



@Entity
@Table(name = "REF_VILLE")
public class Ville extends GenericEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5601891196797295945L;


	/** The id. */
	@Id
	@Column(name = "VILL_CODE")
	private Long id;


	@Column(name = "VILL_LIBELLE")
	private String libelle;

	@Column(name = "VILL_PROV")
	private String prov;

	
	
	public Ville() {
		super();
	}

	public Ville(Long id, String libelle, String prov) {
		super();
		this.libelle = libelle;
		this.prov = prov;
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
	 * @param id            the id to set
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
	 * @param libelle            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
