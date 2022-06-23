/*
 * CarteVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;
import java.util.List;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class CanalVenteVO.
 * 
 * @version 1.0 24 nov. 2014
 * @author sadik
 */
public class CarteVO implements ValueObject, ISearchResultVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1497687386109841415L;

	/** The id. */
	private Long id;

	/** The numero carte. */
	private String numeroCarte;

	/** The solde. */
	private Double solde;

	/** The date expiration. */
	private Date dateExpiration;

	/** The num serie. */
	private String numSerie;

	/** The etudiantvo. */
	private EtudiantVO etudiantvo;

	/** The operation. */
	private String operation;

	/** The operateur. */
	private String operateur;

	/** The statut. */
	private EntityStatus statut;
	
	private List<CarteVO> elements;

	/**
	 * Instantiates a new carte vo.
	 */
	public CarteVO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new carte vo.
	 * 
	 * @param id
	 *            the id
	 * @param numSerie
	 *            the num serie
	 * @param etudiantvo
	 *            the etudiantvo
	 * @param operation
	 *            the operation
	 * @param operateur
	 *            the operateur
	 * @param statut
	 *            the statut
	 */
	public CarteVO(Long id, String numSerie, EtudiantVO etudiantvo,
			String operation, String operateur, EntityStatus statut) {
		super();
		this.id = id;
		this.numSerie = numSerie;
		this.etudiantvo = etudiantvo;
		this.operation = operation;
		this.operateur = operateur;
		this.statut = statut;
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
	 * Gets the num serie.
	 * 
	 * @return the num serie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * Sets the num serie.
	 * 
	 * @param numSerie
	 *            the new num serie
	 */
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * Gets the operation.
	 * 
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * Sets the operation.
	 * 
	 * @param operation
	 *            the new operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * Gets the operateur.
	 * 
	 * @return the operateur
	 */
	public String getOperateur() {
		return operateur;
	}

	/**
	 * Sets the operateur.
	 * 
	 * @param operateur
	 *            the new operateur
	 */
	public void setOperateur(String operateur) {
		this.operateur = operateur;
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
	 * Gets the etudiantvo.
	 * 
	 * @return the etudiantvo
	 */
	public EtudiantVO getEtudiantvo() {
		return etudiantvo;
	}

	/**
	 * Sets the etudiantvo.
	 * 
	 * @param etudiantvo
	 *            the new etudiantvo
	 */
	public void setEtudiantvo(EtudiantVO etudiantvo) {
		this.etudiantvo = etudiantvo;
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarteVO other = (CarteVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
	public ITransformer<Carte, CarteVO> getTransformer() {
		return new CarteVOTransformer();
	}

	/**
	 * Gets the numero carte.
	 * 
	 * @return the numero carte
	 */
	public String getNumeroCarte() {
		return numeroCarte;
	}

	/**
	 * Sets the numero carte.
	 * 
	 * @param numeroCarte
	 *            the new numero carte
	 */
	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	/**
	 * Gets the solde.
	 * 
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * Sets the solde.
	 * 
	 * @param solde
	 *            the new solde
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**
	 * Gets the date expiration.
	 * 
	 * @return the date expiration
	 */
	public Date getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * Sets the date expiration.
	 * 
	 * @param dateExpiration
	 *            the new date expiration
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public List<CarteVO> getElements() {
		return elements;
	}

	public void setElements(List<CarteVO> elements) {
		this.elements = elements;
	}

}
