package com.cp5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	
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
	public String saveCustomer(@ModelAttribute("customer")Customer customer ) {
		customerDao.saveCustomer(customer);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{custId}")
	public String showFormForUpdate(@PathVariable(value = "custId") long custId, Model model) {
		// Get Employee from the Service 
		Customer customer = customerDao.getCustomerById(custId);
		
		// set employee as a model attribute to pre-populate the form 
		model.addAttribute("customer", customer);
		return "update_customer";
	}
	
	@GetMapping("/deleteCustomer/{custId}")
	public String deleteCustomer(@PathVariable (value = "custId") long custId) {
	 // call delete employee method 
	 this.customerDao.deleteCustomerById(custId);
	 return "redirect:/";
	}
}
