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
@Table(name = "REF_NOTE_CRITERE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "NOTE_CRITERE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class NoteCritere extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3229406610394096125L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "NT_ID")
	private Long id;

	/** Identifiant de l'universite. */
	@Column(name = "NT_CODE")
	private String code;

	/** Libellé d'universite. */
	@Column(name = "NT_LIBELLE", length = 30)
	private String libelle;

	@Column(name = "NT_MAX")
	private Integer max;

	@Column(name = "NT_MIN")
	private Integer min;

	@Column(name = "NT_NOTE")
	private Float note;

	/** Ville. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CRI_ID")
	private Critere critere;

	/** Statut. */
	@Column(name = "CRI_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	/**
	 * Get the code
	 * 
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * set code
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * get the libelle
	 * 
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * set the libelle
	 * 
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * get the statut
	 * 
	 * @return statut
	 */
	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "UNIVERSITE [id=" + ", code=" + code + ", libelle=" + libelle;
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

	public void setId(Long id) {
		this.id = id;
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

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public Critere getCritere() {
		return critere;
	}

	public void setCritere(Critere critere) {
		this.critere = critere;
	}

}
