package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("/list")
    ModelAndView showList(){
        List<Product> products = productService.findAll();
        return new ModelAndView("list", "products", products);
    }
    //create
    @GetMapping("/create")
    String pageCreate(@ModelAttribute Product product, Model model){
        model.addAttribute("product",product);
        return "create";
    }
    @PostMapping("/save")
    String addProduct(@ModelAttribute Product product) throws Exception {
        productService.create(product);
        return "redirect:/product";
    }
    //view
    @GetMapping("/{id}/detail")
    String pageView(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("product",productService.findById(id));
        return "detail";
    }
    //edit
    @GetMapping("/{id}/edit")
    String pageEdit(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    String updateProduct(@ModelAttribute Product product) throws Exception {
        productService.update(product);
        return "redirect:/product";
    }
    //delete
    @GetMapping("/{id}/delete")
    String deleteProduct(@PathVariable int id, Model model) throws Exception {
        productService.delete(id);
        return "redirect:/product";
    }
    //search
    @GetMapping("/search")
    String pageSearch(@RequestParam String search, Model model) throws Exception{
        model.addAttribute("products",productService.findByName(search));
        return "list";
    }
}
