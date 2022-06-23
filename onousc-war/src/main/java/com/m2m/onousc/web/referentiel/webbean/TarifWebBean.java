package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.ServiceVO;
import com.m2m.onousc.business.referentiel.vo.TarifVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * 
 * @author abousnane
 *
 */
public class TarifWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3746887351762237659L;
	
	/** The vo. */
	private TarifVO vo;

	/** The vos. */
	private List<TarifVO> vos;

	/** The selected v os. */
	private List<TarifVO> selectedVOs;
	
	private List<ServiceVO> serviceVOs;

	private List<CategoriePorteurVO> categoriePorteurVOs;

	public TarifWebBean() {
		super();
		vo = new TarifVO();
		vos = new ArrayList<TarifVO>();
		selectedVOs = new ArrayList<TarifVO>();
	}
	
	

	public List<ServiceVO> getServiceVOs() {
		return serviceVOs;
	}



	public void setServiceVOs(List<ServiceVO> serviceVOs) {
		this.serviceVOs = serviceVOs;
	}



	public List<CategoriePorteurVO> getCategoriePorteurVOs() {
		return categoriePorteurVOs;
	}



	public void setCategoriePorteurVOs(List<CategoriePorteurVO> categoriePorteurVOs) {
		this.categoriePorteurVOs = categoriePorteurVOs;
	}



	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public TarifVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(TarifVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<TarifVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<TarifVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<TarifVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<TarifVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}


}
