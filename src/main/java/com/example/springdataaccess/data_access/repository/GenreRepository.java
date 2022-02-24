package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> findRandom(int amount);

}
