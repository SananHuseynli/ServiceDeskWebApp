package com.taskmanager.taskmanagementwebapp.dao;

// dao/UserDao.java

import com.taskmanager.taskmanagementwebapp.model.Users;
import com.taskmanager.taskmanagementwebapp.util.DbConnection;
import oracle.jdbc.proxy.annotation.Pre;


import java.sql.*;
import java.util.List;

public class UserDao {

    public Users getUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean addUser(Users user) {
        String sql = "insert into users(name,surname,password,email,phone_number,gender_id,dob,role_id,position_id,fin) values(?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn=DbConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)) {

            ps.setString(1,user.getName());
            ps.setString(2,user.getSurname());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getPhone());
            ps.setInt(6,user.getGender().getId());
            ps.setDate(7,new java.sql.Date(System.currentTimeMillis()));
            ps.setInt(8,user.getRole().getId());
            ps.setInt(9,user.getPosition().getId());
            ps.setString(10,user.getFin());

            return ps.executeUpdate()==1    ;

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return false;
    }

    public Users getUserById(int userId) {
        return null;
    }

    public List<Users> getAllUsers() {
        return List.of();
    }
}

