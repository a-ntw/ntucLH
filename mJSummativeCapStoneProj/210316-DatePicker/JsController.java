package com.ntuc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JsController {

	@GetMapping("/")
	public String showMain(Model model) {

		model.addAttribute("finalDates", finalDates());

		return "index";
	}

	public String[] finalDates() {
		
		LocalDate[] listdates = new LocalDate[3];				// size up first
		LocalDate abcDate1 = LocalDate.parse("2021-04-20");
		LocalDate abcDate2 = LocalDate.parse("2021-04-21");
		LocalDate abcDate3 = LocalDate.parse("2021-04-22");
		listdates[0] = abcDate1;
		listdates[1] = abcDate2;
		listdates[2] = abcDate3;

		
		String[] finalDates= new String[listdates.length];
	
		DateTimeFormatter dTF; 
		dTF = DateTimeFormatter.ofPattern("d/M/yyyy");

		for(int i=0;i<listdates.length;i++) {
			finalDates[i]=dTF.format(listdates[i]);
		}
		
		return finalDates;
		
	}
	
}
