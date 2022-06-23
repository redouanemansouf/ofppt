package com.m2m.technicalservices.cache.impl;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.hibernate.cache.CacheException;

import com.m2m.technicalservices.cache.CacheKey;
import com.m2m.technicalservices.cache.ICacheManager;
import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;

/**
 * implementation JBoss Cache
 * 
 * 
 * @version 1.0
 * @author Younes SOUTEH
 * 
 */
public class EhCacheCacheManager implements ICacheManager {

	private static final ILogger LOGGER = SL4JLogger
			.getInstance(EhCacheCacheManager.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.framework.technicalservices.cache2.ICacheManager#getCacheObject
	 * (com.m2m.framework.technicalservices.cache2.CacheKey)
	 */
	private Cache cache;

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public Object getCacheObject(CacheKey cacheKey)
			throws com.m2m.technicalservices.cache.CachingException {
		Object cachedObject = null;
		try {
			cachedObject = cache.get(cacheKey);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("cacheKey  :" + cacheKey + "cachedObject exist"
						+ (cachedObject == null));
			}
		} catch (IllegalStateException e) {
			LOGGER.error("erreur IllegalStateException getCacheObject", e);
		} catch (CacheException e) {
			LOGGER.error("erreur CacheException getCacheObject", e);
		}
		if (cachedObject != null) {
			return ((Element) cachedObject).getObjectValue();
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.framework.technicalservices.cache2.ICacheManager#putCacheObject
	 * (com.m2m.framework.technicalservices.cache2.CacheKey, java.lang.Object)
	 */
	public void putCacheObject(CacheKey cacheKey, Object cacheObject)
			throws com.m2m.technicalservices.cache.CachingException {
		Element element = new Element(cacheKey, (Serializable) cacheObject);
		cache.put(element);

	}

	public boolean isPresent(CacheKey cacheKey)
			throws com.m2m.technicalservices.cache.CachingException {

		return cache.isKeyInCache(cacheKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.m2m.framework.technicalservices.cache2.ICacheManager#removeCacheObject
	 * (com.m2m.framework.technicalservices.cache2.CacheKey)
	 */
	public void removeCacheObject(CacheKey cacheKey)
			throws com.m2m.technicalservices.cache.CachingException {
		cache.remove(cacheKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.framework.technicalservices.cache2.ICacheManager#clear()
	 */
	public void clear() throws com.m2m.technicalservices.cache.CachingException {
		try {
			cache.removeAll();
		} catch (IllegalStateException e) {
			LOGGER.error("erreur IllegalStateException clear cache", e);
		}
	}

}
