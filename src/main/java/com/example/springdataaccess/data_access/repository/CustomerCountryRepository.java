package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.CustomerCountry;

import java.util.ArrayList;
public interface CustomerCountryRepository {
    ArrayList<CustomerCountry> findAll();
}
