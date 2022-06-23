package com.m2m.onousc.business.referentiel.vo.transformer;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2m.onousc.business.referentiel.dao.UserEntityDaoJpa;
import com.m2m.onousc.business.referentiel.dao.impl.UserEntityDaoImpl;
import com.m2m.onousc.business.referentiel.vo.WinMenuVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.security.WinMenu;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class ProfilProduitVOTransformer
 * 
 * @version 1.0 05 jan. 2015
 * @author msadik
 */
public class WinMenuVOTransformer extends
		BaseTransformer<WinMenu, WinMenuVO> {
	
	@Autowired
	private UserEntityDaoJpa userEntityDaoJpa = (UserEntityDaoJpa) BeansLookuper.lookup("userDao");  

	@Override
	public WinMenuVO model2VO(WinMenu model, boolean... forCombo) {
		WinMenuVO vo = new WinMenuVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setOperateur(model.getOperateur());
			vo.setAbbrev(model.getAbbrev());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
		} else {
			if("O".equals(model.getType())){
				if(userEntityDaoJpa.findByCode(model.getOperateur())!=null)   
					vo.setGroupOperateur(userEntityDaoJpa.findByCode(model.getOperateur()).getGroupname());
			} 
			Objects.copyProperties(vo, model);
		}
		return vo;
	}

	@Override
	public WinMenu vo2Model(WinMenuVO vo) {

		WinMenu model = new WinMenu();
	 
		Objects.copyProperties(model, vo);
		return model;
	}



	
}
