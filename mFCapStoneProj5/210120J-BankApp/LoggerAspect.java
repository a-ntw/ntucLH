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
	public void doLog(JoinPoint jp) {
		Object obj = jp.getArgs()[0];
		Long l = Long.parseLong(obj.toString());
		System.out.println(l);
		
		Customer customer = customerDao.getCustomerById(l);
		System.out.println("  ===> customer " + customer.toString());
		System.out.println("Request to delete by the name, " + customer.getCustName() 
		+ ", with an Customer ID = " + l + " has been Received.");
//		log.info(customer.toString());
		System.out.println(" ==> getSignature :: " + jp.getSignature());
		System.out.println(" ==> getStaticPart :: " + jp.getStaticPart());
	}

//	@Before("execution(public String updateCustomer(..))")
//	public void updateLog() {
//		System.out.println("  ===> Advice logged - Update");
//	}

	
}
