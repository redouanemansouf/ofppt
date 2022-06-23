package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * 
 * @author abousnane
 * 
 */
public class JoursFerieCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4129641117967387560L;
	/** cdoe **/
	private String code;

	/** The libelle. */
	private String libelle;

	/** Date debut. */
	private Date date_debut;

	/** Date Fin. */
	private Date date_fin;

	private String annee;
	
	private String anneeUniv;

	public JoursFerieCriteria() {
		super();
		this.code = null;
		this.libelle = null;
		this.date_debut = null;
		this.date_fin = null;
		this.annee = null;
		this.anneeUniv = null;
	}

	public JoursFerieCriteria(String code, String libelle, Date date_debut,
			Date date_fin, String annee, String anneeUniv, EntityStatus statut,
			SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.annee = annee;
		this.anneeUniv = anneeUniv;
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

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = WebUtils.prepareForLikeStatement(libelle);
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getAnneeUniv() {
		return anneeUniv;
	}

	public void setAnneeUniv(String anneeUniv) {
		this.anneeUniv = anneeUniv;
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
