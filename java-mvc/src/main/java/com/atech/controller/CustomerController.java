package main.java.com.atech.controller;
import main.java.com.atech.model.Customer;
import java.util.List;
import java.util.ArrayList;


public class CustomerController {
    private List<Customer> customers;
    private int nextId;

    public CustomerController(){
        customers = new ArrayList<>();

    }
    public void addCustomer(String name, String phone, String email){
        Customer customer = new Customer(name, phone, email);
    }

    public void listCustomer(){
        if (customers.isEmpty()){
            System.out.println("Customers list is empty");
        }else{
            for (Customer customer : customers){
                System.out.println(customer.getId() + " - " + customer.getName());
            }
        }
    }

    public Customer searchCustomerById(int id){
        for (Customer customer: customers){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

}


