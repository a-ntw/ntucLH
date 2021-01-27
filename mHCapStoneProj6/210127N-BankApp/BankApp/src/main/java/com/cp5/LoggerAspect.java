package com.cp5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	
	Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Autowired
	private CustomerDao customerDao;
	
	@Before("execution(public String deleteCustomer(..))")
	public void deleteLog(JoinPoint jp) {
		Object obj = jp.getArgs()[0];
		Long l = Long.parseLong(obj.toString());
		System.out.println(l);
		
		Customer customer = customerDao.getCustomerById(l);
		System.out.println("  ===> customer " + customer.toString());
		System.out.println("Request to Delete by the name, " + customer.getCustName() 
		+ ", with an Customer ID = " + l + " has been Received.");
		log.info(customer.toString()); // application.properties
		log.warn(" ===> deleteLog :: " + customer.toString() + " >==="); // application.properties
//		System.out.println(" ==> delete/getSignature :: " + jp.getSignature());
//		System.out.println(" ==> delete/getStaticPart :: " + jp.getStaticPart());
//		System.out.println(" ==> delete/getKind :: " + jp.getKind());
//		System.out.println(" ==> delete/jp.getArgs().toString() :: " + jp.getArgs().toString());
	}
	
	@Before("execution(public String showFormForUpdate(..))")
	public void updateLog(JoinPoint jp) {
		
		Object obj = jp.getArgs()[0];
		Long l = Long.parseLong(obj.toString());
		System.out.println(" ===> customer id: " + l);
		
		Customer customer = customerDao.getCustomerById(l);
		System.out.println("Advise to Update by the name, " + customer.getCustName() 
		+ ", with an Customer ID = " + l + " has been Received.");

		log.warn("  ===> updateLog customer Id :: " + customer.toString() + " <==="); // application.properties
	}

}
