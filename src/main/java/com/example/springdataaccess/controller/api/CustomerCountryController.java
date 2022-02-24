package com.example.springdataaccess.controller.api;

import com.example.springdataaccess.data_access.repository.CustomerCountryRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Customer Country")
@RequestMapping("/api")
public class CustomerCountryController {
    private final CustomerCountryRepository customers;

    public CustomerCountryController(CustomerCountryRepository customers) {
        this.customers = customers;
    }


}
