package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("search")
public class TranslationDictionary {
    private String result = null;

    @GetMapping("")
    public String showForm() {
        return "dictionary";
    }

    @PostMapping("trans")
    public String translation(@RequestParam(value = "txtSearch") String txtSearch, Model model) {
        Map<String, String> dictionary = new LinkedHashMap<>();
        dictionary.put("search", "tim kiem");
        dictionary.put("fly", "bay");
        dictionary.put("red", "mau do");
        dictionary.put("housemaid", "noi tro");
        dictionary.put("tighten", "ganchat");
        dictionary.put("code", "ma");
        this.result = dictionary.get(txtSearch.trim().toLowerCase());
        if (this.result != null) {
            model.addAttribute("result", result);
            model.addAttribute("txtSearch", txtSearch);
        } else {
            model.addAttribute("result", "Không tìm thấy");
            model.addAttribute("txtSearch", txtSearch);
        }
        return "result";
    }
}
