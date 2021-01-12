<%@ page import="com.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %><%--
  Created by IntelliJ IDEA.
  User: seifa
  Date: 1/3/2021
  Time: 2:01 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
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
    String number = "";
    String password = "";
    String email = "";
    String name = "";
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    } else {
        String loginType = request.getSession().getAttribute("loginType").toString();

        if (loginType.equals("student")) {
            StudentEntity student = StudentCrud.findStudent(request.getSession().getAttribute("id").toString());
            number = student.getStudentNumber();
            password = student.getStudentPassword();
            email = student.getStudentEmail();
            name = student.getStudentName();

        } else if (loginType.equals("staff")) {
            StaffmemberEntity staff = StaffMemberCrud.findStaffMember(request.getSession().getAttribute("id").toString());
            number = staff.getStaffNumber();
            password = staff.getStaffPassword();
            email = staff.getStaffEmail();
            name = staff.getStaffName();
        }


        boolean profile = request.getRequestURL().toString().contains("profile.jsp");
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
                    <%
                        if (profile) {
                    %>
                    <a class="nav-link active" href="profile.jsp">Profile</a>
                    <%
                    } else {
                    %>
                    <a class="nav-link" href="profile.jsp">Profile</a>
                    <%}%>
                </li>
                <%
                    if (loginType.equals("student")) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="appointments.jsp">My appointments</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="staffAppointments.jsp">My appointments</a>
                </li>
                <%
                    }
                %>
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
<div class="container-fluid" style="margin-top: 100px">
    <ul id="updateProfileErrors">
    </ul>

    <div class="card mb-5">
        <div class="card-header fw-bold">
            Update Profile
        </div>
        <div class="card-body">
            <%
                if (request.getSession().getAttribute("profileUpdate") != null) {

            %>
            <p class="text-success" id="updateProfileSuccess"><%=request.getSession().getAttribute("profileUpdate")%>
            </p>
            <%
                }
                request.getSession().removeAttribute("profileUpdate");

            %>
            <form id="profileDataForm" class="mt-2">
                <div class="mb-3">
                    <label for="exampleInputName" class="form-label">Full name</label>
                    <input type="text" class="form-control" id="exampleInputName" value="<%= name %>" required>
                </div>
                <div class="mb-3">
                    <%--TODO:check update mail error[DONE]--%>
                    <label for="exampleInputEmail" class="form-label">Email</label>
                    <input type="text" class="form-control" id="exampleInputEmail" value="<%=email%>" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPhoneNumber" class="form-label">Phone number</label>
                    <input type="text" class="form-control" id="exampleInputPhoneNumber" value="<%=number%>" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword" class="form-label">Password</label>
                    <input type="text" class="form-control" id="exampleInputPassword" value="<%=password%>" required>
                </div>
            </form>
        </div>
        <div class="card-footer text-muted">
            <div class="d-flex flex-row float-end align-items-center">
                <div class="spinner-border text-primary spinner-border-sm visually-hidden" role="status"
                     id="spinner">
                    <span class="visually-hidden">Loading...</span>
                </div>
                <button type="submit" form="profileDataForm" class="btn btn-primary ms-4" onclick="loadProfileData()"
                        id="update-btn">update
                </button>
            </div>
        </div>
    </div>
    <%
        if (loginType.equals("staff")) {
    %>
    <div class="card mb-5">
        <%--TODO: get all the appointments here--%>
        <% List<AppointmentEntity> appointments = new ArrayList<>();
            appointments = AppointmentCrud.selectAllAppointment("staffId", request.getSession().getAttribute("id").toString());
        %>

        <div class="card-header fw-bold">
            Reservations history
        </div>
        <div class="card-body">
            <div class="d-flex justify-content-center" id="msg"></div>
            <table id="example2" class="cell-border hover mt-4" style="width:100%">
                <thead>
                <tr>
                    <th class="text-center">From</th>
                    <th class="text-center">To</th>
                    <th class="text-center">Offline?</th>
                    <th class="text-center">Location</th>
                    <th class="text-center">Student</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (int i = 0; i < appointments.size(); i++) {
                        Date date = new Date();
                        long time = date.getTime();
                        Timestamp currentDate = new Timestamp(time);


                        OfficehourEntity slot = OfficeHourCrud.findOfficeHour(appointments.get(i).getOfficeHourId());
                        if (currentDate.compareTo(slot.getFromDate()) > 0) {
                %>
                <tr>


                    <td class="text-center"><%=slot.getFromDate()%>
                    </td>
                    <td class="text-center"><%=slot.getToDate() %>
                    </td>
                    <td class="text-center"><%=slot.getIsOffline()%>
                    </td>
                    <td class="text-center"><%=slot.getLocation()%>
                    </td>
                    <td class="text-center"><%=appointments.get(i).getStudentId()%>
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

            }
        }
    %>

</div>
</body>
</html>
