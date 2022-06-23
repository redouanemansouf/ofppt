package com.m2m.onousc.business.reservation.vo.transformer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.vo.transformer.CarteVOTransformer;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.business.reservation.vo.ReservationVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * The Class ReservationVOTransformer.
 */
public class ReservationVOTransformer extends
		BaseTransformer<Reservation, ReservationVO> {

	/** The mapper. */
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	CarteVOTransformer carteVOTransformer = new CarteVOTransformer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#model2VO(com.m2m.
	 * technicalservices.dao.impl.GenericEntity, boolean[])
	 */
	@Override
	public ReservationVO model2VO(Reservation model, boolean... forCombo) {
		ReservationVO vo = new ReservationVO();
		// Objects.copyProperties(vo, model);
		vo = mapper.map(model, ReservationVO.class); 
		return vo;	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#vo2Model(com.m2m.
	 * technicalservices.core.ValueObject)
	 */
	@Override
	public Reservation vo2Model(ReservationVO vo) {
		Reservation model = new Reservation();
		// Objects.copyProperties(model, vo);
		model = mapper.map(vo, Reservation.class);
		// model.setReservationDetail(new ReservationDetailVOTransformer()
		// .vo2Model(vo.getReservationDetail()));
		return model;
	}
	
	public List<ReservationVO> modelToVO(List<Reservation> models, boolean... forCombo) {
 		ReservationVO vo = new ReservationVO(); 
		// Objects.copyProperties(vo, model);
		List<ReservationVO> vos = new ArrayList<ReservationVO>();
		for (Reservation model : models) {
			vo = mapper.map(model, ReservationVO.class);
			vo.setCarte(carteVOTransformer.model2VO(model
					.getCarte()));
			vos.add(vo);
		}
		return vos;  
	}
}
