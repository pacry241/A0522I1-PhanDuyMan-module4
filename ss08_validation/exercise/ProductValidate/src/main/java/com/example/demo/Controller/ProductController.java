package com.example.demo.Controller;

import com.example.demo.Service.impl.ProductService;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("")
    public ModelAndView getAll(@RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Product> products = service.getAll(PageRequest.of(page, 4));
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("listProduct", products);
        return modelAndView;
    }

    ;

    @GetMapping("create")
    public String pageCreate(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        return "create";
    }

    @PostMapping("/save")
    public String addProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "create";
        }
        service.create(product);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String pageEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        service.update(product);
        return "redirect:/product";
    }

    //view
    @GetMapping("/{id}/view")
    public String pageView(@PathVariable int id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "view";
    }

    //delete
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id, Model model) {
        service.delete(service.findById(id));
        return "redirect:/product";
    }
}
