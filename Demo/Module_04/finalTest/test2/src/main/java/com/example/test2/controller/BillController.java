package com.example.test2.controller;

import com.example.test2.dto.SearchSession;
import com.example.test2.service.impl.BillService;
import com.example.test2.service.impl.ProductService;
import com.example.test2.service.impl.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Action;

@Controller
@RequestMapping("/bill")
@SessionAttributes("searchSession")
public class BillController {
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ProductService productService;

    @Autowired
    BillService billService;

    @ModelAttribute("searchSession")
    public SearchSession setUp(){
        return new SearchSession("");
    }

    @GetMapping("/list")
    public ModelAndView findAll(Pageable pageable,
                                @ModelAttribute(name = "searchSession") SearchSession searchSession,
                                @RequestParam(required = false) String searchVal){
        if(searchVal != null){
            searchSession.setValue(searchVal);
        }
        return new ModelAndView("home", "bills", billService.search(pageable,searchSession.getValue()));
    }

   /*@GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("bill",billService.findById(id) );
        modelAndView.addObject("product",billService.findById(id));
        modelAndView.addObject("productType", billService.findById(id));
        return modelAndView;
    }*/

//    @GetMapping("/edit/{id}")
//    public ModelAndView showFormEdit(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("bills", billService.findById(id));
//        model.addAttribute("products", productService.listAll());
//        model.addAttribute("productTypes", productTypeService.listAll());
//
//        return new ModelAndView("/bill/edit", "bill", billService.findById(id));
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        billService.delete(id);
        return "redirect:/bill/list";
    }

}
