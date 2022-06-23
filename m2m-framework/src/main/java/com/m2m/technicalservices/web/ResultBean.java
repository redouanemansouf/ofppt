package com.m2m.technicalservices.web;

import java.io.Serializable;
import java.util.List;

public class ResultBean implements Serializable {
	private List<ISearchResultVO> rows;

	public List<ISearchResultVO> getRows() {
		return rows;
	}

	public void setRows(List<ISearchResultVO> rows) {
		this.rows = rows;
	}
}
