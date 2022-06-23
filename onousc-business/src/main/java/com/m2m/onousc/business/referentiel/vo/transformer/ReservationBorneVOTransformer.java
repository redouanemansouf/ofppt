package com.m2m.onousc.business.referentiel.vo.transformer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.onousc.business.referentiel.model.ReservationBorne;
import com.m2m.onousc.business.referentiel.vo.ReservationBorneVO;

/**
 * The Class ReservationBorneVOTransformer.
 */
public class ReservationBorneVOTransformer extends
		BaseTransformer<ReservationBorne, ReservationBorneVO> {

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
	public ReservationBorneVO model2VO(ReservationBorne model, boolean... forCombo) {
		ReservationBorneVO vo = new ReservationBorneVO();
		// Objects.copyProperties(vo, model);
		vo = mapper.map(model, ReservationBorneVO.class); 
		return vo;	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#vo2Model(com.m2m.
	 * technicalservices.core.ValueObject)
	 */
	@Override
	public ReservationBorne vo2Model(ReservationBorneVO vo) {
		ReservationBorne model = new ReservationBorne();
		model = mapper.map(vo, ReservationBorne.class);
		return model;
	}
	
	public List<ReservationBorneVO> modelToVO(List<ReservationBorne> models, boolean... forCombo) {
 		ReservationBorneVO vo = new ReservationBorneVO(); 
// 		CarteVO carte = new CarteVO();
 	   
		// Objects.copyProperties(vo, model);
		List<ReservationBorneVO> vos = new ArrayList<ReservationBorneVO>();
		for (ReservationBorne model : models) {
			vo = mapper.map(model, ReservationBorneVO.class);
//			carte = (CarteVO)this.mapper.map(model.getCartePorteur(), CarteVO.class);
//		    vo.setCartePorteur(carte);
		    vos.add(vo);
		}
		return vos;  
	}
}
