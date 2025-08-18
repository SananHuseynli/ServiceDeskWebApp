<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.taskmanager.taskmanagementwebapp.model.Users" %>
<%@ page import="com.taskmanager.taskmanagementwebapp.model.Status" %>
<%@ page import="com.taskmanager.taskmanagementwebapp.dao.UserDao" %>
<%@ page import="com.taskmanager.taskmanagementwebapp.dao.StatusDao" %>
<html>
<head>
    <title>Yeni Ticket Yarat</title>
</head>
<body>
<h2>Yeni Ticket Yarat</h2>

<%
    // User və Status siyahılarını databazadan al
    UserDao userDAO = new UserDao();
    List<Users> userList = userDAO.getAllUsers();

    StatusDao statusDAO = new StatusDao();
    List<Status> statusList = statusDAO.getAllStatuses();
%>

<form action="create-ticket" method="post">
    <label for="title">Başlıq:</label><br>
    <input type="text" id="title" name="title" required><br><br>

    <label for="description">Təsvir:</label><br>
    <textarea id="description" name="description" rows="5" cols="40" required></textarea><br><br>

    <label for="status_id">Status:</label><br>
    <select id="status_id" name="status_id" required>
        <%
            for (Status status : statusList) {
        %>
        <option value="<%=status.getId()%>"><%=status.getStatus()%></option>
        <%
            }
        %>
    </select><br><br>

    <label for="assigned_to">Təyin olunan istifadəçi:</label><br>
    <select id="assigned_to" name="assigned_to" required>
        <%
            for (Users user : userList) {
        %>
        <option value="<%=user.getId()%>"><%=user.getName()%> <%=user.getSurname()%></option>
        <%
            }
        %>
    </select><br><br>

    <input type="submit" value="Ticket Yarat">
</form>

</body>
</html>
