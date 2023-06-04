package com.example.productorm.controller;

import com.example.productorm.model.Product;
import com.example.productorm.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView showAll(){
        List<Product> products = productService.findAll();
        return new ModelAndView("product", "products", products);
    }

    @GetMapping("/create")
    public ModelAndView createPage(){
        return new ModelAndView("create", "product", new Product());
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addAttribute("message", "Create Product: " + product.getName() + " done!!!");
        return "redirect:/product";
    }
    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable int id){
        return new ModelAndView("update", "product", productService.findById(id));
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addFlashAttribute("message", "Update Product: " + product.getName() + " done!!!");
        return "redirect:/product";
    }
    @GetMapping("delete/{id}")
    public String removeProduct(@PathVariable int id){
        productService.delete(productService.findById(id));
        return ("redirect:/product");
    }
}
