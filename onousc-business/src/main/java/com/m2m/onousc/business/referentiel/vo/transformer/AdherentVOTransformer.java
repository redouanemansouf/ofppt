package com.m2m.onousc.business.referentiel.vo.transformer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Adherent;
import com.m2m.onousc.business.referentiel.model.Borne;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.model.Tourniquet;
import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

public class AdherentVOTransformer extends
		BaseTransformer<Adherent, AdherentVO> {

	CategoriePorteurVOTransformer categoriePorteurVOTransformer = new CategoriePorteurVOTransformer();
	VilleVOTransformer villeVOTransformer = new VilleVOTransformer();
	PersonnelVOTransformer personnelVOTransformer = new PersonnelVOTransformer();
	TourniquetVOTransformer trnqvo = new TourniquetVOTransformer();
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");

	@Override
	public AdherentVO model2VO(Adherent model, boolean... forCombo) {
		AdherentVO vo = new AdherentVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setNom(model.getNom());
			vo.setPrenom(model.getPrenom());
		} else {
			vo = mapper.map(model, AdherentVO.class);
			vo.setTourniquetVO(trnqvo.model2VO(model.getTourniquet(), false));
		}
		return vo;
	}

	@Override
	public Adherent vo2Model(AdherentVO vo) {
		Adherent model = new Adherent();
	List<Tourniquet> tModels= new ArrayList<>();
		
		for(TourniquetVO object: vo.getTourniquetVO()){
			tModels.add(trnqvo.vo2Model(object));
		}
		
		model=  mapper.map(vo, Adherent.class) ;
		model.setTourniquet(tModels);
		return model;		
	//return mapper.map(vo, Adherent.class);
	}

}
