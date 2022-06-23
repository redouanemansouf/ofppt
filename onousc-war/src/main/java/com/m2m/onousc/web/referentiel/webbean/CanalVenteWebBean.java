package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteWebBean.
 */
public class CanalVenteWebBean extends BaseWebBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8738764930312743199L;

	/** The vo. */
	private CanalVenteVO vo;

	/** The vos. */
	private List<CanalVenteVO> vos;

	/** The selected v os. */
	private List<CanalVenteVO> selectedVOs;

	private List<RestaurantVO> restaurantVOs;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public CanalVenteWebBean() {
		super();
		vo = new CanalVenteVO();
		vos = new ArrayList<CanalVenteVO>();
		selectedVOs = new ArrayList<CanalVenteVO>();
	}

	public List<RestaurantVO> getRestaurantVOs() {
		return restaurantVOs;
	}

	public void setRestaurantVOs(List<RestaurantVO> restaurantVOs) {
		this.restaurantVOs = restaurantVOs;
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public CanalVenteVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo the vo to set
	 */
	public void setVo(CanalVenteVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<CanalVenteVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos the vos to set
	 */
	public void setVos(List<CanalVenteVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<CanalVenteVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs the selectedVOs to set
	 */
	public void setSelectedVOs(List<CanalVenteVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
