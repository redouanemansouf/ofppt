package com.m2m.onousc.business.referentiel.vo.transformer;


import com.m2m.onousc.business.referentiel.vo.CompteVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.tools.Objects;

public class CompteVOTransformer extends
BaseTransformer<UserEntity, CompteVO> {

	@Override
	public CompteVO model2VO(UserEntity model, boolean... forCombo) {
		CompteVO vo = new CompteVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setUsername(model.getUsername());
		} else {
			Objects.copyProperties(vo, model);
		}
		return vo;
	}

	@Override
	public UserEntity vo2Model(CompteVO vo) {
		UserEntity model = new UserEntity();
	Objects.copyProperties(model, vo);
	return model;	
	
	}

}
