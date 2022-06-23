package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Plafond;
import com.m2m.onousc.business.referentiel.vo.PlafondVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class PlafondVOTransformer extends
BaseTransformer<Plafond, PlafondVO>{

	@Override
	public PlafondVO model2VO(Plafond model, boolean... forCombo) {
		PlafondVO vo = new PlafondVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			Objects.copyProperties(vo, model);
		}
		return vo;
	}

	@Override
	public Plafond vo2Model(PlafondVO vo) {
		Plafond model = new Plafond();
		Objects.copyProperties(model, vo);
		return model;
	}

}
