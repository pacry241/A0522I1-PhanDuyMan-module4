package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.global.GlobalData;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    } //page cart

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id){
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }//click add from page viewProduct

//    @GetMapping("/minus/{id}")
//    public String minusCart(@PathVariable Long id, @RequestParam("action") String action) {
//        Optional<Product> productOptional = productService.getProductById(id);
//        Product products = new Product();
//        BeanUtils.copyProperties(productOptional.get(), products);
//        if (products == null) {
//            return "/404";
//        }
//        if (action.equals("show")) {
//            GlobalData.cart.add(productService.getProductById(id).get().minusProduct(products));
//            return "redirect:/cart";
//        }
//
//        GlobalData.cart.add(productService.getProductById(id).get().minusProduct(products));
//        return "redirect:/shop";
//    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    } // delete 1 product

    @GetMapping("/checkout")
    public String checkout(Model model){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setTotal(GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());

        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", orderDTO.getTotal());
        model.addAttribute("cart", GlobalData.cart);
        model.addAttribute("orderDTO", orderDTO);
        return "checkout";
    } // checkout totalPrice
}
