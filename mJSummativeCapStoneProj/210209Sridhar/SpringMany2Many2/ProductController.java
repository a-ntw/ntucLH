package com.ntuc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ntuc.model.Category;
import com.ntuc.model.Products;
import com.ntuc.repository.CategoryRepository;
import com.ntuc.repository.ProductRepository;

@Controller
public class ProductController {

	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private CategoryRepository catrepo;
	
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		List<Products> listProducts = repo.findAll();
		model.addAttribute("listProducts",listProducts);
		return "products";
	}
	
	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		List<Category> listCategories =  catrepo.findAll();
		model.addAttribute("product", new Products());
		model.addAttribute("listCategories",listCategories);
		return "product_form";
		
	}
	
	
	@PostMapping("/products/save")
	public String saveProduct(Products product, HttpServletRequest request) {
		String[] detailIDs = request.getParameterValues("detailID");
		String[] detailNames = request.getParameterValues("detailName");
		String[] detailValues = request.getParameterValues("detailValue");
		
		for (int i = 0; i< detailNames.length; i++) {
			if(detailIDs != null && detailIDs.length > 0)
				product.setDetails(Integer.valueOf(detailIDs[i]), detailNames[i], detailValues[i]);
			else {
				product.addDetail(detailNames[i], detailValues[i]);
		}
		}
		repo.save(product);
		return "redirect:/products";
	}

	
	@GetMapping("/products/edit/{id}")
	public String ShowProductEditForm(@PathVariable("id") Integer id, Model model) {
		Products product = repo.findById(id).get();
		model.addAttribute("product", product);
		List<Category> listCategories = catrepo.findAll();
		model.addAttribute("listCategories", listCategories);
		return "product_form";
		
	}
	
	@GetMapping("/products/delete/{id}")
	public String ShowProductDeleteForm(@PathVariable("id") Integer id, Model model) {
		repo.deleteById(id);
		return "redirect:/products";
	}
	

}
