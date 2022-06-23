package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

public class EquipementCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3582716643660036812L;

	/** Code **/
	private String code;

	private String marque;

	private String fournisseur;

	private String reference;

	private String numSerie;

	private Date dateAchat;

	private String type;

	private String libcite;

	/** resto. */
	private String librest;

	public EquipementCriteria() {
		super();
		this.code = null;
		this.marque = null;
		this.fournisseur = null;
		this.reference = null;
		this.numSerie = null;
		this.dateAchat = null;
		this.type = null;
		this.libcite = null;
		this.librest = null;
	}

	

	public EquipementCriteria(String code, String marque, String fournisseur,
			String reference, String numSerie, Date dateAchat, String type,
			String libcite, String librest, EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.marque = marque;
		this.fournisseur = fournisseur;
		this.reference = reference;
		this.numSerie = numSerie;
		this.dateAchat = dateAchat;
		this.type = type;
		this.libcite = libcite;
		this.librest = librest;
		this.setStatut(statut);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}



	@SuppressWarnings("rawtypes")
	public void activeCriteria() {
		boolean filter = false;
		for (Field field : this.getClass().getDeclaredFields()) {
			Class t = field.getType();
			Object v = null;
			try {
				v = field.get(this);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TO-DO
			}
			if (t == EntityStatus.class && v != null) {
				filter = true;
				break;
			} else if (!t.isPrimitive() && !"sortField".equals(field)
					&& !"sortOrder".equals(field) && v != null) {
				filter = true;
				break;
			}
		}
		if (getStatut() != null)
			filter = true;

		setActiveFilter(filter);

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public String getFournisseur() {
		return fournisseur;
	}



	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}



	public String getNumSerie() {
		return numSerie;
	}



	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}



	public Date getDateAchat() {
		return dateAchat;
	}



	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getLibcite() {
		return libcite;
	}



	public void setLibcite(String libcite) {
		this.libcite = libcite;
	}



	public String getLibrest() {
		return librest;
	}

	public void setLibrest(String librest) {
		this.librest = librest;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
