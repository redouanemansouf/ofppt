package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.onousc.business.referentiel.vo.transformer.ControlAccesVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

public class ControlAccesVO implements ValueObject, ISearchResultVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1479226839093838264L;
	private Long id;
	private String matricule;
	private Date dateAcces;
	private Date heureAcces;
	private EntityStatus statut;
	private Tourniquet tourniquet;

	public ControlAccesVO() {
		super();
	}

	

	public ControlAccesVO(Long id, String matricule, Date dateAcces,
			Date heureAcces, EntityStatus statut, Tourniquet tourniquet) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.dateAcces = dateAcces;
		this.heureAcces = heureAcces;
		this.statut = statut;
		this.tourniquet = tourniquet;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
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
		ControlAccesVO other = (ControlAccesVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		return new ControlAccesVOTransformer();
	}

	public Tourniquet getTourniquet() {
		return tourniquet;
	}

	public void setTourniquet(Tourniquet tourniquet) {
		this.tourniquet = tourniquet;
	}

}
