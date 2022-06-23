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

@Entity
@Table(name = "REF_CATEGORIE_PORTEUR")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "CATEGORIE_PORTEUR_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class CategoriePorteur extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7167039752512708589L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "CA_ID")
	private Long id;

	/** Libellé */
	@Column(name = "CA_LIBELLE", length = 30)
	private String libelle;

	@Column(name = "MT_CODE")
	private String code;

	@Column(name = "CA_CATEGORIE")
	private String categorie;

	@Column(name = "CA_RATIO")
	private Double ratio;

	@Column(name = "CA_PLAFOND_JOURNALIER")
	private String plafJour;

	@Temporal(TemporalType.DATE)
	@Column(name = "CA_DATED")
	private Date dated;

	@Temporal(TemporalType.DATE)
	@Column(name = "CA_DATEF")
	private Date datef;

	@Column(name = "CA_DATEDAF")
	private String datedaf;

	@Column(name = "CA_DATEFAF")
	private String datefaf;

	/** Statut. */
	@Column(name = "CA_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	@ManyToOne
	@JoinColumn(name = "RF_SITE", referencedColumnName = "SITE_id")
	private Site site;

	public String getDatedaf() {
		return datedaf;
	}

	public void setDatedaf(String datedaf) {
		this.datedaf = datedaf;
	}

	public String getDatefaf() {
		return datefaf;
	}

	public void setDatefaf(String datefaf) {
		this.datefaf = datefaf;
	}

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}

	public Date getDatef() {
		return datef;
	}

	public void setDatef(Date datef) {
		this.datef = datef;
	}

	public CategoriePorteur() {
		super();
	}

	public CategoriePorteur(String libelle) {
		super();
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "CategoriePorteur [id=" + id + ", libelle=" + libelle + "]";
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

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getPlafJour() {
		return plafJour;
	}

	public void setPlafJour(String plafJour) {
		this.plafJour = plafJour;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
