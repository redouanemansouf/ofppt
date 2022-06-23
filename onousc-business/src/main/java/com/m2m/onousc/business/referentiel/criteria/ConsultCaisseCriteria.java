package com.m2m.onousc.business.referentiel.criteria;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import com.m2m.onousc.business.common.BaseCriteria;
import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.web.SearchConfig;

/**
 * 
 * @author msadik
 * 
 */
public class ConsultCaisseCriteria extends BaseCriteria implements Serializable {

	/**
	 * 
	 */
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** code **/
	private String typeOperation;
	private Date dateDebut;
	private Date dateFin;
	private String matricule;
	private Long idcaisse;
	

	
	
	
	public ConsultCaisseCriteria() {
	}

	public ConsultCaisseCriteria(String typeOperation, Date dateDebut,
			Date dateFin, String matricule,Long idcaisse) {
		super();
		this.typeOperation = typeOperation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.matricule = matricule;
		this.idcaisse=idcaisse;
	}

	public ConsultCaisseCriteria(String typeOperation, Date dateDebut,
			Date dateFin, String matricule,Long idcaisse, SearchConfig config) {
		super();
		this.typeOperation = typeOperation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.matricule = matricule;
		this.idcaisse=idcaisse;
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public Long getIdcaisse() {
		return idcaisse;
	}

	public void setIdcaisse(Long idcaisse) {
		this.idcaisse = idcaisse;
	}

}
