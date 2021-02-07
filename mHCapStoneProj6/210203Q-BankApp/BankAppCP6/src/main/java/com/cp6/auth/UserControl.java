package com.cp6.auth;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserControl {
	
	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private RoleRepository rolerepo;

	
	@RequestMapping("/")
	public String home() {
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


	@RequestMapping("/users")
	public String ShowUsersList(Model model) {
		java.util.List<Users> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		System.out.println(" ====>  ShowUsersList / users <================");
		return "users";
	}
	
	@GetMapping("/users/new")
	public String ShowUserform(Model model) {
		List<Roles> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		model.addAttribute("Users", new Users());
		System.out.println(" ====>  ShowUserform / users/new <================");
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(Users user) {
		repo.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String ShowEditForm(@PathVariable("id") Integer id, Model model) {
		Users user =   repo.findById(id).get();
		model.addAttribute("Users", user);
		
		List<Roles> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		
		return "user_form";
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		repo.deleteById(id);;
		
		return "redirect:/users";
		
	}
	
	@RequestMapping("/Welcome")
	public String Welcome() {
		System.out.println(" ====>  UserControl / Welcome <================");
		return "Welcome";
	}


	
}