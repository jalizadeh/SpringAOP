package com.jalizadeh.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(public String getName())")
	public void LoggingAdvice() {
		System.err.println(">Log: LoggingAdvice run, get name method captured.");
	}
}
