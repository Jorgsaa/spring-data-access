package com.example.springdataaccess.data_access.model;

public class CustomerGenre {
    private int customerID;
    private String favoriteGenre;

    CustomerGenre (int customerID, String favoriteGenre) {
        setCustomerID(customerID);
        setFavoriteGenre(favoriteGenre);
    }

    // Getters
    public int getCustomerID() {
        return customerID;
    }

    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    // Setters
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFavoriteGenre(String favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }
}
