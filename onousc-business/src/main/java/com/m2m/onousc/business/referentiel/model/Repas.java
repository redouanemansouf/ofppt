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
@Table(name = "REF_REPAS")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "REPAS_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Repas extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680229123179199010L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "REP_ID")
	private Long id;

	@Column(name = "REP_CODE")
	private String code;

	@Column(name = "REP_LIB")
	private String libelle;

	@Column(name = "REP_TYPE")
	private String type;

	@Column(name = "REP_JOUR")
	private String jour;

	@Column(name = "BR_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;
	


	public Repas(Long id, String code, String libelle, String type,
			String jour, EntityStatus statut) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.type = type;
		this.jour = jour;
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	@Override
	public String getTraceInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameEntity() {
		return toString();
	}

	@Override
	public String toString() {
		return "Repas [id=" + id + ", code=" + code + ", libelle=" + libelle
				+ ", type=" + type + ", jour=" + jour + ", statut=" + statut
				+ "]";
	}
	

	
}
