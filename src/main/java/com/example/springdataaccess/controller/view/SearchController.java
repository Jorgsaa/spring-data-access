package com.example.springdataaccess.controller.view;

import com.example.springdataaccess.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final MusicService musicService;

    public SearchController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public String search(Model model, @RequestParam(value = "term", defaultValue = "") String searchTerm) {
        // Redirect to home page if search term is blank
        if (searchTerm.isBlank()) return "redirect:/";
        // Add the search term as an attribute
        model.addAttribute("searchTerm", searchTerm);
        // Add the search results as an attribute
        model.addAttribute("searchResults", musicService.searchMusicData(searchTerm));
        return "search";
    }

}
