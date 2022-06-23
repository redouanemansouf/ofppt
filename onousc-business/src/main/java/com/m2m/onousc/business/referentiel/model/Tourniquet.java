package com.m2m.onousc.business.referentiel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "REF_TOURNIQUET")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "TOURNIQUET_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Tourniquet extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680229123179199010L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "TRQ_ID")
	private Long id;

	/** Libellé du canal de vente. */
	@Column(name = "TRQ_LIBELLE", length = 30)
	private String libelle;

	@Column(name = "TRQ_CODE")
	private String code;

	@Column(name = "TRQ_REF")
	private String reference;
	
	@Column(name = "TRQ_MOD")
	private String mode;
	
	@Column(name = "TRQ_TYPE")
	private String type;

	/** Restaurant. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RS_ID")
	private Restaurant restaurant;

	/** Statut du caisse. */
	@Column(name = "TRQ_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	@Override
	public String getTraceInfo() {
		return Utils.serializeObjectToJsonString(this);
	}
	
	

	public Tourniquet() {
		
	}



	public Tourniquet(Long id, String libelle, String code, String reference,
			String mode, Restaurant restaurant, EntityStatus statut) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.reference = reference;
		this.mode = mode;
		this.restaurant = restaurant;
		this.statut = statut;
	}



	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}


	@Override
	public String toString() {
		return "Tourniquet [id=" + id + ", libelle=" + libelle + ", code="
				+ code + ", reference=" + reference + ", mode=" + mode
				+ ", type=" + type + ", restaurant=" + restaurant + ", statut="
				+ statut + "]";
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
