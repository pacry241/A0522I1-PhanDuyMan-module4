package vn.codegym.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.shopping.dto.CartDto;

@Controller
public class CartController {

    @ModelAttribute("cart")
    public CartDto cartDto() {
        return new CartDto();
    }
    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute(value = "cart",required = false) CartDto cart) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
