package main.java.com.atech.model;

import main.java.com.atech.repository.AddressMapper;
import main.java.com.atech.repository.Repository;
import main.java.com.atech.util.DatabaseUtil;

import java.sql.*;

public class Address {
    private int id;
    private int customerId;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public Address(int customerId, String street, String city,
                   String state, String postalCode, String country){
        this.customerId = customerId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }
    public Address(int id, int customerId, String street, String city,
                   String state, String postalCode, String country){
        this.id = id;
        this.customerId = customerId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public void save(){
        String[] columns = {"fk_customer_id, street, city, state, postal_code, country"};
        Repository<Address> repository = new Repository<>("ADDRESSES", columns, new AddressMapper());
        repository.save(this);
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }
}

