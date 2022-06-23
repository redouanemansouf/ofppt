package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.EquipementVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class EquipementWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4845740600179370691L;
	private EquipementVO vo;

	/**
	 * The vos
	 */
	private List<EquipementVO> vos;

	/** The selected v os. */
	private List<EquipementVO> selectedVOs;

	private List<CiteVO> citeVOs;

	private List<RestaurantVO> restaurantVOs;

	public List<RestaurantVO> getRestaurantVOs() {
		return restaurantVOs;
	}

	public void setRestaurantVOs(List<RestaurantVO> RestaurantVOs) {
		this.restaurantVOs = RestaurantVOs;
	}

	public EquipementWebBean() {
		super();
		vo = new EquipementVO();
		vos = new ArrayList<EquipementVO>();
		selectedVOs = new ArrayList<EquipementVO>();
	}

	public EquipementVO getVo() {
		return vo;
	}

	public void setVo(EquipementVO vo) {
		this.vo = vo;
	}

	public List<EquipementVO> getVos() {
		return vos;
	}

	public void setVos(List<EquipementVO> vos) {
		this.vos = vos;
	}

	public List<EquipementVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<EquipementVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<CiteVO> getCiteVOs() {
		return citeVOs;
	}

	public void setCiteVOs(List<CiteVO> citeVOs) {
		this.citeVOs = citeVOs;
	}

}
