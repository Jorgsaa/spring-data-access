package com.example.springdataaccess.data_access.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerCountryTest {
    CustomerCountry testCustomerCountry;
    String originalCountryName = "Russia";
    int originalNumberOfCustomers = 10;

    @BeforeEach
    void setUp() {
        // Setters are tested when constructor is called
        testCustomerCountry = new CustomerCountry(originalCountryName, originalNumberOfCustomers);
    }

    @Test
    void getCountryName_Void_ShouldReturnCorrectString() {
        String expectedResult = "Russia";
        String actualResult;

        actualResult = testCustomerCountry.getCountryName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getNumberOfCustomers() {
    }
}