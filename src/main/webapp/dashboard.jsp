<%@ page import="com.taskmanager.taskmanagementwebapp.model.Users" %>
<%@ page import="com.taskmanager.taskmanagementwebapp.model.Users" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%
  Users user = (Users) session.getAttribute("loggedUser");
  if (user == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
  <div class="card shadow p-4">
    <h3>Salam, <%= user.getName()+" "+user.getSurname() %>!</h3>
    <p>Xoş gəlmisiniz!</p>

    <div class="mt-4">
      <a href="new_ticket.jsp" class="btn btn-primary">Yeni Ticket Yarat</a>
      <a href="tickets.jsp" class="btn btn-secondary">Ticket-lərimə Bax</a>
      <a href="logout.jsp" class="btn btn-danger">Çıxış</a>
    </div>
  </div>
</div>

</body>
</html>
