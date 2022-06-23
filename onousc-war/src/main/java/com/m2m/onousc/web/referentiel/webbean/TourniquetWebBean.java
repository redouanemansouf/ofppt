package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class TourniquetWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4845740600179370691L;
private TourniquetVO vo;
	
	/**
	 * The vos
	 */
	private List<TourniquetVO> vos;
	
	/** The selected v os. */
	private List<TourniquetVO> selectedVOs;
	
	private List<RestaurantVO> restaurantVOs;
	
	public List<RestaurantVO> getRestaurantVOs() {
		return restaurantVOs;
	}

	public void setRestaurantVOs(List<RestaurantVO> RestaurantVOs) {
		this.restaurantVOs = RestaurantVOs;
	}

	public TourniquetWebBean(){
		super();
		vo = new TourniquetVO();
		vos = new ArrayList<TourniquetVO>();
		selectedVOs = new ArrayList<TourniquetVO>();
	}

	public TourniquetVO getVo() {
		return vo;
	}

	public void setVo(TourniquetVO vo) {
		this.vo = vo;
	}

	public List<TourniquetVO> getVos() {
		return vos;
	}

	public void setVos(List<TourniquetVO> vos) {
		this.vos = vos;
	}

	public List<TourniquetVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<TourniquetVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}
}
