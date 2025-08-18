package com.taskmanager.taskmanagementwebapp.controller;

import com.taskmanager.taskmanagementwebapp.dao.UserDao;
import com.taskmanager.taskmanagementwebapp.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        Users user = userDao.getUserByUsernameAndPassword(username, password);
        if(user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", user);
            response.sendRedirect("dashboard.jsp");

        }else {
            response.sendRedirect("/login.jsp?error=1");
        }

    }


}
