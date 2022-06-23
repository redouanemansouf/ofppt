package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "MONITORING_ECHANGES")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "MONITORING_ECHANGES_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class MonitoringEchange extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6886485584170268157L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;
	@Column(name = "DATE_IMPORT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateImport;
	@Column(name = "NBRE_LIGNE_ERRONE")
	private Integer nbreLigneErronee;
	@Column(name = "NBRE_LIGNE")
	private Integer nbreLigne;
	@Column(name = "RESPONSABLE")
	private String responsable;
	@Column(name = "ENTITE")
	private String entite;
	@Column(name = "TYPE_FICHIER")
	private String typeFichier;
	@Column(name = "PATH")
	private String path;
	@Column(name = "STATUT")
	private String statut;

	@Override
	public String getTraceInfo() {
		return this.toString();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNameEntity() {
		return getClass().getName();
	}

	@Override
	public String toString() {
		return "MonitoringEchange [id=" + id + ", dateImport=" + dateImport + ", nbreLigneErronee=" + nbreLigneErronee
				+ ", nbreLigne=" + nbreLigne + ", responsable=" + responsable + ", entite=" + entite + ", typeFichier="
				+ typeFichier + ", path=" + path + ", statut=" + statut + "]";
	}

	public Date getDateImport() {
		return dateImport;
	}

	public void setDateImport(Date dateImport) {
		this.dateImport = dateImport;
	}

	public Integer getNbreLigneErronee() {
		return nbreLigneErronee;
	}

	public void setNbreLigneErronee(Integer nbreLigneErronee) {
		this.nbreLigneErronee = nbreLigneErronee;
	}

	public Integer getNbreLigne() {
		return nbreLigne;
	}

	public void setNbreLigne(Integer nbreLigne) {
		this.nbreLigne = nbreLigne;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public String getTypeFichier() {
		return typeFichier;
	}

	public void setTypeFichier(String typeFichier) {
		this.typeFichier = typeFichier;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
