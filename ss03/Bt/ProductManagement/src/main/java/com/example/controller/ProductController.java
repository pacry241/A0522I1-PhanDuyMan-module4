package com.example.controller;


import com.example.model.Product;
import com.example.service.Impl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("listProduct",iProductService.findAll());
        return "list";
    }

    //create
    @GetMapping("/create")
    String pageCreate(@ModelAttribute Product product, Model model){
        model.addAttribute("product",product);
        return "create";
    }

    @PostMapping("/save")
    String addProduct(@ModelAttribute Product product) throws Exception {
        iProductService.create(product);
        return "redirect:/product";
    }

    //edit
    @GetMapping("/{id}/edit")
    String pageEdit(@PathVariable String id, Model model) throws Exception {
        model.addAttribute("product",iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    String updateProduct(@ModelAttribute Product product) throws Exception {
        iProductService.update(product);
        return "redirect:/product";
    }

    //view
    @GetMapping("/{id}/view")
    String pageView(@PathVariable String id, Model model) throws Exception {
        model.addAttribute("product",iProductService.findById(id));
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
