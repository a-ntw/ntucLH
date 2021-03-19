package com.ntuc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JsController {

	@GetMapping("/")
	public String showMain(Model model) {

		List<Blockdate> listBddates = null;
		String[] fdates = calenderBlkDates.fdates(listBddates);
		
		model.addAttribute("calenderBlkDates", fdates); // finalDates can only add once

		return "index";
	}


}
