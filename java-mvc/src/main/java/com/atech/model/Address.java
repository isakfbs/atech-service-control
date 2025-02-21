package main.java.com.atech.model;

import main.java.com.atech.util.DatabaseUtil;

import java.sql.*;

public class Address {
    private int id;
    private int customerId;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public Address(int customerId, String street, String city,
                   String state, String postalCode, String country){
        this.customerId = customerId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public void saveInDataBase(){
        String sql = "INSERT INTO ADDRESSES " +
                "(fk_customer_id, street, city, state, postal_code, country) " +
                "VALUES (?,?,?,?,?,?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setInt(1, customerId);
            stmt.setString(2, street);
            stmt.setString(3, city);
            stmt.setString(4, state);
            stmt.setString(5, postalCode);
            stmt.setString(6, country);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()) {
                    this.id = rs.getInt(1);
                }
            }
            System.out.println("Address saved to the database");
        } catch (SQLException e){
            System.err.println("Error saving address: " + e.getMessage());
        }
    }

}

