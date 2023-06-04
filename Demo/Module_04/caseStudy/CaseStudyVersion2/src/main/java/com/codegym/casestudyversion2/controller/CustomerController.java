package com.codegym.casestudyversion2.controller;

import com.codegym.casestudyversion2.dto.CustomerDto;
import com.codegym.casestudyversion2.model.Customer;
import com.codegym.casestudyversion2.model.CustomerType;
import com.codegym.casestudyversion2.service.CustomerService;
import com.codegym.casestudyversion2.service.CustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/home")
    public String goHomePage() {
        return "/home";
    }

    @ModelAttribute("customerTypes")
    public List<CustomerType> findAllCustomerType() {
        return this.customerTypeService.findAll();
    }

    @GetMapping("/list")
    public String goListCustomers(Model model,
                                  @RequestParam(value = "customerName", defaultValue = "") String name,
                                  @RequestParam(value = "customerPhone", defaultValue = "") String phone,
                                  @RequestParam(value = "customerEmail", defaultValue = "") String email,
                                  @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("customerName").descending();
        model.addAttribute("listCustomer", customerService.findAllByCustomerNameContainingOrAndCustomerPhoneContainingOrAndCustomerEmailContaining(
                name, phone, email, PageRequest.of(page, 3, sort)));
//        model.addAttribute("listCustomer", customerService.findAllWithPage(PageRequest.of(page, 3, sort)));
        return "/list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new Customer()); //gióng nhau
        String[] listGender = {"0", "1", "2"};
        model.addAttribute("listGender", listGender);
        model.addAttribute("customerType", this.customerTypeService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute @Valid Customer customer, // giống nhau
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            String[] listGender = {"0", "1", "2"};
            model.addAttribute("listGender", listGender);
            model.addAttribute("customerType", this.customerTypeService.findAll());
            return "create";
        } else {
            CustomerDto newCustomer = new CustomerDto();
            BeanUtils.copyProperties(customer, newCustomer);
            customerService.save(newCustomer);
            redirectAttributes.addFlashAttribute("success", "Save Customer Successfully!");
            return "redirect:/customer";
        }
    }

    @GetMapping("/showEdit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        CustomerDto customerDto = (CustomerDto) customerService.findById(id);
        String[] listGender = {"0", "1", "2"};
        model.addAttribute("listGender", listGender);
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerType", this.customerTypeService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute @Valid Customer customer,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            String[] listGender = {"0", "1", "2"};
            model.addAttribute("listGender", listGender);
            model.addAttribute("customerType", this.customerTypeService.findAll());
            return "edit";
        } else {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            customerService.save(customerDto);
            redirectAttributes.addFlashAttribute("success", "Save Customer successfully!");
            return "redirect:/customer";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        CustomerDto customer = (CustomerDto) customerService.findById(id);
        if (customer == null) {
            return "error";
        }
        customerService.deleteById(customer.getCustomerId());
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detailById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", customerService.findById(id));
        return "detail";
    }
}
