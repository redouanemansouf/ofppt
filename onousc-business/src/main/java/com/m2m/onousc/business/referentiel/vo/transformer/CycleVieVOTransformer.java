/*
 * CanalVenteVOTransformer.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.CycleVie;
import com.m2m.onousc.business.referentiel.vo.CycleVieVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteVOTransformer.
 *
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class CycleVieVOTransformer extends
		BaseTransformer<CycleVie, CycleVieVO> {

	
	CiteVOTransformer citetransformer=new CiteVOTransformer();
	EtudiantVOTransformer etudiantVOTransformer=new EtudiantVOTransformer();
	

	@Override
	public CycleVieVO model2VO(CycleVie model, boolean... forCombo) {
		
		CycleVieVO vo =new CycleVieVO();
		if(forCombo.length >0 && forCombo[0]){
			vo.setId(model.getId());
		}
		else {
			Objects.copyProperties(vo, model);
			vo.setEtudvo(etudiantVOTransformer.model2VO(model.getNumPorteur()));;
		}
		return vo;
	}

	@Override
	public CycleVie vo2Model(CycleVieVO vo) {
		CycleVie model=new CycleVie();
		Objects.copyProperties(model, vo);
		model.setNumPorteur(etudiantVOTransformer.vo2Model(vo.getEtudvo()));
		return model;
	}
	
	


}
