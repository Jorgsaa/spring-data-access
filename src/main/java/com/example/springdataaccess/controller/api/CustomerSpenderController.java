package com.example.springdataaccess.controller.api;

import com.example.springdataaccess.data_access.model.CustomerSpender;
import com.example.springdataaccess.data_access.repository.customer_spender.CustomerSpenderRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class CustomerSpenderController {
    private final CustomerSpenderRepository customerSpenders;

    public CustomerSpenderController(CustomerSpenderRepository customerSpenders) {
        this.customerSpenders = customerSpenders;
    }

    @GetMapping("/spender")
    @Operation(summary = "Get the highest spenders")
    public ArrayList<CustomerSpender> findAll() {
        return customerSpenders.getHighestSpenders();
    }
}
