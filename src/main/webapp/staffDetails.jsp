<%@ page import="java.util.List" %>
<%@ page import="com.*" %>
<%@ page import="java.util.ArrayList" %><%--
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
    String loginType = request.getSession().getAttribute("loginType").toString();
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
                <li class="nav-item">
                    <a class="nav-link" href="appointments.jsp">My appointments</a>
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
    <%
        if (loginType.equals("student")) {
    %>
    <div class="card mb-5">
        <div class="card-header fw-bold">
            Contact-info
        </div>
        <%
            String id = request.getParameter("id");
            if (id != null) {
                StaffmemberEntity staff = StaffMemberCrud.findStaffMember(id);
        %>
        <div class="card-body">
            <p class="card-text">
                <span class="fw-bold">Name: </span><%=staff.getStaffName()%>
            </p>
            <p class="card-text"><span class="fw-bold"> Phone number: </span><%=staff.getStaffNumber()%>
            </p>
            <p class="card-text"><span class="fw-bold">Email: </span><%=staff.getStaffEmail()%>
            </p>
        </div>
        <div class="card-footer text-muted">
            <button class="btn btn-success d-flex float-end">Send message</button>
        </div>
    </div>
    <div class="card mb-5">
        <div class="card-header fw-bold">
            Office hours
        </div>

        <%
            List<OfficehourEntity> slots = OfficeHourCrud.selectStaffOfficeHour(id);
            List<AppointmentEntity> appointments = AppointmentCrud.selectAllAppointment("staffId", staff.getStaffId());
            List<OfficehourEntity> modifiedSlots = new ArrayList<>();
            for (int i = 0; i < slots.size(); i++) {
                if (appointments.size() == 0) {
                    modifiedSlots = slots;
                } else {
                    for (AppointmentEntity appointment : appointments) {

                        if (!(appointment.getOfficeHourId().equals(slots.get(i).getId()))) {
                            modifiedSlots.add(slots.get(i));
                        }

                    }
                }

            }
        %>
        <div class="card-body">
            <div class="d-flex justify-content-center" id="msg"></div>
            <table id="example2" class="cell-border hover mt-4" style="width:100%">
                <thead>
                <tr>
                    <th class="text-center">From</th>
                    <th class="text-center">To</th>
                    <th class="text-center">Reservation</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (OfficehourEntity slot : modifiedSlots) {
                %>
                <tr>
                    <td class="text-center"><%=slot.getFromDate()%>
                    </td>
                    <td class="text-center"><%=slot.getToDate()%>
                    </td>
                    <td class="text-center" id="<%=slot.getId()%>">
                        <button class="btn btn-success" type="button" id="reserve-btn"
                                onclick="reserveSlot('<%=slot.getId()%>','<%=request.getSession().getAttribute("id").toString()%>','<%=staff.getStaffId()%>')">
                            reserve
                        </button>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
    <%
    } else {
    %>
    <div class="card mb-5">
        <div class="card-header fw-bold">
            Contact-info
        </div>
        <%
            String id = request.getParameter("id");
            if (id != null) {
                StudentEntity student = StudentCrud.findStudent(id);
        %>
        <div class="card-body">
            <p class="card-text">
                <span class="fw-bold">ID: </span><%=student.getStudentId()%>
            </p>
            <p class="card-text">
                <span class="fw-bold">Name: </span><%=student.getStudentName()%>
            </p>
            <p class="card-text"><span class="fw-bold"> Phone number: </span><%=student.getStudentNumber()%>
            </p>
            <p class="card-text"><span class="fw-bold">Email: </span><%=student.getStudentEmail()%>
            </p>
        </div>
        <div class="card-footer text-muted">
            <button class="btn btn-success d-flex float-end">Send message</button>
        </div>
    </div>
    <%
            }
        }
    %>
</div>
</div>
</body>
</html>
