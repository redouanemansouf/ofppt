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
@Table(name = "REF_BORNE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "BORNE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Borne extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680229123179199010L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "BR_ID")
	private Long id;

	@Column(name = "BR_CODE")
	private String code;

	@Column(name = "BR_REF")
	private String libelle;

	@Column(name = "BR_IP")
	private String ip;

	/** Restaurant. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SITE_ID")
	private Site site;

	/** Statut du caisse. */
	@Column(name = "BR_STATUT")
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

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
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

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
