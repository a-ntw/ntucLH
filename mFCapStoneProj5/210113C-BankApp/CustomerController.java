package com.cp5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	//	http://localhost:8080/
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("listCustomers", customerDao.getAllCustomers());
		return "index";
		
	}
	
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		
		Customer customer =new Customer();
		model.addAttribute("customer", customer);
		return "new_customer";
	}
	
	@PostMapping("/saveCustomer")
//	public String saveCustomer(Model model) {
	public String saveCustomer(@ModelAttribute("customer")Customer customer) {
		
		customerDao.saveCustomer(customer);
		return "redirect:/";
	}

}
