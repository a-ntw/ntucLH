package com.ntuc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntuc.model.Car;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    @GetMapping
    public String main(Model model) {
        model.addAttribute("car", new Car());
        return "index";
    }

    @PostMapping
    public String save(Car car, Model model) {
        model.addAttribute("car", car);
        return "saved";
    }
}