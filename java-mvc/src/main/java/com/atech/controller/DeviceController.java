package main.java.com.atech.controller;

import main.java.com.atech.model.Device;
import main.java.com.atech.repository.DeviceMapper;
import main.java.com.atech.repository.Repository;

public class DeviceController {
    private Repository<Device> deviceRepository;

    public DeviceController(){
        String[] columns = {"fk_customer_id", "type", "brand", "model", "serial_number"};
        this.deviceRepository = new Repository<>("DEVICES", columns, new DeviceMapper());
    }

    public void saveDevice(Device device){
        deviceRepository.save(device);
    }
}
