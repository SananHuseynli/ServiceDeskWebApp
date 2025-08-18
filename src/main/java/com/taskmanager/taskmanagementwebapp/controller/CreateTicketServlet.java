package com.taskmanager.taskmanagementwebapp.controller;

import com.taskmanager.taskmanagementwebapp.dao.TicketDao;
import com.taskmanager.taskmanagementwebapp.model.Status;
import com.taskmanager.taskmanagementwebapp.model.Ticket;
import com.taskmanager.taskmanagementwebapp.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CreateTicketServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int statusId = Integer.parseInt(request.getParameter("status_id"));
        int assignedTo = Integer.parseInt(request.getParameter("assigned_to"));

        Ticket ticket=new Ticket();
        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setStatus_id(new Status(statusId));
        ticket.setUser_id(new Users(assignedTo));

        TicketDao ticketDao=new TicketDao();
        ticketDao.insertTicket(ticket);
        response.sendRedirect("tickets.jsp");
    }
}
