package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "REF_EQUIPEMENT")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "EQUIPEMENT_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Equipement extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680229123179199010L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "EQUI_ID")
	private Long id;

	@Column(name = "EQUI_CODE")
	private String code;

	@Column(name = "EQUI_REF")
	private String reference;

	@Column(name = "EQUI_NSerie")
	private String numSerie;

	@Column(name = "EQUI_FORNISSEUR")
	private String fournisseur;

	@Column(name = "EQUI_PRIX_ACHAT")
	private Double prixAchat;

	@Column(name = "EQUI_DATE_ACHAT")
	@Temporal(TemporalType.DATE)
	private Date dateAchat;

	/** The type reservation. */
	@Column(name = "EQUI_TYPE")
	private String type;

	/** The type reservation. */
	@Column(name = "EQUI_MARQUE")
	private String marque;

	/** Restaurant. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RS_ID")
	private Restaurant restaurant;

	/** Restaurant. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITE_ID")
	private Cite cite;

	/** Statut du caisse. */
	@Column(name = "EQUI_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

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

	@Override
	public String toString() {
		return "Equipement [id=" + id + ", code=" + code;
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

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fornisseur) {
		this.fournisseur = fornisseur;
	}

	public Double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Cite getCite() {
		return cite;
	}

	public void setCite(Cite cite) {
		this.cite = cite;
	}

}
