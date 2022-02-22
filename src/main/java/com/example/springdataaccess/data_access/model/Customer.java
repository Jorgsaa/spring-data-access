package com.example.springdataaccess.data_access.model;

public class Customer {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName, String company, String address, String city, String state, String country, String postalCode, String phone, String fax, String email, Integer supportRepId) {
        this.customerId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
