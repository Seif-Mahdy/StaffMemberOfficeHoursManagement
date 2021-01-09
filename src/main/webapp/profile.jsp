<%@ page import="com.StudentEntity" %>
<%@ page import="com.StudentCrud" %>
<%@ page import="com.StaffmemberEntity" %>
<%@ page import="com.StaffMemberCrud" %><%--
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script src="scripts.js"></script>
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
                    String loginType = request.getSession().getAttribute("loginType").toString();
                    if(loginType.equals("student")){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="appointments.jsp">My appointments</a>
                </li>
                <%
                    }else{
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
<div class="container-fluid p-5" style="margin-top: 100px">
    <ul id="updateProfileErrors">
    </ul>
    <%
        if (request.getSession().getAttribute("profileUpdate") != null) {

    %>
    <p class="text-success" id="updateProfileSuccess"><%=request.getSession().getAttribute("profileUpdate")%>
    </p>
    <%
        }
        request.getSession().removeAttribute("profileUpdate");
    %>
    <form id="profileDataForm">
        <div class="mb-3">
            <label for="exampleInputName" class="form-label">Full name</label>
            <input type="text" class="form-control" id="exampleInputName" value="<%= name %>" required>
        </div>
        <div class="mb-3">
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
        <div class="d-flex flex-row float-end align-items-center">
            <div class="spinner-border text-primary spinner-border-sm visually-hidden" role="status"
                 id="spinner">
                <span class="visually-hidden">Loading...</span>
            </div>
            <button type="submit" class="btn btn-primary ms-4" onclick="loadProfileData()" id="update-btn">update
            </button>
        </div>
    </form>
</div>
</body>
</html>
