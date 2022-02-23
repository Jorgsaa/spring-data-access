package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Track;

import java.util.List;

public interface TrackRepository {

    List<Track> findByName();

    List<Track> findRandom(int amount);

}
