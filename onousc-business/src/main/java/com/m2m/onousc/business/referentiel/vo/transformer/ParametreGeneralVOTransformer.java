package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.ParametreGeneral;
import com.m2m.onousc.business.referentiel.vo.ParametreGeneralVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class ParametreGeneralVOTransformer extends
BaseTransformer<ParametreGeneral, ParametreGeneralVO>{

	@Override
	public ParametreGeneralVO model2VO(ParametreGeneral model,
			boolean... forCombo) {
		ParametreGeneralVO vo = new ParametreGeneralVO();
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
	public ParametreGeneral vo2Model(ParametreGeneralVO vo) {
		ParametreGeneral model = new ParametreGeneral();
		Objects.copyProperties(model, vo);
		return model;
	}

}