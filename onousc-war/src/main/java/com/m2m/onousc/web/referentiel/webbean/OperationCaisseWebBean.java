package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.OperationCaisseVO;
import com.m2m.onousc.business.referentiel.vo.RestaurantVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * 
 * @author abousnane
 * 
 */
public class OperationCaisseWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3746887351762237659L;

	/** The vo. */
	private OperationCaisseVO vo;

	/** The vos. */
	private List<OperationCaisseVO> vos;

	/** The selected v os. */
	private List<OperationCaisseVO> selectedVOs;

	private List<CaisseVO> caisseVOs;

	private List<RestaurantVO> restaurantVOs;

	private List<CiteVO> citeVOs;

	private List<CaissierVO> caissierVOs;

	private List<EtudiantVO> etudiantVO;

	private List<TransactionVO> transactionVOs;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public OperationCaisseWebBean() {
		super();
		vo = new OperationCaisseVO();
		vos = new ArrayList<OperationCaisseVO>();
		selectedVOs = new ArrayList<OperationCaisseVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public OperationCaisseVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo the vo to set
	 */
	public void setVo(OperationCaisseVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<OperationCaisseVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos the vos to set
	 */
	public void setVos(List<OperationCaisseVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<OperationCaisseVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs the selectedVOs to set
	 */
	public void setSelectedVOs(List<OperationCaisseVO> selectedVOs) {
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

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
