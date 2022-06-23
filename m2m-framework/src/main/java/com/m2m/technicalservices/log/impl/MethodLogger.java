package com.m2m.technicalservices.log.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class MethodLogger {

	@Around("execution(* com.m2m..*.*(..))")
	public Object timeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object retVal = joinPoint.proceed();

		stopWatch.stop();

		StringBuilder logMessageStringBuffer = new StringBuilder();
		logMessageStringBuffer.append(joinPoint.getTarget().getClass()
				.getName());
		logMessageStringBuffer.append(".");
		logMessageStringBuffer.append(joinPoint.getSignature().getName());
		logMessageStringBuffer.append("(");
		logMessageStringBuffer.append(joinPoint.getArgs());
		logMessageStringBuffer.append(")");
		logMessageStringBuffer.append(" execution time: ");
		logMessageStringBuffer.append(stopWatch.getTotalTimeMillis());
		logMessageStringBuffer.append(" ms");

		SL4JLogger.getInstance(this.getClass()).info(
				logMessageStringBuffer.toString());

		return retVal;
	}
}
