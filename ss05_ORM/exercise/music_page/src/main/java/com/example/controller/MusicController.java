package com.example.controller;

import com.example.model.Music;
import com.example.service.impl.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping()
    public ModelAndView showAll(){
        List<Music> musics = musicService.findAll();
        return new ModelAndView("listMusic", "musics", musics);
    }

    @GetMapping("/create")
    public ModelAndView createPage(){
        return new ModelAndView("create", "music", new Music());
    }

    @PostMapping("/create")
    public String createMusic(@ModelAttribute Music music, RedirectAttributes redirectAttributes){
        musicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Create Music: " + music.getName() + " done!");
        return "redirect:/music";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable int id){
        return new ModelAndView("edit", "music", musicService.findById(id));
    }

    @PostMapping("/update/{id}")
    public String updateMusic(@ModelAttribute Music music, RedirectAttributes redirectAttributes){
        musicService.update(music);
        redirectAttributes.addFlashAttribute("message", "Update Music: " + music.getName() + " done!");
        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable int id){
        musicService.delete(musicService.findById(id));
        return ("redirect:/music");
    }
}
