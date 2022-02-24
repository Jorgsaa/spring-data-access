package com.example.springdataaccess.service;

import com.example.springdataaccess.data_access.model.TrackSearchResult;

import java.util.List;
import java.util.Map;

public interface MusicService {

    Map<String, List<?>> fetchRandomMusicData(int amountEach);

    List<TrackSearchResult> searchMusicData(String searchTerm);

}
