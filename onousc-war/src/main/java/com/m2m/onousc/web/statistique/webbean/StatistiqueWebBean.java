package com.m2m.onousc.web.statistique.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.statistique.vo.StatistiqueJourVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class StatistiqueWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3911957976322143751L;
	/** The vo. */
	private StatistiqueJourVO vo; 

	/** The vos. */
	private List<StatistiqueJourVO> vos;

	/** The selected v os. */
	private List<StatistiqueJourVO> selectedVOs;

	private List<StatistiqueJourVO> statistiqueJourVO;

	private List<CiteVO> citeVO;

	private List<RestaurantVO> restaurantVO;

	public List<CiteVO> getCiteVO() {
		return citeVO;
	}

	public void setCiteVO(List<CiteVO> citeVO) {
		this.citeVO = citeVO;
	}

	public List<RestaurantVO> getRestaurantVO() {
		return restaurantVO;
	}

	public void setRestaurantVO(List<RestaurantVO> restaurantVO) {
		this.restaurantVO = restaurantVO;
	}

	public List<StatistiqueJourVO> getStatistiqueJourVO() {
		return statistiqueJourVO;
	}

	public void setStatistiqueJourVO(List<StatistiqueJourVO> statistiqueJourVO) {
		this.statistiqueJourVO = statistiqueJourVO;
	}

	public StatistiqueWebBean() {
		super();
		vo = new StatistiqueJourVO();
		vos = new ArrayList<StatistiqueJourVO>();
		selectedVOs = new ArrayList<StatistiqueJourVO>();
		statistiqueJourVO = new ArrayList<StatistiqueJourVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public StatistiqueJourVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(StatistiqueJourVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<StatistiqueJourVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<StatistiqueJourVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<StatistiqueJourVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<StatistiqueJourVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

}