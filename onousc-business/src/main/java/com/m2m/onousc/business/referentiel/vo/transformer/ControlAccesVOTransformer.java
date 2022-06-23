package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.onousc.business.referentiel.model.ControlAcces;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.ControlAccesVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

public class ControlAccesVOTransformer extends
		BaseTransformer<ControlAcces, ControlAccesVO> {

	
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	
	@Override
	public ControlAccesVO model2VO(ControlAcces model, boolean... forCombo) {
		ControlAccesVO vo = new ControlAccesVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			
		} else {
			vo = mapper.map(model, ControlAccesVO.class);
		}
		return vo;
	}

	@Override
	public ControlAcces vo2Model(ControlAccesVO vo) {
		return mapper.map(vo,ControlAcces.class);
	}

}
