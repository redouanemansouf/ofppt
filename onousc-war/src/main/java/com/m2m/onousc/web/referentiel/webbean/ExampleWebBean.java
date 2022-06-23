package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.m2m.onousc.business.referentiel.vo.ExampleVO;
import com.m2m.technicalservices.web.BaseWebBean;

public class ExampleWebBean extends BaseWebBean {

	/**
	 * 
	 */

	private static final long serialVersionUID = 2141440966758532810L;

	/** The vo. */
	private ExampleVO vo;

	private ExampleVO carte;

	private ExampleVO compte;

	private ExampleVO associationCompte;

	/** The vos. */
	private List<ExampleVO> vos;

	private List<ExampleVO> voComtpes;

	private List<ExampleVO> voCartes;

	private List<ExampleVO> voAssociation;

	/** The selected v os. */
	private List<ExampleVO> selectedVOs;

	public ExampleWebBean() {
		super();
		vo = new ExampleVO();
		carte = new ExampleVO();
		compte = new ExampleVO();
		associationCompte = new ExampleVO();
		vos = new ArrayList<ExampleVO>();
		voComtpes = new ArrayList<ExampleVO>();
		voCartes = new ArrayList<ExampleVO>();
		setVoAssociation(new ArrayList<ExampleVO>());
		selectedVOs = new ArrayList<ExampleVO>();
	}

	/**
	 * Gets the vo.
	 * 
	 * @return the vo
	 */
	public ExampleVO getVo() {
		return vo;
	}

	/**
	 * Sets the vo.
	 * 
	 * @param vo
	 *            the vo to set
	 */
	public void setVo(ExampleVO vo) {
		this.vo = vo;
	}

	/**
	 * Gets the vos.
	 * 
	 * @return the vos
	 */
	public List<ExampleVO> getVos() {
		return vos;
	}

	/**
	 * Sets the vos.
	 * 
	 * @param vos
	 *            the vos to set
	 */
	public void setVos(List<ExampleVO> vos) {
		this.vos = vos;
	}

	/**
	 * Gets the selected v os.
	 * 
	 * @return the selectedVOs
	 */
	public List<ExampleVO> getSelectedVOs() {
		return selectedVOs;
	}

	/**
	 * Sets the selected v os.
	 * 
	 * @param selectedVOs
	 *            the selectedVOs to set
	 */
	public void setSelectedVOs(List<ExampleVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public List<ExampleVO> getVoComtpes() {
		return voComtpes;
	}

	public void setVoComtpes(List<ExampleVO> voComtpes) {
		this.voComtpes = voComtpes;
	}

	public List<ExampleVO> getVoCartes() {
		return voCartes;
	}

	public void setVoCartes(List<ExampleVO> voCartes) {
		this.voCartes = voCartes;
	}

	public ExampleVO getCarte() {
		return carte;
	}

	public void setCarte(ExampleVO carte) {
		this.carte = carte;
	}

	public ExampleVO getCompte() {
		return compte;
	}

	public void setCompte(ExampleVO compte) {
		this.compte = compte;
	}

	public ExampleVO getAssociationCompte() {
		return associationCompte;
	}

	public void setAssociationCompte(ExampleVO associationCompte) {
		this.associationCompte = associationCompte;
	}

	public List<ExampleVO> getVoAssociation() {
		return voAssociation;
	}

	public void setVoAssociation(List<ExampleVO> voAssociation) {
		this.voAssociation = voAssociation;
	}

}
