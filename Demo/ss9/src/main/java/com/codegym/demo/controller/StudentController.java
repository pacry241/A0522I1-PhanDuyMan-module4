package com.codegym.demo.controller;

import com.codegym.demo.model.Student;
import com.codegym.demo.service.IClassroomService;
import com.codegym.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassroomService iClassroomService;


    //    @RequestMapping(method = RequestMethod.GET, value = "/student")
    @GetMapping(value = "")
    public String getList(@RequestParam(value = "page", defaultValue = "0") int page, Model model) throws Exception {
        if(true) {
            throw new Exception();
        }
        Sort sort = Sort.by("point").descending();
        model.addAttribute("listStudent", iStudentService.getAllWithPage(PageRequest.of(page, 1, sort)));
        return "list_thymeleaf";
    }

    @GetMapping("/detail")
    public String detailByID(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("student", iStudentService.findById(id));
        return "detail";
    }

    @GetMapping("/detail/{id}")
    public String detailByIDWithPathVariable(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("student", iStudentService.findById(id));
        return "detail_thymeleaf";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("student", new Student(0, "", 0, 0));
        String[] listGender = {"0", "1", "2"};
        model.addAttribute("listGender", listGender);
        model.addAttribute("listClassroom", iClassroomService.findAll());
        return "create_thymeleaf";
    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
//        new Student().validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            String[] listGender = {"0", "1", "2"};
            model.addAttribute("listGender", listGender);
            model.addAttribute("listClassroom", iClassroomService.findAll());
            return "create_thymeleaf";
        }
        this.iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/student";
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }

}
