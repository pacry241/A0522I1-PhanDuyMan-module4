package com.codegym.ecommercepage.controller;

import com.codegym.ecommercepage.model.Cart;
import com.codegym.ecommercepage.model.Product;
import com.codegym.ecommercepage.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
//@RequestMapping("/home")
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
