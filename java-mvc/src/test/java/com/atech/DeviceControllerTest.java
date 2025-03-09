package com.atech;

import com.atech.controller.DeviceController;
import com.atech.model.Device;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DeviceControllerTest {
    private DeviceController deviceController = new DeviceController();


    @Test
    public void testSaveDevice(){
        Device device = new Device(1,"Laptop","Dell","XPS 22", "ABC123");

        deviceController.saveDevice(device);

        assertTrue(device.getId() > 0);

    }}
