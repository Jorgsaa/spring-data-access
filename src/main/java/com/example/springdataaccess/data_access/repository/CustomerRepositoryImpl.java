package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM Customer", new BeanPropertyRowMapper<>(Customer.class));
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM Customer WHERE CustomerId = ?",
                    new BeanPropertyRowMapper<>(Customer.class),
                    id
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> findByName(String name) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM Customer WHERE Customer.FirstName || ' ' || Customer.LastName LIKE ?",
                    new BeanPropertyRowMapper<>(Customer.class),
                    "%" + name + "%"
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}
