package com.m2m.onousc.business.referentiel.vo.transformer;

import org.dozer.Mapper;

import com.m2m.onousc.business.referentiel.model.Produit;
import com.m2m.onousc.business.referentiel.model.Restaurant;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

public class ProduitVOTransformer extends BaseTransformer<Produit, ProduitVO> {

	Mapper mapper = (Mapper) BeansLookuper.lookup("dozerMapper");
	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();
	CanalVenteVOTransformer canalVenteVOTransformer = new CanalVenteVOTransformer();

	@Override
	public ProduitVO model2VO(Produit model, boolean... forCombo) {
		ProduitVO vo = new ProduitVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setCode(model.getCode());
			vo.setLibelle(model.getLibelle());
			vo.setMontant(model.getMontant());
			vo.setTva(model.getTva());
			if (vo.isSub() == true) {
				vo.setSubaf("Oui");
			} else {
				vo.setSubaf("Non");
			}
//			if(model.getStatut().equals(EntityStatus.ENABLED))
//			{
//			vo.setReference("Active");
//			}
//			else
//			{
//				vo.setReference("Desactive");
//			}
		} else {
			vo = mapper.map(model, ProduitVO.class);
			if (vo.isSub() == true) {
				vo.setSubaf("Oui");
			} else {
				vo.setSubaf("Non");
			}

			if (model.getSite() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));

//			if(model.getStatut().equals(EntityStatus.ENABLED) )
//			{
//			vo.setReference("Active");
//			}
//			else
//			{
//				vo.setReference("Desactive");
//			}
		}
		return vo;
	}

	@Override
	public Produit vo2Model(ProduitVO vo) {
		// return mapper.map(vo, Produit.class);
		Produit model = new Produit();
		//Objects.copyProperties(model, vo);
		model = mapper.map(vo, Produit.class);
		if (vo.getFamilleProd() != null)
			model.setFamilleProd(canalVenteVOTransformer.vo2Model(vo.getFamilleProd()));
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		return model;
	}

}
