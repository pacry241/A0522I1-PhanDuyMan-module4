package com.example.controller;

import com.example.model.ToKhaiYTe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("")
public class ToKhaiYTeController {
    private static Map<String, String> list = new LinkedHashMap<>();

    static {
        list.put("tauBay","Tàu bay");
        list.put("tauThuyen","Tàu Thuyền");
        list.put("oto","ô tô");
        list.put("anthor","Khác");
    }

    @GetMapping("/add")
    String showToKhaiYTe(Model model){
        model.addAttribute("toKhaiYTe",new ToKhaiYTe());
        model.addAttribute("phuongTiens", list);
        return "home";
    }

    @PostMapping("/add")
    String showDienToKhaiYTe(Model model, @ModelAttribute ToKhaiYTe toKhaiYTe){
        model.addAttribute("toKhaiYTe",toKhaiYTe);
        return "result";
    }
}
