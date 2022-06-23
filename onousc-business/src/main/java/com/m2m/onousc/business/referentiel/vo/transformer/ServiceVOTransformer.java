/*
 * ServiceVOTransformer.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Service;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class ServiceVOTransformer.
 * 
 * @version 1.0 21 oct. 2015
 * @author mbenboubker
 */
public class ServiceVOTransformer extends BaseTransformer<Service, ServiceVO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#model2VO(com.m2m.
	 * technicalservices.dao.impl.GenericEntity, boolean[])
	 */
	@Override
	public ServiceVO model2VO(Service model, boolean... forCombo) {
		ServiceVO vo = new ServiceVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
			vo.setPrix(model.getPrix());
		} else {
			Objects.copyProperties(vo, model);
		}
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#vo2Model(com.m2m.
	 * technicalservices.core.ValueObject)
	 */
	@Override
	public Service vo2Model(ServiceVO vo) {
		Service model = new Service();
		Objects.copyProperties(model, vo);
		return model;
	}

}
