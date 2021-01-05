<%--
  Created by IntelliJ IDEA.
  User: seif
  Date: 1/5/21
  Time: 3:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script src="scripts.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap5.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container-fluid d-flex align-items-center">
        <a class="navbar-brand" href="home.jsp">
            <img src="images/1153972.svg" alt="" width="50" height="50">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="profile.jsp">Profile</a>
                </li>
            </ul>
            <div>
                <div class="spinner-border text-primary spinner-border-sm visually-hidden" role="status"
                     id="spinner1">
                    <span class="visually-hidden">Loading...</span>
                </div>
                <button class="btn btn-primary ms-4" onclick="logout()" id="logout-btn">Logout</button>
            </div>
        </div>
    </div>
</nav>
<div style="margin-top: 100px" class="p-5">
    <div class="card mb-5">
        <div class="card-header fw-bold">
            Contact-info
        </div>
        <div class="card-body">
            <p class="card-text">Sara El-nady</p>
            <p class="card-text">01234567891</p>
            <p class="card-text">s.elnady@gmail.com</p>
        </div>
        <div class="card-footer text-muted">
            <button class="btn btn-success d-flex float-end">Send message</button>
        </div>
    </div>
    <div class="card mb-5">
        <div class="card-header fw-bold">
            Office hours
        </div>
        <div class="card-body">
            <table id="example2" class="display table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>From</th>
                    <th>To</th>
                    <%--                    <th>Office</th>--%>
                    <%--                    <th>Age</th>--%>
                    <%--                    <th>Start date</th>--%>
                    <%--                    <th>Salary</th>--%>
                </tr>
                </thead>
                <tbody>
                <tr onclick="" style="cursor: pointer">
                    <td>5-1-2021 02:00PM</td>
                    <td>5-1-2021 03:00PM</td>
                    <%--                    <td>System Architect</td>--%>
                    <%--                    <td>Edinburgh</td>--%>
                    <%--                    <td>61</td>--%>
                    <%--                    <td>2011/04/25</td>--%>
                    <%--                    <td>$320,800</td>--%>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
