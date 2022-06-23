package com.m2m.onousc.business.referentiel.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "REF_FILIERE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "FILIERE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Filiere extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4655589766933870934L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	/** Libellé du FILIERE. */
	@Column(name = "LIBELLE", length = 30)
	private String libelle;

	@Column(name = "CODE")
	private String code;

	/** Statut du filiere */
	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	@ManyToOne
	@JoinColumn(name = "FK_SITE", referencedColumnName = "SITE_id")
	private Site site;

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
		return "FILIERE [id=" + ", code=" + code + ", libelle=" + libelle;
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

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
