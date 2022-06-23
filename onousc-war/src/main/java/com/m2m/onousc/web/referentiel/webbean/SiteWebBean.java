package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * The Class SiteWebBean.
 */
public class SiteWebBean extends BaseWebBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8738764930312743199L;

	/** The vo. */
	private SiteVO vo;

	/** The vos. */
	private List<SiteVO> vos;

	private List<VilleVO> villeVOs;

	/** The selected v os. */
	private List<SiteVO> selectedVOs;

//	private List<RestaurantVO> restaurantVOs;

	public SiteWebBean() {
		super();
		vo = new SiteVO();
		vos = new ArrayList<SiteVO>();
		selectedVOs = new ArrayList<SiteVO>();
	}

//
//	public List<RestaurantVO> getRestaurantVOs() {
//		return restaurantVOs;
//	}
//
//
//
//	public void setRestaurantVOs(List<RestaurantVO> restaurantVOs) {
//		this.restaurantVOs = restaurantVOs;
//	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public SiteVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo the vo to set
	 */
	public void setVo(SiteVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<SiteVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos the vos to set
	 */
	public void setVos(List<SiteVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<SiteVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs the selectedVOs to set
	 */
	public void setSelectedVOs(List<SiteVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<VilleVO> getVilleVOs() {
		return villeVOs;
	}

	public void setVilleVOs(List<VilleVO> villeVOs) {
		this.villeVOs = villeVOs;
	}

}
