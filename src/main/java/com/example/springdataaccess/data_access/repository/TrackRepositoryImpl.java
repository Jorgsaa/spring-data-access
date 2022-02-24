package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Track;
import com.example.springdataaccess.data_access.model.TrackArtistAlbumGenre;
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
    public List<TrackArtistAlbumGenre> findDetailsByName(String searchTerm) {
        try {
            return jdbcTemplate.query("""
                        SELECT
                                Track.Name AS TrackName,
                                album.Title AS AlbumName,
                                artist.Name AS ArtistName,
                                genre.Name as GenreName
                        FROM Track
                        INNER JOIN Album album on album.AlbumId = Track.AlbumId
                        INNER JOIN Genre genre on genre.GenreId = Track.GenreId
                        INNER JOIN Artist artist on artist.ArtistId = album.ArtistId
                        WHERE Track.Name LIKE ?
                    """, new BeanPropertyRowMapper<>(TrackArtistAlbumGenre.class), "%" + searchTerm + "%");
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
