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
@Table(name = "REF_PLAFOND")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "PLAFOND_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class Plafond extends GenericEntity implements ITracable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5398243442472155739L;
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "PL_ID")
	private Long id;

	/** Libellé du plafond. */
	@Column(name = "PL_LIBELLE", length = 30)
	private String libelle;

	@Column(name = "PL_CODE")
	private String code;
	
	
	@Column(name = "PL_MAX")
	private Integer max;
	
	@Column(name = "PL_MIN")
	private Integer min;
	
	/** Statut du caisse. */
	@Column(name = "PL_STATUT")
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
	public String toString(){
		return "PLAFOND [id="+id+", code=" +code + ", libelle="
				+libelle;
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

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
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
