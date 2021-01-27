package com.cp5.authenticate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class CheckUser {
	private Object principal;
	private String user;
	
	@Around("execution(public String TestAop(..))")
	public String checkLoggerUser(ProceedingJoinPoint joinpoint) throws Throwable {
		
		principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println(" ====>> CheckUser >> " + principal);
		
		if (principal instanceof UserDetails) {
			user = ((UserDetails) principal).getUsername();
		} else {
			user = principal.toString();
		}

		if (user.equals("ntuc")) {
			System.out.println("success");
			System.out.println(" ====>  CheckUser / SUCCESS <================");
			return "redirect:/error.html";
		}
		else {
			System.out.println("not success");
			return (String)joinpoint.proceed();
		}
			
	}
}
