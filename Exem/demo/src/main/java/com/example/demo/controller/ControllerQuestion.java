package com.example.demo.controller;

import com.example.demo.service.QuestionContentService;
import com.example.demo.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerQuestion {
    @Autowired
    QuestionTypeService questionTypeService;
    @Autowired
    QuestionContentService questionContentService;


    @GetMapping("/index")
    public String index(@RequestParam(value = "page",defaultValue = "0") Integer page, Model model){
        Sort sort = new Sort("id");
        model.addAttribute("list", questionContentService.findAll(PageRequest.of(page,2,)));
        model.addAttribute("type", questionTypeService.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("question", new QuestionContent());
        model.addAttribute("type", questionTypeService.findAll());
        return "create";
    }
    @PostMapping("/create")
    public String createBlog(@Valid @ModelAttribute("question") QuestionContent question, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("type", questionTypeService.findAll());
            return "create";
        }
        questionContentService.save(question);
        return "redirect:/index";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id")String id, Model model){
        model.addAttribute("question", questionContentService.findById(id));
        return "view" ;
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id")String id, Model model){
        model.addAttribute("question", questionContentService.findById(id));
        model.addAttribute("type", questionTypeService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String edit(@Valid @ModelAttribute("question") QuestionContent question, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("type", questionTypeService.findAll());
            return "edit";
        }
        questionContentService.save(question);
        return "redirect:/index";
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("idDelete") String id) {
        questionContentService.removeById(id);
        return "redirect:/index";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, Model model,
                         @RequestParam(value = "nameTitle",defaultValue = "") String title,
                         @RequestParam(value = "id",defaultValue = "") String id){
        model.addAttribute("list", questionContentService.findByTitleContainingAndQuestionType_IdQuestionTypeContaining(title,id,pageable));
        model.addAttribute("type", questionTypeService.findAll());
        return "index";
    }
}
