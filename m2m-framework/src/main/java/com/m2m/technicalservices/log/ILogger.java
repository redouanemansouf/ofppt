package com.m2m.technicalservices.log;

public interface ILogger {
	void debug(String msg);

	void debug(String msg, Throwable t);

	void info(String msg);

	void info(String msg, Throwable t);

	void warning(String msg);

	void warning(String msg, Throwable t);

	void error(String msg);
	
	void error(String msg, Throwable t);

	boolean isDebugEnabled();
	
	boolean isErrorEnabled();
	
	boolean isInfoEnabled();
	
	boolean isWarnEnabled();
	


	
}
