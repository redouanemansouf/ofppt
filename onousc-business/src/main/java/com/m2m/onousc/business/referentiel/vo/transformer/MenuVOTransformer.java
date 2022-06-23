package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Menu;
import com.m2m.onousc.business.referentiel.vo.MenuVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class MenuVOTransformer extends
		BaseTransformer<Menu, MenuVO> {

	/* (non-Javadoc)
	 * @see com.m2m.technicalServices.core.ITransformer#model2VO(com.m2m.technicalServices.dao.impl.GenericEntity, boolean[])
	 */
	@Override
	public MenuVO model2VO(Menu model, boolean... forCombo) {
		MenuVO vo = new MenuVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setCode(model.getCode());
			vo.setLibelle(model.getLibelle());
		} else {
			Objects.copyProperties(vo, model); 
		}
		return vo;
	}

	/* (non-Javadoc)
	 * @see com.m2m.technicalServices.core.ITransformer#vo2Model(com.m2m.technicalServices.core.ValueObject)
	 */
	@Override
	public Menu vo2Model(MenuVO vo) {
		Menu model = new Menu();
		Objects.copyProperties(model, vo);
		return model;
	}

}
