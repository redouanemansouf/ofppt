/*
 * CarteVOTransformer.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Carte;
import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.model.ProfilPorteur;
import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.ProfilPorteurVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class CanalVenteVOTransformer.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class ProfilPorteurVOTransformer extends BaseTransformer<ProfilPorteur, ProfilPorteurVO> {

	@Override
	public ProfilPorteurVO model2VO(ProfilPorteur model, boolean... forCombo) {
		ProfilPorteurVO vo = new ProfilPorteurVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
		} else {
			Objects.copyProperties(vo, model);
		}
		return vo;
	}

	@Override
	public ProfilPorteur vo2Model(ProfilPorteurVO vo) {
		ProfilPorteur model = new ProfilPorteur();
		Objects.copyProperties(model, vo);
		return model;
	}

}
