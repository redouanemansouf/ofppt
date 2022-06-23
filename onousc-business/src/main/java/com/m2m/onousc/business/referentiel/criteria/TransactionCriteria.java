package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

public class TransactionCriteria extends BaseCriteria implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6977032407430026644L;
	private Date dateDebut;
	private Date dateFin;
	private Integer type;
	private String libcite;
	private String librestaurant;
	private String typeOperation;
	private String codeetu;

	public TransactionCriteria() {
		super();
		this.dateDebut = null;
		this.dateFin = null;
		this.type = null;
		this.libcite = null;
		this.librestaurant = null;
		this.typeOperation = null;
		this.codeetu = null;
	}

	public TransactionCriteria(Date dateDebut, Date dateFin, Integer type,
			String libcite, String librestaurant, String typeOperation,
			String codeetu, SearchConfig config) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.type = type;
		this.libcite = libcite;
		this.librestaurant = librestaurant;
		this.typeOperation = typeOperation;
		this.codeetu = codeetu;
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getLibcite() {
		return libcite;
	}

	public void setLibcite(String libcite) {
		this.libcite = libcite;
	}

	public String getLibrestaurant() {
		return librestaurant;
	}

	public void setLibrestaurant(String librestaurant) {
		this.librestaurant = librestaurant;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public String getCodeetu() {
		return codeetu;
	}

	public void setCodeetu(String codeetu) {
		this.codeetu = codeetu;
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

	public String getDateFinFormat() {
		Calendar c = Calendar.getInstance();
		c.setTime(dateFin);
		String res = c.get(Calendar.YEAR) + "-"
				+ (int) (c.get(Calendar.MONTH) + 1) + "-"
				+ c.get(Calendar.DAY_OF_MONTH);
		return res;
	}

}