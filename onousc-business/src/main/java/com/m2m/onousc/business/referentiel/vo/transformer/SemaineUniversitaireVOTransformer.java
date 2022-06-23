package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.SemaineUniversitaire;
import com.m2m.onousc.business.referentiel.vo.SemaineUniversitaireVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class SemaineUniversitaireVOTransformer.
 */
public class SemaineUniversitaireVOTransformer extends
		BaseTransformer<SemaineUniversitaire, SemaineUniversitaireVO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#model2VO(com.m2m.
	 * technicalservices.dao.impl.GenericEntity, boolean[])
	 */
	@Override
	public SemaineUniversitaireVO model2VO(SemaineUniversitaire model,
			boolean... forCombo) {
		SemaineUniversitaireVO vo = new SemaineUniversitaireVO();
		Objects.copyProperties(vo, model);
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.technicalservices.core.ITransformer#vo2Model(com.m2m.
	 * technicalservices.core.ValueObject)
	 */
	@Override
	public SemaineUniversitaire vo2Model(SemaineUniversitaireVO vo) {
		SemaineUniversitaire model = new SemaineUniversitaire();
		Objects.copyProperties(model, vo);
		return model;
	}

}
