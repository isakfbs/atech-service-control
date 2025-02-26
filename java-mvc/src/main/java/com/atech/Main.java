package main.java.com.atech;


import main.java.com.atech.controller.CustomerController;
import main.java.com.atech.model.Service;
import main.java.com.atech.view.CustomerView;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        CustomerView view = new CustomerView(controller);
//        Service service = new Service(1,"Testando descrição","Entregue");
        view.showMenu();

    }
}