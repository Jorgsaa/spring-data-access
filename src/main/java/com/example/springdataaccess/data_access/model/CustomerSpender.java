package com.example.springdataaccess.data_access.model;

public class CustomerSpender {
    private int customerId;
    private double totalSpending;

    public CustomerSpender(int customerId, double totalSpending) {
        setCustomerId(customerId);
        setTotalSpending(totalSpending);
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public double getTotalSpending() {
        return totalSpending;
    }

    // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalSpending(double highestSpending) {
        this.totalSpending = highestSpending;
    }
}
