package com.m2m.onousc.web.referentiel.mbean;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.m2m.onousc.business.referentiel.service.ReferentielService;
import com.m2m.onousc.business.referentiel.vo.CarteVO;
import com.m2m.onousc.business.referentiel.vo.EtudiantVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.referentiel.vo.transformer.CarteVOTransformer;
import com.m2m.onousc.business.reservation.model.Reservation;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.impl.ReferentielBusDelegate;
import com.m2m.onousc.web.referentiel.webbean.CarteWebBean;
import com.m2m.technicalservices.reporting.ReportSpecification;
import com.m2m.technicalservices.reporting.ReportType;
import com.m2m.technicalservices.reporting.impl.JasperReportExporter;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;
import com.m2m.technicalservices.web.JSFUtils;

@ManagedBean
@ViewScoped
public class CarteMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8675368865246183267L;
	/** The web bean. */
	private CarteWebBean webBean;
	private List<CarteVO> voLots;

	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");

	ReferentielService referentielServic = (ReferentielService) BeansLookuper.lookup("referentielService");

	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());

	private boolean activeOpp = false;
	private String numeroCarteV;

	private String codeMassarV;

	public void init() {
		webBean = new CarteWebBean();
		webBean.setEtudiantVOs(referentielService.findAllEtudiantforCombo());
		webBean.setListSiteForCombo(referentielService.findAllSite());
		// webBean.setCitevos(referentielService.findAllCiteForCombo());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new CarteVO());
		;
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<CarteVO>());
	}

	public void delivrer(String CodeMassar, String NumCarte) {

		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.delivrer_Carte(webBean);

		if (!error) {

			addPrezMsgInfo("MESSAGE_SUCCESS_DELIVRED", null);

			// if(refService.findCarteByEtud(webBean.getVo().getEtudvo().getId()).getStatut()==EntityStatus.DILVRED)
			// render=false;
			JSFUtils.contextExecute("_popMessage()");
		}
		/*
		 * try { generateReport(CodeMassar,NumCarte); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 */

		feedReport();
	}

	public void generateReport() throws IOException {

		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("codeMassarV");
		String value2 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("numeroCarteV");
		JasperReportExporter jasperExporter = new JasperReportExporter();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String path = "resources/reports/";
		String fileOutput = "attestation";

		List<Reservation> beanList = new ArrayList<Reservation>();
		ReportType reportType = ReportType.PDF;

		String fileJrxml = "attestation.jrxml";

		EtudiantVO etudiant = referentielService.findEtudiantByMassar(codeMassarV);

		java.text.DateFormat dateFormatLong = new java.text.SimpleDateFormat("dd/MM/yyyy");

		dataMap.put("annee", referentielService.findActuelAnneeUniversitaire().getLibelle());
		dataMap.put("Nom", etudiant.getNom());
		dataMap.put("Prenom", etudiant.getPrenom());
		dataMap.put("Massar", etudiant.getCodeMassar());

		dataMap.put("site", etudiant.getSiteVO().getLibelle());
		dataMap.put("NumCarte", numeroCarteV);
		dataMap.put("date", dateFormatLong.format(new Date()));
		dataMap.put("ville", etudiant.getSiteVO().getVille().getLibelle());
		dataMap.put("resident", etudiant.getResident() ? "d’hébergement" : "Restaurant ");
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();

		ec.responseReset();
		ec.setResponseContentType("application/pdf");
		String fileName = "Attestation_" + etudiant.getCodeMassar() + ".pdf";
		ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName);

		OutputStream output = ec.getResponseOutputStream();

		ReportSpecification reportSpec = new ReportSpecification(path + fileJrxml, output);

		jasperExporter.export(reportSpec, beanList, reportType, dataMap);
		fc.responseComplete();

	}

	public void recupListCarte() {
		CarteVOTransformer carteVOTransformer = new CarteVOTransformer();
		webBean.setVoLot(
				carteVOTransformer.model2VO(referentielServic.find_Carte_By_Lot(webBean.getVo().getOperateur())));
	}

	public void delivLotCarte() {
		clearReport();
		ReferentielBusDelegate delegate = new ReferentielBusDelegate();
		error = delegate.delivrerCollectionCarte(webBean);

		if (!error) {
			addPrezMsgInfo("MESSAGE_SUCCESS_DELIVRED", null);

			// if(refService.findCarteByEtud(webBean.getVo().getEtudvo().getId()).getStatut()==EntityStatus.DILVRED)
			// render=false;
			// JSFUtils.contextExecute("_hideDialog()");
		}
		feedReport();

	}

	public void deliverCollectionCarte() {
		clearReport();
		if (!webBean.getSelectedVOs().isEmpty()) {
			ReferentielBusDelegate delegate = new ReferentielBusDelegate();
			// error = delegate.delivrerCollectionCarte(webBean);
			if (error) {
				JSFUtils.contextExecute("_errorDialog()");
			} else {
				addPrezMsgInfo("MESSAGE_SUCCESS_DELIVRED", null);
			}
		} else {
			addPrezMsgInfo("AUCUN_ELEMENT_SELECTIONE", null);
		}
		feedReport();
	}

	/**
	 * 
	 * @return webBean
	 */

//	@Override
//	protected boolean isAutorise() {
//		return hasEcran(Constantes.CODE_ENR_CYV);
//	}

	public boolean isActiveOpp() {
		if (webBean.getSelectedVOs().size() == 0)
			activeOpp = false;
		else
			activeOpp = true;

		return activeOpp;
	}

	public CarteWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(CarteWebBean webBean) {
		this.webBean = webBean;
	}

	public List<CarteVO> getVoLots() {
		return voLots;
	}

	public void setVoLots(List<CarteVO> voLots) {
		this.voLots = voLots;
	}

	public String getNumeroCarteV() {
		return numeroCarteV;
	}

	public void setNumeroCarteV(String numeroCarteV) {
		this.numeroCarteV = numeroCarteV;
	}

	public String getCodeMassarV() {
		return codeMassarV;
	}

	public void setCodeMassarV(String codeMassarV) {
		this.codeMassarV = codeMassarV;
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}
