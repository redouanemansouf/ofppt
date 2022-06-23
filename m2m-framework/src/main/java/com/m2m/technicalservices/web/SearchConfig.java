package com.m2m.technicalservices.web;

import java.io.Serializable;

public class SearchConfig implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Nombre total de resultats
	 */
	private Long rowCount;
	/**
	 * Constante definissant le nombre de result a afficher par page
	 */
	private int limitResultPerPage = 15;
	/**
	 * Specifie la position initiale pour la recuperation des donnees
	 */
	private int offset;
	/**
	 * Nombre de resultats a afficher par page
	 */
	private int pageSize;
	public Long getRowCount() {
		return rowCount;
	}
	public void setRowCount(Long rowCount) {
		this.rowCount = rowCount;
	}
	public int getLimitResultPerPage() {
		return limitResultPerPage;
	}
	public void setLimitResultPerPage(int limitResultPerPage) {
		this.limitResultPerPage = limitResultPerPage;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
