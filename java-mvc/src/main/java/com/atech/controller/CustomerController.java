package com.atech.controller;
import com.atech.model.Customer;
import com.atech.repository.CustomerMapper;
import com.atech.repository.Repository;



public class CustomerController {
    private Repository<Customer> customerRepository;

    public CustomerController(){
        String[] columns = {"name","phone","email"};
        this.customerRepository = new Repository<>("CUSTOMERS", columns, new CustomerMapper());
    }

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void listCustomer(){
//        if (customers.isEmpty()){
//            System.out.println("Customers list is empty");
//        }else{
//            for (Customer customer : customers){
//                System.out.println(customer.getId() + " - " + customer.getName());
//            }
//        }
    }

//    public Customer searchCustomerById(int id){
////        for (Customer customer: customers){
////            if(customer.getId() == id){
////                return customer;
////            }
////        }
////        return null;
//    }

}


