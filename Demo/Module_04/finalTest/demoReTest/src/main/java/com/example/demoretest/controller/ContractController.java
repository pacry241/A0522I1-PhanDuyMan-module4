package com.example.demoretest.controller;

import com.example.demoretest.dto.SearchSession;
import com.example.demoretest.model.Contract;
import com.example.demoretest.model.Customer;
import com.example.demoretest.service.contract.ContractService;
import com.example.demoretest.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class ContractController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ContractService contractService;

    @GetMapping("/contracts")
    public ModelAndView  List(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("contracts", contractService.finAll());
        modelAndView.addObject("mySearch", new SearchSession());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        List<String> types = new ArrayList<>();
        types.add("Dat");
        types.add("Nha");

        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("types", types);
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("customers", customerService.finAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save (@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult){
       ModelAndView modelAndView = new ModelAndView("create");
       modelAndView.addObject("customers", customerService.finAll());

       if (bindingResult.hasErrors()){
           modelAndView.addObject("contract", contract);
           return modelAndView;
       }
       contractService.save(contract);
       modelAndView.addObject("contract", new Contract());
       modelAndView.addObject("message", "New contract created successfully");
       return modelAndView;
    }

}
