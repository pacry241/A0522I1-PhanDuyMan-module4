package com.codegym.demo.controller;

import com.codegym.demo.model.Student;
import com.codegym.demo.service.IClassroomService;
import com.codegym.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassroomService iClassroomService;

    //    @RequestMapping(method = RequestMethod.GET, value = "/student")
    @GetMapping(value = "")
    public String getList(Model model) {
        model.addAttribute("listStudent", iStudentService.getAll());
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
        model.addAttribute("student", new Student(0,"",0,0));
        String[] listGender = {"0","1", "2"};
        model.addAttribute("listGender", listGender);
        model.addAttribute("listClassroom", iClassroomService.findAll());
        return "create_thymeleaf";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student")Student student,
                                RedirectAttributes redirectAttributes) {
        this.iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/student";
    }

}
