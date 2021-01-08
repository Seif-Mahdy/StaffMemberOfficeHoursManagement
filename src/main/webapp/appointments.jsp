<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.*" %><%--
  Created by IntelliJ IDEA.
  User: seif
  Date: 1/7/21
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My appointment</title>
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
</head>
<body>
<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    }
    boolean appointments = request.getRequestURL().toString().contains("appointments.jsp");
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
                    <a class="nav-link" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="profile.jsp">Profile</a>
                </li>
                <% if (appointments) {%>
                <li class="nav-item">
                    <a class="nav-link active" href="appointments.jsp">My appointments</a>
                </li>
                <% } else {%>
                <li class="nav-item">
                    <a class="nav-link" href="appointments.jsp">My appointments</a>
                </li>
                <%}%>
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
    <%
        String studentId = request.getSession().getAttribute("id").toString();
        //TODO:create function to get all the appointments,get the office hour details and the name of the staff member[DONE]
        ///list of all appointments contain student id , office hour id , staff id
        ///
        List<AppointmentEntity> appointmentsList = AppointmentCrud.selectAllAppointment("studentId", studentId);
        List<OfficehourEntity> slotsInfo = new ArrayList<>();
        List<StaffmemberEntity> staffInfo = new ArrayList<>();
        for (int i = 0; i < appointmentsList.size(); i++) {
            slotsInfo.add(OfficeHourCrud.findOfficeHour(appointmentsList.get(i).getOfficeHourId()));
            staffInfo.add(StaffMemberCrud.findStaffMember(appointmentsList.get(i).getStaffId()));
        }

    %>
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
                    <th class="text-center">Staff member</th>
                    <th class="text-center">Cancel appointment</th>
                </tr>
                </thead>
                <tbody>

                <%
                    for (int i = 0; i < appointmentsList.size(); i++) {
                %>
                <tr>


                    <td class="text-center">
                        <%=slotsInfo.get(i).getFromDate() %>
                    </td>
                    <td class="text-center">
                        <%= slotsInfo.get(i).getToDate() %>
                    </td>
                    <td class="text-center">
                        <% Byte isOnline = slotsInfo.get(i).getIsOffline();
                            if (isOnline == 1) {%>
                        Yes
                        <%
                        } else if (isOnline == 0) {%>
                        No
                        <% }
                        %>
                    </td>
                    <td class="text-center">
                        <%
                            String location = slotsInfo.get(i).getLocation();
                            if (location == null) {
                        %>
                        N/A
                        <%} else { %>
                        <%=location%>
                        <% }
                        %>
                    </td>
                    <td class="text-center">
                        <%= staffInfo.get(i).getStaffName()%>
                    </td>

                    <td class="text-center">
                        <%--TODO:create a function to cancel reservation[Done]--%>
                        <%--TODO:get the appointment id and pass it to the function--%>



                        <button class="btn btn-danger" type="button" onclick="">
                            Cancel
                        </button>
                    </td>
                </tr>
                <% }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
