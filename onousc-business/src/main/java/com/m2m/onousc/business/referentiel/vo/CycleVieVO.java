/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.vo.transformer.CycleVieVOTransformer;
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
public class CycleVieVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6420083613576922097L;

	private Long id;

	private String numSerie;

	private EtudiantVO etudvo;

	private String operation;

	private Date dateOperation;

	private String operateur;

	private EntityStatus statut;

	public CycleVieVO() {
		super();
		etudvo = new EtudiantVO();
	}

	public CycleVieVO(Long id, String numSerie, EtudiantVO etudvo,
			String operation, Date dateOperation, String operateur,
			EntityStatus statut) {
		super();
		this.id = id;
		this.numSerie = numSerie;
		this.etudvo = etudvo;
		this.operation = operation;
		this.dateOperation = dateOperation;
		this.operateur = operateur;
		this.statut = statut;
	}

	public EtudiantVO getEtudvo() {
		return etudvo;
	}

	public void setEtudvo(EtudiantVO etudvo) {
		this.etudvo = etudvo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
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
		// TODO Auto-generated method stub
		return new CycleVieVOTransformer();
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
		CycleVieVO other = (CycleVieVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
