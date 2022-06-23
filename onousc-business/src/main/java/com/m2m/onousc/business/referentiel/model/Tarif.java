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

/**
 * 
 * @author abousnane
 *
 */
@Entity
@Table(name = "REF_TARIF")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "TARIF_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)

public class Tarif extends GenericEntity implements ITracable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6695402866386659717L;
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "TR_ID")
	private Long id;

	/** Libellé du tarif. */
	@Column(name = "TR_LIBELLE", length = 30)
	private String libelle;

	@Column(name = "TR_CODE")
	private String code;
	
	@Column(name = "TR_TARIF")
	private Double tarif;
	
	/** Service de tarif. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SR_ID")
	private Service service;
	
	/** CategoriePorteur de starif. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CA_ID")
	private CategoriePorteur categoriePorteur;
	
	/** Statut du tarif. */
	@Column(name = "TR_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;
	
	public Tarif(){
		super();
	}
	
		

	public Tarif(String libelle, Double tarif, Service service, CategoriePorteur categoriePorteur) {
		super();
		this.libelle = libelle;
		this.tarif = tarif;
		this.service = service;
		this.categoriePorteur = categoriePorteur;
	}

	@Override
	public String toString(){
		return "Tarif [id=" + id + ", libelle=" + libelle
				+ ", tarif =" + tarif + "]";
	}

	@Override
	public String getTraceInfo() {
		return Utils.serializeObjectToJsonString(this);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNameEntity() {
		return this.getClass().getName();
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



	public Double getTarif() {
		return tarif;
	}



	public void setTarif(Double tarif) {
		this.tarif = tarif;
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



	public Service getService() {
		return service;
	}



	public void setService(Service service) {
		this.service = service;
	}



	public CategoriePorteur getCategoriePorteur() {
		return categoriePorteur;
	}



	public void setCategoriePorteur(CategoriePorteur categoriePorteur) {
		this.categoriePorteur = categoriePorteur;
	}
	
	
}
