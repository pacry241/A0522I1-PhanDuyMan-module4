package com.example.demotestmorning.controller;

import com.example.demotestmorning.dto.SearchSession;
import com.example.demotestmorning.model.Contract;
import com.example.demotestmorning.service.impl.ContractService;
import com.example.demotestmorning.service.impl.CustomerService;
import com.example.demotestmorning.validator.ValidatorContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
@SessionAttributes("searchSession")
public class ContractController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ContractService contractService;

    @Autowired
    ValidatorContract validatorContract;

    @ModelAttribute("searchSession")
    public SearchSession setUp(){
        return new SearchSession("");
    }

    @GetMapping("/list")
    public ModelAndView findAll(Pageable pageable,
                                @ModelAttribute(name = "searchSession") SearchSession searchSession,
                                @RequestParam(required = false) String searchVal){
        if(searchVal != null){
            searchSession.setValue(searchVal);
        }
        return new ModelAndView("home", "contracts", contractService.search(pageable,searchSession.getValue()));
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("customers", customerService.listAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNew(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model){
//        validatorContract.validate(contract, bindingResult);
//        if (bindingResult.hasErrors()){
//            model.addAttribute("customers", customerService.listAll());
//            return "create";
//        }
        contractService.create(contract);
//        redirectAttributes.addAttribute("message",
//                "Add Contract: " + contract.getContractId() + " done!!!");
        return "redirect:/contract/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer", customerService.listAll());
        modelAndView.addObject("contract", contractService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        contractService.delete(id);
        redirectAttributes.addFlashAttribute("message",
                "Delete contract: " + id + " done!");
        return "redirect:/contract/list";
    }

}
