package com.m2m.technicalservices.log.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.m2m.technicalservices.log.ILogger;

public class SL4JLogger implements ILogger {

	private Logger logger;

	private SL4JLogger(Logger sl4jLogger) {
		this.logger = sl4jLogger;
	}

	public static ILogger getInstance(Class clazz) {
		return new SL4JLogger(LoggerFactory.getLogger(clazz));
	}

	public void debug(String msg) {
		logger.debug(msg);
	}

	public void debug(String msg, Throwable t) {
		logger.debug(msg, t);
	}

	public void info(String msg) {
		logger.info(msg);
	}

	public void info(String msg, Throwable t) {
		logger.info(msg, t);
	}

	public void warning(String msg) {
		logger.warn(msg);
	}

	public void warning(String msg, Throwable t) {
		logger.warn(msg);
	}

	public void error(String msg) {
		logger.error(msg);
	}

	public void error(String msg, Throwable t) {
		logger.error(msg, t);
	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

}
