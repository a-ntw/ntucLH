package com.cp5.authenticate;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserControl {
	
	@RequestMapping("/")
	public String Welcome() {
		System.out.println(" ====>  UserControl / Welcome <================");
		return "index";
//		return "Welcome";
	}

	@RequestMapping("/testaop")
	public String TestAop(Principal principal) {
		System.out.println(" ====>  UserControl / AOP <================");
		return "Welcomeaop";
	}

	@RequestMapping("/login")
	public String login() {
		System.out.println(" ====>  UserControl /login <================");
			return "login";
	}

	@RequestMapping("/logout-success")
	public String logout() {
		System.out.println(" ====>  UserControl /Logout!! <================");
			return "logout";
	}
	
}