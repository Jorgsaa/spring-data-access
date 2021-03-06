package com.example.springdataaccess.data_access.model;

public class CustomerCountry {
    private String countryName;
    private int numberOfCustomers;

    public CustomerCountry(String countryName, int numberOfCustomers) {
        setCountryName(countryName);
        setNumberOfCustomers(numberOfCustomers);
    }

    // Getters
    public String getCountryName() {
        return countryName;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    // Setters
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }
}
