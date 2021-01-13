<%@ page import="com.StudentEntity" %>
<%@ page import="com.StudentCrud" %>
<%@ page import="com.StaffmemberEntity" %>
<%@ page import="com.StaffMemberCrud" %>
<%@ page import="java.util.ArrayList" %>
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
    <%@include file="layout/includes.html" %>
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
%>
<%@include file="layout/navbar.jsp" %>
<div class="container-fluid p-5" style="margin-top: 100px">
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
