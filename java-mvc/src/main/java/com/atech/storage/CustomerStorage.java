package main.java.com.atech.storage;

import main.java.com.atech.model.Customer;

import java.sql.SQLException;

public interface CustomerStorage {
    void save(Customer customer) throws SQLException;
}
