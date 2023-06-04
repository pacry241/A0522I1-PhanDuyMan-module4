package com.example.songupload.controler;

import com.example.songupload.model.Song;
import com.example.songupload.repository.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/music")
public class SongController {
    private static SongRepository songRepository = new SongRepository();

    @GetMapping("")
    String showList(Model model){
        model.addAttribute("list",songRepository.showAll());
        return "list";
    }

    @GetMapping("/add")
    String addMusic(Model model){
        model.addAttribute("music",new Song());
        return "home";
    }

    @PostMapping("/save")
    String add(@ModelAttribute("music") Song music, Model model){
        songRepository.addMusic(music);
        model.addAttribute("list",songRepository.showAll());
        return "list";
    }
}
