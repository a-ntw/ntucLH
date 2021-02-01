package com.cp5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Autowired
	private CustomerDao customerDao;
	
	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
//	@Pointcut("execution(public String show*(..))")
//	public void test() {}
//	
//	@Before("test()")
//	public void LoggingAdvice() {
////		logger.info("Attribute has been added");
//		System.out.println("New Form");
//	}
	
	@Before("execution(public String findPageinated(..))")
//	@Before("execution(* Model addAttribute(..))")
//	@Before("execution(* *.addAttribute(..))")
	public void LoggingAdviceTwo() {
//		logger.info("Attribute has been added");
		System.out.println("Adding form details in homepage");
	}
	
	@Before("execution(public String showNewCustomerForm(..))")
	public void newCustomerLog() {
		logger.info("New form has been generated");
	}
	
	@Around("execution(public String deleteCustomer(*))")
	public Object doDeleteLog(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object obj = joinPoint.getArgs()[0];
		Long custId = Long.parseLong(obj.toString());
		Customer customer = customerDao.getCustomerById(custId);		
		logger.info("Customer " + customer + " will be deleted.");
		try {					
			Object result = joinPoint.proceed();
			logger.info("Customer " + customer + " has been deleted.");			
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}
//	@Before("execution(public String deleteCustomer(*))")
//	public void beforeDeleteLog(JoinPoint jp) {
//		Object obj = jp.getArgs()[0];
//		Long custId = Long.parseLong(obj.toString());
//		Customer customer = customerDao.getCustomerById(custId);		
//		logger.info("Customer " + customer + " will be deleted.");		
//	}
//	
//	@After("execution(public String deleteCustomer(*))")
//	public void afterDeleteLog(JoinPoint jp) {
//		Object obj = jp.getArgs()[0];
//		Long custId = Long.parseLong(obj.toString());				
//		logger.info("Customer " + custId + " has been deleted.");		
//	}
	
	@After("execution(public String showFormForUpdate(..))")
	public void beforeUpdateLog(JoinPoint jp) {
		Object obj = jp.getArgs()[0];
		Long custId = Long.parseLong(obj.toString());
		Customer customer = customerDao.getCustomerById(custId);		
		logger.info("Customer " + custId + " " + customer + " is selected for updating.");
	}
	
	@After("execution(public String saveCustomer(..))")
	public void saveLog(JoinPoint jp) {
		Object customer = jp.getArgs()[0];		
		logger.info("Customer " + customer + "'s information has been saved.");
	}
}
