/*
* LazySearchService.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.technicalservices.web;

import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 * The Class LazySearchService.
 *
 * @version 1.0 1 avr. 2015
 * @author amtarji
 */
@Service("lazySearchService")
public class LazySearchService implements ILazySearchService {

	/* (non-Javadoc)
	 * @see com.m2m.technicalservices.web.ILazySearchService#lazySearch(com.m2m.technicalservices.web.SearchBase, java.io.Serializable, com.m2m.technicalservices.web.SearchConfig, java.lang.String, java.lang.String)
	 */
	@Override
	public SearchResultBean lazySearch(SearchBase search,
			Serializable searchBean, SearchConfig configuration,
			String sortField, String sortOrder) {
		return search.search(searchBean, configuration, sortField, sortOrder);
	}

}
