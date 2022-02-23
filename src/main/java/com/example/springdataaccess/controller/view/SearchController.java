package com.example.springdataaccess.controller.view;

import com.example.springdataaccess.data_access.model.Artist;
import com.example.springdataaccess.data_access.model.Genre;
import com.example.springdataaccess.data_access.model.Track;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    public class SearchResult {
        public Artist artist;
        public Genre genre;
        public Track track;

        public SearchResult(Artist artist, Genre genre, Track track) {
            this.artist = artist;
            this.genre = genre;
            this.track = track;
        }
    }

    @GetMapping
    public String search(Model model, @RequestParam(value = "term", defaultValue = "") String searchTerm) {
        if (searchTerm.isBlank())
            return "redirect:/";

        // temporary data
        Collection<SearchResult> searchResults = List.of(
                new SearchResult(
                        new Artist(0, "artistName0"),
                        new Genre(0, "genreName0"),
                        new Track(0, "trackName0")
                ),
                new SearchResult(
                        new Artist(1, "artistName1"),
                        new Genre(1, "genreName1"),
                        new Track(1, "trackName1")
                ),
                new SearchResult(
                        new Artist(2, "artistName2"),
                        new Genre(2, "genreName2"),
                        new Track(2, "trackName2")
                )
        );
        model.addAttribute("searchResults", searchResults);

        model.addAttribute("searchTerm", searchTerm);



        return "search";
    }

}
