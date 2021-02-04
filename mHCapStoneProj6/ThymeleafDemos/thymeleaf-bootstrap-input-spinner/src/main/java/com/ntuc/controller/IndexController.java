package com.ntuc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntuc.model.Weather;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    @GetMapping
    public String main(Model model) {
        model.addAttribute("weather", new Weather());
        return "index";
    }

    @PostMapping
    public String save(Weather weather, Model model) {
        model.addAttribute("weather", weather);
        return "saved";
    }
}
