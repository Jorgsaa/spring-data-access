package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.Customer;
import com.example.springdataaccess.data_access.model.CustomerCountry;

import java.util.Collection;

public interface CustomerCountryRepository<T> {
    Collection<T> findAll();
}
