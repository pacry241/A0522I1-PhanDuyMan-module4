package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;
import vn.codegym.service.StudentServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    //    @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/list")
//    public String showList(Model model){
    public String showList(ModelMap modelMap) {
        List<Student> studentList = studentService.findAll();
        modelMap.addAttribute("studentList", studentList);
        return "list";
    }

    @GetMapping
    public ModelAndView showList1() {
        List<Student> studentList = studentService.findAll();
        return new ModelAndView("list", "studentList", studentList);
    }

//    @PostMapping
//    public String createStudent(){
//
//    }
}
