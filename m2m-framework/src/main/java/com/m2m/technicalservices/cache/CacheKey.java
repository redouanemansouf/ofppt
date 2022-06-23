package com.m2m.technicalservices.cache;

import java.io.Serializable;

/**
 * Cette interface est impléménté par les cached object il definit la clé du
 * cached object.
 * 
 * @version 1.0
 * @author @Younes SOUTEH
 */
public class CacheKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2735448365021480863L;

	private String clazz;
	private String method;
	private Object[] methodArgs;
	private String key;

	/**
	 * constructor
	 * 
	 * @param clazz
	 * @param method
	 * @param methodArgs
	 */
	public CacheKey(String clazz, String method, Object[] methodArgs) {
		this.clazz = clazz;
		this.method = method;
		this.methodArgs = methodArgs;
		genererKey();
	}

	/**
	 * generate key
	 */
	private void genererKey() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(clazz + ":" + method);
		if (methodArgs != null) {
			stringBuilder.append("[");
			for (int i = 0; i < methodArgs.length - 1; i++) {
				stringBuilder.append(methodArgs[i].toString() + ",");
			}
			stringBuilder.append(methodArgs[methodArgs.length - 1].toString());
			stringBuilder.append("]");
		}
		key = stringBuilder.toString();
	}

	/**
	 * la cle de l'objet dans le cache
	 * 
	 * @return
	 * @throws CachingException
	 */
	public String getKey() {
		return key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return key.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof CacheKey)) {
			return false;
		}
		CacheKey cacheKey = (CacheKey) obj;
		if (this.getKey().equals(cacheKey.getKey())) {
			return true;
		}
		return false;
	}

}
