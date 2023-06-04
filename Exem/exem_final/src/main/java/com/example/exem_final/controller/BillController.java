package com.example.exem_final.controller;

import com.example.exem_final.model.Bill;
import com.example.exem_final.model.Product;
import com.example.exem_final.model.ProductType;
import com.example.exem_final.service.BillService;
import com.example.exem_final.service.ProductService;
import com.example.exem_final.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("list")
    public String home(Model model, @RequestParam(value = "keyword", defaultValue = "") String keyword,
                       @RequestParam(value = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
//        String[] listNumber = {"1","2","3","4","5","6","7","8","9","10"};
//        model.addAttribute("listNumber", listNumber);
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
    public String updateStudent(@PathVariable("id") Integer id, Bill bill, Model model) {
        bill.setBillId(id);
        billService.update(bill);
        return "redirect:/bill/list";
    }

    @GetMapping("delete/{id}")
    public String deleteBill(@PathVariable("id") Integer id) {
        billService.deleteById(id);
        return "redirect:/bill/list";
    }
}
