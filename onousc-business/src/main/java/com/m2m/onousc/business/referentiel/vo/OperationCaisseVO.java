package com.m2m.onousc.business.referentiel.vo;

import java.util.Date;

import com.m2m.onousc.business.referentiel.model.OperationCaisse;
import com.m2m.onousc.business.referentiel.vo.transformer.OperationCaisseVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * 
 * @author abousnane
 * 
 */
public class OperationCaisseVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7012835532487536260L;

	/** The id. */
	private Long id;

	private String typeOperation;

	private Double montant;

	private Date dateOperation;

	private CaisseVO caisseVO;

	// private CaissierVO caissierVO;

	private Double solde;

	private String matricule;

	private ProduitVO produitVO;

	private PersonnelVO nom;

	private PersonnelVO prenom;

	private SiteVO siteVO;

	// private EtudiantVO etudiantVO;

	public PersonnelVO getNom() {
		return nom;
	}

	public void setNom(PersonnelVO nom) {
		this.nom = nom;
	}

	public PersonnelVO getPrenom() {
		return prenom;
	}

	public void setPrenom(PersonnelVO prenom) {
		this.prenom = prenom;
	}

	public OperationCaisseVO() {
		super();
	}

	public OperationCaisseVO(Long id, String typeOperation, Double montant, Date dateOperation, Double solde,
			String matricule, CaisseVO caisseVO) {
		super();
		this.id = id;
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.dateOperation = dateOperation;
		this.solde = solde;
		this.matricule = matricule;
		this.caisseVO = caisseVO;
	}

	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<OperationCaisse, OperationCaisseVO> getTransformer() {
		return new OperationCaisseVOTransformer();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		OperationCaisseVO other = (OperationCaisseVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public CaisseVO getCaisseVO() {
		return caisseVO;
	}

	public void setCaisseVO(CaisseVO caisseVO) {
		this.caisseVO = caisseVO;
	}

	public ProduitVO getProduitVO() {
		return produitVO;
	}

	public void setProduitVO(ProduitVO produitVO) {
		this.produitVO = produitVO;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

}
