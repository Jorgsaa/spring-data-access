package com.example.springdataaccess.controller.view;

import com.example.springdataaccess.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    public class Artist {
        public String name;

        public Artist(String name) {
            this.name = name;
        }
    }

    public class SongAlbum {
        public String songTitle;
        public String albumTitle;

        public SongAlbum(String songTitle, String albumTitle) {
            this.songTitle = songTitle;
            this.albumTitle = albumTitle;
        }
    }

    public class Genre {
        public String genre;

        public Genre(String genre) {
            this.genre = genre;
        }
    }

    private final MusicService musicService;

    public IndexController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public String index(Model model) {
        // Temporary data
        Collection<Artist> artists = List.of(
            new Artist("Drake"),
            new Artist("Clams Casino"),
            new Artist("Daft Punk"),
            new Artist("Jimmy neutron"),
            new Artist("Michael Jackson")
        );

        Collection<SongAlbum> songAlbums = List.of(
                new SongAlbum("Songtitle1", "Albumtitle1"),
                new SongAlbum("Songtitle2", "Albumtitle2"),
                new SongAlbum("Songtitle3", "Albumtitle3"),
                new SongAlbum("Songtitle4", "Albumtitle4"),
                new SongAlbum("Songtitle5", "Albumtitle5")
        );

        Collection<Genre> genres = List.of(
                new Genre("genre1"),
                new Genre("genre2"),
                new Genre("genre3"),
                new Genre("genre4"),
                new Genre("genre5")
        );

        model.addAttribute("artists", artists);
        model.addAttribute("songAlbums", songAlbums);
        model.addAttribute("genres", genres);

        // Fetch 5 of each type of data
        musicService.fetchRandomMusicData(5)
                // Add each collection data as an attribute with the map key as name
                .forEach(model::addAttribute);
        return "index";
    }

}
