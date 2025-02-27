package main.java.com.atech.model;

import main.java.com.atech.repository.DeviceMapper;
import main.java.com.atech.repository.Repository;


public class Device {
    private int id;
    private int customerId;
    private String type;
    private String brand;
    private String model;
    private String serialNumber;

    public Device(int customerID, String type, String brand, String model, String serialNumber){
        this.customerId = customerID;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public Device(int id ,int customerID, String type, String brand, String model, String serialNumber){
        this(customerID,type,brand,model,serialNumber);
        this.id = id;
    }

    public void save(){
        String[] columns = {"fk_customer_id", "type", "brand", "model", "serial_number"};
        Repository<Device> repository =
                new Repository<>("DEVICES", columns, new DeviceMapper());
        repository.save(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
