/*
 * CanalVenteVOTransformer.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Etudiants;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteVOTransformer.
 * 
 * @version 1.0 24 nov. 2014
 * @author msadik
 */
public class EtudiantVOTransformer extends BaseTransformer<Etudiants, EtudiantVO> {

	CiteVOTransformer citetransformer = new CiteVOTransformer();
	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();
	RestaurantVOTransformer restaurantvotransformer = new RestaurantVOTransformer();
	NoteCritereVOTransformer noteCritereVOTransformer = new NoteCritereVOTransformer();
	AnneeUniversitaireVOTransformer anneeUniVOTransformer = new AnneeUniversitaireVOTransformer();

	@Override
	public EtudiantVO model2VO(Etudiants model, boolean... forCombo) {
		EtudiantVO vo = new EtudiantVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setNom(model.getNom());
			vo.setPrenom(model.getPrenom());
		} else {
			Objects.copyProperties(vo, model);
			// vo.setCitovo(citetransformer.model2VO(model.getCite()));
			if (model.getSite() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite()));
			if (model.getRestaurant() != null)
				vo.setRestaurantVO(restaurantvotransformer.model2VO(model.getRestaurant()));
			vo.setNoteCritereVOs(noteCritereVOTransformer.model2VO(model.getNoteCritere(), false));
			vo.setAnneeUniversitaireVO(anneeUniVOTransformer.model2VO(model.getAnneeUniversitaire(), forCombo));
		}
		return vo;
	}

	@Override
	public Etudiants vo2Model(EtudiantVO vo) {
		Etudiants model = new Etudiants();
		Objects.copyProperties(model, vo);
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		// model.setCite(citetransformer.vo2Model(vo.getCitovo()));
		if (vo.getRestaurantVO() != null)
			model.setRestaurant(restaurantvotransformer.vo2Model(vo.getRestaurantVO()));
		model.setNoteCritere(noteCritereVOTransformer.vo2Model(vo.getNoteCritereVOs()));
		model.setAnneeUniversitaire(anneeUniVOTransformer.vo2Model(vo.getAnneeUniversitaireVO()));
		return model;
	}

}
