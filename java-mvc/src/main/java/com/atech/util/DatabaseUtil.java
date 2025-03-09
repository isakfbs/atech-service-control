package com.atech.util;

import java.sql.*;


public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/service_management";
    private static final String USER = "root";
    private static final String PASSWORD = "Avatar@666";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Utility method to wrap Connection and PreparedStatement
    public static void executeQuery(String sql, SQLConsumer statementConsumer){
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statementConsumer.accept(stmt);
        }catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
    }

    // Overloaded method for queries that return a result (e.g., SELECT)
    public static <T> T executeQuery(String sql, SQLFunction<PreparedStatement, T> statementFunction){
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            return statementFunction.apply(stmt);
        } catch (SQLException e){
            System.err.println("Error executing query: " + e.getMessage());
            return null;
        }
    }

    }

