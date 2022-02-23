package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Artist;

import java.util.List;

public interface ArtistRepository {

    List<Artist> findByName();

    List<Artist> findRandom(int amount);

}
