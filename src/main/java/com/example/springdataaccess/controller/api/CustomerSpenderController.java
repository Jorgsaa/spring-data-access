package com.example.springdataaccess.controller.api;

import com.example.springdataaccess.data_access.repository.CustomerSpenderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerSpenderController {
    private final CustomerSpenderRepository customerSpenders;

    public CustomerSpenderController(CustomerSpenderRepository customerSpenders) {
        this.customerSpenders = customerSpenders;
    }
}
