package main.java.com.atech.storage;
import main.java.com.atech.model.Customer;
import main.java.com.atech.util.DatabaseUtil;
import java.sql.*;

public class DatabaseStorage implements CustomerStorage{
    @Override
    public void save(Customer customer) throws SQLException {
        String sql = "INSERT INTO CUSTOMERS(name, phone, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.setString(3, customer.getEmail());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()){
                    customer.setId(rs.getInt(1));
                }
            }
            System.out.println("Customer saved to the database.");
        }
    }
    }
