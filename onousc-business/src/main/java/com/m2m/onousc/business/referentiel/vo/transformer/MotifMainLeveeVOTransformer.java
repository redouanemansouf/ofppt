package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.MotifMainLevee;
import com.m2m.onousc.business.referentiel.vo.MotifMainLeveeVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class MotifMainLeveeVOTransformer extends
BaseTransformer<MotifMainLevee, MotifMainLeveeVO>{

	@Override
	public MotifMainLeveeVO model2VO(MotifMainLevee model,
			boolean... forCombo) {
		MotifMainLeveeVO vo = new MotifMainLeveeVO();
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
	public MotifMainLevee vo2Model(MotifMainLeveeVO vo) {
		MotifMainLevee model = new MotifMainLevee();
		Objects.copyProperties(model, vo);
		return model;
	}

}