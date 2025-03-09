package com.atech.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapper<T> {
    void mapToStatement(PreparedStatement stmt, T entity) throws SQLException;
    T mapFromResultSet(ResultSet rs) throws SQLException;
    void setId(T entity, int id);
}
