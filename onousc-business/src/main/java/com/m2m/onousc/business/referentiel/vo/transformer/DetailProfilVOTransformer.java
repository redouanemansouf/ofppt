package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.DetailProfilAcces;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.DetailProfilVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

public class DetailProfilVOTransformer extends
		BaseTransformer<DetailProfilAcces, DetailProfilVO> {

	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");

	@Override
	public DetailProfilVO model2VO(DetailProfilAcces model, boolean... forCombo) {
	DetailProfilVO vo=new DetailProfilVO();
	if(forCombo.length>0 && forCombo[0])
	{
		vo.setId(model.getId());
		
	}
	else 
	{
		vo=mapper.map(model, DetailProfilVO.class);
	}
		return vo;
	}

	@Override
	public DetailProfilAcces vo2Model(DetailProfilVO vo) {
		return mapper.map(vo, DetailProfilAcces.class);
	}

}
