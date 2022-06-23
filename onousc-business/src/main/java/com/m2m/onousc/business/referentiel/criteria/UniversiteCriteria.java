package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

public class UniversiteCriteria extends BaseCriteria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -645455182854493824L;
	
	/** code**/
	private String code;
	/** Libellé d'universite. */
	private String libelle;
	
	/** Adresse de l'universite. */
	private String adresseUniv;

	/** Nom responsable de l'universite. */
	private String nomResponsableUniv;
	
	/** Prenom responsable de l'universite. */
	private String prenomResponsableUniv;
	
	/** Numéro tele de l'universite.. */
	private String numTeleUniv;
	
	/** Adresse email de l'universite. */
	private String adresseEmailUniv;
	
	private String libelleville;
	
	public UniversiteCriteria(){
		super();
		this.code = null;
		this.libelle = null;
		this.adresseUniv = null;
		this.nomResponsableUniv = null;
		this.prenomResponsableUniv = null;
		this.numTeleUniv = null;
		this.adresseEmailUniv = null;
		this.libelleville = null;
	}
	
	
	
	public UniversiteCriteria(String code, String libelle, String adresseUniv,
			String nomResponsableUniv, String prenomResponsableUniv,
			String numTeleUniv, String adresseEmailUniv, String libelleville,EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.adresseUniv = adresseUniv;
		this.nomResponsableUniv = nomResponsableUniv;
		this.prenomResponsableUniv = prenomResponsableUniv;
		this.numTeleUniv = numTeleUniv;
		this.adresseEmailUniv = adresseEmailUniv;
		this.libelleville = libelleville;
		this.setStatut(statut);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
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
	 * @return adresseUniv
	 */
	public String getAdresseUniv() {
		return adresseUniv;
	}


	/**
	 * 
	 * @param adresseUniv
	 */
	public void setAdresseUniv(String adresseUniv) {
		this.adresseUniv = adresseUniv;
	}


	/**
	 * 
	 * @return nomResponsableUniv
	 */
	public String getNomResponsableUniv() {
		return nomResponsableUniv;
	}


	/**
	 * 
	 * @param nomResponsableUniv
	 */
	public void setNomResponsableUniv(String nomResponsableUniv) {
		this.nomResponsableUniv = nomResponsableUniv;
	}


	/**
	 * 
	 * @return prenomResponsableUniv
	 */
	public String getPrenomResponsableUniv() {
		return prenomResponsableUniv;
	}


	/**
	 * 
	 * @param prenomResponsableUniv
	 */
	public void setPrenomResponsableUniv(String prenomResponsableUniv) {
		this.prenomResponsableUniv = prenomResponsableUniv;
	}


	/**
	 * 
	 * @return numTeleUniv
	 */
	public String getNumTeleUniv() {
		return numTeleUniv;
	}


	/**
	 * 
	 * @param numTeleUniv
	 */
	public void setNumTeleUniv(String numTeleUniv) {
		this.numTeleUniv = numTeleUniv;
	}


	/**
	 * 
	 * @return adresseEmailUniv
	 */
	public String getAdresseEmailUniv() {
		return adresseEmailUniv;
	}


	/**
	 * 
	 * @param adresseEmailUniv
	 */
	public void setAdresseEmailUniv(String adresseEmailUniv) {
		this.adresseEmailUniv = adresseEmailUniv;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
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
