package com.example.casestudy.controller;

import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String ShowEmployeePage(@RequestParam(value = "page", defaultValue = "0") int page, Model model){
        Sort sort = Sort.by("employeeName").descending();
        model.addAttribute("employees", employeeService.findAll(PageRequest.of(page, 1, sort)));
        return "/employee";
    }


}
