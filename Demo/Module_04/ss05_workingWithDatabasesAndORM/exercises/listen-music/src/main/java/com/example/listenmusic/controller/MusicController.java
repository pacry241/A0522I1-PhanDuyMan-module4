package com.example.listenmusic.controller;

import com.example.listenmusic.service.IMusicService;
import com.example.listenmusic.model.Music;
import com.example.listenmusic.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService musicService;

    @GetMapping()
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Music> musics = musicService.findAll();
        modelAndView.addObject("musics", musics);
        return modelAndView;
    }

    @GetMapping("/create")
    String pageCreate(@ModelAttribute Music music){
        ModelAndView modelAndView = new ModelAndView("/create");
        musicService.save(music);
        modelAndView.addObject("music",music);
        return "create";
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
