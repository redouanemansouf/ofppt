/*
 * SiteVOTransformer.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

// TODO: Auto-generated Javadoc

public class SiteVOTransformer extends BaseTransformer<Site, SiteVO> {

	VilleVOTransformer villetrans = new VilleVOTransformer();
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#model2VO(com.m2m.
	 * technicalservices.dao.impl.GenericEntity, boolean[])
	 */

	@Override
	public SiteVO model2VO(Site model, boolean... forCombo) {
		SiteVO vo = new SiteVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			vo = mapper.map(model, SiteVO.class);

			if (model.getVille()!=null && villetrans.model2VO(model.getVille(), forCombo) != null)
				vo.setVille(villetrans.model2VO(model.getVille(), forCombo));

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
	public Site vo2Model(SiteVO vo) {
		Site model = new Site();
		model = mapper.map(vo, Site.class);
		if (vo.getVille() != null)
			model.setVille(villetrans.vo2Model(vo.getVille()));

		return model;
	}

}
