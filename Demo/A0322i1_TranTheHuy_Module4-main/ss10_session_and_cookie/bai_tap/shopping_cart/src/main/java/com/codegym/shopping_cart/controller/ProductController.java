package com.codegym.shopping_cart.controller;

import com.codegym.shopping_cart.dto.CartDto;
import com.codegym.shopping_cart.dto.ProductDto;
import com.codegym.shopping_cart.model.Product;
import com.codegym.shopping_cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        return new ModelAndView("detail", "products", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, Model model,
                            @SessionAttribute("cart") CartDto cartDto,
                            @CookieValue(value ="setCart", defaultValue = "") String setCart,
                            HttpServletResponse response, HttpServletRequest request) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cartDto.addProduct(productDto);

            setCart = String.valueOf(cartDto);
            Cookie cookie = new Cookie("setCart", setCart);
            cookie.setMaxAge(24 * 60 * 60 * 5);
            cookie.setPath("/");
            response.addCookie(cookie);

            //get all cookies
            Cookie[] cookies = request.getCookies();
            //iterate each cookie
            for (Cookie ck : cookies) {
                //display only the cookie with the name 'setCart'
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
        } else {
            cartDto.setProductMap(null);
            Cookie cookie = new Cookie("setCart", setCart);
            model.addAttribute("cookieValue", cookie);
        }
        return "redirect:/cart";
    }

}
