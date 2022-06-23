/*
* ILazySearchService.java
*
* Copyright (c) 1990-2015 M2M Group, Inc. All Rights Reserved.
*/
package com.m2m.technicalservices.web;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;


/**
 * The Interface ILazySearchService.
 *
 * @version 1.0 1 avr. 2015
 * @author amtarji
 */
public interface ILazySearchService {
	
	/**
	 * Lazy search.
	 *
	 * @param search the search
	 * @param searchBean the search bean
	 * @param configuration the configuration
	 * @param sortField the sort field
	 * @param sortOrder the sort order
	 * @return the search result bean
	 */
	@Transactional(readOnly=true)
	public SearchResultBean lazySearch(SearchBase search, Serializable searchBean,
			SearchConfig configuration, String sortField, String sortOrder);
}
