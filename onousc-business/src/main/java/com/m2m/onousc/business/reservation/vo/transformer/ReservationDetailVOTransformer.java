/*
 * ReservationDetailVOTransformer.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.reservation.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.reservation.model.ReservationDetail;
import com.m2m.onousc.business.reservation.vo.ReservationDetailVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * The Class ReservationDetailVOTransformer.
 */
public class ReservationDetailVOTransformer extends
		BaseTransformer<ReservationDetail, ReservationDetailVO> {

	/** The mapper. */
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#model2VO(com.m2m.
	 * technicalservices.dao.impl.GenericEntity, boolean[])
	 */
	@Override
	public ReservationDetailVO model2VO(ReservationDetail model,
			boolean... forCombo) {
		ReservationDetailVO vo = new ReservationDetailVO();
		// Objects.copyProperties(vo, model);
		vo = mapper.map(model, ReservationDetailVO.class);
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#vo2Model(com.m2m.
	 * technicalservices.core.ValueObject)
	 */
	@Override
	public ReservationDetail vo2Model(ReservationDetailVO vo) {
		ReservationDetail model = new ReservationDetail();
		// Objects.copyProperties(model, vo);
		model = mapper.map(vo, ReservationDetail.class);
		return model;
	}

}
