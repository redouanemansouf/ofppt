package com.m2m.onousc.web.statistique.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class TransactionWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3911957976322143751L;
	/** The vo. */
	private TransactionVO vo;

	/** The vos. */
	private List<TransactionVO> vos;

	/** The selected v os. */
	private List<TransactionVO> selectedVOs;

	private List<TransactionVO> TransactionVO;

	private List<CiteVO> citeVO;

	private List<RestaurantVO> restaurantVO;

	private List<EtudiantVO> etudiantVO;

	public List<EtudiantVO> getEtudiantVO() {
		return etudiantVO;
	}

	public void setEtudiantVO(List<EtudiantVO> etudiantVO) {
		this.etudiantVO = etudiantVO;
	}

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

	public List<TransactionVO> getTransactionVO() {
		return TransactionVO;
	}

	public void setTransactionVO(List<TransactionVO> TransactionVO) {
		this.TransactionVO = TransactionVO;
	}

	public TransactionWebBean() {
		super();
		vo = new TransactionVO();
		vos = new ArrayList<TransactionVO>();
		selectedVOs = new ArrayList<TransactionVO>();
		TransactionVO = new ArrayList<TransactionVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public TransactionVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(TransactionVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<TransactionVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<TransactionVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<TransactionVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<TransactionVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

}