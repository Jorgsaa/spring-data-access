package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Track;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrackRepositoryImpl implements TrackRepository {

    private final JdbcTemplate jdbcTemplate;

    public TrackRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Track> findByName() {
        return null;
    }

    @Override
    public List<Track> findRandom(int amount) {
        return null;
    }

}
