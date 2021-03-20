package com.ntuc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JsController {

	@Autowired Blockdate d;
	@Autowired bdatesRepository repo;
	
	@GetMapping("/")
	public String showMain(Model model) {

		List<Blockdate> listBddates = repo.findAll();
		String[] fdates = calenderBlkDates.fdates(listBddates);
		
		model.addAttribute("calenderBlkDates", fdates); // finalDates can only add once

		return "index";
	}


}
