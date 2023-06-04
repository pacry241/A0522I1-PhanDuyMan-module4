package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.global.GlobalData;
import com.example.demo.model.Product;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class  HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

//    @GetMapping("/users/add")
//    public String updateUser(Model model) {
//        UserDTO currentUser = new UserDTO();
//        User user = userService.getUserByEmail(currentUser.getEmail()).get();
//        currentUser.setId(user.getId());
//        currentUser.setEmail(user.getEmail());
//        currentUser.setPassword("");
//        currentUser.setFirstName(user.getFirstName());
//        currentUser.setLastName(user.getLastName());
//        currentUser.setPhone(user.getPhone());
//        List<Long> roleIds = new ArrayList<>();
//        for (Role item : user.getIdRole()) {
//            roleIds.add(item.getId());
//        }
//        currentUser.setIdRole(roleIds);
//        //get current User runtime
//
//        model.addAttribute("userDTO", currentUser);
//        return "userRoleAdd";
//    }

//    @PostMapping("/users/add")
//    public String postUserAdd(@ModelAttribute("userDTO") UserDTO userDTO) {
//        //convert dto > entity
//        User user = new User();
//        user.setId(userDTO.getId());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(userDTO.getPassword());
//        user.setFirstName(userDTO.getFirstName());
//        user.setLastName(userDTO.getLastName());
//        user.setPhone(userDTO.getPhone());
//        List<Role> roles = userService.getUserById(user.getId()).get().getIdRole();
//        user.setIdRole(roles);
//
//        userService.updateUser(user);
//        return "index";
//    }

    @GetMapping({"/", "/home"})   //index
    public String home(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());
        return "shop";
    } //view All Products

    @GetMapping("/shop/page")
    public String shopPage(Model model, @RequestParam("p") Optional<Integer> p) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("categories", categoryService.getAllCategory());
        Page<Product> page = productService.getAllWithPage(PageRequest.of(p.orElse(0), 3));
        model.addAttribute("products", page.getContent());
        model.addAttribute("pageProducts", page); // page not list
        return "shop";
    } //view All Products

    @GetMapping("/shop/category/{id}")
    public String shopByCat(@PathVariable Long id, Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProductByCategoryId(id));
        return "shop";
    } //view Products By Category

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(@PathVariable long id, Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("product", productService.getProductById(id).get());
        return "viewProduct";
    } //view product Details
}
