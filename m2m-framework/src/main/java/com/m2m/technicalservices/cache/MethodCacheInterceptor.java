package com.m2m.technicalservices.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;

/**
 * a
 * 
 * @author @Younes SOUTEH
 * 
 */
@Aspect
public class MethodCacheInterceptor {

	private ICacheManager cacheManager;

	/** logger for MethodCachingInterceptor */
	private static final ILogger LOGGER = SL4JLogger
			.getInstance(MethodCacheInterceptor.class);

	@Around("@annotation(CacheableMethod)")
	public Object cachedObject(ProceedingJoinPoint pjp) throws Throwable {

		LOGGER.info("Caching object");

		String targetMethodName = pjp.getSignature().getName();
		String clazz = pjp.getTarget().getClass().getName();
		Object[] methodArgs = pjp.getArgs();

		CacheKey cacheKey = new CacheKey(clazz, targetMethodName, methodArgs);
		Object methodReturn;

		synchronized (this) {
			methodReturn = cacheManager.getCacheObject(cacheKey);
			if (methodReturn == null) {
				methodReturn = pjp.proceed();
				cacheManager.putCacheObject(cacheKey, methodReturn);
			}
		}

		return methodReturn;
	}

	/**
	 * @return the cacheManager
	 */
	public ICacheManager getCacheManager() {
		return cacheManager;
	}

	/**
	 * @param cacheManager
	 *            the cacheManager to set
	 */
	public void setCacheManager(ICacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}
