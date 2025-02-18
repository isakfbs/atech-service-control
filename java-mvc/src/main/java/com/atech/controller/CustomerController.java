package main.java.com.atech.controller;
import main.java.com.atech.model.Customer;

import java.util.List;
import java.util.ArrayList;


public class CustomerController {
    private List<Customer> customers;
    private int nextId;

    public CustomerController(){
        customers = new ArrayList<>();
        nextId = 1;
    }
    public void addCustomer(String name, String phone, String email, String adress){
        Customer customer = new Customer(nextId, name, phone, email, adress);
        customers.add(customer);
        nextId ++;
        System.out.println("Customer was added successfully!");
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


