package com.ntuc.controller;

import com.ntuc.repository.*;
import com.ntuc.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository repo;
	
	@GetMapping("/categories")
	public String listCategories(Model model) {
		List<Category> listcategories = repo.findAll();
		model.addAttribute("listcategories",listcategories);
		return "categories";
	}
	
	@GetMapping("/categories/new")
	public String ShowCategoryNewForm(Model model) {
		model.addAttribute("category", new Category());
		
		return "category_form";
						
	}
	
	@PostMapping("/categories/save")
	public String saveCategory(Category category) {
		repo.save(category);
		return "redirect:/categories";
	}
	
	@GetMapping("/error")
	public String Error() {
		
		return "error";
						
	}
	
}
