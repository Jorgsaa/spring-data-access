package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Genre;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
    public List<Genre> findByName(String name) {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Genre WHERE Name LIKE ?",
                    new BeanPropertyRowMapper<>(Genre.class),
                    "%" + name + "%"
            );
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

    @Override
    public List<Genre> findRandom(int amount) {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Genre ORDER BY random() LIMIT ?",
                    new BeanPropertyRowMapper<>(Genre.class),
                    amount
            );
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

}
