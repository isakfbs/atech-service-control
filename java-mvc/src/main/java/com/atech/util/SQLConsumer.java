package main.java.com.atech.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface SQLConsumer {
    void accept(PreparedStatement stmt) throws SQLException;
}
