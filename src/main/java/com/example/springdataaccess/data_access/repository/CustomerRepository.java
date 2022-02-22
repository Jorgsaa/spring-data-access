package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> findAll();

    Optional<Customer> findById(Integer id);

    Optional<Customer> findByName(String name);

}
