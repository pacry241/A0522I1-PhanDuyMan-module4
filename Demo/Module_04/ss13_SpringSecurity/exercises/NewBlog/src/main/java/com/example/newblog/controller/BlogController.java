package com.example.newblog.controller;

import com.example.newblog.model.Blog;
import com.example.newblog.repository.ICategoryRepository;
import com.example.newblog.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    ICategoryRepository categoryRepository;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @GetMapping("/user")
    public ModelAndView user(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return new ModelAndView("/user");
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        // Get authenticated user name from SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return new ModelAndView("/admin");
    }
    @GetMapping("/list")
    public ModelAndView showListBlog(Principal principal){
        List<Blog> blogs = blogService.getList();
        System.out.println(principal.getName());
        return new ModelAndView("list", "blogs", blogs);
    }

    @GetMapping("/create")
    public ModelAndView createBlogPage(){
        return new ModelAndView("create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String createblog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create Blog: " + blog.getNameBlog() + " done!");
        return "redirect:/blog/list";
    }

    //
    @GetMapping("/update/{id}")
    public ModelAndView updateBlogPage(@PathVariable int id){
        return new ModelAndView("update", "blog", blogService.getBlogById(id));
    }

    @PostMapping("/update/{idBlog}")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message", "Update Blog: " + blog.getNameBlog() + " done!");
        return "redirect:/blog";
    }
    //
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        blogService.deleteBlogById(id);
        return"redirect:/blog";
    }
    //
    @GetMapping("/detail/{id}")
    public String view (@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.getBlogById(id));
        return "detail";
    }
    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam(name = "txtSearch") String nameOrid){
        return new ModelAndView("list", "blogs", blogService.findByName(nameOrid));
    }

    @GetMapping("/search2")
    public ModelAndView searchById(@RequestParam(name = "idSearch") int id){
        List<Blog> blogs = (List<Blog>) blogService.getBlogById(id);
        return new ModelAndView("list", "blogs", blogs);
    }

}
