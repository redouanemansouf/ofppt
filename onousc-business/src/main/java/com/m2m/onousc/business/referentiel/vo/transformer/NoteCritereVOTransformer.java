package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.NoteCritere;
import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.onousc.business.referentiel.vo.NoteCritereVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * 
 * @author abousnane
 * 
 */
public class NoteCritereVOTransformer extends
		BaseTransformer<NoteCritere, NoteCritereVO> {

	@Override
	public NoteCritereVO model2VO(NoteCritere model, boolean... forCombo) {
		NoteCritereVO vo = new NoteCritereVO();
		CritereVOTransformer sertrans = new CritereVOTransformer();
		CritereVO svo = sertrans.model2VO(model.getCritere(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			Objects.copyProperties(vo, model);
			vo.setCritereVO(svo);
		}
		return vo;
	}

	@Override
	public NoteCritere vo2Model(NoteCritereVO vo) {
		NoteCritere model = new NoteCritere();
		Objects.copyProperties(model, vo);
		CritereVOTransformer sertrans = new CritereVOTransformer();
		model.setCritere(sertrans.vo2Model(vo.getCritereVO()));
		return model;
	}

}
