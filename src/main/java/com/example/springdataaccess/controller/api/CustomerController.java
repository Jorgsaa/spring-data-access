package com.example.springdataaccess.controller.api;

import com.example.springdataaccess.data_access.model.Customer;
import com.example.springdataaccess.data_access.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerRepository customers;

    public CustomerController(CustomerRepository customers) {
        this.customers = customers;
    }

    @GetMapping
    public List<Customer> findAll() {
        return customers.findAll();
    }

    @GetMapping("id/{customerId}")
    public Optional<Customer> findById(@PathVariable Integer customerId) {
        return customers.findById(customerId);
    }

    @GetMapping("name/{customerName}")
    public Optional<Customer> findByName(@PathVariable String customerName) {
        return customers.findByName(customerName);
    }

    @GetMapping("pagination")
    public List<Customer> findByPage(@RequestParam Integer limit, @RequestParam Integer offset) {
        return customers.findByPage(limit, offset);
    }

    @PostMapping
    public Boolean save(@RequestBody Customer customer) {
        return customers.save(customer);
    }

    @PatchMapping
    public Boolean update(@RequestBody Customer customer) {
        return customers.update(customer);
    }

}
