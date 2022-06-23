package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

public class ClotureCaisseCriteria extends BaseCriteria implements Serializable {

	private Long caisse;

	private Long caissier;

	private Date dateCloture;

	public ClotureCaisseCriteria() {
		super();

	}

	public ClotureCaisseCriteria(Long caisse, Long caissier, Date dateCloture,
			SearchConfig config) {
		super();
		this.caisse = caisse;
		this.caissier = caissier;
		this.dateCloture = dateCloture;

		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	public Long getCaisse() {
		return caisse;
	}

	public void setCaisse(Long caisse) {
		this.caisse = caisse;
	}

	public Long getCaissier() {
		return caissier;
	}

	public void setCaissier(Long caissier) {
		this.caissier = caissier;
	}

	public Date getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
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
