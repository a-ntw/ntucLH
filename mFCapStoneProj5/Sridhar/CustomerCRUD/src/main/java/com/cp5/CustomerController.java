package com.cp5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		//lab-1 - lab -5 BEG
//		model.addAttribute("listCustomers", customerDao.getAllCustomers());
//		return "index";
		// lab 1 - lab - 5 END
//		return findPaginated(1, model); // lab6
		return findPaginated(1, "custId", "asc", model);
	}
	
	@GetMapping("/showNewCustomerForm")
	 public String showNewCustomerForm(Model model) {
	     // create model attribute to bind form data
	     Customer customer= new Customer();
	     model.addAttribute("customer", customer);
	     return "new_customer";
	 }
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        // save employee to database

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
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField, //lab-7
			@RequestParam("sortDir") String sortDir, //lab-7
			Model model) {
	    int pageSize = 5;

//	    Page < Customer> page = customerDao.findPaginated(pageNo, pageSize);
	    Page < Customer> page = customerDao.findPaginated(pageNo, pageSize, sortField, sortDir);
	    List < Customer > listCustomers = page.getContent();

	    model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    
	    // lab 7 - BEGIN
	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	    // lab 7 - END
	    model.addAttribute("listCustomers", listCustomers);
	    return "index";
	}
	
	
	
}
