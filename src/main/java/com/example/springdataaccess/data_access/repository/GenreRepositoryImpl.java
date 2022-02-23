package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepositoryImpl implements GenreRepository{

    private final JdbcTemplate jdbcTemplate;

    public GenreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> findByName() {
        return null;
    }

    @Override
    public List<Genre> findRandom(int amount) {
        return null;
    }

}
