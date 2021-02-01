package com.cp5;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cp5.daoauthenticate.UserService;
import com.cp5.daoauthenticate.Users;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private UserService userService;
	
	//Model to hold data coming in and passing data out
	@RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword, HttpSession session) {
//		List<Customer> listCustomer = customerDao.getAllCustomers(keyword);
//        model.addAttribute("listCustomers", listCustomer);
//        model.addAttribute("keyword", keyword);
        session.setAttribute("favecolor", "red"); 
		
        return "index";
    }
	
	@RequestMapping("/bank")
    public String viewBankPage(Model model, @Param("keyword") String keyword, HttpSession session) {
//		List<Customer> listCustomer = customerDao.getAllCustomers(keyword);
//        model.addAttribute("listCustomers", listCustomer);
//        model.addAttribute("keyword", keyword);
        session.setAttribute("favecolor", "red"); 
		
        return findPageinated(1, "custId", "ASC", model, keyword);
    }

	@GetMapping("/page/{pageNo}")
	public String findPageinated(@PathVariable(value = "pageNo") int pageNo, 
									@Param("sortField") String sortField,
									@Param("sortDirection")String sortDirection, 
									Model model, 
									@Param("keyword") String keyword) {
		int pageSize = 5;		
		Page <Customer> page = customerDao.findPageinated(pageNo, pageSize, keyword, sortField, sortDirection);
		List <Customer> listCustomers = page.getContent();
		model.addAttribute("listCustomers", listCustomers);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDirection", sortDirection);
		model.addAttribute("reverseSortDir", sortDirection.equalsIgnoreCase("ASC") ? "DESC" : "ASC");
		model.addAttribute("keyword", keyword);
			
        
//        model.addAttribute("sessionId", session.getId());
		return "bank_app";
	}	

	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);		
		return "new_customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, 
			@Param("newOrUpdate")String newOrUpdate) {
		//1)do validation on customer 2)store into binding result 3)if result has any errors in result
		if (bindingResult.hasErrors() && newOrUpdate.equals("new")) 		
			return "new_customer";
		else if (bindingResult.hasErrors() && newOrUpdate.equals("update"))
			return "update_customer";
		customerDao.saveCustomer(customer);
		return "redirect:/bank_app";
	}
	
	@GetMapping("/newUserForm")
	public String showNewUserForm(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);		
		return "new_user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") Users user, BindingResult bindingResult) {
		//1)do validation on customer 2)store into binding result 3)if result has any errors in result
		if (bindingResult.hasErrors()) 		
			return "new_user";		
		userService.saveUser(user);
		System.out.println("user created");
		return "redirect:/bank_app";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable (value = "id") long userId) {
		// call delete employee method 
		this.userService.deleteUserById(userId);
		return "redirect:/adminPage";
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
		return "redirect:/bank_app";
	}

	@RequestMapping("/login")
	public String login() {		
		return "login";
	}
	
	@RequestMapping("/adminPage")
    public String viewAdminPage(Model model, @Param("keyword") String keyword) {

        return findAdminPageinated(1, "id", "ASC", model, keyword);
    }

	@GetMapping("/adminPage/{pageNo}")
	public String findAdminPageinated(@PathVariable(value = "pageNo") int pageNo, 
									@Param("sortField") String sortField,
									@Param("sortDirection")String sortDirection, 
									Model model, 
									@Param("keyword") String keyword) {
		int pageSize = 5;		
		Page <Users> page = userService.findPageinated(pageNo, pageSize, keyword, sortField, sortDirection);
		List <Users> listUsers = page.getContent();
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDirection", sortDirection);
		model.addAttribute("reverseSortDir", sortDirection.equalsIgnoreCase("ASC") ? "DESC" : "ASC");
		model.addAttribute("keyword", keyword);		
		return "admin_page";
	}
}
