package com.example.springdataaccess.data_access.repository.artist;

import com.example.springdataaccess.data_access.model.Artist;
import com.example.springdataaccess.data_access.repository.artist.ArtistRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepositoryImpl implements ArtistRepository {

    private final JdbcTemplate jdbcTemplate;

    public ArtistRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
