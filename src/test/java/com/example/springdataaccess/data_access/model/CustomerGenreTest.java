package com.example.springdataaccess.data_access.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerGenreTest {
    CustomerGenre testCustomerGenre;
    int originalCustomerID = 1;
    String originalFavoriteGenre = "Rock";

    @BeforeEach
    void setUp() {
        // Setters are tested here because they are used in the constructor
        testCustomerGenre = new CustomerGenre(originalCustomerID, originalFavoriteGenre);
    }

    @Test
    void getCustomerID() {
    }

    @Test
    void getFavoriteGenre() {
    }
}