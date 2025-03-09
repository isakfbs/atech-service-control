package com.atech.storage;

import com.atech.model.Customer;

import java.sql.SQLException;

public interface CustomerStorage {
    void save(Customer customer) throws SQLException;
}
