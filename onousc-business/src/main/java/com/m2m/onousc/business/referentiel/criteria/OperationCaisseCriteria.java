package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * 
 * @author abousnane
 * 
 */
public class OperationCaisseCriteria extends BaseCriteria implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9125357497510211646L;

	/** code **/
	private String typeOperation;

	private Date dateOperation;

	private String libcaisse;

	private String libresto;

	private String codeetu;

	private String type;

	private String libcite;

	private String caissiercode;

	public OperationCaisseCriteria() {
		super();
		this.typeOperation = null;
		this.dateOperation = null;
		this.libcaisse = null;
		this.libresto = null;
		this.codeetu = null;
		this.type = null;
		this.libcite = null;
		this.caissiercode = null;
	}

	public OperationCaisseCriteria(String typeOperation, Date dateOperation,
			String libcaisse, String libresto, String codeetu, String type,
			String libcite, String caissiercode, SearchConfig config) {
		super();
		this.typeOperation = typeOperation;
		this.dateOperation = dateOperation;
		this.libcaisse = libcaisse;
		this.libresto = libresto;
		this.type = type;
		this.codeetu = codeetu;
		this.libcite = libcite;
		this.caissiercode = caissiercode;
		this.setSearchConfig(config);
		this.setSortField(null);
		this.setSortOrder(null);
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getLibcaisse() {
		return libcaisse;
	}

	public void setLibcaisse(String libcaisse) {
		this.libcaisse = libcaisse;
	}

	public String getLibresto() {
		return libresto;
	}

	public void setLibresto(String libresto) {
		this.libresto = libresto;
	}

	public String getCodeetu() {
		return codeetu;
	}

	public void setCodeetu(String codeetu) {
		this.codeetu = codeetu;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibcite() {
		return libcite;
	}

	public void setLibcite(String libcite) {
		this.libcite = libcite;
	}

	public String getCaissiercode() {
		return caissiercode;
	}

	public void setCaissiercode(String caissiercode) {
		this.caissiercode = caissiercode;
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
