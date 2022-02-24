package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Track;
import com.example.springdataaccess.data_access.model.TrackArtistAlbumGenre;

import java.util.List;

public interface TrackRepository {

    List<TrackArtistAlbumGenre> findDetailsByName(String searchTerm);

    List<Track> findRandom(int amount);

}
