package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

public class TourniquetVOTransformer extends
		BaseTransformer<Tourniquet, TourniquetVO> {
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");

	@Override
	public TourniquetVO model2VO(Tourniquet model, boolean... forCombo) {
		TourniquetVO vo = new TourniquetVO();
		RestaurantVOTransformer Restauranttrans = new RestaurantVOTransformer();
		// RestaurantVO cvo = Restauranttrans.model2VO(model.getRestaurant(),
		// forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			/*
			 * Objects.copyProperties(vo, model);
			 * if(Restauranttrans.model2VO(model.getRestaurant(),
			 * forCombo)!=null) vo.setRestaurant(
			 * Restauranttrans.model2VO(model.getRestaurant(), forCombo));
			 */
			vo = mapper.map(model, TourniquetVO.class);
		}
		return vo;
	}

	@Override
	public Tourniquet vo2Model(TourniquetVO vo) {
		/*
		 * Tourniquet model = new Tourniquet(); Objects.copyProperties(model,
		 * vo); RestaurantVOTransformer Restauranttrans = new
		 * RestaurantVOTransformer();
		 * model.setRestaurant(Restauranttrans.vo2Model(vo.getRestaurant()));
		 * return model;
		 */
		return mapper.map(vo, Tourniquet.class);
	}

}
