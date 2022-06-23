package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

public class RestaurantCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -703091229727555547L;

	private Long id;
	/** Code **/
	private String code;
	/** Libellé de la caisse. */
	private String libelle;

	/** cite. */
	private String libcite;

	/** Nom responsable */
	private String nomResponsable;

	/** Prenom responsable. */
	private String prenomResponsable;

	/** Numéro tele. */
	private String numTele;

	/** Adresse email. */
	private String adresseEmail;

	private String libelleville;

	private Long idSite;

	/** Adresse. */
	private String adresse;

	public RestaurantCriteria() {
		super();
		this.code = null;
		this.libelle = null;
		this.libcite = null;
		this.nomResponsable = null;
		this.prenomResponsable = null;
		this.numTele = null;
		this.adresseEmail = null;
		this.libelleville = null;
		this.adresse = null;
	}

	public RestaurantCriteria(String code, String libelle, String libcite, String nomResponsable,
			String prenomResponsable, String numTele, String adresseEmail, String libelleville, String adresse,
			EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.libcite = libcite;
		this.nomResponsable = nomResponsable;
		this.prenomResponsable = prenomResponsable;
		this.numTele = numTele;
		this.adresseEmail = adresseEmail;
		this.libelleville = libelleville;
		this.adresse = adresse;
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

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = WebUtils.prepareForLikeStatement(libelle);
	}

	public String getLibcite() {
		return libcite;
	}

	public void setLibcite(String libcite) {
		this.libcite = WebUtils.prepareForLikeStatement(libcite);
	}

	public String getNomResponsable() {
		return nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	public String getPrenomResponsable() {
		return prenomResponsable;
	}

	public void setPrenomResponsable(String prenomResponsable) {
		this.prenomResponsable = prenomResponsable;
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

	public String getLibelleville() {
		return libelleville;
	}

	public void setLibelleville(String libelleville) {
		this.libelleville = libelleville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}

}
