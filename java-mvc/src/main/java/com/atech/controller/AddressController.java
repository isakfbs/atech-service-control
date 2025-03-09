package com.atech.controller;

import com.atech.model.Address;
import com.atech.repository.AddressMapper;
import com.atech.repository.Repository;

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
