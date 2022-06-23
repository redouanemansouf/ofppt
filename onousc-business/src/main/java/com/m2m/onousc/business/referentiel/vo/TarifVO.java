package com.m2m.onousc.business.referentiel.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.Tarif;
import com.m2m.onousc.business.referentiel.vo.transformer.TarifVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.validation.AlphaNum;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * 
 * @author abousnane
 *
 */
public class TarifVO implements ValueObject, ISearchResultVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7012835532487536260L;


	/** The id. */
	private Long id;

	/** Libellé. */
	@NotNull
	@AlphaNum
	@Size(max = 30)
	private String libelle;
	
	@NotNull
	@Size(max = 4)
	private String code;
	
	@NotNull
	private Double tarif;
	
	@NotNull
	private ServiceVO serviceVO;
	@NotNull
	private CategoriePorteurVO categoriePorteurVO;

	
	/** Statut du canal de vente. */
	private EntityStatus statut;
	
	public TarifVO(){
		super();
	}
	
	
	
	public TarifVO(String libelle, Double tarif, ServiceVO serviceVO, CategoriePorteurVO categoriePorteurVO) {
		super();
		this.libelle = libelle;
		this.tarif = tarif;
		this.serviceVO = serviceVO;
		this.categoriePorteurVO = categoriePorteurVO;
	}



	@Override
	public String getIdForSearch() {
		return String.valueOf(this.id);
	}

	@Override
	public ITransformer<Tarif, TarifVO> getTransformer() {
		return new TarifVOTransformer();
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public Double getTarif() {
		return tarif;
	}



	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}



	public EntityStatus getStatut() {
		return statut;
	}



	public void setStatut(EntityStatus statut) {
		this.statut = statut;
	}
	
	
	
	public ServiceVO getServiceVO() {
		return serviceVO;
	}



	public void setServiceVO(ServiceVO serviceVO) {
		this.serviceVO = serviceVO;
	}



	public CategoriePorteurVO getCategoriePorteurVO() {
		return categoriePorteurVO;
	}



	public void setCategoriePorteurVO(CategoriePorteurVO categoriePorteurVO) {
		this.categoriePorteurVO = categoriePorteurVO;
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
		TarifVO other = (TarifVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
