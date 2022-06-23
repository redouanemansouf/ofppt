package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Caisse;
import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

public class CaisseVOTransformer extends BaseTransformer<Caisse, CaisseVO> {
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();

	@Override
	public CaisseVO model2VO(Caisse model, boolean... forCombo) {
		CaisseVO vo = new CaisseVO();
		RestaurantVOTransformer Restauranttrans = new RestaurantVOTransformer();
		// RestaurantVO cvo = Restauranttrans.model2VO(model.getRestaurant(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			/*
			 * Objects.copyProperties(vo, model);
			 * if(Restauranttrans.model2VO(model.getRestaurant(), forCombo)!=null)
			 * vo.setRestaurant(Restauranttrans.model2VO(model.getRestaurant(), forCombo));
			 */
			if (model != null)
				vo = mapper.map(model, CaisseVO.class);
			if (vo.getSiteVO() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));
		}
		return vo;
	}

	@Override
	public Caisse vo2Model(CaisseVO vo) {
		Caisse model = new Caisse();
		/*
		 * Objects.copyProperties(model, vo); RestaurantVOTransformer Restauranttrans =
		 * new RestaurantVOTransformer();
		 * model.setRestaurant(Restauranttrans.vo2Model(vo.getRestaurant())); return
		 * model;
		 */
		model = mapper.map(vo, Caisse.class);
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		return model;
	}

}
