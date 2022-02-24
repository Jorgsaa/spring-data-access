package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.CustomerGenre;
import com.example.springdataaccess.data_access.repository.customer_genre.CustomerGenreRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerGenreRepositoryTest {
    CustomerGenreRepositoryImpl testCustomerGenreDAO;

    @BeforeEach
    void setUp() {
        testCustomerGenreDAO = new CustomerGenreRepositoryImpl();
    }

    @Test
    void getFavoriteGenres_InvalidNegativeID_ShouldReturnEmptyList() {
        List<CustomerGenre> expectedResult = new ArrayList<>();
        List<CustomerGenre> actualResult;
        int negativeID = -1;

        actualResult = testCustomerGenreDAO.getFavoriteGenres(negativeID);

        assertEquals(expectedResult, actualResult);
    }
}