package com.m2m.onousc.web.referentiel.webbean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.CarteNapsVO;
import com.m2m.onousc.business.referentiel.vo.SiteVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * The Class CanalVenteWebBean.
 */
public class CarteNapsWebBean extends BaseWebBean {

	// J.RHANIM - 25-06-2018
	private static final long serialVersionUID = 4174259303551373101L;

	private CarteNapsVO vo = new CarteNapsVO();
	private List<CarteNapsVO> vos;
	private List<CarteNapsVO> selectedVOs;
	private File importedFile;
	private File fileRejet;
	private long nbrLignesRejets;
	private long nbrLignesValides;
	private CarteNapsVO vot = new CarteNapsVO();
	private List<CarteNapsVO> vots;
	private List<SiteVO> listSiteForCombo = new ArrayList<SiteVO>();

	private List<CarteNapsVO> listLignes = new ArrayList<CarteNapsVO>();
	private List<CarteNapsVO> listRejets = new ArrayList<CarteNapsVO>();

	public CarteNapsWebBean() {
		vo = new CarteNapsVO();

		vos = new ArrayList<CarteNapsVO>();
		selectedVOs = new ArrayList<CarteNapsVO>();

	}

	public File getImportedFile() {
		return importedFile;
	}

	public CarteNapsVO getVo() {
		return vo;
	}

	public void setVo(CarteNapsVO vo) {
		this.vo = vo;
	}

	public List<CarteNapsVO> getVos() {
		return vos;
	}

	public void setVos(List<CarteNapsVO> vos) {
		this.vos = vos;
	}

	public List<CarteNapsVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<CarteNapsVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<CarteNapsVO> getListLignes() {
		return listLignes;
	}

	public void setListLignes(List<CarteNapsVO> listLignes) {
		this.listLignes = listLignes;
	}

	public List<CarteNapsVO> getListRejets() {
		return listRejets;
	}

	public void setListRejets(List<CarteNapsVO> listRejets) {
		this.listRejets = listRejets;
	}

	public void setImportedFile(File importedFile) {
		this.importedFile = importedFile;
	}

	public File getFileRejet() {
		return fileRejet;
	}

	public void setFileRejet(File fileRejet) {
		this.fileRejet = fileRejet;
	}

	public long getNbrLignesRejets() {
		return nbrLignesRejets;
	}

	public void setNbrLignesRejets(long nbrLignesRejets) {
		this.nbrLignesRejets = nbrLignesRejets;
	}

	public long getNbrLignesValides() {
		return nbrLignesValides;
	}

	public void setNbrLignesValides(long nbrLignesValides) {
		this.nbrLignesValides = nbrLignesValides;
	}

	public CarteNapsVO getVot() {
		return vot;
	}

	public void setVot(CarteNapsVO vot) {
		this.vot = vot;
	}

	public List<CarteNapsVO> getVots() {
		return vots;
	}

	public void setVots(List<CarteNapsVO> vots) {
		this.vots = vots;
	}

	public List<SiteVO> getListSiteForCombo() {
		return listSiteForCombo;
	}

	public void setListSiteForCombo(List<SiteVO> listSiteForCombo) {
		this.listSiteForCombo = listSiteForCombo;
	}
}
