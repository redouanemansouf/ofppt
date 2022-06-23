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

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 *
 * @author msadik
 */
@Entity
@Table(name = "DELIVRANCE_CARTE")
@TableGenerator(name = "PkGen", table = "sequence_generator", pkColumnName = "GEN_NAME", pkColumnValue = "DELIVRANCE_CARTE_Gen", valueColumnName = "GEN_VALUE", initialValue = 0, allocationSize = 1)
public class DelivranceCarte extends GenericEntity implements ITracable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8427357376365920439L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PkGen")
	@Column(name = "Id_deliv")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private Etudiants etudiant;

	@Basic(optional = false)
	@Column(name = "DATE_DELIVRANCE")
	private Date dateDelivrance;
	@Basic(optional = false)
	@Column(name = "CATEGORIE")
	private String categorie;
	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private EntityStatus statut;

	public DelivranceCarte() {
	}

	public DelivranceCarte(Long id, Etudiants etudiant, Date dateDelivrance, String categorie, EntityStatus statut) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.dateDelivrance = dateDelivrance;
		this.categorie = categorie;
		this.statut = statut;
	}

	public DelivranceCarte(Long id) {
		this.id = id;
	}

	public Etudiants getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiants etudiant) {
		this.etudiant = etudiant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDelivrance() {
		return dateDelivrance;
	}

	public void setDateDelivrance(Date dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "DelivranceCarte [id=" + id + ", etudiant=" + etudiant + ", dateDelivrance=" + dateDelivrance
				+ ", categorie=" + categorie + ", statut=" + statut + "]";
	}

	@Override
	public String getTraceInfo() {
		// TODO Auto-generated method stub
		return toString();
	}

	@Override
	public String getNameEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}