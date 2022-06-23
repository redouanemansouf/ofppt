package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

public class NoteCritereCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7966411465904605872L;

	/** Code **/
	private String code;
	/** Libellé. */
	private String libelle;

	private Integer min;

	private Integer max;

	private Float note;

	private String libcritere;

	public NoteCritereCriteria() {
		super();
		this.code = null;
		this.libelle = null;
		this.min = null;
		this.max = null;
		this.note = null;
		this.libcritere = null;
	}

	public NoteCritereCriteria(String code, String libelle, Integer min,
			Integer max, String libcritere, EntityStatus statut,
			SearchConfig config) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.min = min;
		this.max = max;
		this.libcritere = libcritere;
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

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public String getLibcritere() {
		return libcritere;
	}

	public void setLibcritere(String libcritere) {
		this.libcritere = libcritere;
	}

}
