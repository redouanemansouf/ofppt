package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.referentiel.model.ImportInscription;
import com.m2m.onousc.business.referentiel.vo.transformer.ImportInscriptionVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

public class ImportInscriptionVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2128676822023258814L;
	private Long id;
	private String cin;
	private String motifRejet;
	private String userName;
	private Date dateOperation;
	private String codeMassar;

	public ImportInscriptionVO() {
		super();
	}

	public ImportInscriptionVO(Long id, String cin, String motifRejet, String userName, Date dateOperation,
			String codeMassar) {
		super();
		this.id = id;
		this.cin = cin;
		this.motifRejet = motifRejet;
		this.userName = userName;
		this.dateOperation = dateOperation;
		this.codeMassar = codeMassar;
	}

	public String getCodeMassar() {
		return codeMassar;
	}

	public void setCodeMassar(String codeMassar) {
		this.codeMassar = codeMassar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getMotifRejet() {
		return motifRejet;
	}

	public void setMotifRejet(String motifRejet) {
		this.motifRejet = motifRejet;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	@Override
	public String toString() {
		return "ImportInscriptionVO [id=" + id + ", cin=" + cin + ", motifRejet=" + motifRejet + ", userName="
				+ userName + ", dateOperation=" + dateOperation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImportInscriptionVO other = (ImportInscriptionVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<ImportInscription, ImportInscriptionVO> getTransformer() {
		return new ImportInscriptionVOTransformer();
	}

}
