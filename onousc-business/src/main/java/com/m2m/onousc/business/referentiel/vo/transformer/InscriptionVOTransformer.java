package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.Inscription;
import com.m2m.onousc.business.referentiel.vo.InscriptionVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class InscriptionVOTransformer extends BaseTransformer<Inscription, InscriptionVO> {

	AnneeUniversitaireVOTransformer anneeUniversitaireVOTransformer = new AnneeUniversitaireVOTransformer();
	VilleVOTransformer villeVOTransformer = new VilleVOTransformer();
	RestaurantVOTransformer restaurantVOTransformer = new RestaurantVOTransformer();
	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();

	@Override
	public InscriptionVO model2VO(Inscription model, boolean... forCombo) {
		InscriptionVO vo = new InscriptionVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setCin(model.getCin());
			vo.setCodeMassar(model.getCodeMassar());
			vo.setEtablissement(model.getEtablissement());
		} else {
			Objects.copyProperties(vo, model);
			vo.setAnneUniversitaireVO(anneeUniversitaireVOTransformer.model2VO(model.getAnneUniversitaire(), false));
			vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));
			if (model.getRestaurant() != null)
				vo.setRestaurantVO(restaurantVOTransformer.model2VO(model.getRestaurant(), false));
			if (model.getVilleRestaurant() != null)
				vo.setVilleRestaurantVO(villeVOTransformer.model2VO(model.getVilleRestaurant(), false));
			if (model.getVille() != null)
				vo.setVilleVO(villeVOTransformer.model2VO(model.getVille(), false));
		}
		return vo;
	}

	@Override
	public Inscription vo2Model(InscriptionVO vo) {
		Inscription model = new Inscription();
		Objects.copyProperties(model, vo);
		model.setAnneUniversitaire(anneeUniversitaireVOTransformer.vo2Model(vo.getAnneUniversitaireVO()));
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		if (vo.getRestaurantVO() != null)
			model.setRestaurant(restaurantVOTransformer.vo2Model(vo.getRestaurantVO()));
		if (vo.getVilleRestaurantVO() != null)
			model.setVilleRestaurant(villeVOTransformer.vo2Model(vo.getVilleRestaurantVO()));
		if (vo.getVilleVO() != null)
			model.setVille(villeVOTransformer.vo2Model(vo.getVilleVO()));
		return model;
	}

}
