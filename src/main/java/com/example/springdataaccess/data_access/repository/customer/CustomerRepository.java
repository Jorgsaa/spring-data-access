package com.example.springdataaccess.data_access.repository.customer;

import com.example.springdataaccess.data_access.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> findAll();

    Optional<Customer> findById(Integer id);

    Optional<Customer> findByName(String name);

    List<Customer> findByPage(Integer limit, Integer offset);

    Boolean save(Customer customer);

    Boolean update(Customer customer);

}
