<%--
  Created by IntelliJ IDEA.
  User: seifa
  Date: 12/30/2020
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.DbConnection" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script src="scripts.js"></script>
</head>
<body style="width: 100%;height: 100%;position: fixed">

<%
if(request.getSession().getAttribute("id")!=null)
{
    response.sendRedirect("home.jsp");
}
%>
<div class="container-fluid d-flex flex-column justify-content-center align-items-center"
     style="height: 100%;background-color:gainsboro">
    <%
        if (request.getSession().getAttribute("success") != null) {
    %>
    <div class="alert alert-success" role="alert">
        <%--        <%--%>
        <%--            PrintWriter writer = response.getWriter();--%>
        <%--            writer.print();--%>
        <%--        %>--%>
        <%= request.getSession().getAttribute("success")%>
    </div>
    <%
            request.getSession().removeAttribute("success");
        }
    %>
    <div class="w-50 shadow p-5 bg-light rounded">
        <form action="#" method="POST" id="login-form">
            <p class="text-danger" id="validation_error"></p>
            <div class="mb-3">
                <label for="exampleInputID" class="form-label">User ID</label>
                <input type="text" class="form-control" id="exampleInputID" name="id" required>
            </div>
            <div class="mb-5">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" name="password" required>
            </div>
            <div class="input-group mb-5">
                <label class="input-group-text" for="inputGroupSelect01">Login as</label>
                <select class="form-select" id="inputGroupSelect01" name="login_type">
                    <option value="Student">Student</option>
                    <option value="Staff member">Staff member</option>
                </select>
            </div>
            <div class="d-flex justify-content-between align-items-center">
                <div class="d-flex flex-row align-items-center">
                    <button type="submit" class="btn btn-primary" onclick="loadLoginData()" id="login-btn">login
                    </button>
                    <div class="spinner-border text-primary spinner-border-sm ms-4 visually-hidden" role="status"
                         id="spinner">
                        <span class="visually-hidden">Loading...</span>
                    </div>
                </div>
                <a href="register.jsp">Don't have an account?</a>
            </div>

        </form>
    </div>
</div>
</body>
</html>