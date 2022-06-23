package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.model.Universite;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.UniversiteVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

public class CiteVOTransformer extends BaseTransformer<Cite, CiteVO> {
	
	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");

	@Override
	public CiteVO model2VO(Cite model, boolean... forCombo) {
		CiteVO vo = new CiteVO();
		UniversiteVOTransformer unitrans = new UniversiteVOTransformer();
		UniversiteVO univo = new UniversiteVO();
		univo = unitrans.model2VO(model.getUniversite(), forCombo);
//		VilleVOTransformer villetrans = new VilleVOTransformer();
//		VilleVO villeVO = villetrans.model2VO(model.getVille(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCode(model.getCode());
			vo.setAdresseCite(model.getAdresseCite());
			vo.setAdresseEmailCite(model.getAdresseEmailCite());
			vo.setNomResponsableCite(model.getNomResponsableCite());
			vo.setNumTeleCite(model.getNumTeleCite());
			vo.setPrenomResponsableCite(model.getPrenomResponsableCite());
			vo.setUniversite(univo);

		} else {
			/*Objects.copyProperties(vo, model);
		
			if(unitrans.model2VO(model.getUniversite(), forCombo)!=null)
				vo.setUniversiteVO(unitrans.model2VO(model.getUniversite(), forCombo));
			vo.setVilleVO(villeVO);*/
			vo = mapper.map(model, CiteVO.class);
		}
		return vo;
	}

	@Override
	public Cite vo2Model(CiteVO vo) {
	/*	Cite model = new Cite();
		Objects.copyProperties(model, vo);
		UniversiteVOTransformer unitrans = new UniversiteVOTransformer();
		Universite univ = new Universite();
		univ = unitrans.vo2Model(vo.getUniversiteVO());
		model.setUniversite(univ);
		VilleVOTransformer villetrans = new VilleVOTransformer();
		model.setVille(villetrans.vo2Model(vo.getVilleVO()));*/
		return mapper.map(vo, Cite.class);
	}

}
