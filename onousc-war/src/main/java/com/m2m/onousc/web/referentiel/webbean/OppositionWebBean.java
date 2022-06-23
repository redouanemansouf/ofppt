package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.MotifMainLeveeVO;
import com.m2m.onousc.business.referentiel.vo.MotifOppositionVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class OppositionWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6195558298542787855L;

	private CarteVO vo;
	private List<CarteVO> vos;
	private List<CarteVO> selectedVOs;
	private CarteVO selectedVO;
	private CarteVO previousSelectedVO = new CarteVO();

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	private List<EtudiantVO> etudiantVOs;

	private List<MotifOppositionVO> opposVOs;

	private List<MotifMainLeveeVO> motifMainVOs;

	private String codeMassar;

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}

	public OppositionWebBean() {
		super();
		vo = new CarteVO();
		vos = new ArrayList<CarteVO>();
		selectedVOs = new ArrayList<CarteVO>();
		etudiantVOs = new ArrayList<EtudiantVO>();

	}

	public CarteVO getVo() {
		return vo;
	}

	public void setVo(CarteVO vo) {
		this.vo = vo;
	}

	public List<CarteVO> getVos() {
		return vos;
	}

	public void setVos(List<CarteVO> vos) {
		this.vos = vos;
	}

	public List<CarteVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<CarteVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public CarteVO getSelectedVO() {
		return selectedVO;
	}

	public void setSelectedVO(CarteVO selectedVO) {
		this.selectedVO = selectedVO;
	}

	public List<EtudiantVO> getEtudiantVOs() {
		return etudiantVOs;
	}

	public void setEtudiantVOs(List<EtudiantVO> etudiantVOs) {
		this.etudiantVOs = etudiantVOs;
	}

	public List<MotifOppositionVO> getOpposVOs() {
		return opposVOs;
	}

	public void setOpposVOs(List<MotifOppositionVO> opposVOs) {
		this.opposVOs = opposVOs;
	}

	public List<MotifMainLeveeVO> getMotifMainVOs() {
		return motifMainVOs;
	}

	public void setMotifMainVOs(List<MotifMainLeveeVO> motifMainVOs) {
		this.motifMainVOs = motifMainVOs;
	}

	public CarteVO getPreviousSelectedVO() {
		return previousSelectedVO;
	}

	public void setPreviousSelectedVO(CarteVO previousSelectedVO) {
		this.previousSelectedVO = previousSelectedVO;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
