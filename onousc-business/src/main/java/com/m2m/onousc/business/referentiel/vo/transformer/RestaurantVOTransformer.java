package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

public class RestaurantVOTransformer extends BaseTransformer<Restaurant, RestaurantVO> {

	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();
	CiteVOTransformer citetrans = new CiteVOTransformer();
	VilleVOTransformer villetrans = new VilleVOTransformer();

	@Override
	public RestaurantVO model2VO(Restaurant model, boolean... forCombo) {
		RestaurantVO vo = new RestaurantVO();
		CiteVOTransformer citetrans = new CiteVOTransformer();

		VilleVOTransformer villetrans = new VilleVOTransformer();

		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			/*
			 * Objects.copyProperties(vo, model); if(citetrans.model2VO(model.getCite(),
			 * forCombo)!=null) vo.setCiteVO(citetrans.model2VO(model.getCite(), forCombo));
			 * if(villetrans.model2VO(model.getVille(), forCombo)!=null)
			 * vo.setVilleVO(villetrans.model2VO(model.getVille(), forCombo));
			 */
			vo = mapper.map(model, RestaurantVO.class);
			if (model.getSite() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));
		}
		return vo;
	}

	@Override
	public Restaurant vo2Model(RestaurantVO vo) {
		Restaurant model = new Restaurant();
		model = mapper.map(vo, Restaurant.class);
		// Objects.copyProperties(model, vo);
		if (vo.getCite() != null)
			model.setCite(citetrans.vo2Model(vo.getCite()));
//		if (vo.getVille() != null)
//			model.setVille(villetrans.vo2Model(vo.getVille()));
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		return model;
		// return mapper.map(vo, Restaurant.class);

	}

}
