package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.MonitoringEchange;
import com.m2m.onousc.business.referentiel.vo.MonitoringEchangeVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class MonitoringEchangeVOTransformer extends BaseTransformer<MonitoringEchange, MonitoringEchangeVO> {

	@Override
	public MonitoringEchangeVO model2VO(MonitoringEchange model, boolean... forCombo) {
		MonitoringEchangeVO vo = new MonitoringEchangeVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
		} else {
			Objects.copyProperties(vo, model);
		}
		return vo;
	}

	@Override
	public MonitoringEchange vo2Model(MonitoringEchangeVO vo) {
		MonitoringEchange model = new MonitoringEchange();
		Objects.copyProperties(model, vo);
		return model;
	}

}
