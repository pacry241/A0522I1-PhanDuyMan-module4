package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpProduct(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(){
        return new ModelAndView("shop", "products", productService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable("id") Product product){
        return new ModelAndView("detail", "product", product);
    }
    @GetMapping("/des/{id}")
    public String reOutCart(@PathVariable long id, @ModelAttribute("cart") Cart cart, @RequestParam("action") String action){
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()){
            return "error.404";
        }if (action.equals("show")){
            cart.desProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable long id, @ModelAttribute("cart") Cart cart,
                            @RequestParam("action") String action){
        Optional<Product> productOptional =productService.findById(id);
        if (!productOptional.isPresent()){
            return "error.404";
        }
        if (action.equals("show")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

}
