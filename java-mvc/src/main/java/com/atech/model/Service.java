package main.java.com.atech.model;

import main.java.com.atech.repository.Repository;
import main.java.com.atech.repository.ServiceMapper;
import java.time.LocalDateTime;

public class Service {
    private int id;
    private int customerId;
    private int deviceId;
    private String description;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double cost;

    public Service(int customerId, int deviceId, String description, String status,
                   LocalDateTime startDate, LocalDateTime endDate, Double cost){
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public Service(int id, int customerId, int deviceId, String description, String status,
                   LocalDateTime startDate, LocalDateTime endDate, Double cost){
        this(customerId,deviceId, description,status,startDate,endDate,cost);
        this.id = id;
    }

    public void save(){
        String[] columns = {"customer_id", "device_id", "description", "status", "start_date", "end_date","cost"};
        Repository<Service> repository =
                new Repository<>("SERVICES",columns, new ServiceMapper());
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

    public int getDeviceId() {
        return deviceId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public double getCost() {
        return cost;
    }
}
