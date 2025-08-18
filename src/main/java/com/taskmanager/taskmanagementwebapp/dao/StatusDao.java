package com.taskmanager.taskmanagementwebapp.dao;

import com.taskmanager.taskmanagementwebapp.model.Status;
import com.taskmanager.taskmanagementwebapp.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class StatusDao {
    public Status getStatusById(int statusId) {
        Status status = null;
        String sql = "SELECT * FROM ticket_status WHERE id = ?";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, statusId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    status = new Status();
                    status.setId(rs.getInt("id"));
                    status.setStatus(rs.getString("status"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<Status> getAllStatuses() {
        return List.of();
    }
}

