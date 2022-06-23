package com.m2m.technicalservices.web;

import java.io.Serializable;
import java.util.List;

public abstract class SearchBase {

	public final SearchResultBean search(Serializable searchBean,
			SearchConfig configuration, String sortField, String sortOrder) {
		SearchResultBean result = precondition(searchBean);
		if (result != null && result.isError()) {
			return result;
		}
		List<Object> listResult = execute(searchBean, configuration, sortField,
				sortOrder);

		if (listResult != null) {
			long totalNumberOfResult = configuration.getRowCount() != null ? configuration
					.getRowCount() : listResult.size();
			result = tranform(listResult);
			result.setTotalNumberOfResult((int) totalNumberOfResult);
		} else {
			result = new SearchResultBean();
		}
		return result;
	}

	public abstract SearchResultBean tranform(List<Object> resultQuery);

	public List<Object> execute(Serializable searchBean,
			SearchConfig configuration, String sortField, String sortOrder) {
		return specificExecute(searchBean, configuration, sortField, sortOrder);
	}

	public abstract List<Object> specificExecute(Serializable searchBean,
			SearchConfig configuration, String sortField, String sortOrder);

	public abstract SearchResultBean precondition(Serializable searchBean);
}
