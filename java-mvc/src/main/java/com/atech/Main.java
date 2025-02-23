package main.java.com.atech;


import main.java.com.atech.controller.CustomerController;
import main.java.com.atech.model.Device;
import main.java.com.atech.view.CustomerView;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        CustomerView view = new CustomerView(controller);
        view.showMenu();

    }
}