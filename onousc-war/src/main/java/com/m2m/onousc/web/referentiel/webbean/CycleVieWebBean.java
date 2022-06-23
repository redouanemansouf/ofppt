package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.model.MotifMainLevee;
import com.m2m.onousc.business.referentiel.vo.CycleVieVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.MotifMainLeveeVO;
import com.m2m.onousc.business.referentiel.vo.MotifOppositionVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteWebBean.
 */
public class CycleVieWebBean extends BaseWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The vo. */
	private CycleVieVO vo;

	private List<CycleVieVO> vos;

	/** The selected v os. */
	private List<CycleVieVO> selectedVOs;

	private List<EtudiantVO> etudiantVOs;

	private CycleVieVO selectedVO;

	private List<MotifOppositionVO> opposVOs;

	private List<MotifMainLeveeVO> motifMainVOs;

	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	public CycleVieWebBean() {
		super();
		vo = new CycleVieVO();
		vos = new ArrayList<CycleVieVO>();
		selectedVOs = new ArrayList<CycleVieVO>();
		etudiantVOs = new ArrayList<EtudiantVO>();
	}

	public List<MotifMainLeveeVO> getMotifMainVOs() {
		return motifMainVOs;
	}

	public void setMotifMainVOs(List<MotifMainLeveeVO> motifMainVOs) {
		this.motifMainVOs = motifMainVOs;
	}

	public List<MotifOppositionVO> getOpposVOs() {
		return opposVOs;
	}

	public void setOpposVOs(List<MotifOppositionVO> opposVOs) {
		this.opposVOs = opposVOs;
	}

	public CycleVieVO getVo() {
		return vo;
	}

	public void setVo(CycleVieVO vo) {
		this.vo = vo;
	}

	public List<CycleVieVO> getVos() {
		return vos;
	}

	public void setVos(List<CycleVieVO> vos) {
		this.vos = vos;
	}

	public List<CycleVieVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<CycleVieVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<EtudiantVO> getEtudiantVOs() {
		return etudiantVOs;
	}

	public void setEtudiantVOs(List<EtudiantVO> etudiantVOs) {
		this.etudiantVOs = etudiantVOs;
	}

	public CycleVieVO getSelectedVO() {
		return selectedVO;
	}

	public void setSelectedVO(CycleVieVO selectedVO) {
		this.selectedVO = selectedVO;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}

}
