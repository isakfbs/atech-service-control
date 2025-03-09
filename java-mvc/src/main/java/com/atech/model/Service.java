package com.atech.model;
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
