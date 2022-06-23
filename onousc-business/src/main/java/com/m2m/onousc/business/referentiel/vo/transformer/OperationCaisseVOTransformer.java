package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.OperationCaisse;
import com.m2m.onousc.business.referentiel.model.Personnel;
import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.OperationCaisseVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.tools.Objects;

/**
 * 
 * @author abousnane
 * 
 */
public class OperationCaisseVOTransformer extends
		BaseTransformer<OperationCaisse, OperationCaisseVO> {
	
	private ReferentielService parametreReferentielService = (ReferentielService) BeansLookuper
			.lookup("referentielService");

	@Override
	public OperationCaisseVO model2VO(OperationCaisse model,
			boolean... forCombo) {
		OperationCaisseVO vo = new OperationCaisseVO();
		CaisseVOTransformer sertrans = new CaisseVOTransformer();
		ProduitVOTransformer prdtrans = new ProduitVOTransformer();
		EtudiantVOTransformer cattrans = new EtudiantVOTransformer();
		CaissierVOTransformer caitrans = new CaissierVOTransformer();
//		CaisseVO svo = sertrans.model2VO(model.getCaisse(), forCombo);
//		EtudiantVO cvo = cattrans.model2VO(model.getEtudiant(), forCombo);
//		CaissierVO caivo = caitrans.model2VO(model.getCaissier(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			Personnel perso = parametreReferentielService.findPersonnelByMatr(model.getMatricule());
			
			vo.setNom(new PersonnelVOTransformer().model2VO(perso));
			vo.setPrenom(new PersonnelVOTransformer().model2VO(perso));
		} else {
			Objects.copyProperties(vo, model);
Personnel perso = parametreReferentielService.findPersonnelByMatr(model.getMatricule());
			
			vo.setNom(new PersonnelVOTransformer().model2VO(perso));
			vo.setPrenom(new PersonnelVOTransformer().model2VO(perso));
		//	if(sertrans.model2VO(model.getCaisse(), forCombo)!=null)
			if(model.getCaisse()!=null){
				vo.setCaisseVO(sertrans.model2VO(model.getCaisse(), forCombo));
			} else {
				vo.setCaisseVO(null);
			}
			
			if(model.getProduit()!=null){
				vo.setProduitVO(prdtrans.model2VO(model.getProduit(), forCombo));
			} else {
				vo.setProduitVO(null);
			}
			
			
//			if(cattrans.model2VO(model.getEtudiant(), forCombo)!=null)
//			vo.setEtudiantVO(cattrans.model2VO(model.getEtudiant(), forCombo));
//			if(caitrans.model2VO(model.getCaissier(), forCombo)!=null)
//			vo.setCaissierVO(caitrans.model2VO(model.getCaissier(), forCombo));
		}
		return vo;
	}

	@Override
	public OperationCaisse vo2Model(OperationCaisseVO vo) {
		OperationCaisse model = new OperationCaisse();
		Objects.copyProperties(model, vo);
		CaisseVOTransformer sertrans = new CaisseVOTransformer();
		EtudiantVOTransformer cattrans = new EtudiantVOTransformer();
		CaissierVOTransformer caitrans = new CaissierVOTransformer();
//		model.setCaisse(sertrans.vo2Model(vo.getCaisseVO()));
//		model.setEtudiant(cattrans.vo2Model(vo.getEtudiantVO()));
//		model.setCaissier(caitrans.vo2Model(vo.getCaissierVO()));
		return model;
	}

}
