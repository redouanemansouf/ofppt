package com.m2m.onousc.business.referentiel.vo.transformer;

import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.m2m.onousc.business.referentiel.model.CategoriePorteur;
import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.technicalservices.core.BaseTransformer;
import com.m2m.technicalservices.tools.Objects;

public class CategoriePorteurVOTransformer extends BaseTransformer<CategoriePorteur, CategoriePorteurVO> {

	SiteVOTransformer siteVOTransformer = new SiteVOTransformer();

	@Override
	public CategoriePorteurVO model2VO(CategoriePorteur model, boolean... forCombo) {
		CategoriePorteurVO vo = new CategoriePorteurVO();
		if (forCombo.length > 0 && forCombo[0]) {
			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			if (model.getCategorie() == "etudiantb") {
				vo.setCategorie("Etudiant Boursier");
			}
			if (model.getCategorie() == "etudiantn") {
				vo.setCategorie("Etudiant Non Boursier");
			}
			vo.setCode(model.getCode());
			vo.setRatio(model.getRatio());
			vo.setDated(model.getDated());
			vo.setDatef(model.getDatef());

			Date date1 = vo.getDated();
			Date date2 = vo.getDatef();

			DateTime dt1 = new DateTime(date1);
			LocalDate localDate1 = dt1.toLocalDate();

			DateTime dt2 = new DateTime(date2);
			LocalDate localDate2 = dt2.toLocalDate();

			int month1 = localDate1.getMonthOfYear();
			int day1 = localDate1.getDayOfMonth();

			int month2 = localDate2.getMonthOfYear();
			int day2 = localDate2.getDayOfMonth();

			/** Date Debut **/

			if (month1 == 1) {
				String sdt1 = day1 + " " + "Janvier";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 2) {
				String sdt1 = day1 + " " + "Fevrier";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 3) {
				String sdt1 = day1 + " " + "Mars";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 4) {
				String sdt1 = day1 + " " + "Avril";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 5) {
				String sdt1 = day1 + " " + "Mai";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 6) {
				String sdt1 = day1 + " " + "Juin";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 7) {
				String sdt1 = day1 + " " + "Juillet";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 8) {
				String sdt1 = day1 + " " + "Aout";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 9) {
				String sdt1 = day1 + " " + "Septembre";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 10) {
				String sdt1 = day1 + " " + "Octobre";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 11) {
				String sdt1 = day1 + " " + "Novembre";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 12) {
				String sdt1 = day1 + " " + "Decembre";
				vo.setDatedaf(sdt1);
			}

			/** Date Fin **/

			if (month2 == 1) {
				String sdt2 = day2 + " " + "Janvier";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 2) {
				String sdt2 = day2 + " " + "Fevrier";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 3) {
				String sdt2 = day2 + " " + "Mars";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 4) {
				String sdt2 = day2 + " " + "Avril";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 5) {
				String sdt2 = day2 + " " + "Mai";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 6) {
				String sdt2 = day2 + " " + "Juin";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 7) {
				String sdt2 = day2 + " " + "Juillet";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 8) {
				String sdt2 = day2 + " " + "Aout";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 9) {
				String sdt2 = day2 + " " + "Septembre";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 10) {
				String sdt2 = day2 + " " + "Octobre";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 11) {
				String sdt2 = day2 + " " + "Novembre";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 12) {
				String sdt2 = day2 + " " + "Decembre";
				vo.setDatefaf(sdt2);
			}

//			String sdt1 = day1 + "/" + month1;
//			String sdt2 = day2 + "/" + month2;
//			vo.setDatedaf(sdt1);
//			vo.setDatefaf(sdt2);

		} else {
			Objects.copyProperties(vo, model);

			vo.setId(model.getId());
			vo.setLibelle(model.getLibelle());
			vo.setCategorie(model.getCategorie());

//			if(vo.getCategorie().contains("etudiantb"))
//			{
//				vo.setCategorie("Etudiant Boursier");
//			}
//			if(model.getCategorie().contains("etudiantn"))
//			{
//				vo.setCategorie("Etudiant Non Boursier");
//			}
			vo.setCode(model.getCode());
			vo.setRatio(model.getRatio());
			vo.setDated(model.getDated());
			vo.setDatef(model.getDatef());

			Date date1 = vo.getDated();
			Date date2 = vo.getDatef();

			DateTime dt1 = new DateTime(date1);
			LocalDate localDate1 = dt1.toLocalDate();

			DateTime dt2 = new DateTime(date2);
			LocalDate localDate2 = dt2.toLocalDate();

			int month1 = localDate1.getMonthOfYear();
			int day1 = localDate1.getDayOfMonth();

			int month2 = localDate2.getMonthOfYear();
			int day2 = localDate2.getDayOfMonth();

			/** Date Debut **/

			if (month1 == 1) {
				String sdt1 = day1 + " " + "Janvier";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 2) {
				String sdt1 = day1 + " " + "Fevrier";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 3) {
				String sdt1 = day1 + " " + "Mars";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 4) {
				String sdt1 = day1 + " " + "Avril";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 5) {
				String sdt1 = day1 + " " + "Mai";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 6) {
				String sdt1 = day1 + " " + "Juin";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 7) {
				String sdt1 = day1 + " " + "Juillet";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 8) {
				String sdt1 = day1 + " " + "Aout";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 9) {
				String sdt1 = day1 + " " + "Septembre";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 10) {
				String sdt1 = day1 + " " + "Octobre";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 11) {
				String sdt1 = day1 + " " + "Novembre";
				vo.setDatedaf(sdt1);
			}
			if (month1 == 12) {
				String sdt1 = day1 + " " + "Decembre";
				vo.setDatedaf(sdt1);
			}

			/** Date Fin **/

			if (month2 == 1) {
				String sdt2 = day2 + " " + "Janvier";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 2) {
				String sdt2 = day2 + " " + "Fevrier";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 3) {
				String sdt2 = day2 + " " + "Mars";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 4) {
				String sdt2 = day2 + " " + "Avril";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 5) {
				String sdt2 = day2 + " " + "Mai";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 6) {
				String sdt2 = day2 + " " + "Juin";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 7) {
				String sdt2 = day2 + " " + "Juillet";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 8) {
				String sdt2 = day2 + " " + "Aout";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 9) {
				String sdt2 = day2 + " " + "Septembre";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 10) {
				String sdt2 = day2 + " " + "Octobre";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 11) {
				String sdt2 = day2 + " " + "Novembre";
				vo.setDatefaf(sdt2);
			}
			if (month2 == 12) {
				String sdt2 = day2 + " " + "Decembre";
				vo.setDatefaf(sdt2);
			}

			if (model.getSite() != null)
				vo.setSiteVO(siteVOTransformer.model2VO(model.getSite(), false));

//			String sdt1 = day1 + "-" + month1;
//			String sdt2 = day2 + "-" + month2;
//			vo.setDatedaf(sdt1);
//			vo.setDatefaf(sdt2);

		}
		return vo;
	}

	@Override
	public CategoriePorteur vo2Model(CategoriePorteurVO vo) {
		CategoriePorteur model = new CategoriePorteur();
		Objects.copyProperties(model, vo);
		if (vo.getSiteVO() != null)
			model.setSite(siteVOTransformer.vo2Model(vo.getSiteVO()));
		return model;
	}

}