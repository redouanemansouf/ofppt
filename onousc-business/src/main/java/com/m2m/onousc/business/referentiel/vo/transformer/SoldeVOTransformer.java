/*
 * CarteVOTransformer.java
 *
 * Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.model.Site;
import com.m2m.onousc.business.referentiel.model.Solde;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.SoldeVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class CanalVenteVOTransformer.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class SoldeVOTransformer extends BaseTransformer<Solde, SoldeVO> {
	
	private ReferentielService parametreReferentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");
	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();
	@Override
	public SoldeVO model2VO(Solde model, boolean... forCombo) {
		SoldeVO vo = new SoldeVO();
		Objects.copyProperties(vo,model );
		vo.setMatr(model.getMatr());
		vo.setDate(model.getDate());
		vo.setMaj(model.getMaj());
		vo.setInit(model.getInit());
		
		if (model.getSite() != null)
			vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));
//		findPersonnelByMatr
		Personnel perso = parametreReferentielService.findPersonnelByMatr(model.getMatr());
		if (perso !=null)
		{
		vo.setNom(perso.getNom());
		vo.setPrenom(perso.getPrenom());
//		
		}
		//String gitnom;
//		String gitprenom;
//		gitnom= vo.getNom().getNom();
//		gitprenom = vo.getPrenom().getPrenom();
//		vo.setNom(gitnom);
		return vo;
	}

	@Override
	public Solde vo2Model(SoldeVO vo) {
		Solde model = new Solde();
		Site site = new Site();
		if (vo.getSiteVO() != null)
			site = siteVOTransformer.vo2Model(vo.getSiteVO());
		Objects.copyProperties(model, vo);
		model.setSite(site);
		return model;
	}

}
