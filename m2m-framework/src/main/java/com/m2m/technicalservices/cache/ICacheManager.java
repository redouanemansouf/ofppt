package com.m2m.technicalservices.cache;

/**
 * 
 * L'interface main du service de cache Il definit les methodes qui seront
 * implemente par les differents implmentations base sur des 3rd party caching
 * API
 * 
 * 
 * 
 * @version 1.0
 * @author @Younes SOUTEH
 */

public interface ICacheManager {

	/**
	 * recuperer un objet du cache a partir du region par defaut retourne null
	 * si l'objet n'existe pas dans le cache.
	 * 
	 * @param cacheKey
	 *            Cache object
	 * @param cacheLoader
	 *            ICacheLoader object
	 * @return cached object
	 * @throws CachingException
	 */
	public Object getCacheObject(CacheKey cacheKey) throws CachingException;

	/**
	 * charge l'objet dans la region par defaut dans le cache. .
	 */
	public void putCacheObject(CacheKey cacheKey, Object cacheObject)
			throws CachingException;

	/**
	 * verifier si l'objet est present dans la region par defaut de cache
	 * 
	 * @param cacheKey
	 * @return
	 * @throws CachingException
	 */
	public boolean isPresent(CacheKey cacheKey) throws CachingException;

	/**
	 * supprime le cached object a partir du region par defaut.
	 */
	public void removeCacheObject(CacheKey cacheKey) throws CachingException;

	/**
	 * vide la region par defaut .
	 */
	public void clear() throws CachingException;

}
