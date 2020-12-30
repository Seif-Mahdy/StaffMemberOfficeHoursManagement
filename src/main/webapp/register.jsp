<%--
  Created by IntelliJ IDEA.
  User: seifa
  Date: 12/30/2020
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.DbConnection" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body style="width: 100%;height: 100%;position: fixed">

<div class="container-fluid d-flex justify-content-center align-items-center"
     style="height: 100%;background-color:gainsboro">
    <div class="w-50 shadow p-5 bg-light rounded">
        <form action="" method="POST">
            <div class="mb-3">
                <label for="exampleInputUserName" class="form-label">User name</label>
                <input type="text" class="form-control" id="exampleInputUserName" name="UserName" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" name="email" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputPhoneNumber" class="form-label">Phone number</label>
                <input type="text" class="form-control" id="exampleInputPhoneNumber" name="phoneNumber" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputSSN" class="form-label">SSN</label>
                <input type="text" class="form-control" id="exampleInputSSN" name="ssn" required>
            </div>
            <div class="mb-5 d-flex flex-column">
                <label class="mb-3">Register As:</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role" id="flexRadioDefault1">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Doctor
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role" id="flexRadioDefault2">
                    <label class="form-check-label" for="flexRadioDefault2">
                        TA
                    </label>
                </div>
            </div>
            <div class="d-flex justify-content-between align-items-center">
                <button type="submit" class="btn btn-primary">Register</button>
                <a href="index.jsp">don't have an account?</a>
            </div>

        </form>
    </div>
</div>
</body>
</html>
