package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.SoldeVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class SoldeWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6195558298542787855L;

	private SoldeVO vo;
	private List<SoldeVO> vos;
	private List<SoldeVO> selectedVOs;
	private SoldeVO selectedVO;
	private PersonnelVO nom;
	private long RSolde;
	private PersonnelVO prenom;
	private SoldeVO previousSelectedVO = new SoldeVO();
	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public PersonnelVO getNom() {
		return nom;
	}

	public void setNom(PersonnelVO nom) {
		this.nom = nom;
	}

	public PersonnelVO getPrenom() {
		return prenom;
	}

	public void setPrenom(PersonnelVO prenom) {
		this.prenom = prenom;
	}

	public SoldeWebBean() {
		super();
		vo = new SoldeVO();
		vos = new ArrayList<SoldeVO>();
		selectedVOs = new ArrayList<SoldeVO>();
	}

	public SoldeVO getVo() {
		return vo;
	}

	public void setVo(SoldeVO vo) {
		this.vo = vo;
	}

	public List<SoldeVO> getVos() {
		return vos;
	}

	public void setVos(List<SoldeVO> vos) {
		this.vos = vos;
	}

	public List<SoldeVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<SoldeVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public SoldeVO getSelectedVO() {
		return selectedVO;
	}

	public void setSelectedVO(SoldeVO selectedVO) {
		this.selectedVO = selectedVO;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

	public SoldeVO getPreviousSelectedVO() {
		return previousSelectedVO;
	}

	public void setPreviousSelectedVO(SoldeVO previousSelectedVO) {
		this.previousSelectedVO = previousSelectedVO;
	}

	public long getRSolde() {
		return RSolde;
	}

	public void setRSolde(long rSolde) {
		RSolde = rSolde;
	}

}
