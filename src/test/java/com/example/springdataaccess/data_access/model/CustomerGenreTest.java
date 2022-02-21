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
    void getCustomerID_ValidNoInput_ShouldReturnID() {
        int expectedID = 1;
        int actualID;

        actualID = testCustomerGenre.getCustomerID();

        assertEquals(expectedID, actualID);
    }

    @Test
    void getFavoriteGenre_ValidNoInput_ShouldReturnFavoriteGenre() {
        String expectedResult = "Rock";
        String actualResult;

        actualResult = testCustomerGenre.getFavoriteGenre();

        assertEquals(expectedResult, actualResult);
    }
}