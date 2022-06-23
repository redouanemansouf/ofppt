/*
 * CanalVenteVOTransformer.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.CanalVente;
import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteVOTransformer.
 *
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class CanalVenteVOTransformer extends BaseTransformer<CanalVente, CanalVenteVO> {

	RestaurantVOTransformer restaurantVOTransformer = new RestaurantVOTransformer();

	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#model2VO(com.m2m.
	 * technicalservices.dao.impl.GenericEntity, boolean[])
	 */
	@Override
	public CanalVenteVO model2VO(CanalVente model, boolean... forCombo) {
		CanalVenteVO vo = new CanalVenteVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			Objects.copyProperties(vo, model);
			if (model.getRestaurant() != null && model.getRestaurant().size() > 0) {
				vo.setRestaurantVOs(restaurantVOTransformer.model2VO(model.getRestaurant(), false));
			}
			if (model.getSite() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));
		}
		return vo;
	}

//	private List<RestaurantVO> model2VO(List<Restaurant> restaurant, boolean b) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	public List<V> model2VOL(List<T> models, boolean... forCombo) {
//		List<V> vos = new ArrayList<V>();
//		for (T model : models) {
//			vos.add(model2VO(model, forCombo));
//		}
//		return vos;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#vo2Model(com.m2m.
	 * technicalservices.core.ValueObject)
	 */
	@Override
	public CanalVente vo2Model(CanalVenteVO vo) {
		CanalVente model = new CanalVente();
		Objects.copyProperties(model, vo);

		if (vo.getRestaurantVOs() != null && vo.getRestaurantVOs().size() > 0) {
			model.setRestaurant(restaurantVOTransformer.vo2Model(vo.getRestaurantVOs()));
		}
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		return model;
	}

}
