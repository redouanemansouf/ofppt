package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;

public class MenuCriteria extends BaseCriteria implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5232121339516692853L;
	
	private String code;
	private String libelle;
	private String abbrev;
	private String pageName;
	
	/**
	 * 
	 */
	public MenuCriteria() {
		super();
		this.code = null;
		this.libelle = null;
		this.abbrev = null;
		this.pageName = null;
	} 


	public MenuCriteria(String code, String libelle, String abbrev, String pageName) {
		super();
		this.code = code;
		this.libelle = libelle; 
		this.abbrev = abbrev;
		this.pageName = pageName;
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


	public String getAbbrev() {
		return abbrev;
	}


	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}


	public String getPageName() {
		return pageName;
	}


	public void setPageName(String pageName) {
		this.pageName = pageName;
	}


}
