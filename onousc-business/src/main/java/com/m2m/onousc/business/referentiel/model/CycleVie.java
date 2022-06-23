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
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * 
 * @author msadik
 */
@Entity
@Table(name = "CYCLE_VIE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "CYCLE_VIE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class CycleVie extends GenericEntity implements ITracable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "CYCLE_ID")
	private Long id;

	@Column(name = "NUM_SERIE")
	private String numSerie;

	@ManyToOne
	@JoinColumn(name = "numporteur", referencedColumnName = "id", nullable=true)
	private Etudiants numPorteur;

	@Column(name = "OPERATION")
	private String operation;

	@Column(name = "DATE_OPERATION")
	@Temporal(TemporalType.DATE)
	private Date dateOperation;

	@Column(name = "OPERATEUR")
	private String operateur;

	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	public CycleVie() {
	}

	public CycleVie(Long id) {
		this.id = id;
	}

	public CycleVie(Long id, String numSerie, Etudiants numPorteur,
			String operation, Date dateOperation, String operateur,
			EntityStatus statut) {
		super();
		this.id = id;
		this.numSerie = numSerie;
		this.numPorteur = numPorteur;
		this.operation = operation;
		this.dateOperation = dateOperation;
		this.operateur = operateur;
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public Etudiants getNumPorteur() {
		return numPorteur;
	}

	public void setNumPorteur(Etudiants numPorteur) {
		this.numPorteur = numPorteur;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CycleVie)) {
			return false;
		}
		CycleVie other = (CycleVie) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CycleVie [id=" + id + ", numSerie=" + numSerie
				+ ", numPorteur=" + numPorteur + ", operation=" + operation
				+ ", dateOperation=" + dateOperation + ", operateur="
				+ operateur + ", statut=" + statut + "]";
	}

	@Override
	public String getTraceInfo() {
		return toString();
	}

	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}
}
