package com.example.springdataaccess.data_access;

import com.example.springdataaccess.data_access.model.Customer;
import com.example.springdataaccess.data_access.model.CustomerGenre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerGenreDAOTest {
    CustomerGenreDAO testCustomerGenreDAO;

    @BeforeEach
    void setUp() {
        testCustomerGenreDAO = new CustomerGenreDAO();
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