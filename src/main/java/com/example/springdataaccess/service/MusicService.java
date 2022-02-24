package com.example.springdataaccess.service;

import com.example.springdataaccess.data_access.model.TrackArtistAlbumGenre;

import java.util.List;
import java.util.Map;

public interface MusicService {

    Map<String, List<?>> fetchRandomMusicData(int amountEach);

    List<TrackArtistAlbumGenre> searchMusicData(String searchTerm);

}
