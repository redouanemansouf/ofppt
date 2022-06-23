package com.m2m.technicalservices.tools;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.m2m.technicalservices.cache.impl.EhCacheCacheManager;
import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;

public class Objects {

	private static final ILogger LOGGER = SL4JLogger
			.getInstance(EhCacheCacheManager.class);

	private Objects() {
	}

	/**
	 * Helps to avoid using {@code @SuppressWarnings( "unchecked"})} when
	 * casting to a generic type. See
	 * http://stackoverflow.com/questions/509076/how
	 * -do-i-address-unchecked-cast-warnings/509230#509230
	 */
	@SuppressWarnings({ "unchecked" })
	public static <T> T uncheckedCast(Object obj) {
		return (T) obj;
	}

	public static void copyProperties(Object dest, Object src) {

		try {

			BeanUtils.copyProperties(dest, src);

		} catch (IllegalAccessException e) {
			LOGGER.error(
					"IllegalAccessException while executing copyProperties method ",
					e);
		} catch (InvocationTargetException e) {
			LOGGER.error(
					"InvocationTargetException while executing copyProperties method ",
					e);
		}
	}

}
