package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.vo.transformer.EvenementVOTransformer;
import com.m2m.onousc.business.referentiel.vo.transformer.ProduitVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

public class EvenementVO implements ValueObject, ISearchResultVO {

	private Long id;
	private String code;
	private String description;
	private String etat;
	private Date dateDebut;
	private Date dateFin;
	private String priorite;
	private EntityStatus statut;
	
	
	public EvenementVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EvenementVO(Long id, String description, String etat,
			Date dateDebut, Date dateFin, String priorite, EntityStatus statut) {
		super();
		this.id = id;
		this.description = description;
		this.etat = etat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.priorite = priorite;
		this.statut = statut;
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getEtat() {
		return etat;
	}



	public void setEtat(String etat) {
		this.etat = etat;
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



	public String getPriorite() {
		return priorite;
	}



	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}



	public EntityStatus getStatut() {
		return statut;
	}



	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvenementVO other = (EvenementVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	@Override
	public String getIdForSearch() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		
		return new EvenementVOTransformer();
	}
	


}
