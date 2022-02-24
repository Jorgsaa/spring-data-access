package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Track;
import com.example.springdataaccess.data_access.model.TrackSearchResult;

import java.util.List;

public interface TrackRepository {

    List<TrackSearchResult> findDetailsByName(String searchTerm);

    List<Track> findRandom(int amount);

}
