package com.example.springdataaccess.data_access.repository.customer;

import com.example.springdataaccess.data_access.model.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;
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
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM Customer WHERE CustomerId = ?", new BeanPropertyRowMapper<>(Customer.class), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> findByName(String name) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM Customer WHERE Customer.FirstName || ' ' || Customer.LastName LIKE ? LIMIT 1", new BeanPropertyRowMapper<>(Customer.class), "%" + name + "%"));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Customer> findByPage(Integer limit, Integer offset) {
        return jdbcTemplate.query("SELECT * FROM Customer LIMIT ? OFFSET ?", new BeanPropertyRowMapper<>(Customer.class), limit, offset);
    }

    @Override
    public Boolean save(Customer customer) {
        int result = 0;
        try {
            result = jdbcTemplate.update("""
                        INSERT INTO Customer (CustomerId, FirstName, LastName, City, State, Country, PostalCode, Phone, Email)
                        VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)
                    """, customer.getFirstName(), customer.getLastName(), customer.getCity(), customer.getState(), customer.getCountry(), customer.getPostalCode(), customer.getPhone(), customer.getEmail());
        } catch (UncategorizedSQLException ignored) {}
        return result == 1;
    }

    @Override
    public Boolean update(Customer customer) {
        int result = 0;
        try {
            result = jdbcTemplate.update("""
                        UPDATE Customer
                        SET FirstName = ?,
                            LastName = ?,
                            City = ?,
                            State = ?,
                            Country = ?,
                            PostalCode = ?,
                            Phone = ?,
                            Email = ?
                        WHERE CustomerId = ?
                    """, customer.getFirstName(), customer.getLastName(), customer.getCity(), customer.getState(), customer.getCountry(), customer.getPostalCode(), customer.getPhone(), customer.getEmail(), customer.getCustomerId());
        } catch (UncategorizedSQLException ignored) {}
        return result == 1;
    }

}
