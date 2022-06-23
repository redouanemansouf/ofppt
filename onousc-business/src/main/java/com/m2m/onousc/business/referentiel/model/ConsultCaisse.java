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
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.utils.Utils;
import com.m2m.technicalservices.audit.impl.ITracable;
import com.m2m.technicalservices.dao.impl.GenericEntity;

@Entity
@Table(name = "OPER_RECHARGE_CAISSE")
public class ConsultCaisse extends GenericEntity {

	/**
	 * 
	 */


	/**
	 * 
	 */
	private static final long serialVersionUID = 8228761198380445982L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id_oper")
	private long id;

	@Column(name = "type_oper")
	private String typeOperation;

	/** Montant. */
	@Column(name = "montant", length = 30)
	private Double montant;

	@Basic(optional = false)
	@Column(name = "date_oper")
	@Temporal(TemporalType.DATE)
	private Date dateOperation;

	
	@Column(name = "CA_ID")
	private String id_caisse;

	
	@Column(name = "Id_caissier")
	private String id_caissier;

	@Column(name = "solde_caisse")
	private Double solde;
	
	@Column(name = "matricule")
	private String  matricule;


	@Column(name = "id_produit")
	private String  id_produit;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public String getId_caisse() {
		return id_caisse;
	}


	public void setId_caisse(String id_caisse) {
		this.id_caisse = id_caisse;
	}


	public String getId_caissier() {
		return id_caissier;
	}


	public void setId_caissier(String id_caissier) {
		this.id_caissier = id_caissier;
	}


	public Double getSolde() {
		return solde;
	}


	public void setSolde(Double solde) {
		this.solde = solde;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getId_produit() {
		return id_produit;
	}


	public void setId_produit(String id_produit) {
		this.id_produit = id_produit;
	}


	@Override
	public String toString() {
		return "ConsultCaisse [id=" + id + ", typeOperation=" + typeOperation
				+ ", montant=" + montant + ", dateOperation=" + dateOperation
				+ ", id_caisse=" + id_caisse + ", id_caissier=" + id_caissier
				+ ", solde=" + solde + ", matricule=" + matricule
				+ ", id_produit=" + id_produit + "]";
	}


	public ConsultCaisse(long id, String typeOperation, Double montant,
			Date dateOperation, String id_caisse, String id_caissier,
			Double solde, String matricule, String id_produit) {
		super();
		this.id = id;
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.dateOperation = dateOperation;
		this.id_caisse = id_caisse;
		this.id_caissier = id_caissier;
		this.solde = solde;
		this.matricule = matricule;
		this.id_produit = id_produit;
	}


	public ConsultCaisse() {
		super();
	}


	
	
	
	
	

}
