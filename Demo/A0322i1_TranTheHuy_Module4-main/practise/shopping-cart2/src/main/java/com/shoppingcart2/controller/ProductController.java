package com.shoppingcart2.controller;

import com.shoppingcart2.model.Cart;
import com.shoppingcart2.model.Product;
import com.shoppingcart2.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop( @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        Product products = new Product();
        BeanUtils.copyProperties(productOptional.get(), products);
        if (products == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            Cookie cookie = new Cookie();

            cart.addProduct(products);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(products);
        return "redirect:/shop";
    }
    @GetMapping("/minus/{id}")
    public String minusCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        Product products = new Product();
        BeanUtils.copyProperties(productOptional.get(), products);
        if (products == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.minusProduct(products);
            return "redirect:/shopping-cart";
        }

        cart.minusProduct(products);
        return "redirect:/shop";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable long id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        Product products = new Product();
        BeanUtils.copyProperties(productOptional.get(), products);
        model.addAttribute("product", products);
        return "/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        Product products = new Product();
        BeanUtils.copyProperties(productOptional.get(), products);
        if (products == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.removeProduct(products);
            return "redirect:/shopping-cart";
        }
        cart.removeProduct(products);
        return "redirect:/shop";
    }
}