package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.JoursFerie;
import com.m2m.onousc.business.referentiel.vo.AnneeUniversitaireVO;
import com.m2m.onousc.business.referentiel.vo.JoursFerieVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class JoursFerieVOTransformer extends
BaseTransformer<JoursFerie, JoursFerieVO>{

	@Override
	public JoursFerieVO model2VO(JoursFerie model, boolean... forCombo) {
		JoursFerieVO vo = new JoursFerieVO();
		AnneeUniversitaireVOTransformer anntrans = new AnneeUniversitaireVOTransformer();
		AnneeUniversitaireVO annvo = anntrans.model2VO(model.getAnneeUniversitaire(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			Objects.copyProperties(vo, model);
			vo.setAnneeUniversitaireVO(annvo);
		}
		return vo;
	}

	@Override
	public JoursFerie vo2Model(JoursFerieVO vo) {
		JoursFerie model = new JoursFerie();
		Objects.copyProperties(model, vo);
		AnneeUniversitaireVOTransformer anntrans = new AnneeUniversitaireVOTransformer();
		model.setAnneeUniversitaire(anntrans.vo2Model(vo.getAnneeUniversitaireVO()));
		return model;
	}

}
