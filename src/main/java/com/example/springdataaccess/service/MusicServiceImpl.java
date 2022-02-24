package com.example.springdataaccess.service;

import com.example.springdataaccess.data_access.model.TrackSearchResult;
import com.example.springdataaccess.data_access.repository.artist.ArtistRepository;
import com.example.springdataaccess.data_access.repository.GenreRepository;
import com.example.springdataaccess.data_access.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    private final ArtistRepository artists;
    private final GenreRepository genres;
    private final TrackRepository tracks;

    public MusicServiceImpl(ArtistRepository artists, GenreRepository genres, TrackRepository tracks) {
        this.artists = artists;
        this.genres = genres;
        this.tracks = tracks;
    }

    @Override
    public HashMap<String, List<?>> fetchRandomMusicData(int amountEach) {
        HashMap<String, List<?>> musicData = new HashMap<>();
        musicData.put("artists", artists.findRandom(amountEach));
        musicData.put("genres", genres.findRandom(amountEach));
        musicData.put("tracks", tracks.findRandom(amountEach));
        return musicData;
    }


    public List<TrackSearchResult> searchMusicData(String searchTerm) {
        return tracks.findDetailsByName(searchTerm);
    }

}
