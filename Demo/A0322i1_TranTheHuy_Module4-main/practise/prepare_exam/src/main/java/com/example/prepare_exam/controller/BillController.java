package com.example.prepare_exam.controller;

import com.example.prepare_exam.model.Bill;
import com.example.prepare_exam.model.Product;
import com.example.prepare_exam.model.ProductType;
import com.example.prepare_exam.service.BillService;
import com.example.prepare_exam.service.ProductService;
import com.example.prepare_exam.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

//    @GetMapping("/list")
//    public ModelAndView showList(Pageable pageable){
//         Pageable pageable = PageRequest.of(page, 3);
//        return new ModelAndView("home", "bills", billService.findAll(pageable));
//    }

    @GetMapping("list")
    public String home(Model model, @RequestParam(value = "keyword", defaultValue = "") String keyword,
                       @RequestParam(value = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 3);
        model.addAttribute("bills", billService.findAllByRequirement(keyword, pageable));
        return "home";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("bill", new Bill());
        model.addAttribute("products", productService.listAll());
        model.addAttribute("productTypes", productTypeService.listAll());
        return "create";

    }

    @PostMapping("add")
    public String addBill(@Valid Bill bill, BindingResult result, Model model, ProductType productType, Product product) {
//        model.addAttribute("typeProducts", productTypeService.listAll());
        if (result.hasErrors()) {
            model.addAttribute("products", productService.listAll());
            model.addAttribute("productTypes", productTypeService.listAll());
            return "create";
        } else {
            billService.save(bill);
        }
        return "redirect:/bill/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Bill bill = billService.findById(id);
        model.addAttribute("productType", productTypeService.listAll());
        model.addAttribute("product", productService.listAll());
        model.addAttribute("bill", bill);
        return "edit";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") Integer id, @Valid Bill bill, BindingResult result, Model model) {
        bill.setBillId(id);
        if (result.hasErrors()) {
            model.addAttribute("product", productService.listAll());
            model.addAttribute("productType", productTypeService.listAll());
            return "edit";
        } else {
            billService.update(bill);
        }
        return "redirect:/bill/list";
    }

    @GetMapping("delete/{id}")
    public String deleteBill(@PathVariable("id") Integer id) {
        billService.deleteById(id);
        return "redirect:/bill/list";
    }
}
