package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

public class CategoriePorteurCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7966411465904605872L;

	/** Code **/
	private String code;
	/** Libellé. */
	private String libelle;

	private String categorie;

	private Double ratio;

	private String plafJour;

	private Date dated;

	private Date datef;

	private Long idSite;

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}

	public Date getDatef() {
		return datef;
	}

	public void setDatef(Date datef) {
		this.datef = datef;
	}

	public String getPlafJour() {
		return plafJour;
	}

	public void setPlafJour(String plafJour) {
		this.plafJour = plafJour;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public CategoriePorteurCriteria() {
		super();
		this.code = null;
		this.libelle = null;
		this.ratio = null;
		this.categorie = null;
		this.plafJour = null;
		this.dated = null;
		this.datef = null;

	}

	public CategoriePorteurCriteria(String code, String libelle, Double ratio, String categorie, String plafJour,
			Date dated, Date datef, EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.ratio = ratio;
		this.categorie = categorie;
		this.plafJour = plafJour;
		this.dated = dated;
		this.datef = datef;
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
		this.libelle = libelle;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public Long getIdSite() {
		return idSite;
	}

	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}

}
