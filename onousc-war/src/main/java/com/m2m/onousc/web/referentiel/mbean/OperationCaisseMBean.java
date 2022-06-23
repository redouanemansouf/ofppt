package com.m2m.onousc.web.referentiel.mbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.m2m.onousc.business.referentiel.Constantes;
import com.m2m.onousc.business.referentiel.vo.OperationCaisseVO;
import com.m2m.onousc.business.referentiel.vo.UserEntityVO;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.onousc.web.referentiel.webbean.OperationCaisseWebBean;
import com.m2m.onousc.web.statistique.StatistiqueSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.BaseMBean;

/**
 * 
 * @author abousnane
 * 
 */
@ManagedBean
@ViewScoped
public class OperationCaisseMBean extends BaseMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3481171614216454350L;

	/** The web bean. */
	private OperationCaisseWebBean webBean;
	ReferentielSrvPresentation referentielService = (ReferentielSrvPresentation) BeansLookuper
			.lookup("referentielSrvPresentation");
	StatistiqueSrvPresentation statistiqueService = (StatistiqueSrvPresentation) BeansLookuper
			.lookup("statistiqueSrvPresentation");
	UserEntityVO user = referentielService.findUserEntityByCode(userSession.getUserConecte().getCode());
	private Double someR = 0.0;
	private Double someD = 0.0;

	public void init() {
		webBean = new OperationCaisseWebBean();
		webBean.setCaisseVOs(referentielService.findAllCaisseForCombo());
		webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
		webBean.setEtudiantVO(referentielService.findAllEtudiantforCombo());
		webBean.setCiteVOs(referentielService.findAllCiteForCombo());
		webBean.setCaissierVOs(referentielService.findAllCaissierVOForCombo());
		webBean.setListSiteForCombo(referentielService.findAllSite());
	}

	/**
	 * Reset web bean vo.
	 */
	public void resetWebBeanVO() {
		webBean.setVo(new OperationCaisseVO());
	}

	public void resetWebBeanSelectedVO() {
		webBean.setSelectedVOs(new ArrayList<OperationCaisseVO>());
	}

	public OperationCaisseWebBean getWebBean() {
		return webBean;
	}

	public void setWebBean(OperationCaisseWebBean webBean) {
		this.webBean = webBean;
	}

	public void onCiteChange(String liberest) {
		if (liberest != null && !liberest.equals("")) {
			webBean.setCaisseVOs(referentielService.findAllCaisseByLibelleRestaurant(liberest));
			webBean.setEtudiantVO(referentielService.findAllEtudiantByLibelleRestaurant(liberest));
		} else {
			webBean.setCaisseVOs(referentielService.findAllCaisseForCombo());
			webBean.setEtudiantVO(referentielService.findAllEtudiantforCombo());
		}
	}

	public Double getSomeR() {
		for (TransactionVO tr : webBean.getTransactionVOs()) {
			if (tr.getTypeOperation().equals("R"))
				return tr.getTotal();
		}

		return 0.0;

	}

	public void setSomeR(Double someR) {
		this.someR = someR;
	}

	public Double getSomeD() {
		for (TransactionVO tr : webBean.getTransactionVOs()) {
			if (tr.getTypeOperation().equals("D"))
				return tr.getTotal();
		}

		return 0.0;
	}

	public void setSomeD(Double someD) {
		this.someD = someD;
	}

	public void onCountryChange(String libcite) {
		if (libcite != null && !libcite.equals("")) {
			webBean.setRestaurantVOs(referentielService.findAllRestaurantByLibelleCite(libcite));
		} else
			webBean.setRestaurantVOs(referentielService.findAllRestaurantForCombo());
	}

	public void findSoldeByMatr() {
		webBean.getVo().setSolde(referentielService.findSoldeByMatricule(webBean.getVo().getMatricule()));
	}

	public void preProcessPDF(Object document) {
		Document pdf = (Document) document;
		pdf.setPageSize(PageSize.A4.rotate());
		pdf.open();
	}

	public void preProcessPDF2(Object document) {

		Document doc = (Document) document;
		doc.setPageSize(PageSize.LEGAL.rotate());
		doc.addTitle("Informe de Procesos"); // i tried to add a title with this , but it did not work.
		doc.addCreationDate(); // this did not work either.

	}

	@Override
	protected boolean isAutorise() {
		return hasEcran(Constantes.CODE_REF_CONSLT_OPERATION);
	}

	public UserEntityVO getUser() {
		return user;
	}

	public void setUser(UserEntityVO user) {
		this.user = user;
	}

}