package com.m2m.technicalservices.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.m2m.technicalservices.core.ProcessMsg;
import com.m2m.technicalservices.core.ProcessResult;
import com.m2m.technicalservices.spring.BeansLookuper;

public abstract class AbstractSearchMBean extends
		LazyDataModel<ISearchResultVO> implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final int PAGE_SIZE = 100;
	protected SearchConfig config = new SearchConfig();
	protected SearchBase search;
	protected Serializable searchCriteria;
	protected SearchResultBean searchResultBean = new SearchResultBean();
	private List<ISearchResultVO> clientRows;
	protected boolean execSearch;
	protected List<ProcessMsg> messages = new ArrayList<ProcessMsg>();

	public AbstractSearchMBean() {
		setPageSize(PAGE_SIZE);
	}

	@PostConstruct
	protected void init() {
		initData();
	}

	protected void initData() {
	}

	/**
	 * Resets the searchCriteria To be implemented by the child classes
	 * *SearchMBean
	 * 
	 * @author aelhachimi 17 Fév 2015
	 */
	public abstract void resetSearchCriteria();

	
	@Override
	public ISearchResultVO getRowData(String rowKey) {
		if (searchResultBean != null
				&& searchResultBean.getResultBean() != null) {
			List<ISearchResultVO> rows = searchResultBean.getResultBean()
					.getRows();
			if (rows != null) {
				for (ISearchResultVO elem : rows) {
					if (elem.getIdForSearch().equals(rowKey)) {
						return elem;
					}
				}
			}
		}
		return null;
	}

	@Override
	public List<ISearchResultVO> load(int first, int pageSize,
			String sortField, SortOrder sortingOrder,
			Map<String, Object> filters) {
		if (!execSearch) {
			resetConfig();
			this.setRowCount(0);
			return new ArrayList<ISearchResultVO>();
		}
		config.setOffset(first);
		config.setPageSize(pageSize);
		/**
		 * Sorting
		 */
		String sortOrder = sortingOrder != null ? (SortOrder.ASCENDING.name()
				.equals(sortingOrder.name()) ? "ASC" : "DESC") : null;

		/**
		 * * @author amtarji
		 * 
		 * Ajout de Transactional pour le chargement lazy des collections selon
		 * le mapping VO/model, utilisez 'forCombo' et dozzer pour mapper QUE
		 * les collections/champs souhaitées.
		 * 
		 */
		searchResultBean = ((ILazySearchService) BeansLookuper
				.lookup("lazySearchService")).lazySearch(search,
				searchCriteria, config, sortField, sortOrder);

		if (searchResultBean != null && searchResultBean.isError()) {
			this.afficherMessages();
			return new ArrayList<ISearchResultVO>();
		}
		this.setRowCount((int) searchResultBean.getTotalNumberOfResult());
		return searchResultBean.getResultBean().getRows();
	}

	private void afficherMessages() {
		ProcessMsg msg = searchResultBean.getProcessMsg();
		if (msg == null) {
			messages = new ArrayList<ProcessMsg>();
		}
		if (msg != null) {
			messages.add(msg);
		}
		ProcessResult resultMsg = new ProcessResult();
		resultMsg.setMessages(messages);
		MessageHelper.processBusinessMesssage(resultMsg);
	}

	@Override
	public Object getRowKey(ISearchResultVO searchResultVo) {
		return searchResultVo.getIdForSearch();
	}

	public SearchResultBean getSearchResultBean() {
		return searchResultBean;
	}

	public void setSearchResultBean(SearchResultBean searchResultBean) {
		this.searchResultBean = searchResultBean;
	}

	public List<ISearchResultVO> getClientRows() {
		return clientRows;
	}

	public void setClientRows(List<ISearchResultVO> clientRows) {
		this.clientRows = clientRows;
	}

	/**
	 * Reset configuration.
	 */
	protected void resetConfig() {
		config.setOffset(0);
		config.setRowCount(null);
	}

	public void run() {
		this.resetConfig();
		SearchResultBean result = search.precondition(searchCriteria);
		if (result != null && result.isError()) {
			this.searchResultBean = result;
			this.afficherMessages();
			execSearch = false;
		} else {
			execSearch = true;
		}
	}

	public boolean isExecSearch() {
		return execSearch;
	}

	public void setExecSearch(boolean execSearch) {
		this.execSearch = execSearch;
	}

	public Serializable getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(Serializable searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public SearchConfig getConfig() {
		return config;
	}

	public void setConfig(SearchConfig config) {
		this.config = config;
	}

	public SearchBase getSearch() {
		return search;
	}

	public void setSearch(SearchBase search) {
		this.search = search;
	}

	public List<ProcessMsg> getMessages() {
		return messages;
	}

	public void setMessages(List<ProcessMsg> messages) {
		this.messages = messages;
	}

}
