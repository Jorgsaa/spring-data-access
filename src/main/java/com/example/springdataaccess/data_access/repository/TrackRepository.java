package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Track;

import java.util.List;

public interface TrackRepository {

    List<Track> findByName(String name);

    List<Track> findRandom(int amount);

}
