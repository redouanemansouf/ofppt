package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

public class CaissierCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -703091229727555547L;

	/** Code **/
	private String code;

	/** Nom responsable */
	private String nom;

	/** Prenom responsable. */
	private String prenom;

	/** Numéro tele. */
	private String numTele;

	/** Adresse email. */
	private String adresseEmail;

	private String libellecaisse;

	private Long idSite;

	public CaissierCriteria() {
		super();
		this.code = null;
		this.nom = null;
		this.prenom = null;
		this.numTele = null;
		this.adresseEmail = null;
		this.libellecaisse = null;
	}

	public CaissierCriteria(String code, String libelle, String libcite, String nomResponsable,
			String prenomResponsable, String numTele, String adresseEmail, String libelleville, String adresse,
			EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.nom = nomResponsable;
		this.prenom = prenomResponsable;
		this.numTele = numTele;
		this.adresseEmail = adresseEmail;
		this.libellecaisse = libelleville;
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
			} else if (!t.isPrimitive() && !"sortField".equals(field) && !"sortOrder".equals(field) && v != null) {
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

	public String getNumTele() {
		return numTele;
	}

	public void setNumTele(String numTele) {
		this.numTele = numTele;
	}

	public String getAdresseEmail() {
		return adresseEmail;
	}

	public void setAdresseEmail(String adresseEmail) {
		this.adresseEmail = adresseEmail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLibellecaisse() {
		return libellecaisse;
	}

	public void setLibellecaisse(String libellecaisse) {
		this.libellecaisse = libellecaisse;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}

}