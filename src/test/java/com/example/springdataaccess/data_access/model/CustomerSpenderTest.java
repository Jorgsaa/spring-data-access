package com.example.springdataaccess.data_access.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerSpenderTest {
    CustomerSpender testCustomerSpender;
    int originalCustomerId = 1;
    double originalTotalSpending = 10.0;

    @BeforeEach
    void setUp() {
        testCustomerSpender = new CustomerSpender(originalCustomerId, originalTotalSpending);
    }

    @Test
    void getCustomerId_Void_ShouldReturnCorrectId() {
        int expectedId = 1;
        int actualId;

        actualId = testCustomerSpender.getCustomerId();

        assertEquals(expectedId, actualId);
    }

    @Test
    void getTotalSpending_Void_ShouldReturnCorrectNumber() {
        double expectedSpending = 10;
        double actualSpending;

        actualSpending = testCustomerSpender.getTotalSpending();

        assertEquals(expectedSpending, actualSpending);
    }
}