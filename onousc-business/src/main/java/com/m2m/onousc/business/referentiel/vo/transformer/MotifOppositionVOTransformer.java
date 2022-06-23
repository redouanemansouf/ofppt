package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.MotifOpposition;
import com.m2m.onousc.business.referentiel.vo.MotifOppositionVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class MotifOppositionVOTransformer extends
BaseTransformer<MotifOpposition, MotifOppositionVO>{

	@Override
	public MotifOppositionVO model2VO(MotifOpposition model,
			boolean... forCombo) {
		MotifOppositionVO vo = new MotifOppositionVO();
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
	public MotifOpposition vo2Model(MotifOppositionVO vo) {
		MotifOpposition model = new MotifOpposition();
		Objects.copyProperties(model, vo);
		return model;
	}

}