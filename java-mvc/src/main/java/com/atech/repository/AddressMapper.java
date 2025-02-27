package main.java.com.atech.repository;

import main.java.com.atech.model.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements  EntityMapper<Address> {

    @Override
    public void mapToStatement(PreparedStatement stmt, Address address) throws SQLException {
        stmt.setInt(1, address.getCustomerId());
        stmt.setString(2, address.getStreet());
        stmt.setString(3, address.getCity());
        stmt.setString(4, address.getState());
        stmt.setString(5, address.getPostalCode());
        stmt.setString(6, address.getCountry());
    }

    @Override
    public Address mapFromResultSet(ResultSet rs) throws SQLException {
        return new Address(
                rs.getInt("id"),
                rs.getInt("fk_customer_id"),
                rs.getString("street"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getString("postal_code"),
                rs.getString("country")
        );
    }

    @Override
    public void setId(Address address, int id) {
        address.setId(id);
    }
}
