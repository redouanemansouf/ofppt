package com.m2m.onousc.business.referentiel.vo.transformer;

import com.m2m.onousc.business.referentiel.model.ConsultCaisse;
import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.ConsultCaisseVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

/**
 * 
 * @author abousnane
 * 
 */
public class ConsultCaisseVOTransformer extends
		BaseTransformer<ConsultCaisse, ConsultCaisseVO> {

	@Override
	public ConsultCaisseVO model2VO(ConsultCaisse model,
			boolean... forCombo) {
		ConsultCaisseVO vo = new ConsultCaisseVO();
		CaisseVOTransformer sertrans = new CaisseVOTransformer();
		ProduitVOTransformer prdtrans = new ProduitVOTransformer();
		EtudiantVOTransformer cattrans = new EtudiantVOTransformer();
		CaissierVOTransformer caitrans = new CaissierVOTransformer();
//		CaisseVO svo = sertrans.model2VO(model.getCaisse(), forCombo);
//		EtudiantVO cvo = cattrans.model2VO(model.getEtudiant(), forCombo);
//		CaissierVO caivo = caitrans.model2VO(model.getCaissier(), forCombo);
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
		} else {
			Objects.copyProperties(vo, model);
		//	if(sertrans.model2VO(model.getCaisse(), forCombo)!=null)
//			if(model.getCaisse()!=null){
//				vo.setCaisseVO(sertrans.model2VO(model.getCaisse(), forCombo));
//			} else {
//				vo.setCaisseVO(null);
//			}
//			
//			if(model.getProduit()!=null){
//				vo.setProduitVO(prdtrans.model2VO(model.getProduit(), forCombo));
//			} else {
//				vo.setProduitVO(null);
//			}
			

		}
		return vo;
	}

	@Override
	public ConsultCaisse vo2Model(ConsultCaisseVO vo) {
		ConsultCaisse model = new ConsultCaisse();
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
