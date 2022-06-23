package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class CategoriePorteurWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4332167668676400799L;
	/** The vo. */
	private CategoriePorteurVO vo;

	/** The vos. */
	private List<CategoriePorteurVO> vos;

	/** The selected v os. */
	private List<CategoriePorteurVO> selectedVOs;

	private String datedaf;

	private String datefaf;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public String getDatedaf() {
		return datedaf;
	}

	public void setDatedaf(String datedaf) {
		this.datedaf = datedaf;
	}

	public String getDatefaf() {
		return datefaf;
	}

	public void setDatefaf(String datefaf) {
		this.datefaf = datefaf;
	}

	public CategoriePorteurWebBean() {
		super();
		vo = new CategoriePorteurVO();
		vos = new ArrayList<CategoriePorteurVO>();
		selectedVOs = new ArrayList<CategoriePorteurVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public CategoriePorteurVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo the vo to set
	 */
	public void setVo(CategoriePorteurVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<CategoriePorteurVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos the vos to set
	 */
	public void setVos(List<CategoriePorteurVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<CategoriePorteurVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs the selectedVOs to set
	 */
	public void setSelectedVOs(List<CategoriePorteurVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
