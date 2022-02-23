package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Artist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepositoryImpl implements ArtistRepository{

    private final JdbcTemplate jdbcTemplate;

    public ArtistRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Artist> findByName() {
        return null;
    }

    @Override
    public List<Artist> findRandom(int amount) {
        return null;
    }

}
