<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center">Login</h2>
    <form action="<%=request.getContextPath()%>/login" method="post" class="w-50 mx-auto border p-4 bg-white rounded shadow">

        <div class="mb-3">
            <label for="username" class="form-label">İstifadəçi adı</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Şifrə</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>

        <%
            String loginError = (String) session.getAttribute("loginError");
            if (loginError != null) {
        %>
        <div class="alert alert-danger text-center"><%= loginError %></div>
        <%
                session.removeAttribute("loginError");
            }
        %>

        <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary w-50">Daxil ol</button>
        </div>




    </form>
</div>
</body>
</html>
