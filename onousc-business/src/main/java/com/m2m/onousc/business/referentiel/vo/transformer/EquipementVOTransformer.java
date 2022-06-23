package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Equipement;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.EquipementVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class EquipementVOTransformer extends
		BaseTransformer<Equipement, EquipementVO> {

	@Override
	public EquipementVO model2VO(Equipement model, boolean... forCombo) {
		EquipementVO vo = new EquipementVO();
		CiteVOTransformer citetrans = new CiteVOTransformer();
		RestaurantVOTransformer Restauranttrans = new RestaurantVOTransformer();
		CiteVO cvo = citetrans.model2VO(model.getCite(), forCombo);
		RestaurantVO rvo = Restauranttrans.model2VO(model.getRestaurant(),
				forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setCode(model.getCode());
		} else {
			Objects.copyProperties(vo, model);
			vo.setCiteVO(cvo);
			vo.setRestaurantVO(rvo);
		}
		return vo;
	}

	@Override
	public Equipement vo2Model(EquipementVO vo) {
		Equipement model = new Equipement();
		Objects.copyProperties(model, vo);
		CiteVOTransformer citetrans = new CiteVOTransformer();
		RestaurantVOTransformer Restauranttrans = new RestaurantVOTransformer();
		model.setCite(citetrans.vo2Model(vo.getCiteVO()));
		model.setRestaurant(Restauranttrans.vo2Model(vo.getRestaurantVO()));
		return model;
	}

}
