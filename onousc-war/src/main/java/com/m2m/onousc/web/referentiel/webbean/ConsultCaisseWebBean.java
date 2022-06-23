package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.ConsultCaisseVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * 
 * @author abousnane
 * 
 */
public class ConsultCaisseWebBean extends BaseWebBean {

	/**
	 * 
	 */


	/**
	 * 
	 */
	private static final long serialVersionUID = -1407372978851639031L;

	/** The vo. */
	private ConsultCaisseVO vo;

	/** The vos. */
	private List<ConsultCaisseVO> vos;

	/** The selected v os. */
	private List<ConsultCaisseVO> selectedVOs;

	private List<CaisseVO> caisseVOs;

	private List<RestaurantVO> restaurantVOs;

	private List<CiteVO> citeVOs;

	private List<CaissierVO> caissierVOs;

	private List<EtudiantVO> etudiantVO;

	private List<TransactionVO> transactionVOs;

	public ConsultCaisseWebBean() {
		super();
		vo = new ConsultCaisseVO();
		vos = new ArrayList<ConsultCaisseVO>();
		selectedVOs = new ArrayList<ConsultCaisseVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public ConsultCaisseVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(ConsultCaisseVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<ConsultCaisseVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<ConsultCaisseVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<ConsultCaisseVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<ConsultCaisseVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<CaisseVO> getCaisseVOs() {
		return caisseVOs;
	}

	public void setCaisseVOs(List<CaisseVO> caisseVOs) {
		this.caisseVOs = caisseVOs;
	}

	public List<RestaurantVO> getRestaurantVOs() {
		return restaurantVOs;
	}

	public void setRestaurantVOs(List<RestaurantVO> restaurantVOs) {
		this.restaurantVOs = restaurantVOs;
	}

	public List<EtudiantVO> getEtudiantVO() {
		return etudiantVO;
	}

	public void setEtudiantVO(List<EtudiantVO> etudiantVO) {
		this.etudiantVO = etudiantVO;
	}

	public List<TransactionVO> getTransactionVOs() {
		return transactionVOs;
	}

	public void setTransactionVOs(List<TransactionVO> transactionVOs) {
		this.transactionVOs = transactionVOs;
	}

	public List<CiteVO> getCiteVOs() {
		return citeVOs;
	}

	public void setCiteVOs(List<CiteVO> citeVOs) {
		this.citeVOs = citeVOs;
	}

	public List<CaissierVO> getCaissierVOs() {
		return caissierVOs;
	}

	public void setCaissierVOs(List<CaissierVO> caissierVOs) {
		this.caissierVOs = caissierVOs;
	}

}
