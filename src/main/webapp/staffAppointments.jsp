<%@ page import="com.StaffmemberEntity" %>
<%@ page import="com.StaffMemberCrud" %><%--
  Created by IntelliJ IDEA.
  User: seif
  Date: 1/8/21
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My appointments</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="scripts.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">

    <%-- date time picker --%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.38.0/js/tempusdominus-bootstrap-4.min.js"
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.38.0/css/tempusdominus-bootstrap-4.min.css"
          crossorigin="anonymous"/>
</head>
<body>
<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    }
    boolean appointment = request.getRequestURL().toString().contains("staffAppointments.jsp");
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

                    <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>

                </li>
                <li class="nav-item">
                    <a class="nav-link" href="profile.jsp">Profile</a>
                </li>
                <li class="nav-item">
                    <%
                        if (appointment) {
                    %>
                    <a class="nav-link active" href="staffAppointments.jsp">My appointments</a>
                    <%
                    } else {
                    %>
                    <a class="nav-link" href="staffAppointments.jsp">My appointments</a>
                    <% }
                    %>
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
            My office hours
        </div>
        <div class="card-body">
            <table id="example" class="cell-border hover" style="width:100%">
                <thead>
                <tr>
                    <th class="text-center">From</th>
                    <th class="text-center">To</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="card-footer text-muted">
            <button class="btn btn-success d-flex float-end" data-toggle="modal" data-target="#exampleModal">Add office hour</button>
        </div>
    </div>
    <div class="card mb-5">
        <div class="card-header fw-bold">
            My appointments
        </div>
        <div class="card-body">
            <table id="example2" class="cell-border hover" style="width:100%">
                <thead>
                <tr>
                    <th class="text-center">From</th>
                    <th class="text-center">To</th>
                    <th class="text-center">Offline?</th>
                    <th class="text-center">Location</th>
                    <th class="text-center">Student</th>
                    <th class="text-center">Cancel appointment</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="text-center">test</td>
                    <td class="text-center">test</td>
                    <td class="text-center">test</td>
                    <td class="text-center">test</td>
                    <td class="text-center">test</td>
                    <td class="text-center">
                        <button class="btn btn-danger" type="button">
                            Cancel
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="card-footer text-muted">
            <button class="btn btn-danger d-flex float-end" data-toggle="modal" data-target="#exampleModal1">Cancel appointments of a day</button>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add office hour</h5>
                <button type="button" class="close btn" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="" method="POST">

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-success">Add</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">Modal title2</h5>
                <button type="button" class="close btn" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
