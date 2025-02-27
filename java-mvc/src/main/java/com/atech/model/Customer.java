package main.java.com.atech.model;

import main.java.com.atech.repository.CustomerMapper;
import main.java.com.atech.repository.Repository;

public class Customer {
    private int id;
    private String name;
    private String phone;
    private String email;

    public Customer(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Customer(int id, String name, String phone, String email){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void save() {
        String[] columns = {"name","phone","email"};
        Repository<Customer> repository = new Repository<>("CUSTOMERS",
                columns, new CustomerMapper());
        repository.save(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
