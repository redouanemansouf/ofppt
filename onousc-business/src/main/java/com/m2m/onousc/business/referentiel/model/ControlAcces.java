package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

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
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "CONTROL_ACCES")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "ACCES_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class ControlAcces extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680229123179199010L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ACCES_ID")
	private Long id;

	/** Libellé du canal de vente. */
	@Column(name = "MATRICULE", length = 10)
	private String matricule;

	@Column(name = "ACCES_DATE")
	@Temporal(TemporalType.DATE)
	private Date dateAcces;

	@Column(name = "ACCES_HEURE")
	@Temporal(TemporalType.TIME)
	private Date heureAcces;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TOURNIQUET_ID")
	private Tourniquet tourniquet;

	/** Statut du caisse. */
	@Column(name = "CA_STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	
	
	
	
	public ControlAcces() {
	}

	public ControlAcces(Long id, String matricule, Date dateAcces,
			Date heureAcces, EntityStatus statut,Tourniquet tourniquet) {
		this.id = id;
		this.matricule = matricule;
		this.dateAcces = dateAcces;
		this.heureAcces = heureAcces;
		this.statut = statut;
		this.tourniquet=tourniquet;
	}

	@Override
	public String getTraceInfo() {
		return toString();
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Date getDateAcces() {
		return dateAcces;
	}

	public void setDateAcces(Date dateAcces) {
		this.dateAcces = dateAcces;
	}

	public Date getHeureAcces() {
		return heureAcces;
	}

	public void setHeureAcces(Date heureAcces) {
		this.heureAcces = heureAcces;
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

	@Override
	public String getNameEntity() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		return "ControlAcces [id=" + id + ", matricule=" + matricule
				+ ", dateAcces=" + dateAcces + ", heureAcces=" + heureAcces
				+ ", statut=" + statut + "]";
	}

	public Tourniquet getTourniquet() {
		return tourniquet;
	}

	public void setTourniquet(Tourniquet tourniquet) {
		this.tourniquet = tourniquet;
	}
	
	

}
