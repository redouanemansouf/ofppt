package com.m2m.onousc.business.referentiel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "REF_MOTIF_MAIN_LEVEE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "MOTIF_MAIN_LEVEE_OPPOSITION_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class MotifMainLevee extends GenericEntity implements ITracable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7167039752512708589L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "MM_ID")
	private Long id;

	/** Libell? */
	@Column(name = "MM_LIBELLE", length = 30)
	private String libelle;

	@Column(name = "MM_CODE")
	private String code;
	
	/** Statut. */
	@Column(name = "MM_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;
	
	public MotifMainLevee(){
		super();
	}
	
	
	
	public MotifMainLevee(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	@Override
	public String toString(){
		return "MainLevee [id=" + id + ", libelle=" + libelle
				+ "]";
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
	
	

}
