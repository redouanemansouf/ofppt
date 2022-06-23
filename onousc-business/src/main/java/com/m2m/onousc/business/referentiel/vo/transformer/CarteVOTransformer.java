/*
 * CarteVOTransformer.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class CanalVenteVOTransformer.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class CarteVOTransformer extends BaseTransformer<Carte, CarteVO> {

	/** The citetransformer. */
	CiteVOTransformer citetransformer = new CiteVOTransformer();

	/** The etudiant vo transformer. */
	EtudiantVOTransformer etudiantVOTransformer = new EtudiantVOTransformer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#model2VO(com.m2m.
	 * technicalservices.dao.impl.GenericEntity, boolean[])
	 */
	@Override
	public CarteVO model2VO(Carte model, boolean... forCombo) {
		CarteVO vo = new CarteVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
		} else {
			Objects.copyProperties(vo, model);
			vo.setEtudiantvo(etudiantVOTransformer.model2VO(model
					.getNumPorteur()));
			;
		}
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#vo2Model(com.m2m.
	 * technicalservices.core.ValueObject)
	 */
	@Override
	public Carte vo2Model(CarteVO vo) {
		Carte model = new Carte();
		Objects.copyProperties(model, vo);
		model.setNumPorteur(etudiantVOTransformer.vo2Model(vo.getEtudiantvo()));
		return model;
	}

}
