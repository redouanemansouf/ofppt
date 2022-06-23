package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.vo.GroupUserVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class ProfilProduitVOTransformer
 * 
 * @version 1.0 05 jan. 2015
 * @author iissouani
 */
public class GroupUserVOTransformer extends
		BaseTransformer<GroupUser, GroupUserVO> {
	
	/** Le/La mapper. */
	

	@Override
	public GroupUserVO model2VO(GroupUser model, boolean... forCombo) {
		GroupUserVO vo = new GroupUserVO();
		
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setGroupname(model.getGroupname()); 
		} else {
			Objects.copyProperties(vo, model);  
		}
		return vo;
	}

	@Override
	public GroupUser vo2Model(GroupUserVO vo) {
		GroupUser model = new GroupUser();		
		Objects.copyProperties(model, vo);
		return model;
    
	}



	
}
