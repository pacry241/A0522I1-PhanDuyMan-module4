package com.example.customercs.controller;

import com.example.customercs.model.Customer;
import com.example.customercs.service.impl.CustomerService;
import com.example.customercs.service.impl.CustomerTypeService;
import com.example.customercs.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private CustomerValidator customerValidator;
    @GetMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("")
    public ModelAndView showCustomerList(@RequestParam(value = "page", defaultValue = "0")int page) {
        Page<Customer> pageList = customerService.findAllWithPage(PageRequest.of(page,1));
        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("customers", pageList);
        return modelAndView;
    }

    @GetMapping("create")
    public String showPageCrete(@ModelAttribute("customer") Customer customer, Model model) {
        model.addAttribute("customer", customer);
        model.addAttribute("listType", customerTypeService.findAll());
        return "create";
    }

    @PostMapping("create")
    public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        customerValidator.validate(customer, bindingResult);
//        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listType", customerTypeService.findAll());
            return "create";
        }
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/customer";
    }
    @GetMapping("delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id){
        customerService.delete(customerService.findById(id));
        return "redirect:/customer";
    }

    @GetMapping("edit/{id}")
    public String pageEdit(@PathVariable Long id, Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        model.addAttribute("listType", this.customerTypeService.findAll());
        return "edit";
    }

    @PostMapping("edit")
    public String updateCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("listType", this.customerTypeService.findAll());
            return "edit";
        }
        customerService.save(customer);
        return "redirect:/customer";
    }

}
