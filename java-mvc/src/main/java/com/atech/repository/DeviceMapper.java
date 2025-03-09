package com.atech.repository;

import com.atech.model.Device;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceMapper implements EntityMapper<Device> {
    @Override
    public void mapToStatement(PreparedStatement stmt, Device device) throws SQLException {
        stmt.setInt(1, device.getCustomerId());
        stmt.setString(2, device.getType());
        stmt.setString(3, device.getBrand());
        stmt.setString(4, device.getModel());
        stmt.setString(5, device.getSerialNumber());
    }

    @Override
    public Device mapFromResultSet(ResultSet rs) throws SQLException {
        return new Device(
                rs.getInt("id"),
                rs.getInt("fk_customer_id"),
                rs.getString("type"),
                rs.getString("brand"),
                rs.getString("model"),
                rs.getString("serial_number")
        );
    }

    @Override
    public void setId(Device device, int id) {
        device.setId(id);
    }
}
