package com.example.springdataaccess.data_access.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerSpenderTest {
    CustomerSpender testCustomerSpender;
    int originalCustomerId = 1;
    int originalHighestSpending = 1000000;

    @BeforeEach
    void setUp() {
        testCustomerSpender = new CustomerSpender(originalCustomerId, originalHighestSpending);
    }

    @Test
    void getCustomerId() {
    }

    @Test
    void getHighestSpending() {
    }
}