package com.example.music.baitap.controller;

import com.example.music.model.Music;
import com.example.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService musicService;

    @GetMapping("/musics")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Music> musics = musicService.findAll();
        modelAndView.addObject("musics", musics);
        return modelAndView;
    }

    @PostMapping
    public String updateCustomer(Music music) {
         musicService.save(music);
        return "redirect:/musics";
    }
    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Music  music = musicService.findOne(id);
        modelAndView.addObject("music", music);
        return modelAndView;
    }
}
