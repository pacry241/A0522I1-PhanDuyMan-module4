package com.example.product_springdatarepository.controller;

import com.example.product_springdatarepository.model.Product;
import com.example.product_springdatarepository.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping()
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "3") int page){
        Sort sort = Sort.by("name");
        model.addAttribute("products", service.getAll());
        return "list";
    }

    @GetMapping("/create")
    public ModelAndView createProductPage(){
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        service.save(product);
        redirectAttributes.addFlashAttribute("message", "Create Product: " + product.getName() + " done!");
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return"redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String view (@PathVariable int id, Model model){
        model.addAttribute("product", service.findById(id));
        return "detail";
    }
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable int id, Model model){
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateBlog(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        service.save(product);
        redirectAttributes.addFlashAttribute("message", "Update Product: " + product.getName() + " done!");
        return "redirect:/product";
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam(name = "txtSearch") String name){
        return new ModelAndView("list", "products", service.findByName(name));
    }

}
