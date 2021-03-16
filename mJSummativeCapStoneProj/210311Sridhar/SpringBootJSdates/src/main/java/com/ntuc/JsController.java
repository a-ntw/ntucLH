package com.ntuc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class JsController {

	@Autowired blockdates d;
	@Autowired bdatesRepository repo;

	
	@GetMapping("/")
	public String showMain(Model model) {
		Date[] listdates = repo.showDates();
		model.addAttribute("listdates", listdates);
		return "index";
	}
	
	@GetMapping("/new")
	public String shoadd(Model model) {
		blockdates bd = new blockdates();
		Date[] listdates = repo.showDates();
		String[] finalDates= new String[listdates.length];
		SimpleDateFormat b = new SimpleDateFormat("d-m-yyyy");
			for(int i=0;i<listdates.length;i++) {
				finalDates[i]=b.format(listdates[i]);
			}
		model.addAttribute("finalDates", finalDates);
		model.addAttribute("bd", bd);
		
		return "addform";
	}
	
	@PostMapping("/save")
	public String SaveDate(blockdates bdates) {
		repo.save(bdates);
		return "redirect:/";
	}
	
	
}
