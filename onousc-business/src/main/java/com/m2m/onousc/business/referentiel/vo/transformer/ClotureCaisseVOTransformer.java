package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.ClotureCaisse;
import com.m2m.onousc.business.referentiel.vo.ClotureCaisseVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class ClotureCaisseVOTransformer extends
		BaseTransformer<ClotureCaisse, ClotureCaisseVO> {

	CaisseVOTransformer caisseVOTransformer = new CaisseVOTransformer();
	CaissierVOTransformer caissierVOTransformer = new CaissierVOTransformer();

	@Override
	public ClotureCaisseVO model2VO(ClotureCaisse model, boolean... forCombo) {
		ClotureCaisseVO vo = new ClotureCaisseVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());

		} else {
			Objects.copyProperties(vo, model);
			vo.setCaissevo(caisseVOTransformer.model2VO(model.getCaisse()));
			vo.setCaissiervo(caissierVOTransformer.model2VO(model.getCaissier()));
		}

		return vo;
	}

	@Override
	public ClotureCaisse vo2Model(ClotureCaisseVO vo) {
		ClotureCaisse model = new ClotureCaisse();
		Objects.copyProperties(model, vo);
		model.setCaisse(caisseVOTransformer.vo2Model(vo.getCaissevo()));
		model.setCaissier(caissierVOTransformer.vo2Model(vo.getCaissiervo()));
		return model;
	}

}
