package com.Aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Aop.demo.SpringAopApplication;


@Aspect
public class LoggingAspect {
	
	Logger logger = LoggerFactory.getLogger(SpringAopApplication.class);
		
	//@Before("execution(public String getName())")
	//@Before("execution(public String com.Aop.demo.Circle.getName())")
	//@Before("execution(public * get*())")
	//@Before("allGetters()")
	
	
	public void LoggingAdvice() {
		//System.out.println("Advice run. The Get method is called");
		logger.info("The Advice Get method has been called.");
		
	}
	
	
	@Before("aspecttest()")
	public void SecondLogging() {
		System.out.println("Advice run Second time.");
	}
	

	@Pointcut("execution(public String getName())")
	public void aspecttest() {}
	
	
	

}
