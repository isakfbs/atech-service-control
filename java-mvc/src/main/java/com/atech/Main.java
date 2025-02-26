package main.java.com.atech;


import main.java.com.atech.controller.CustomerController;
import main.java.com.atech.model.Customer;
import main.java.com.atech.model.Service;
import main.java.com.atech.storage.CustomerStorage;
import main.java.com.atech.storage.DatabaseStorage;
import main.java.com.atech.storage.StorageFactory;
import main.java.com.atech.view.CustomerView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CustomerController controller = new CustomerController();
        CustomerView view = new CustomerView(controller);
        CustomerStorage storage = StorageFactory.getStorage("database");
        Customer customer = new Customer("Alice Johnson", "5551234567", "alice.johnson@example.com");
        customer.save(storage);
        System.out.println("Customer ID: " + customer.getId());
        view.showMenu();

    }
}