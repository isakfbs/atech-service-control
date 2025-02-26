package main.java.com.atech.storage;

import main.java.com.atech.model.Customer;

import java.sql.SQLException;

public class JsonFileStorage implements CustomerStorage{

    private final String filepath;

    public JsonFileStorage(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void save(Customer customer) throws SQLException {

    }
}
