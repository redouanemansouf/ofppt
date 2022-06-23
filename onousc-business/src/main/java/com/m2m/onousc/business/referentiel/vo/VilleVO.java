package com.m2m.onousc.business.referentiel.vo;

import com.m2m.onousc.business.referentiel.model.Ville;
import com.m2m.onousc.business.referentiel.vo.transformer.VilleVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;

public class VilleVO  implements ValueObject {



	/**
	 * 
	 */
	private static final long serialVersionUID = 5472199143094061429L;
	private Long id;
	private String libelle;
	private String prov;

	
	
	public VilleVO() {
		super();
	}

	public VilleVO(Long id, String libelle, String prov) {
		super();
		this.libelle = libelle;
		this.prov = prov;
	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Gets the libelle.
	 *
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 *
	 * @param libelle            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	@Override
	public ITransformer<Ville,VilleVO> getTransformer() {
		return new VilleVOTransformer();
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
		VilleVO other = (VilleVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
