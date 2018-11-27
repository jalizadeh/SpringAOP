package com.jalizadeh.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LoggingAspect {

	//only for getName methods
	//@Before("execution(public String getName())")
	
	//make it specifically activate on one class
	//@Before("execution(public String com.jalizadeh.model.Circle.getName())")
	
	//activate on all the classes inside package model
	//@Before("execution(public String com.jalizadeh.model.*.getName())")
	
	//make it active for any "getter" method with any return type
	//use * where ever you want
	//get*(..) -> has zero-unlimited number of args
	//get*(*) -> has some number of args
	//@Before("execution(public * get*(*))")
	
	@Before("allGetters() && packageAndSubpackageMethod()")
	public void LoggingAdvice() {
		System.err.println(">Log: LoggingAdvice run, get name method captured."); 
	}
	
	@Before("allGetters()")
	public void SecondAdvice() {
		System.err.println(">Log: SecondAdvice run, get method captured."); 
	}
	
	
	/**
	 * This is a dummy method to carry the @Pointcut
	 * can be used when a execution statement is very long or
	 * used a lot
	 */
	@Pointcut("execution(public * get*())")
	public void allGetters() {}
	
	
	//video 29
	/**
	 * sensitive to any method inside class Circle
	 */
	//@Pointcut("execution(* * com.jalizadeh.model.Circle.*(..))")
	@Pointcut("within(com.jalizadeh.model.Circle)")
	public void allCircleMethods() {}
	
	/**
	 * all classes inside package model 
	 */
	@Pointcut("within(com.jalizadeh.model.*)")
	public void packageMethod() {}
	
	
	
	/**
	 * all classes inside package model & it`s sub packages
	 */
	@Pointcut("within(com.jalizadeh.model..*)")
	public void packageAndSubpackageMethod() {}
}
