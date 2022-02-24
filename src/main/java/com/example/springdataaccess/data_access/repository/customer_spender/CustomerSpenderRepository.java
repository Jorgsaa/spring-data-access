package com.example.springdataaccess.data_access.repository.customer_spender;

import com.example.springdataaccess.data_access.model.CustomerSpender;

import java.util.ArrayList;

public interface CustomerSpenderRepository {
    ArrayList<CustomerSpender> getHighestSpenders();
}
