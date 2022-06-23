package com.m2m.onousc.business.referentiel.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "OPER_RECHARGEMENT")
public class OperationCaisse extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1897231897866437254L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_oper")
	private Long id;

	@Column(name = "type_oper")
	private String typeOperation;

	/** Montant. */
	@Column(name = "montant", length = 30)
	private Double montant;

	@Basic(optional = false)
	@Column(name = "date_oper")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOperation;

	/** AnneeUniversitaire. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CA_ID", nullable = true)
	private Caisse caisse;

	/** AnneeUniversitaire. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_caissier", nullable = true)
	private Caissier caissier;

	@Column(name = "solde_caisse")
	private Double solde;

	@Column(name = "matricule")
	private String matricule;

	/** AnneeUniversitaire. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = true)
	private Produit produit;

	@ManyToOne
	@JoinColumn(name = "OP_SITE", referencedColumnName = "SITE_id")
	private Site site;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public OperationCaisse() {
		super();
	}

	public OperationCaisse(Long id, String typeOperation, Double montant, Date dateOperation, Caisse caisse,
			Caissier caissier, Double solde, String matricule, Produit produit) {
		super();
		this.id = id;
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.dateOperation = dateOperation;
		this.caisse = caisse;
		this.caissier = caissier;
		this.solde = solde;
		this.matricule = matricule;
		this.produit = produit;
//		this.etudiant = etudiant;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "OperationCaisse [id=" + id + ", solde=" + solde;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

//	public Etudiants getEtudiant() {
//		return etudiant;
//	}
//
//	public void setEtudiant(Etudiants etudiant) {
//		this.etudiant = etudiant;
//	}

	public void setId(Long id) {
		this.id = id;
	}

	public Caissier getCaissier() {
		return caissier;
	}

	public void setCaissier(Caissier caissier) {
		this.caissier = caissier;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}
