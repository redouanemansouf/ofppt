package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.referentiel.model.ConsultCaisse;
import com.m2m.onousc.business.referentiel.vo.transformer.ConsultCaisseVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * 
 * @author abousnane
 * 
 */
public class ConsultCaisseVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6275311149739068070L;

	/**
	 * 
	 */


	/** The id. */
	private long id;

	private String typeOperation;

	private Double montant;

	private Date dateOperation;

	private String id_caisse;

	private String id_caissier;

	private Double solde;
	
	private String  matricule;
	
	private String id_produit;

	//private EtudiantVO etudiantVO;

	public ConsultCaisseVO() {
		super();
	}


	public ConsultCaisseVO(long id, String typeOperation, Double montant,
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
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<ConsultCaisse, ConsultCaisseVO> getTransformer() {
		return new ConsultCaisseVOTransformer();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultCaisseVO other = (ConsultCaisseVO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	



	}
