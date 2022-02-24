package com.example.springdataaccess.data_access.model;

public class CustomerSpender {
    private int customerId;
    private double highestSpending;

    public CustomerSpender(int customerId, double highestSpending) {
        setCustomerId(customerId);
        setHighestSpending(highestSpending);
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public double getHighestSpending() {
        return highestSpending;
    }

    // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setHighestSpending(double highestSpending) {
        this.highestSpending = highestSpending;
    }
}
