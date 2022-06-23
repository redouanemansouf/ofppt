package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.AnneeUniversitaire;
import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class AnneeUniversitaireVOTransformer extends
BaseTransformer<AnneeUniversitaire, AnneeUniversitaireVO>{

	@Override
	public AnneeUniversitaireVO model2VO(AnneeUniversitaire model,
			boolean... forCombo) {
		AnneeUniversitaireVO vo = new AnneeUniversitaireVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			Objects.copyProperties(vo, model);
		}
		return vo;
	}

	@Override
	public AnneeUniversitaire vo2Model(AnneeUniversitaireVO vo) {
		AnneeUniversitaire model = new AnneeUniversitaire();
		Objects.copyProperties(model, vo);
		return model;
	}

}
