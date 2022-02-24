package com.example.springdataaccess.controller.api;

import com.example.springdataaccess.data_access.model.Customer;
import com.example.springdataaccess.data_access.model.CustomerCountry;
import com.example.springdataaccess.data_access.repository.CustomerCountryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@Tag(name = "Customer Country")
@RequestMapping("/api")
public class CustomerCountryController {
    private final CustomerCountryRepository customerCountries;

    public CustomerCountryController(CustomerCountryRepository customerCountries) {
        this.customerCountries = customerCountries;
    }


}