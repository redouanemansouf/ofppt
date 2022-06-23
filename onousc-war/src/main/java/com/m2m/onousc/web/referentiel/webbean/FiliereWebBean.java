package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.FiliereVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class FiliereWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5312348707593422717L;

	private FiliereVO vo;

	/**
	 * The vos
	 */
	private List<FiliereVO> vos;

	/** The selected v os. */
	private List<FiliereVO> selectedVOs;

	private List<FiliereVO> selectedFilVOs;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public List<FiliereVO> getSelectedFilVOs() {
		return selectedFilVOs;
	}

	public void setSelectedFilVOs(List<FiliereVO> selectedFilVOs) {
		this.selectedFilVOs = selectedFilVOs;
	}

	public FiliereWebBean() {
		super();
		vo = new FiliereVO();
		vos = new ArrayList<FiliereVO>();
		selectedVOs = new ArrayList<FiliereVO>();
	}

	public FiliereVO getVo() {
		return vo;
	}

	public void setVo(FiliereVO vo) {
		this.vo = vo;
	}

	public List<FiliereVO> getVos() {
		return vos;
	}

	public void setVos(List<FiliereVO> vos) {
		this.vos = vos;
	}

	public List<FiliereVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<FiliereVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
