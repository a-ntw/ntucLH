package com.ntuc.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ntuc.employee.model.Employee;
import com.ntuc.employee.service.EmployeeService;

import java.util.Comparator;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public String main(Model model) {

        model.addAttribute("employees", employeeService.generateEmployeeList());
        model.addAttribute("bySalary", Comparator.comparing(Employee::getSalary));

        return "employees";
    }
}
