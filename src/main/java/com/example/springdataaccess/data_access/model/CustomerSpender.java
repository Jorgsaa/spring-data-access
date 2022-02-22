package com.example.springdataaccess.data_access.model;

public class CustomerSpender {
    private int customerId;
    private int highestSpending;

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public int getHighestSpending() {
        return highestSpending;
    }

    // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setHighestSpending(int highestSpending) {
        this.highestSpending = highestSpending;
    }
}
