package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.dao.SiteDaoJpa;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.security.UserEntity;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class ProfilProduitVOTransformer
 * 
 * @version 1.0 05 jan. 2015
 * @author msadik
 */
public class UserEntityVOTransformer extends
		BaseTransformer<UserEntity, UserEntityVO> {
	
	SiteDaoJpa siteDaoJpa = (SiteDaoJpa) BeansLookuper
			.lookup("siteDaoJpa");

	@Override
	public UserEntityVO model2VO(UserEntity model, boolean... forCombo) {
		UserEntityVO vo = new UserEntityVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setUsername(model.getUsername());
			vo.setLastName(model.getLastName());
			vo.setFirstName(model.getFirstName());
			vo.setEmail(model.getEmail()); 
		} else {
			Objects.copyProperties(vo, model);
			if (model.getSite() != null) {
				vo.setSiteVO(new SiteVOTransformer().model2VO(
						siteDaoJpa.find(model.getSite()),false));
			}
		}
		return vo;
	}

	@Override
	public UserEntity vo2Model(UserEntityVO vo) {

		UserEntity model = new UserEntity();
		
		if (vo.getSiteVO() != null) {
			model.setSite(vo.getSiteVO().getId());
		}
	
		Objects.copyProperties(model, vo);
		return model;
	}



	
}
