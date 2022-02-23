package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Track;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
    public List<Track> findByName(String name) {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Track WHERE Name LIKE ?",
                    new BeanPropertyRowMapper<>(Track.class),
                    "%" + name + "%"
            );
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

    @Override
    public List<Track> findRandom(int amount) {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Track ORDER BY random() LIMIT ?",
                    new BeanPropertyRowMapper<>(Track.class),
                    amount
            );
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

}
