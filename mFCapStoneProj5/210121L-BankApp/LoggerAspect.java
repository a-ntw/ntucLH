package com.cp5;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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

/*
5
  ===> customer com.cp6.cust.Customer@222a1d7c
Request to Delete by the name, Erisson John, with an Customer ID = 5 has been Received.
2021-02-22 22:18:00.292  INFO 2592 --- [nio-8080-exec-5] com.cp6.cust.LoggerAspect                : com.cp6.cust.Customer@222a1d7c
2021-02-22 22:18:00.293  WARN 2592 --- [nio-8080-exec-5] com.cp6.cust.LoggerAspect                :  ===> deleteLog :: com.cp6.cust.Customer@222a1d7c >===
==========> UsersDetailImpl Set<Roles> userRoles.size():: 4
==========> UsersDetailImpl,userRole:: SALESPERSON
==========> UsersDetailImpl,userRole:: ADMIN
==========> UsersDetailImpl,userRole:: MANAGER
==========> UsersDetailImpl,userRole:: USER

*/
