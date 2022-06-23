package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.model.Cite;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.CiteVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteWebBean.
 */
public class CarteWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5284430388294842476L;

	/** The vo. */
	private CarteVO vo;

	private List<CarteVO> vos;

	/** The selected v os. */
	private List<CarteVO> selectedVOs;

	private List<EtudiantVO> etudiantVOs;

	private List<CiteVO> citevos;

	private CarteVO selectedVO;

	private List<CarteVO> voLot;

	private String nouveauNumCarte;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public CarteWebBean() {
		vo = new CarteVO();
		vos = new ArrayList<CarteVO>();
		selectedVOs = new ArrayList<CarteVO>();
		etudiantVOs = new ArrayList<EtudiantVO>();
		citevos = new ArrayList<CiteVO>();
	}

	public CarteVO getVo() {
		return vo;
	}

	public void setVo(CarteVO vo) {
		this.vo = vo;
	}

	public List<CarteVO> getVos() {
		return vos;
	}

	public void setVos(List<CarteVO> vos) {
		this.vos = vos;
	}

	public List<CarteVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<CarteVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<EtudiantVO> getEtudiantVOs() {
		return etudiantVOs;
	}

	public void setEtudiantVOs(List<EtudiantVO> etudiantVOs) {
		this.etudiantVOs = etudiantVOs;
	}

	public CarteVO getSelectedVO() {
		return selectedVO;
	}

	public void setSelectedVO(CarteVO selectedVO) {
		this.selectedVO = selectedVO;
	}

	public List<CiteVO> getCitevos() {
		return citevos;
	}

	public void setCitevos(List<CiteVO> citevos) {
		this.citevos = citevos;
	}

	public List<CarteVO> getVoLot() {
		return voLot;
	}

	public void setVoLot(List<CarteVO> voLot) {
		this.voLot = voLot;
	}

	public String getNouveauNumCarte() {
		return nouveauNumCarte;
	}

	public void setNouveauNumCarte(String nouveauNumCarte) {
		this.nouveauNumCarte = nouveauNumCarte;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
