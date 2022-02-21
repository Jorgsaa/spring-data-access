package com.example.springdataaccess.data_access.model;

public class CustomerGenre {
    private int customerID;
    private String favoriteGenre;
    private int songsBoughtFromGenre;

    public CustomerGenre(int customerID, String favoriteGenre, int songsBoughtFromGenre) {
        setCustomerID(customerID);
        setFavoriteGenre(favoriteGenre);
        setSongsBoughtFromGenre(songsBoughtFromGenre);
    }

    // Getters
    public int getCustomerID() {
        return customerID;
    }

    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    public int getSongsBoughtFromGenre() {
        return songsBoughtFromGenre;
    }

    // Setters
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFavoriteGenre(String favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public void setSongsBoughtFromGenre(int songsBoughtFromGenre) {
        this.songsBoughtFromGenre = songsBoughtFromGenre;
    }
}
