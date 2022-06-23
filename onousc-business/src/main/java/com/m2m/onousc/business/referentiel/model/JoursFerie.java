package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Basic;
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
@Table(name = "REF_JOURS_FERIE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "JOURS_FERIE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class JoursFerie extends GenericEntity implements ITracable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1897231897866437254L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "JF_ID")
	private Long id;
	
	@Column(name = "JF_CODE")
	private String code;
	
	/** Libellé du jours feire. */
	@Column(name = "JF_LIBELLE", length = 30)
	private String libelle;
	
	@Basic(optional = false)
	@Column(name = "JF_Date_debut")
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	
	@Basic(optional = false)
	@Column(name = "JF_Date_fin")
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	
	/** AnneeUniversitaire. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="AN_ID")
	private AnneeUniversitaire anneeUniversitaire;

	/** Statut. */
	@Column(name = "JF_STATUT")
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
		return "JourFerie [id=" + id + ", libelle=" + libelle
				+ ", date debut = " + date_debut + " date fin = "+ date_fin +"]";
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
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


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AnneeUniversitaire getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	

}
