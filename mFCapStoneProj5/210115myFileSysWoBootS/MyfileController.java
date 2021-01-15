package com.cp5;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyfileController {
	
	@Autowired
	private MyfileDao myfileDao;
	
	//	http://localhost:8080/
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
//		model.addAttribute("listMyfile", myfileDao.getAllMyfiles());
//		return "index";
		return findPaginated(1, "fid", "ASC",  model);
	}
	
	@GetMapping("/page/{pageNo}")
	private String findPaginated(@PathVariable(value = "pageNo") int pageNo, 
								@RequestParam("sortField") String sortField, 
								@RequestParam("sortDirection") String sortDirection, 
								Model model) {
		
		int pageSize = 5;
//		Page <Myfile> page = myfileDao.findPaginated(pageNo, pageSize);
		Page <Myfile> page = myfileDao.findPaginated(pageNo, pageSize, sortField, sortDirection);
		List <Myfile> listMyfile = page.getContent();
		model.addAttribute("listMyfile", listMyfile);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDirection", sortDirection);
		model.addAttribute("reverseSortDirection", sortDirection.equalsIgnoreCase("ASC") ? "DESC" : "ASC");
		return "index";
	}

	
	@GetMapping("/showNewMyfileForm")
	public String showNewMyfileForm(Model model) {
		
		Myfile myfile =new Myfile();
		model.addAttribute("myfile", myfile);
		return "new_myfile";
	}
	
	@PostMapping("/saveMyfile")
////	public String saveMyfile(Model model) {
//	public String saveMyfile(@ModelAttribute("myfile")Myfile myfile) {
	public String saveMyfile(@Valid @ModelAttribute("myfile") Myfile myfile, BindingResult bindingResult) {
		// same customer to database
		
		if(bindingResult.hasErrors())
			return "new_myfile";	
		
		myfileDao.saveMyfile(myfile);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{fid}")
	public String showFormForUpdate(@PathVariable(value = "fid") long fid, Model model) {
		// Get Myfile from the Service 
		Myfile myfile = myfileDao.getMyfileById(fid);
		
		// set myfile as a model attribute to pre-populate the form 
		model.addAttribute("myfile", myfile);
		return "update_myfile";
	}

	@GetMapping("/deleteMyfile/{fid}")
	public String deleteMyfile(@PathVariable(value = "fid") long fid) {
		// call delete myfile method
		this.myfileDao.deleteMyfileById(fid);
		return "redirect:/";
	}

}
