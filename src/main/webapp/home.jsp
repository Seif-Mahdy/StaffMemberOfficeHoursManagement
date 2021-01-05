<%--
  Created by IntelliJ IDEA.
  User: seifa
  Date: 1/3/2021
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script src="scripts.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <%--    <script class="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>--%>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
    <%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">--%>
</head>
<body>
<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    }
    boolean home = request.getRequestURL().toString().contains("home.jsp");
%>
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
                    <%
                        if (home) {
                    %>
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                    <%
                    } else {
                    %>
                    <a class="nav-link" aria-current="page" href="#">Home</a>
                    <%
                        }
                    %>
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
<div class="p-5" style="margin-top: 100px">
    <div class="card mb-5">
        <div class="card-header fw-bold">
            Notifications
        </div>
        <div class="card-body">
            <p class="card-text">This is a test notification!.</p>

        </div>
    </div>
    <div class="card mb-5">
        <div class="card-header fw-bold">
            Subjects
        </div>
        <div class="card-body">
            <table id="example" class="cell-border hover" style="width:100%">
                <thead>
                <tr>
                    <th>Name</th>
                    <%--                    <th>Position</th>--%>
                    <%--                    <th>Office</th>--%>
                    <%--                    <th>Age</th>--%>
                    <%--                    <th>Start date</th>--%>
                    <%--                    <th>Salary</th>--%>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Math</td>
                    <%--                    <td>System Architect</td>--%>
                    <%--                    <td>Edinburgh</td>--%>
                    <%--                    <td>61</td>--%>
                    <%--                    <td>2011/04/25</td>--%>
                    <%--                    <td>$320,800</td>--%>
                </tr>
                <tr>
                    <td>Algorithms</td>
                    <%--                    <td>Accountant</td>--%>
                    <%--                    <td>Tokyo</td>--%>
                    <%--                    <td>63</td>--%>
                    <%--                    <td>2011/07/25</td>--%>
                    <%--                    <td>$170,750</td>--%>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card mb-5">
        <div class="card-header fw-bold">
            Staff members teaching X
        </div>
        <div class="card-body">
            <table id="example1" class="cell-border hover" style="width:100%">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone number</th>
                    <th>Role</th>
                    <%--                    <th>Start date</th>--%>
                    <%--                    <th>Salary</th>--%>
                </tr>
                </thead>
                <tbody>
                <tr onclick="window.location.href='staffDetails.jsp'" style="cursor: pointer">
                    <td>Sara El-nady</td>
                    <td>s.elnady@gmail.com</td>
                    <td>01234567891</td>
                    <td>TA</td>
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
