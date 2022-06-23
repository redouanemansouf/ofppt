/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.vo.transformer.DelivranceVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.web.ISearchResultVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteVO.
 * 
 * @version 1.0 24 nov. 2014
 * @author sadik
 */
public class DelivranceVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private EtudiantVO etudiantvo;

	private Date dateDelivrance;

	private EntityStatus statut;

	public DelivranceVO() {

	}

	public DelivranceVO(Long id, EtudiantVO etudiantvo, Date dateDelivrance,
			EntityStatus statut) {
		super();
		this.id = id;
		this.etudiantvo = etudiantvo;
		this.dateDelivrance = dateDelivrance;
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EtudiantVO getEtudiantvo() {
		return etudiantvo;
	}

	public void setEtudiantvo(EtudiantVO etudiantvo) {
		this.etudiantvo = etudiantvo;
	}

	public Date getDateDelivrance() {
		return dateDelivrance;
	}

	public void setDateDelivrance(Date dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}

	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	@Override
	public String getIdForSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		return new DelivranceVOTransformer();
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
		DelivranceVO other = (DelivranceVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
