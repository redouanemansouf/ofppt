package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CanalVenteVO;
import com.m2m.onousc.business.referentiel.vo.ProduitVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * author msadik
 */
public class ProduitWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6764427901483498499L;

	/** The vo. */
	private ProduitVO vo;

	private List<ProduitVO> vos;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	/** The selected v os. */
	private List<ProduitVO> selectedVOs;

	private List<CanalVenteVO> famProduitvos;

	public ProduitWebBean() {
		vo = new ProduitVO();
		vos = new ArrayList<ProduitVO>();
		selectedVOs = new ArrayList<ProduitVO>();
		famProduitvos = new ArrayList<CanalVenteVO>();
	}

	public ProduitVO getVo() {
		return vo;
	}

	public void setVo(ProduitVO vo) {
		this.vo = vo;
	}

	public List<ProduitVO> getVos() {
		return vos;
	}

	public void setVos(List<ProduitVO> vos) {
		this.vos = vos;
	}

	public List<ProduitVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<ProduitVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<CanalVenteVO> getFamProduitvos() {
		return famProduitvos;
	}

	public void setFamProduitvos(List<CanalVenteVO> famProduitvos) {
		this.famProduitvos = famProduitvos;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
