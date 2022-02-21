package com.example.springdataaccess.data_access.model;

public record Customer (
        Integer id,
        String firstName,
        String lastName,
        String company,
        String address,
        String city,
        String state,
        String country,
        String postalCode,
        String phone,
        String fax,
        String email,
        Integer supportRepId
) {}
