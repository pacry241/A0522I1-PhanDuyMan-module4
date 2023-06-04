package com.example.ajaxblog.controller;

import com.example.ajaxblog.model.Blog;
import com.example.ajaxblog.repository.ICategoryRepository;
import com.example.ajaxblog.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

/*@Controller
@RequestMapping("/blog")*/
public class BlogController {
    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    ICategoryRepository categoryRepository;

    /*@GetMapping
    public String home(@RequestParam("q") Optional<String> q,
                       @PageableDefault(value = 3, sort = "name", direction = Sort.Direction.ASC)
                       Pageable pageable, Model model) {
        if (!q.isPresent()) {
            model.addAttribute("blogs", blogService.getList());
        } else {
            model.addAttribute("blogs", blogService.searchByName(q.get(), pageable));
            model.addAttribute("q", q.get());
        }
        return "/list";
    }*/


    @GetMapping("/list")
    public ModelAndView showListBlog(){
        List<Blog> blogs = blogService.getList();
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
