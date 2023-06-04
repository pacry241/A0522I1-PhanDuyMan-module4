package vn.codegym.shopping.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.shopping.dto.CartDto;
import vn.codegym.shopping.dto.ProductDto;
import vn.codegym.shopping.model.Product;
import vn.codegym.shopping.service.IProductService;

import java.util.Optional;
@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService service;

    @ModelAttribute("cart")
    public CartDto cartDto() {
        return new CartDto();
    }

    @GetMapping("/home")
    public String listProduct(@PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Product> products = service.findAll(pageable);
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/add/{id}")
    public String addToCard(@PathVariable Integer id, @SessionAttribute("cart") CartDto cart,
                            @RequestParam("action") String action) {
       Product productOptional = service.findById(id);
        if (productOptional==null) {
            return "/error";
        }

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productOptional, productDto);
        cart.addProduct(productDto);
        if (action.equals("show")) {
            return "redirect:/shopping-cart";
        }
        return "redirect:/";
    }
    @GetMapping("/{id}/view")
    public String view (@PathVariable int id,Model model){
        model.addAttribute("product",service.findById(id));
        return "view";
    }
}
