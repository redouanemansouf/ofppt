package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.TarifVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * 
 * @author abousnane
 *
 */
public class TarifVOTransformer extends
BaseTransformer<Tarif, TarifVO>{

	@Override
	public TarifVO model2VO(Tarif model, boolean... forCombo) {
		TarifVO vo = new TarifVO();
		ServiceVOTransformer sertrans = new ServiceVOTransformer();
		CategoriePorteurVOTransformer cattrans = new CategoriePorteurVOTransformer();
		ServiceVO svo = sertrans.model2VO(model.getService(), forCombo);
		CategoriePorteurVO cvo = cattrans.model2VO(model.getCategoriePorteur(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			Objects.copyProperties(vo, model);
			vo.setServiceVO(svo);
			vo.setCategoriePorteurVO(cvo);
		}
		return vo;
	}

	@Override
	public Tarif vo2Model(TarifVO vo) {
		Tarif model = new Tarif();
		Objects.copyProperties(model, vo);
		ServiceVOTransformer sertrans = new ServiceVOTransformer();
		CategoriePorteurVOTransformer cattrans = new CategoriePorteurVOTransformer();
		model.setService(sertrans.vo2Model(vo.getServiceVO()));
		model.setCategoriePorteur(cattrans.vo2Model(vo.getCategoriePorteurVO()));
		return model;
	}

}
