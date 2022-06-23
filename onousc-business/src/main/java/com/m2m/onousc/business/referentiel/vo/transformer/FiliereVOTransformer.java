package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Filiere;
import com.m2m.onousc.business.referentiel.vo.FiliereVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

public class FiliereVOTransformer extends BaseTransformer<Filiere, FiliereVO> {

	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();

	@Override
	public FiliereVO model2VO(Filiere model, boolean... forCombo) {
		FiliereVO vo = new FiliereVO();

		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			
			vo = mapper.map(model, FiliereVO.class);
			if (model.getSite() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));
		}
		return vo;
	}

	@Override
	public Filiere vo2Model(FiliereVO vo) {
		Filiere model = new Filiere();
		model = mapper.map(vo, Filiere.class);
		
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		return model;

	}

}
