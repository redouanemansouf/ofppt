package com.m2m.onousc.web.referentiel.webbean;

import java.util.ArrayList;
import java.util.List;

import com.m2m.onousc.business.referentiel.vo.AdherentVO;
import com.m2m.onousc.business.referentiel.vo.CategoriePorteurVO;
import com.m2m.onousc.business.referentiel.vo.CritereVO;
import com.m2m.onousc.business.referentiel.vo.PersonnelVO;
import com.m2m.onousc.business.referentiel.vo.TourniquetVO;
import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.technicalservices.web.BaseWebBean;

// TODO: Auto-generated Javadoc
/**
 * author msadik
 */
public class AdherentWebBean extends BaseWebBean {



	/**
	 * 
	 */
	private static final long serialVersionUID = 4436025075676099168L;

	/** The vo. */
	private AdherentVO vo;
	
	private double solde;

	private List<AdherentVO> vos;
	
	private String MatrSearch;

	private String jSessionID;

	private String serverNameAndPort;

	/** The selected v os. */
	private List<AdherentVO> selectedVOs;

	private List<VilleVO> villevos;

	private List<CategoriePorteurVO> categorievos;
	
	private List<PersonnelVO> personnelvos;
	
	private List<CritereVO> profilvos;
	
	private List<TourniquetVO> selectedTourniquets;	

	public List<TourniquetVO> getSelectedTourniquets() {
		return selectedTourniquets;
	}

	public void setSelectedTourniquets(List<TourniquetVO> selectedTourniquets) {
		this.selectedTourniquets = selectedTourniquets;
	}

	public AdherentWebBean() {
		setVo(new AdherentVO());
		setMatrSearch("");
		setVos(new ArrayList<AdherentVO>());
		setSelectedVOs(new ArrayList<AdherentVO>());
		setVillevos(new ArrayList<VilleVO>());
		setCategorievos(new ArrayList<CategoriePorteurVO>());
		setPersonnelvos(new ArrayList<PersonnelVO>());
		profilvos=new ArrayList<CritereVO>();
		selectedTourniquets=new ArrayList<TourniquetVO>();
	}

	public List<PersonnelVO> getPersonnelvos() {
		return personnelvos;
	}

	public void setPersonnelvos(List<PersonnelVO> personnelvos) {
		this.personnelvos = personnelvos;
	}

	public List<CategoriePorteurVO> getCategorievos() {
		return categorievos;
	}

	public void setCategorievos(List<CategoriePorteurVO> categorievos) {
		this.categorievos = categorievos;
	}

	public List<VilleVO> getVillevos() {
		return villevos;
	}

	public void setVillevos(List<VilleVO> villevos) {
		this.villevos = villevos;
	}

	public List<AdherentVO> getSelectedVOs() {
		return selectedVOs;
	}

	public void setSelectedVOs(List<AdherentVO> selectedVOs) {
		this.selectedVOs = selectedVOs;
	}

	public String getMatrSearch() {
		return MatrSearch;
	}

	public void setMatrSearch(String matrSearch) {
		MatrSearch = matrSearch;
	}

	public List<AdherentVO> getVos() {
		return vos;
	}

	public void setVos(List<AdherentVO> vos) {
		this.vos = vos;
	}

	public AdherentVO getVo() {
		return vo;
	}

	public void setVo(AdherentVO vo) {
		this.vo = vo;
	}

	public List<CritereVO> getProfilvos() {
		return profilvos;
	}

	public void setProfilvos(List<CritereVO> profilvos) {
		this.profilvos = profilvos;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
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

 

	

}
