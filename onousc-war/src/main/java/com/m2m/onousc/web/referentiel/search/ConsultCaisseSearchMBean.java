package com.m2m.onousc.web.referentiel.search;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.m2m.onousc.business.referentiel.criteria.ConsultCaisseCriteria;
import com.m2m.onousc.business.statistique.vo.TransactionVO;
import com.m2m.onousc.web.statistique.StatistiqueSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;
import com.m2m.technicalservices.web.AbstractSearchMBean;
import com.m2m.technicalservices.web.SearchResultBean;

/**
 * 
 * @author abousnane
 * 
 */

@ManagedBean
@ViewScoped
public class ConsultCaisseSearchMBean extends AbstractSearchMBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6700921221225736957L;
	/**
	 * 
	 */
	

	/** The canal vente criteria. */
	private ConsultCaisseCriteria ConsultaCaisseCriteria = new ConsultCaisseCriteria();
	StatistiqueSrvPresentation statistiqueService = (StatistiqueSrvPresentation) BeansLookuper
			.lookup("statistiqueSrvPresentation");
	List<TransactionVO> transactionVOs = new ArrayList<TransactionVO>();
	private Double someR = 0.0;
	private Double someD = 0.0;
	private Double some = 0.0;

	public ConsultCaisseSearchMBean() {
		search = new ConsultCaisseSearch();
		searchCriteria = ConsultaCaisseCriteria;
	//	setTransactionVOs(statistiqueService
			//	.findTotalTransaction(OperationCaisseCriteria));
		initData();
	}

	public void initData() {

		searchCriteria = ConsultaCaisseCriteria;
	//	setTransactionVOs(statistiqueService
				//.findTotalTransaction(OperationCaisseCriteria));
		run();
	}

	@Override
	public void resetSearchCriteria() {
		this.ConsultaCaisseCriteria = new ConsultCaisseCriteria();
		searchCriteria = ConsultaCaisseCriteria;

	}

	

	public List<TransactionVO> getTransactionVOs() {
		return transactionVOs;
	}

	public void setTransactionVOs(List<TransactionVO> transactionVOs) {
		this.transactionVOs = transactionVOs;
	}

	public Double getSomeR() {
		for (TransactionVO tr : transactionVOs) {
			if (tr.getTypeOperation().equals("R"))
				return tr.getTotal();
		}

		return 0.0;

	}

	public void setSomeR(Double someR) {
		this.someR = someR;
	}

	public Double getSomeD() {
		for (TransactionVO tr : transactionVOs) {
			if (tr.getTypeOperation().equals("D"))
				return tr.getTotal();
		}

		return 0.0;
	}

	public void setSomeD(Double someD) {
		this.someD = someD;
	}

	public void chercher() {
		run();
		//setTransactionVOs(statistiqueService
			//	.findTotalTransaction(OperationCaisseCriteria));
	}

	public Double getSome() {
		return getSomeR() - getSomeD();
	}

	public void setSome(Double some) {
		this.some = some;
	}

	public ConsultCaisseCriteria getConsultCaisseCriteria() {
		return ConsultaCaisseCriteria;
	}

	public void setConsultCaisseCriteria(
			ConsultCaisseCriteria consultCaisseCriteria) {
		ConsultaCaisseCriteria = consultCaisseCriteria;
	}

	
	
}
