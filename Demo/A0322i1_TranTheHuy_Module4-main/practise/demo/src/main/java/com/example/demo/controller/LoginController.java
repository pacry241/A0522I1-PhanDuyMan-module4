//package com.example.demo.controller;
//
//import com.example.demo.dto.UserDTO;
//import com.example.demo.global.GlobalData;
//import com.example.demo.model.Role;
//import com.example.demo.model.User;
//import com.example.demo.repository.RoleRepository;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class LoginController {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @GetMapping("/login")
//    public String login(){
//        GlobalData.cart.clear();
//        return "login";
//    } //page login
//
//    @GetMapping("/forgotpassword")
//    public String forgotPass(Model model){
//        model.addAttribute("userDTO", new UserDTO());
//        return "forgotpassword";
//    }
//
//    @GetMapping("/register")
//    public String registerGet(Model model){
//        return "register";
//    } //page register
//
//    @PostMapping("/register")
//    public String registerPost(@ModelAttribute User userModel, HttpServletRequest request) throws ServletException {
//        //chuyen password tu form dki thanh dang ma hoa
//        String password = userModel.getPassword();
//        //set mac dinh role user,admin
//        List<Role> roles = new ArrayList<>();
//        roles.add(roleRepository.findById(1L).get());
//        roles.add(roleRepository.findById(2L).get());
//        userModel.setIdRole(roles);
//        userRepository.save(userModel);
//        //login & chuyen den page home
//        request.login(userModel.getEmail(), password);
//        return "redirect:/";
//    } //after register success
//}
