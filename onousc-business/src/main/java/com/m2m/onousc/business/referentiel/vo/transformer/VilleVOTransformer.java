package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Ville;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

public class VilleVOTransformer extends
		BaseTransformer<Ville, VilleVO> {

	
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	/* (non-Javadoc)
	 * @see com.m2m.technicalServices.core.ITransformer#model2VO(com.m2m.technicalServices.dao.impl.GenericEntity, boolean[])
	 */
	@Override
	public VilleVO model2VO(Ville model, boolean... forCombo) {
		VilleVO vo = new VilleVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
		} else {
//			Objects.copyProperties(vo, model);
			vo = mapper.map(model, VilleVO.class);
		}
		return vo;
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalServices.core.ITransformer#vo2Model(com.m2m.technicalServices.core.ValueObject)
	 */
	@Override
	public Ville vo2Model(VilleVO vo) {
		Ville model = new Ville();
//		Objects.copyProperties(model, vo);
		model = mapper.map(vo, Ville.class);
		return model;
	}

}
