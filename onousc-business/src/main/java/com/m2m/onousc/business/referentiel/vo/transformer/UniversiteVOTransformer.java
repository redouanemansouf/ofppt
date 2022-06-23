package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class UniversiteVOTransformer extends BaseTransformer<Universite, UniversiteVO>{

	@Override
	public UniversiteVO model2VO(Universite model, boolean... forCombo) {
		UniversiteVO vo = new UniversiteVO();
		VilleVOTransformer villetrans = new VilleVOTransformer();
		VilleVO villeVO = null;
		if (model.getVille() != null)
			villeVO = villetrans.model2VO(model.getVille(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			Objects.copyProperties(vo, model);
			vo.setVilleVO(villeVO);
		}
		return vo;
	}

	@Override
	public Universite vo2Model(UniversiteVO vo) {
		Universite model = new Universite();
		Objects.copyProperties(model, vo);
		VilleVOTransformer villetrans = new VilleVOTransformer();
		model.setVille(villetrans.vo2Model(vo.getVilleVO()));
		return model;
	}

}
