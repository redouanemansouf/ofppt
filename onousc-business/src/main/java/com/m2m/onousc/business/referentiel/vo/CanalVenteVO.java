/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.List;

import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.vo.transformer.CanalVenteVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.FixedSize;
import com.m2m.technicalservices.web.ISearchResultVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteVO.
 * 
 * @version 1.0 24 nov. 2014
 * @author aelhachimi
 */
public class CanalVenteVO implements ValueObject, ISearchResultVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8161591620134745200L;

	/** The id. */
	private Long id;

	/** Libellé du canal de vente. */

	@AlphaNum
	@Size(max = 30)
	private String libelle;

	@FixedSize(size = 4)
	private String code;

	private List<Long> idRestaurantsL;

	private List<String> idRestaurants;

	private List<RestaurantVO> restaurantVOs;

	/** Statut du canal de vente. */
	private EntityStatus statut;

	private SiteVO siteVO;

	/**
	 * Instantiates a new canal vente vo.
	 */
	public CanalVenteVO() {
		super();
	}

	/**
	 * Instantiates a new canal vente vo.
	 * 
	 * @param libelle     the libelle
	 * @param description the description
	 */
	public CanalVenteVO(String libelle, String description) {
		super();
		this.libelle = libelle;
//		this.description = description;
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
	 * @param id the id to set
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
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the descpription
	 */
//	public String getDescription() {
//		return description;
//	}
//
//	/**
//	 * Sets the description.
//	 * 
//	 * @param description
//	 *            the new description
//	 */
//	public void setDescription(String description) {
//		this.description = description;
//	}

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
	 * @param statut the statut to set
	 */
	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.web.ISearchResultVO#getIdForSearch()
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
	@Override
	public ITransformer<CanalVente, CanalVenteVO> getTransformer() {
		return new CanalVenteVOTransformer();
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
		CanalVenteVO other = (CanalVenteVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<RestaurantVO> getRestaurantVOs() {
		return restaurantVOs;
	}

	public void setRestaurantVOs(List<RestaurantVO> restaurantVOs) {
		this.restaurantVOs = restaurantVOs;
	}

	public List<String> getIdRestaurants() {
		return idRestaurants;
	}

	public void setIdRestaurants(List<String> idRestaurants) {
		this.idRestaurants = idRestaurants;
	}

	public List<Long> getIdRestaurantsL() {
		return idRestaurantsL;
	}

	public void setIdRestaurantsL(List<Long> idRestaurantsL) {
		this.idRestaurantsL = idRestaurantsL;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

}
