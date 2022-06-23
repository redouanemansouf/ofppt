package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.onousc.business.referentiel.vo.BorneVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class BorneVOTransformer extends BaseTransformer<Borne, BorneVO> {

	@Override
	public BorneVO model2VO(Borne model, boolean... forCombo) {
		BorneVO vo = new BorneVO();
		SiteVOTransformer sitetrans = new SiteVOTransformer();
		SiteVO cvo = sitetrans.model2VO(model.getSite(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setCode(model.getCode());
		} else {
			Objects.copyProperties(vo, model);
			vo.setSiteVO(cvo);
		}
		return vo;
	}

	@Override
	public Borne vo2Model(BorneVO vo) {
		Borne model = new Borne();
		Objects.copyProperties(model, vo);
		SiteVOTransformer sitetrans = new SiteVOTransformer();
		model.setSite(sitetrans.vo2Model(vo.getSiteVO()));
		return model;
	}

}
