package codegym.vn.demo_1_project.controller;

import codegym.vn.demo_1_project.model.QuestionContent;
import codegym.vn.demo_1_project.service.IQuestionContentService;
import codegym.vn.demo_1_project.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class QuestionController {
    @Autowired
    IQuestionTypeService questionTypeService;
    @Autowired
    IQuestionContentService questionContentService;


    @GetMapping("/index")
    public String index(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, Model model){
        model.addAttribute("list", questionContentService.findAll(pageable));
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
