package com.atech.repository;

import com.atech.util.DatabaseUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Repository<T>{
    private final String tableName;
    private final String[] columns;
    private final EntityMapper<T> entityMapper;

    public Repository(String tableName, String[] columns, EntityMapper<T> entityMapper){
        this.tableName = tableName;
        this.columns = columns;
        this.entityMapper = entityMapper;
    }

    public void save(T entity)  {
        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)",
                tableName, String.join(", ", columns),
                String.join(", ", getPlaceholders(columns.length)));

        DatabaseUtil.executeQuery(sql, stmt -> {
            entityMapper.mapToStatement(stmt, entity);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) {
                    entityMapper.setId(entity, rs.getInt(1));
                }
            }
            System.out.println("Entity saved to the database.");
        });
    }

    public T findById(int id){
        String sql = String.format("SELECT * FROM %s WHERE id = ?", tableName);
        return DatabaseUtil.executeQuery(sql, stmt -> {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return entityMapper.mapFromResultSet(rs);
                }
            }
        return null;
        });
    }

    public List<T> findAll(){
        String sql = String.format("SELECT * FROM %s", tableName);
        return DatabaseUtil.executeQuery(sql, stmt -> {
            List<T> entities = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    entities.add(entityMapper.mapFromResultSet(rs));
                }
            }
            return entities;
        });
    }

    public void delete(int id) {
        String sql = String.format("DELETE FROM %s WHERE id = ?", tableName);
        DatabaseUtil.executeQuery(sql, stmt -> {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Entity deleted from the database.");
        });
    }

    private String[] getPlaceholders(int count){
        String[] placeholders = new String[count];
        for (int i = 0; i < count; i++) {
            placeholders[i] = "?";
        }
        return placeholders;
    }
}
