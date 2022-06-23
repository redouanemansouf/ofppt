package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.ImportInscription;
import com.m2m.onousc.business.referentiel.vo.ImportInscriptionVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class ImportInscriptionVOTransformer extends BaseTransformer<ImportInscription, ImportInscriptionVO>{

	@Override
	public ImportInscriptionVO model2VO(ImportInscription model,
			boolean... forCombo) {
		ImportInscriptionVO vo = new ImportInscriptionVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setCin(model.getCin());
			vo.setCodeMassar(model.getCodeMassar());
		} else {
			Objects.copyProperties(vo, model);
		}
		return vo;
	}

	@Override
	public ImportInscription vo2Model(ImportInscriptionVO vo) {
		ImportInscription model = new ImportInscription();
		Objects.copyProperties(model, vo);
		return model;
	}

}
