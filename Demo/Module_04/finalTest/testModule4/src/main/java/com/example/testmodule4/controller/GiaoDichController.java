package com.example.testmodule4.controller;

import com.example.testmodule4.dto.SearchSession;
import com.example.testmodule4.service.impl.GiaoDichService;
import com.example.testmodule4.service.impl.KhachHangService;
import com.example.testmodule4.validator.ValidatorPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/giaodich")
@SessionAttributes("searchSession")
public class GiaoDichController {
    @Autowired
    ValidatorPhone validatorPhone;

    @Autowired
    GiaoDichService giaoDichService;

    @Autowired
    KhachHangService khachHangService;

    @ModelAttribute("searchSession")
    public SearchSession setUp(){
        return new SearchSession("");
    }

    @GetMapping("/list")
    public ModelAndView findAll(Pageable pageable,
                                @ModelAttribute(name = "searchSession") SearchSession searchSession,
                                @RequestParam(required = false) String searchVal){
        if (searchVal != null){
            searchSession.setValue(searchVal);
        }
        return new ModelAndView("templates/giaodich/home", "khachhangs",
                khachHangService.searchByNameOrDichVu(pageable, searchSession.getValue()));
    }
}
