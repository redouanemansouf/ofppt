/*
 * CarteVOTransformer.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.CarteNaps;
import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class CanalVenteVOTransformer.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class CarteNapsVOTransformer extends BaseTransformer<CarteNaps, CarteNapsVO> {

	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();
	@Override
	public CarteNapsVO model2VO(CarteNaps model, boolean... forCombo) {
		CarteNapsVO vo = new CarteNapsVO();
		if(model == null){return null;}
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
		} else {

			Objects.copyProperties(vo, model);

			if (model.getSite() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));
		}
		
		return vo;
	}

	@Override
	public CarteNaps vo2Model(CarteNapsVO vo) {
		CarteNaps model = new CarteNaps();
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		Objects.copyProperties(model, vo);
		return model;
	}


}
