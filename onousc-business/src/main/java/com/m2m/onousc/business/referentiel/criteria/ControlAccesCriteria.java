package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.common.WebUtils;
import com.m2m.technicalservices.web.SearchConfig;

public class ControlAccesCriteria extends BaseCriteria implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6809000746274328472L;

	/** Matricule **/
	private String matricule;
	
	private Date dateAcces;
	
	private Date heureAcces; 
	
	private Date dateDebut;
	
	private Date dateFin;
	
	private Long tourniquet;


	

	public ControlAccesCriteria(String matricule, Date dateAcces,
			Date heureAcces, Date dateDebut, Date dateFin,Long tourniquet) {
		this.matricule = matricule;
		this.dateAcces = dateAcces;
		this.heureAcces = heureAcces;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tourniquet=tourniquet;
	}

	public ControlAccesCriteria(String matricule, Date dateAcces,
	Date heureAcces, Date dateDebut, Date dateFin,EntityStatus statut,Long tourniquet, SearchConfig config) {
		super();
		this.matricule = matricule;
		this.dateAcces = dateAcces;
		this.heureAcces = heureAcces;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tourniquet=tourniquet;
		this.setStatut(statut);
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	public ControlAccesCriteria() {
		
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Date getDateAcces() {
		return dateAcces;
	}

	public void setDateAcces(Date dateAcces) {
		this.dateAcces = dateAcces;
	}

	public Date getHeureAcces() {
		return heureAcces;
	}

	public void setHeureAcces(Date heureAcces) {
		this.heureAcces = heureAcces;
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

	public Long getTourniquet() {
		return tourniquet;
	}

	public void setTourniquet(Long tourniquet) {
		this.tourniquet = tourniquet;
	}



}
