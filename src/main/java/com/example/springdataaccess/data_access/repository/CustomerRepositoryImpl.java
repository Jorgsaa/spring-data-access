package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM Customer", (resultSet, rowNum) -> new Customer(
                resultSet.getInt("CustomerId"),
                resultSet.getString("FirstName"),
                resultSet.getString("LastName"),
                resultSet.getString("Company"),
                resultSet.getString("Address"),
                resultSet.getString("City"),
                resultSet.getString("State"),
                resultSet.getString("Country"),
                resultSet.getString("PostalCode"),
                resultSet.getString("Phone"),
                resultSet.getString("Fax"),
                resultSet.getString("Email"),
                resultSet.getInt("SupportRepId")
        ));
    }

}
