package com.m2m.onousc.business.referentiel.vo.transformer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;

public class PersonnelVOTransformer extends BaseTransformer<Personnel, PersonnelVO> {

	CategoriePorteurVOTransformer categoriePorteurVOTransformer = new CategoriePorteurVOTransformer();
	VilleVOTransformer villeVOTransformer = new VilleVOTransformer();
	TourniquetVOTransformer trnqvo = new TourniquetVOTransformer();
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();

	@Override
	public PersonnelVO model2VO(Personnel model, boolean... forCombo) {
		PersonnelVO vo = new PersonnelVO();
		if (model == null) {
			return null;
		}
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setMatr(model.getMatr());
			vo.setPrenom(model.getPrenom());
			vo.setNom(model.getNom());
			vo.setPrenom(model.getPrenom());
		} else {
			vo = mapper.map(model, PersonnelVO.class);
			vo.setTouniquetVO(trnqvo.model2VO(model.getTourniquet(), false));
//			if(model.getStatut().equals(EntityStatus.ENABLED) )
//			{
//			vo.setReference("Active");
//			}
//			else
//			{
//				vo.setReference("Desactive");
//			}
			if (model.getSite() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));

		}

		return vo;
	}

	@Override
	public Personnel vo2Model(PersonnelVO vo) {
		Personnel model = new Personnel();
//		Objects.copyProperties(model, vo);	
//		model.setCategorie(categoriePorteurVOTransformer.vo2Model(vo
//				.getCategorieVO()));
//		model.setLieuNaissance(villeVOTransformer.vo2Model(vo
//				.getLieuNaissance()));
		// Objects.copyProperties(model, vo);

		List<Tourniquet> tModels = new ArrayList<>();

		for (TourniquetVO object : vo.getTourniquetVO()) {
			tModels.add(trnqvo.vo2Model(object));
		}

		model = mapper.map(vo, Personnel.class);
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		model.setTourniquet(tModels);
		return model;
		// return mapper.map(vo, Personnel.class) ;
	}

}
