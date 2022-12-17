package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
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

    //    @RequestMapping(method = RequestMethod.GET, value = "/student")
    @GetMapping(value = "")
    public String getList(Model model) {
        model.addAttribute("listStudent", iStudentService.getAll());
        return "list";
    }

    @GetMapping("/detail")
    public String detailByID(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("student", iStudentService.findById(id));
        return "detail";
    }

    @GetMapping("/detail/{id}")
    public String detailByIDWithPathVariable(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("student", iStudentService.findById(id));
        return "detail";
    }

    @GetMapping("/create")
    public String showFormCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@RequestParam("codeStudent")Integer codeStudent,
                                @RequestParam("nameStudent")String nameStudent,
                                @RequestParam("point")Double point,
                                @RequestParam("gender")Integer gender,
                                RedirectAttributes redirectAttributes) {
        Student student = new Student(codeStudent,nameStudent,point,gender);
        this.iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/student";
    }

}
