package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.DemandeAdmin;
import com.m2m.onousc.business.referentiel.vo.DemandeAdminVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

public class DemandeAdminVOTransformer extends BaseTransformer<DemandeAdmin, DemandeAdminVO> {
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");

	@Override
	public DemandeAdminVO model2VO(DemandeAdmin model, boolean... forCombo) {
		DemandeAdminVO vo = new DemandeAdminVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());

		} else {
			if (model != null)
				vo = mapper.map(model, DemandeAdminVO.class);
		}
		return vo;
	}

	@Override
	public DemandeAdmin vo2Model(DemandeAdminVO vo) {
		DemandeAdmin model = new DemandeAdmin();
		model = mapper.map(vo, DemandeAdmin.class);
		return model;
	}

}
