package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Critere;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

public class CritereVOTransformer extends
BaseTransformer<Critere, CritereVO>{
	
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");

	@Override
	public CritereVO model2VO(Critere model,
			boolean... forCombo) {
		CritereVO vo = new CritereVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			return  mapper.map(model, CritereVO.class) ;
		}
		return vo;
	}

	@Override
	public Critere vo2Model(CritereVO vo) {
		
		return  mapper.map(vo, Critere.class) ;
	}

}