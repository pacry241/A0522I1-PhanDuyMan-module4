package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("listProduct",service.findAll());
        return "list";
    }
    @GetMapping("/create")
    String pageCreate(@ModelAttribute Product product, Model model){
        model.addAttribute("product",product);
        return "create";
    }
    @PostMapping("/save")
    String addProduct(@ModelAttribute Product product) throws Exception {
        service.create(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    String pageEdit(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("product",service.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    String updateProduct(@ModelAttribute Product product) throws Exception {
        service.update(product);
        return "redirect:/product";
    }

    //view
    @GetMapping("/{id}/view")
    String pageView(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("product",service.findById(id));
        return "view";
    }

    //delete
    @GetMapping("/{id}/delete")
    String deleteProduct(@PathVariable String id, Model model) throws Exception {
        iProductService.delete(id);
        return "redirect:/product";
    }

    //search
    @GetMapping("/search")
    String pageSearch(@RequestParam String search, Model model) throws Exception{
        model.addAttribute("listProduct",iProductService.findByName(search));
        return "list";
    }
}
