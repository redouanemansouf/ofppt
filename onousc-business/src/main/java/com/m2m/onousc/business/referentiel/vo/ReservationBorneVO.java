/*
 * ReservationVO.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.referentiel.model.ReservationBorne;
import com.m2m.onousc.business.referentiel.vo.transformer.ReservationBorneVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

public class ReservationBorneVO implements ValueObject, ISearchResultVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6206239823279278145L;

	/** The id. */
	private Long id;

	/** The date operation. */
	private Date dateOperation;

	private Long cartePorteur;

	/** The montant. */
	private Double montant;

	/** The borne. */
	private BorneVO borne = new BorneVO();

	/**
	 * Instantiates a new reservation vo.
	 */
	public ReservationBorneVO() {
		super();
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
	public ITransformer<ReservationBorne, ReservationBorneVO> getTransformer() {
		return new ReservationBorneVOTransformer();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Long getCartePorteur() {
		return cartePorteur;
	}

	public void setCartePorteur(Long cartePorteur) {
		this.cartePorteur = cartePorteur;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public BorneVO getBorne() {
		return borne;
	}

	public void setBorne(BorneVO borne) {
		this.borne = borne;
	}

}
