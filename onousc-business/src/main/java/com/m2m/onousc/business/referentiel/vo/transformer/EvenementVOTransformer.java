package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Evenement;
import com.m2m.onousc.business.referentiel.model.Produit;
import com.m2m.onousc.business.referentiel.vo.EvenementVO;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

public class EvenementVOTransformer extends BaseTransformer<Evenement, EvenementVO> {

	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");

	@Override
	public EvenementVO model2VO(Evenement model, boolean... forCombo) {
		EvenementVO vo = new EvenementVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setCode(model.getCode());
			
		} else {
			vo = mapper.map(model, EvenementVO.class);
		}
		return vo;
	}

	@Override
	public Evenement vo2Model(EvenementVO vo) {
		return mapper.map(vo,Evenement.class);
	}

}
