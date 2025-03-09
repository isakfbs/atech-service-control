package com.atech.controller;

import com.atech.model.Service;
import com.atech.repository.Repository;
import com.atech.repository.ServiceMapper;

public class ServiceController {
    private Repository<Service> serviceRepository;

    public ServiceController(){
        String[] columns = {"customer_id", "device_id", "description", "status", "start_date", "end_date","cost"};
        this.serviceRepository = new Repository<>("SERVICES",columns, new ServiceMapper());
    }

    public void saveService(Service service){
        serviceRepository.save(service);
    }
}
