package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class CaisseWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4845740600179370691L;
	private CaisseVO vo;

	/**
	 * The vos
	 */
	private List<CaisseVO> vos;

	/** The selected v os. */
	private List<CaisseVO> selectedVOs;

	private List<RestaurantVO> restaurantVOs;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public List<RestaurantVO> getRestaurantVOs() {
		return restaurantVOs;
	}

	public void setRestaurantVOs(List<RestaurantVO> RestaurantVOs) {
		this.restaurantVOs = RestaurantVOs;
	}

	public CaisseWebBean() {
		super();
		vo = new CaisseVO();
		vos = new ArrayList<CaisseVO>();
		selectedVOs = new ArrayList<CaisseVO>();
	}

	public CaisseVO getVo() {
		return vo;
	}

	public void setVo(CaisseVO vo) {
		this.vo = vo;
	}

	public List<CaisseVO> getVos() {
		return vos;
	}

	public void setVos(List<CaisseVO> vos) {
		this.vos = vos;
	}

	public List<CaisseVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<CaisseVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
