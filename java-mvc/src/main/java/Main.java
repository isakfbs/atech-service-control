package main.java;


import main.java.controller.CustomerController;
import main.java.view.CustomerView;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        CustomerView view = new CustomerView(controller);
        view.showMenu();
    }
}