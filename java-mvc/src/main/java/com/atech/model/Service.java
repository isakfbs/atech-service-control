package main.java.com.atech.model;

import main.java.com.atech.util.DatabaseUtil;

import java.sql.*;
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

    public Service(int customerId, String description, String status,
                   LocalDateTime startDate, LocalDateTime endDate, Double cost){
        this.customerId = customerId;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public void saveInDatabase(){
        String sql = "INSERT INTO SERVICES " +
                "(customer_id, description, status, start_date, end_date,cost)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection conn = DatabaseUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            stmt.setInt(1, customerId);
            stmt.setString(2, description);
            stmt.setString(3, status);
            stmt.setObject(4, startDate);
            stmt.setObject(5, endDate);
            stmt.setDouble(6, cost);
            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    this.id = rs.getInt(1);
                }
            }
            System.out.println("Service saved to the database");

        }catch (SQLException e){
            System.err.println("Error saving service: " + e.getMessage());
        }
    }

}
