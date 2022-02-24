package com.example.springdataaccess.controller.api;

import com.example.springdataaccess.data_access.model.Customer;
import com.example.springdataaccess.data_access.model.CustomerGenre;
import com.example.springdataaccess.data_access.repository.customer_genre.CustomerGenreRepository;
import com.example.springdataaccess.data_access.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerRepository customers;
    private final CustomerGenreRepository customerGenre;

    public CustomerController(CustomerRepository customers, CustomerGenreRepository customerGenre) {
        this.customers = customers;
        this.customerGenre = customerGenre;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customerList = customers.findAll();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("id/{customerId}")
    public ResponseEntity<Customer> findById(@PathVariable Integer customerId) {
        Optional<Customer> customer = customers.findById(customerId);
        return ResponseEntity.of(customer);
    }

    @GetMapping("id/{customerId}/popular-genre")
    public ArrayList<CustomerGenre> findFavoriteGenres(
            @PathVariable Integer customerId
    ) {
        return customerGenre.getFavoriteGenres(customerId);
    }

    @GetMapping("name/{customerName}")
    public ResponseEntity<Customer> findByName(@PathVariable String customerName) {
        Optional<Customer> customer = customers.findByName(customerName);
        return ResponseEntity.of(customer);
    }

    @GetMapping("pagination")
    public ResponseEntity<List<Customer>> findByPage(@RequestParam Integer limit, @RequestParam Integer offset) {
        List<Customer> customerList = this.customers.findByPage(limit, offset);
        return ResponseEntity.ok(customerList);
    }

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody Customer customer) {
        Boolean saved = customers.save(customer);
        return ResponseEntity.status(saved ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(saved);
    }

    @PatchMapping
    public ResponseEntity<Boolean> update(@RequestBody Customer customer) {
        Boolean updated = customers.update(customer);
        return ResponseEntity.status(updated ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST).body(updated);
    }

}
