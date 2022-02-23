package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Artist;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
    public List<Artist> findByName(String name) {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Artist WHERE Name LIKE ?",
                    new BeanPropertyRowMapper<>(Artist.class),
                    "%" + name + "%"
            );
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

    @Override
    public List<Artist> findRandom(int amount) {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Artist ORDER BY random() LIMIT ?",
                    new BeanPropertyRowMapper<>(Artist.class),
                    amount
            );
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

}
