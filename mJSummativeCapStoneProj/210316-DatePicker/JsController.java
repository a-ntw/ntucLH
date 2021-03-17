package com.ntuc;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JsController {

	@Autowired blockdates d;
	
	@Autowired bdatesRepository repo;
	
	@GetMapping("/")
	public String showMain(Model model) {
		List<blockdates> listdates = repo.findAll();

		model.addAttribute("listdates", listdates);

		return "index";
	}

}
