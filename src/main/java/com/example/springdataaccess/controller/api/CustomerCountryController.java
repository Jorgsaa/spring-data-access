package com.example.springdataaccess.controller.api;

import com.example.springdataaccess.data_access.model.CustomerCountry;
import com.example.springdataaccess.data_access.repository.CustomerCountryRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class CustomerCountryController {
    private final CustomerCountryRepository customerCountries;

    public CustomerCountryController(CustomerCountryRepository customerCountries) {
        this.customerCountries = customerCountries;
    }

    @GetMapping("/country")
    @Operation(summary = "Get customers in each country")
    public ArrayList<CustomerCountry> findAll() {
        return customerCountries.findAll();
    }
}
