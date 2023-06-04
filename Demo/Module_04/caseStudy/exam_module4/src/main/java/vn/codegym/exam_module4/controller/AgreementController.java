package vn.codegym.exam_module4.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.exam_module4.dto.AgreementDto;
import vn.codegym.exam_module4.entity.Agreement;
import vn.codegym.exam_module4.entity.Hostel;
import vn.codegym.exam_module4.service.IAgreementService;
import vn.codegym.exam_module4.service.IHostelService;

import java.util.List;

@Controller
@RequestMapping("/agreement")
public class AgreementController {
    @Autowired
    private IAgreementService agreementService;
    @Autowired
    private IHostelService hostelService;
    @ModelAttribute("allHostel")
    public List<Hostel> allHostel() {
        return hostelService.findAll();
    }
    @GetMapping("")
    public String view(Model model) {
        model.addAttribute("agreements", agreementService.findAll());
        return "/agreement/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("agreementDto", new AgreementDto());
        model.addAttribute("hostelFree", hostelService.findHostelFree());
        return "/agreement/create";
    }
    @PostMapping("/save")
    public String save(@Validated AgreementDto agreementDto, BindingResult bindingResult) {
        System.out.println(bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            return "/agreement/create";
        }
        Agreement agreement = new Agreement();
        BeanUtils.copyProperties(agreementDto, agreement);
        agreement.getHostel().setStatus(false);
        agreementService.save(agreement);
        return "redirect:/agreement";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        agreementService.findById(id).get().getHostel().setStatus(true);
        agreementService.delete(id);
        return "redirect:/agreement";
    }
}
