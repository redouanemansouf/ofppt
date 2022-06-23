package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.vo.TraceEntityVO;
import com.m2m.technicalservices.audit.impl.TraceEntity;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * The Class ProfilProduitVOTransformer
 * 
 * @version 1.0 05 jan. 2015
 * @author iissouani
 *
 */
public class TraceEntityVOTransformer extends
		BaseTransformer<TraceEntity, TraceEntityVO> {

	@Override
	public TraceEntityVO model2VO(TraceEntity model, boolean... forCombo) {
		TraceEntityVO vo = new TraceEntityVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setIdEntity(model.getId_Entity());
		} else {
			
			Objects.copyProperties(vo, model);
			if(vo.getNameEntity().endsWith("Personnel"))
			{
				vo.setNameEntity("Personnel");
			}
			if(vo.getNameEntity().endsWith("CarteNaps"))
			{
				vo.setNameEntity("Import");
			}
			if(vo.getNameEntity().endsWith("CanalVente"))
			{
				vo.setNameEntity("Famille-Produit");
			}
			if(vo.getNameEntity().endsWith("Produit"))
			{
				vo.setNameEntity("Produit");
			}
			if(vo.getNameEntity().endsWith("CategoriePorteur"))
			{
				vo.setNameEntity("Profil-Porteur");
			}
			if(vo.getNameEntity().endsWith("Caisse"))
			{
				vo.setNameEntity("Caisse");
			}
			if(vo.getNameEntity().endsWith("Caissier"))
			{
				vo.setNameEntity("Caissier");
			}
			if(vo.getNameEntity().endsWith("Restaurant"))
			{
				vo.setNameEntity("Restaurant");
			}
			if(vo.getNameEntity().endsWith("UserEntity"))
			{
				vo.setNameEntity("Utilisateurs");
			}
			if(vo.getNameEntity().endsWith("GroupUser"))
			{
				vo.setNameEntity("Groupes-Administrateurs");
			}
			
		}
		return vo;
	}

	@Override
	public TraceEntity vo2Model(TraceEntityVO vo) {

		TraceEntity model = new TraceEntity();
	
		Objects.copyProperties(model, vo); 
		return model;
	}



	
}
