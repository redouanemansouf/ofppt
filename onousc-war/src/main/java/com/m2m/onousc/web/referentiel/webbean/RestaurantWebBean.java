package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class RestaurantWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5312348707593422717L;

	private RestaurantVO vo;

	/**
	 * The vos
	 */
	private List<RestaurantVO> vos;

	/** The selected v os. */
	private List<RestaurantVO> selectedVOs;

	private List<CiteVO> citeVOs;

	private List<VilleVO> villeVOs;

	private List<RestaurantVO> selectedFilVOs;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public List<RestaurantVO> getSelectedFilVOs() {
		return selectedFilVOs;
	}

	public void setSelectedFilVOs(List<RestaurantVO> selectedFilVOs) {
		this.selectedFilVOs = selectedFilVOs;
	}

	public List<VilleVO> getVilleVOs() {
		return villeVOs;
	}

	public void setVilleVOs(List<VilleVO> villeVOs) {
		this.villeVOs = villeVOs;
	}

	public List<CiteVO> getCiteVOs() {
		return citeVOs;
	}

	public void setCiteVOs(List<CiteVO> citeVOs) {
		this.citeVOs = citeVOs;
	}

	public RestaurantWebBean() {
		super();
		vo = new RestaurantVO();
		vos = new ArrayList<RestaurantVO>();
		selectedVOs = new ArrayList<RestaurantVO>();
	}

	public RestaurantVO getVo() {
		return vo;
	}

	public void setVo(RestaurantVO vo) {
		this.vo = vo;
	}

	public List<RestaurantVO> getVos() {
		return vos;
	}

	public void setVos(List<RestaurantVO> vos) {
		this.vos = vos;
	}

	public List<RestaurantVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<RestaurantVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
