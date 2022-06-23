package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Caissier;
import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * 
 * @author abousnane
 * 
 */
public class CaissierVOTransformer extends BaseTransformer<Caissier, CaissierVO> {

	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();

	@Override
	public CaissierVO model2VO(Caissier model, boolean... forCombo) {
		CaissierVO vo = new CaissierVO();
		CaisseVOTransformer sertrans = new CaisseVOTransformer();
		CaisseVO svo = sertrans.model2VO(model.getCaisse(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
		} else {
			/*
			 * Objects.copyProperties(vo, model); vo.setCaisseVO(svo);
			 */
			vo = mapper.map(model, CaissierVO.class);
			if (model.getSite() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));
		}
		return vo;
	}

	@Override
	public Caissier vo2Model(CaissierVO vo) {
		Caissier model = new Caissier();
		/*
		 * Objects.copyProperties(model, vo); CaisseVOTransformer sertrans = new
		 * CaisseVOTransformer(); model.setCaisse(sertrans.vo2Model(vo.getCaisseVO()));
		 * return model;
		 */
		model = mapper.map(vo, Caissier.class);
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		return model;
	}

}
