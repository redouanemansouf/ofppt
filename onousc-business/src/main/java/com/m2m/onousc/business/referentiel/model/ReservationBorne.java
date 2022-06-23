/*
 * Reservation.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class Reservation.
 * 
 * @author user
 * @version 1.0 12 oct. 2015
 */
@Entity
@Table(name = "reservation_borne")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "RESERVATION_BORNE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class ReservationBorne extends GenericEntity implements ITracable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1118181878185009422L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "ID")
	private Long id;

	/** The date operation. */
	@Column(name = "DATE_OPERATION")
	@Temporal(TemporalType.DATE)
	private Date dateOperation;

	/** The montant. */
	@Column(name = "MONTANT")
	private Double montant;

	@Column(name = "CARTE")
	private Long cartePorteur;

	@Column(name = "STATUT")
	private String statut;

	/** The borne. */
	@ManyToOne
	@JoinColumn(name = "BORNE", referencedColumnName = "BR_ID")
	private Borne borne;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.audit.impl.ITracable#getTraceInfo()
	 */
	@Override
	public String getTraceInfo() {
		return Utils.serializeObjectToJsonString(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	@Override
	public String getNameEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getCartePorteur() {
		return cartePorteur;
	}

	public void setCartePorteur(Long cartePorteur) {
		this.cartePorteur = cartePorteur;
	}

	public Borne getBorne() {
		return borne;
	}

	public void setBorne(Borne borne) {
		this.borne = borne;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "ReservationBorne [id=" + id + ", dateOperation=" + dateOperation + ", montant=" + montant
				+ ", cartePorteur=" + cartePorteur + ", borne=" + borne + "]";
	}

}
