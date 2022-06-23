package com.m2m.technicalservices.security;

public class Permission {
	//code ecran ou composant spécifique
	private String codeEcran;
	private boolean isVisible;
	private boolean hasCreate;
	private boolean hasUpdate;
	private boolean hasDelete;
	private boolean hasSelect;
	
	public Permission(String codeEcran, boolean isVisible, boolean hasCreate,
			boolean hasUpdate, boolean hasDelete, boolean hasSelect) {
		super();
		this.codeEcran = codeEcran;
		this.isVisible = isVisible;
		this.hasCreate = hasCreate;
		this.hasUpdate = hasUpdate;
		this.hasDelete = hasDelete;
		this.hasSelect = hasSelect;
	}
	public String getCodeEcran() {
		return codeEcran;
	}
	public void setCodeEcran(String codeEcran) {
		this.codeEcran = codeEcran;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public boolean isHasCreate() {
		return hasCreate;
	}
	public void setHasCreate(boolean hasCreate) {
		this.hasCreate = hasCreate;
	}
	public boolean isHasUpdate() {
		return hasUpdate;
	}
	public void setHasUpdate(boolean hasUpdate) {
		this.hasUpdate = hasUpdate;
	}
	public boolean isHasDelete() {
		return hasDelete;
	}
	public void setHasDelete(boolean hasDelete) {
		this.hasDelete = hasDelete;
	}
	public boolean isHasSelect() {
		return hasSelect;
	}
	public void setHasSelect(boolean hasSelect) {
		this.hasSelect = hasSelect;
	}
	
}
