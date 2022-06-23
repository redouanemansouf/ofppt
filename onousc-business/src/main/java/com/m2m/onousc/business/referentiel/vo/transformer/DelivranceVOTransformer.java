/*
 * CanalVenteVOTransformer.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.DelivranceCarte;
import com.m2m.onousc.business.referentiel.vo.DelivranceVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteVOTransformer.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class DelivranceVOTransformer extends
		BaseTransformer<DelivranceCarte, DelivranceVO> {

	EtudiantVOTransformer etudiantVOTransformer = new EtudiantVOTransformer();

	@Override
	public DelivranceVO model2VO(DelivranceCarte model, boolean... forCombo) {
		DelivranceVO vo = new DelivranceVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
		} else {
			Objects.copyProperties(vo, model);
			vo.setEtudiantvo(etudiantVOTransformer.model2VO(model.getEtudiant()));
			;
		}
		return vo;
	}

	@Override
	public DelivranceCarte vo2Model(DelivranceVO vo) {
		DelivranceCarte model = new DelivranceCarte();
		Objects.copyProperties(model, vo);
		model.setEtudiant(etudiantVOTransformer.vo2Model(vo.getEtudiantvo()));
		return model;
	}

}
