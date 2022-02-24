package com.example.springdataaccess.data_access.repository.customer_genre;

import com.example.springdataaccess.data_access.model.CustomerGenre;

import java.util.ArrayList;

public interface CustomerGenreRepository {
    ArrayList<CustomerGenre> getFavoriteGenres(int id);
}
