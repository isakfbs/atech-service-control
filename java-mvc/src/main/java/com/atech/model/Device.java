package main.java.com.atech.model;

import main.java.com.atech.util.DatabaseUtil;
import java.sql.*;

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

    public void saveInDatabase(){
        String sql = "INSERT INTO DEVICES (fk_customer_id, type, brand, model, serial_number) VALUES (?,?,?,?,?)";
        try(Connection conn = DatabaseUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setInt(1, customerId);
            stmt.setString(2, type);
            stmt.setString(3, brand);
            stmt.setString(4, model);
            stmt.setString(5, serialNumber);
            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    this.id = rs.getInt(1);
                }
            }
            System.out.println("Device saved to the database.");
        } catch (SQLException e) {
            System.err.println("Error saving device: " + e.getMessage());
        }
    }
}
