/*
 * CanalVenteCriteria.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * The Class CanalVenteCriteria.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class DetailProfilCriteria extends BaseCriteria implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5337953083720183654L;

	

	private String tranche ;
	private String jour ;
	private Date  dateDebut ;
	private Date dateFin ;
	private Long profil ;
	private String libelleP;
	
	
	
	public DetailProfilCriteria(String tranche, String jour, Date dateDebut,
			Date dateFin, Long profil,String libelleP,EntityStatus statut, SearchConfig config) {
		super();
		this.tranche = tranche;
		this.jour = jour;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.profil = profil;
		this.libelleP=libelleP;
		this.setStatut(null);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}


	public DetailProfilCriteria() {
		
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

	public String getTranche() {
		return tranche;
	}

	public void setTranche(String tranche) {
		this.tranche = tranche;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Long getProfil() {
		return profil;
	}

	public void setProfil(Long profil) {
		this.profil = profil;
	}


	public String getLibelleP() {
		return libelleP;
	}


	public void setLibelleP(String libelleP) {
		this.libelleP = libelleP;
	}


}
