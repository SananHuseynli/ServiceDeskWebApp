package com.taskmanager.taskmanagementwebapp.dao;

import com.taskmanager.taskmanagementwebapp.model.Status;
import com.taskmanager.taskmanagementwebapp.model.Ticket;
import com.taskmanager.taskmanagementwebapp.model.Users;
import com.taskmanager.taskmanagementwebapp.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDao {


    public void insertTicket(Ticket ticket) {
        String sql = "insert into tickets (title,description,status_id,assigned_to)\n" +
                "VALUES (?,?,?,?);";

        try (Connection connection= DbConnection.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, ticket.getTitle());
            stmt.setString(2, ticket.getDescription());
            stmt.setObject(3,ticket.getStatus_id());
            stmt.setObject(4,ticket.getUser_id());

            stmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Ticket getTicketById(int id) throws SQLException {
        Ticket ticket = null;
        String sql = "select * from tickets where id = ?";
        try (Connection connection = DbConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ticket = new Ticket();
                    ticket.setId(rs.getInt("id"));
                    ticket.setTitle(rs.getString("title"));
                    ticket.setDescription(rs.getString("description"));

                    int status_id = rs.getInt("status_id");
                    int user_id = rs.getInt("assigned_to");

                    Status status=new StatusDao().getStatusById(status_id);
                    Users assignedUser=new UserDao().getUserById(user_id);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ticket;


        }
    }}
