package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Customer;

import java.util.Collection;
import java.util.List;

public interface CustomerCountryRepository {
    List<Customer> findAll();
}
