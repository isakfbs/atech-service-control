package main.java.com.atech.repository;

import main.java.com.atech.model.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ServiceMapper implements EntityMapper<Service>{
    @Override
    public void mapToStatement(PreparedStatement stmt, Service service) throws SQLException {
        stmt.setInt(1, service.getCustomerId());
        stmt.setInt(2, service.getDeviceId());
        stmt.setString(3, service.getDescription());
        stmt.setString(4, service.getStatus());
        stmt.setObject(5, service.getStartDate());
        stmt.setObject(6, service.getEndDate());
        stmt.setDouble(7, service.getCost());
    }

    @Override
    public Service mapFromResultSet(ResultSet rs) throws SQLException {
        return new Service(
                rs.getInt("id"),
                rs.getInt("customer_id"),
                rs.getString("description"),
                rs.getString("status"),
                rs.getObject("start_date", LocalDateTime.class),
                rs.getObject("end_date", LocalDateTime.class),
                rs.getDouble("cost")
        );
    }

    @Override
    public void setId(Service service, int id) {
        service.setId(id);
    }
}
