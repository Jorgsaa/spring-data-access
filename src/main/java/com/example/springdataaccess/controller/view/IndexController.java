package com.example.springdataaccess.controller.view;

import com.example.springdataaccess.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private final MusicService musicService;

    public IndexController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public String index(Model model) {
        // Fetch 5 of each type of data
        musicService.fetchMusicData(5)
                // Add each collection data as an attribute with the map key as name
                .forEach(model::addAttribute);
        return "index";
    }

}
