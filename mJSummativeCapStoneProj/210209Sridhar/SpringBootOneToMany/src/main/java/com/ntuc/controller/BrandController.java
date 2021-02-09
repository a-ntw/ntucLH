package com.ntuc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ntuc.model.Brands;
import com.ntuc.model.Category;
import com.ntuc.repository.BrandRepository;
import com.ntuc.repository.CategoryRepository;

@Controller
public class BrandController {

	@Autowired
	private BrandRepository repo;
	
	@Autowired
	private CategoryRepository catrepo;
	
	@GetMapping("/brands/new")
	public String ShowNewBrandForm(Model model) {
		model.addAttribute("brand", new Brands());
		List<Category> listcategories = catrepo.findAll();
		model.addAttribute("listcategories",listcategories);
		return "brand_form";
	}
	
	@PostMapping("/brands/save")
	public String saveBrand(Brands brand) {
		repo.save(brand);
		return "redirect:/brands";
	}
	
	@GetMapping("/brands")
	public String  listBrands(Model model) {
		List<Brands> listBrands = repo.findAll();
		model.addAttribute("listBrands",listBrands);
		return "brands";
	}
	
	@GetMapping("/brands/edit/{id}")
	public String ShowBrandEditForm(@PathVariable("id") Integer id, Model model) {
		Brands brand = repo.findById(id).get();
		model.addAttribute("brand",brand);
		List<Category> listcategories = catrepo.findAll();
		model.addAttribute("listcategories", listcategories);
		return "brand_form";
	}
	
}
