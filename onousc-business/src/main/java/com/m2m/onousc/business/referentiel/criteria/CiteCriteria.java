package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;




import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

public class CiteCriteria extends BaseCriteria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4607552495389160436L;
	
	/**      Code          **/
	private String code;
	/** Libellé de la cité. */
	private String libelle;
	
	/** Universite de la cité. */
	private String libuniv;
	
	/** Adresse de la cité. */
	private String adresseCite;
	
	/** Nom responsable de la cité. */
	private String nomResponsableCite;
	
	/** Prenom responsable de la cité. */
	private String prenomResponsableCite;
	
	/** Numéro tele de la cité. */
	private String numTeleCite;
	
	/** Adresse email de la cité. */
	private String adresseEmailCite;
	
	private String libelleville;
	
	public CiteCriteria(){
		super();
		this.code = null;
		this.libelle = null;
		this.libuniv = null;
		this.adresseCite = null;
		this.nomResponsableCite = null;
		this.prenomResponsableCite = null;
		this.numTeleCite = null;
		this.adresseEmailCite = null;
		this.libelleville = null;
	}
	
	
	public CiteCriteria(String code, String libelle, String libuniv,
			String adresseCite, String nomResponsableCite,
			String prenomResponsableCite, String numTeleCite,
			String adresseEmailCite, String libelleville, EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.libuniv = libuniv;
		this.adresseCite = adresseCite;
		this.nomResponsableCite = nomResponsableCite;
		this.prenomResponsableCite = prenomResponsableCite;
		this.numTeleCite = numTeleCite;
		this.adresseEmailCite = adresseEmailCite;
		this.libelleville = libelleville;
		this.setStatut(statut);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * 
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	
	/**
	 * 
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = WebUtils.prepareForLikeStatement(libelle);
	}
	
	/**
	 * 
	 * @return universite
	 */
	public String getLibuniv() {
		return libuniv;
	}
	
	/**
	 * 
	 * @param universite
	 */
	public void setLibuniv(String libuniv) {
		this.libuniv = libuniv;
	}
	
	/**
	 * 
	 * @return adresseCite
	 */
	public String getAdresseCite() {
		return adresseCite;
	}
	
	/**
	 * 
	 * @param adresseCite
	 */
	public void setAdresseCite(String adresseCite) {
		this.adresseCite = adresseCite;
	}
	
	/**
	 * 
	 * @return nomResponsableCite
	 */
	public String getNomResponsableCite() {
		return nomResponsableCite;
	}
	
	/**
	 * 
	 * @param nomResponsableCite
	 */
	public void setNomResponsableCite(String nomResponsableCite) {
		this.nomResponsableCite = nomResponsableCite;
	}
	
	/**
	 * 
	 * @return prenomResponsableCite
	 */
	public String getPrenomResponsableCite() {
		return prenomResponsableCite;
	}
	
	/**
	 * 
	 * @param prenomResponsableCite
	 */
	public void setPrenomResponsableCite(String prenomResponsableCite) {
		this.prenomResponsableCite = prenomResponsableCite;
	}
	
	/**
	 * 
	 * @return numTeleCite
	 */
	public String getNumTeleCite() {
		return numTeleCite;
	}
	
	/**
	 * 
	 * @param numTeleCite
	 */
	public void setNumTeleCite(String numTeleCite) {
		this.numTeleCite = numTeleCite;
	}
	
	/**
	 * 
	 * @return adresseEmailCite
	 */
	public String getAdresseEmailCite() {
		return adresseEmailCite;
	}
	
	/**
	 * 
	 * @param adresseEmailCite
	 */
	public void setAdresseEmailCite(String adresseEmailCite) {
		this.adresseEmailCite = adresseEmailCite;
	}
	
	public String getLibelleville() {
		return libelleville;
	}


	public void setLibelleville(String libelleville) {
		this.libelleville = libelleville;
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
	
}
