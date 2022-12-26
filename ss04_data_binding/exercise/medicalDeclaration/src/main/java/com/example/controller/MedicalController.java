package com.example.controller;

import com.example.model.Medical;
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
public class MedicalController {
    private static Map<String, String> stringsVehicle = new LinkedHashMap<>();
    static {
        stringsVehicle.put("mayBay","Máy Bay");
        stringsVehicle.put("tauThuyen","Tàu Thuyền");
        stringsVehicle.put("oto","ô tô");
        stringsVehicle.put("khac","Khác");
    }

    @GetMapping("/add")
    String showToKhaiYTe(Model model){
        model.addAttribute("medical",new Medical());
        model.addAttribute("Vehicle",stringsVehicle);
        return "home";
    }

    @PostMapping("/add")
    String showDienToKhaiYTe(Model model, @ModelAttribute Medical medicalForm){
        model.addAttribute("toKhaiYTe",medicalForm);
        return "result";
    }
}
