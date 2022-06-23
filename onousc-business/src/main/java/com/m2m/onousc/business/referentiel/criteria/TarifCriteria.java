package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * 
 * @author abousnane
 *
 */
public class TarifCriteria extends BaseCriteria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9125357497510211646L;
	
	/**   code   **/
	private String code;
	/** The libelle. */
	private String libelle;
	
	/** The tarif. */
	private Double tarif;
	
	private String libelleservice;
	private String libellecatporteur;
	
	public TarifCriteria(){
		super();
		this.code = null;
		this.libelle = null;
		this.tarif = null;
		this.libelleservice = null;
		this.libellecatporteur = null;
	}

	public TarifCriteria(String code, String libelle, Double tarif, String libelleservice, 	String libellecatporteur, EntityStatus statut, SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.tarif = tarif;
		this.libelleservice = libelleservice;
		this.libellecatporteur = libellecatporteur;
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

	public Double getTarif() {
		return tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	
	
	public String getLibelleservice() {
		return libelleservice;
	}

	public void setLibelleservice(String libelleservice) {
		this.libelleservice = libelleservice;
	}

	public String getLibellecatporteur() {
		return libellecatporteur;
	}

	public void setLibellecatporteur(String libellecatporteur) {
		this.libellecatporteur = libellecatporteur;
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
