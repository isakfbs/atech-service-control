package main.java.com.atech.controller;

import main.java.com.atech.model.Address;
import main.java.com.atech.repository.AddressMapper;
import main.java.com.atech.repository.Repository;

public class AddressController {
    private Repository<Address> addressRepository;

    public AddressController(){
        String[] columns = {"fk_customer_id, street, city, state, postal_code, country"};
        this.addressRepository = new Repository<>("ADDRESSES", columns, new AddressMapper());
    }

    public void saveAddress(Address address){
        addressRepository.save(address);
    }
}
