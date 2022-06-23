/*
 * ServiceVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Service;
import com.m2m.onousc.business.referentiel.vo.transformer.ServiceVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.Number;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class ServiceVO.
 * 
 * @version 1.0 21 oct. 2015
 * @author mbenboubker
 */
public class ServiceVO implements ValueObject, ISearchResultVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1773967331617198827L;

	/** The id. */
	private Long id;

	/** The libelle. */
	@NotNull
	@AlphaNum
	@Size(max = 300)
	private String libelle;

	/** The code. */
	@NotNull
	@Size(max = 8)
	private String code;

	
	/** The heure debut. */
	private Date heureDebut;

	
	/** The heure fin. */
	private Date heureFin;

	private String type;

	private String jour;
	
	
	private Double prix;
	
	
	/** The statut. */
	private EntityStatus statut;

	/**
	 * Instantiates a new service vo.
	 */
	public ServiceVO() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.ISearchResultVO#getIdForSearch()
	 */
	/**
	 * Gets the id for search.
	 * 
	 * @return the id for search
	 */
	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ValueObject#getTransformer()
	 */
	/**
	 * Gets the transformer.
	 * 
	 * @return the transformer
	 */
	@Override
	public ITransformer<Service, ServiceVO> getTransformer() {
		return new ServiceVOTransformer();
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the libelle.
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 * 
	 * @param libelle
	 *            the new libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the heure debut.
	 * 
	 * @return the heure debut
	 */
	public Date getHeureDebut() {
		return heureDebut;
	}

	/**
	 * Sets the heure debut.
	 * 
	 * @param heureDebut
	 *            the new heure debut
	 */
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	/**
	 * Gets the heure fin.
	 * 
	 * @return the heure fin
	 */
	public Date getHeureFin() {
		return heureFin;
	}

	/**
	 * Sets the heure fin.
	 * 
	 * @param heureFin
	 *            the new heure fin
	 */
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	/**
	 * Gets the statut.
	 * 
	 * @return the statut
	 */
	public EntityStatus getStatut() {
		return statut;
	}

	/**
	 * Sets the statut.
	 * 
	 * @param statut
	 *            the new statut
	 */
	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	/**
	 * Hash code.
	 * 
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/**
	 * Equals.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceVO other = (ServiceVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	
}
