package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

public class OppositionAdhCriteria extends BaseCriteria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4407451559479561608L;
	
	private String matrAdh;
	
	private String nom;
	
	private String prenom;

	private EntityStatus statut;

	public OppositionAdhCriteria() {
		super();
	}

	public OppositionAdhCriteria(String matrAdh, String nom, String prenom,
			EntityStatus statut) {
		super();
		this.matrAdh = matrAdh;
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
	}
	
	
	public OppositionAdhCriteria(String matrAdh, String nom, String prenom,
			EntityStatus statut,SearchConfig config) {
		super();
		this.matrAdh = matrAdh;
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
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

	

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	public String getMatrAdh() {
		return matrAdh;
	}

	public void setMatrAdh(String matrAdh) {
		this.matrAdh = matrAdh;
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
	
	
	
	
	
	

}
