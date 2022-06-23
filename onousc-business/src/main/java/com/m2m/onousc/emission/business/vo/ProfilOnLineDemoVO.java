/*
 * CanalVenteVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.emission.business.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.dao.impl.GenericEntity;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.validation.FixedSize;
import com.m2m.technicalservices.web.ISearchResultVO;

public class ProfilOnLineDemoVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -897348782312403573L;

	/** The id. */
	private Long id;

	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;

	@NotNull
	@FixedSize(size = 3)
	private String code;

	private Double debitplafond;

	private Double plafondRechargement;

	private Integer periode;

	private String devise;

	private String banque;

	private String typeCarte;

	private String paiment;

	private EntityStatus statut;

	public ProfilOnLineDemoVO() {
		super();
	}

	public ProfilOnLineDemoVO(Long id, String libelle, String code,
			Double debitplafond, Double plafondRechargement, Integer periode,
			String devise, String banque, String typeCarte, String paiment,
			EntityStatus statut) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.debitplafond = debitplafond;
		this.plafondRechargement = plafondRechargement;
		this.periode = periode;
		this.devise = devise;
		this.banque = banque;
		this.typeCarte = typeCarte;
		this.paiment = paiment;
		this.statut = statut;
	}

	public Double getDebitplafond() {
		return debitplafond;
	}

	public void setDebitplafond(Double debitplafond) {
		this.debitplafond = debitplafond;
	}

	public Double getPlafondRechargement() {
		return plafondRechargement;
	}

	public void setPlafondRechargement(Double plafondRechargement) {
		this.plafondRechargement = plafondRechargement;
	}

	public Integer getPeriode() {
		return periode;
	}

	public void setPeriode(Integer periode) {
		this.periode = periode;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public String getPaiment() {
		return paiment;
	}

	public void setPaiment(String paiment) {
		this.paiment = paiment;
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
	 *            the id to set
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
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	 *            the statut to set
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banque == null) ? 0 : banque.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((debitplafond == null) ? 0 : debitplafond.hashCode());
		result = prime * result + ((devise == null) ? 0 : devise.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((paiment == null) ? 0 : paiment.hashCode());
		result = prime * result + ((periode == null) ? 0 : periode.hashCode());
		result = prime
				* result
				+ ((plafondRechargement == null) ? 0 : plafondRechargement
						.hashCode());
		result = prime * result + ((statut == null) ? 0 : statut.hashCode());
		result = prime * result
				+ ((typeCarte == null) ? 0 : typeCarte.hashCode());
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
		ProfilOnLineDemoVO other = (ProfilOnLineDemoVO) obj;
		if (banque == null) {
			if (other.banque != null)
				return false;
		} else if (!banque.equals(other.banque))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (debitplafond == null) {
			if (other.debitplafond != null)
				return false;
		} else if (!debitplafond.equals(other.debitplafond))
			return false;
		if (devise == null) {
			if (other.devise != null)
				return false;
		} else if (!devise.equals(other.devise))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (paiment == null) {
			if (other.paiment != null)
				return false;
		} else if (!paiment.equals(other.paiment))
			return false;
		if (periode == null) {
			if (other.periode != null)
				return false;
		} else if (!periode.equals(other.periode))
			return false;
		if (plafondRechargement == null) {
			if (other.plafondRechargement != null)
				return false;
		} else if (!plafondRechargement.equals(other.plafondRechargement))
			return false;
		if (statut != other.statut)
			return false;
		if (typeCarte == null) {
			if (other.typeCarte != null)
				return false;
		} else if (!typeCarte.equals(other.typeCarte))
			return false;
		return true;
	}

}
