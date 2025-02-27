package main.java.com.atech.repository;

import main.java.com.atech.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements EntityMapper<Customer>{
    @Override
    public void mapToStatement(PreparedStatement stmt, Customer customer) throws SQLException {
        stmt.setString(1, customer.getName());
        stmt.setString(2, customer.getPhone());
        stmt.setString(3, customer.getEmail());
    }

    @Override
    public Customer mapFromResultSet(ResultSet rs) throws SQLException {
        return new Customer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("phone"),
                rs.getString("email")
        );
    }

    @Override
    public void setId(Customer customer, int id) {
        customer.setId(id);
    }
}
