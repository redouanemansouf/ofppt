package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CaisseVO;
import com.m2m.onousc.business.referentiel.vo.CaissierVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

/**
 * 
 * @author abousnane
 * 
 */
public class CaissierWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3746887351762237659L;

	private String jSessionID;

	private String serverNameAndPort;

	/** The vo. */
	private CaissierVO vo;

	/** The vos. */
	private List<CaissierVO> vos;

	/** The selected v os. */
	private List<CaissierVO> selectedVOs;

	private List<CaisseVO> caisseVOs;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public CaissierWebBean() {
		super();
		vo = new CaissierVO();
		vos = new ArrayList<CaissierVO>();
		selectedVOs = new ArrayList<CaissierVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public CaissierVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo the vo to set
	 */
	public void setVo(CaissierVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<CaissierVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos the vos to set
	 */
	public void setVos(List<CaissierVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<CaissierVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs the selectedVOs to set
	 */
	public void setSelectedVOs(List<CaissierVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<CaisseVO> getCaisseVOs() {
		return caisseVOs;
	}

	public void setCaisseVOs(List<CaisseVO> caisseVOs) {
		this.caisseVOs = caisseVOs;
	}

	public String getjSessionID() {
		return jSessionID;
	}

	public void setjSessionID(String jSessionID) {
		this.jSessionID = jSessionID;
	}

	public String getServerNameAndPort() {
		return serverNameAndPort;
	}

	public void setServerNameAndPort(String serverNameAndPort) {
		this.serverNameAndPort = serverNameAndPort;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
