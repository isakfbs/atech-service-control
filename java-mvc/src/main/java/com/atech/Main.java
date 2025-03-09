package com.atech;


import com.atech.controller.CustomerController;
import com.atech.view.CustomerView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CustomerController controller = new CustomerController();
        CustomerView view = new CustomerView(controller);
        view.showMenu();
    }
}