package com.example.springdataaccess.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
public class SearchController {

    @GetMapping
    public String search(Model model, @RequestParam(value = "term", defaultValue = "") String searchTerm) {
        if (searchTerm.isBlank())
            return "redirect:/";
        model.addAttribute("searchTerm", searchTerm);
        return "search";
    }

}
