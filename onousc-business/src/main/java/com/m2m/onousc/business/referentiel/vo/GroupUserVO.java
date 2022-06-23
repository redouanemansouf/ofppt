/*
 * GroupUserVO.java
 *
 * Copyright (c) 1990-2014 M2M Group, Inc. All Rights Reserved.
 */
package com.m2m.onousc.business.referentiel.vo;

import com.m2m.onousc.business.common.EntityStatus;
import com.m2m.onousc.business.referentiel.model.GroupUser;
import com.m2m.onousc.business.referentiel.vo.transformer.GroupUserVOTransformer;
import com.m2m.technicalservices.core.ITransformer;
import com.m2m.technicalservices.core.ValueObject;
import com.m2m.technicalservices.web.ISearchResultVO;

/**
 * The Class GroupUserVO.
 * 
 * @author iissouani
 */
public class GroupUserVO implements ValueObject, ISearchResultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String groupname;
	private String libelle;
	private EntityStatus statut;
	private boolean enabled;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GroupUserVO() {

	}



	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String getIdForSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITransformer<GroupUser, GroupUserVO> getTransformer() {
		return new GroupUserVOTransformer();
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	


	public EntityStatus getStatut() {
		return statut;
	}

	public void setStatut(EntityStatus statut) {
		this.statut = statut;
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
		GroupUserVO other = (GroupUserVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
