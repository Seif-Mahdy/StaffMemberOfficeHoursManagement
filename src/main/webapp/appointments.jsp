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
    <%@include file="layout/includes.html" %>
</head>
<body>
<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<%@include file="layout/navbar.jsp" %>
<div class="p-5" style="margin-top: 100px">
    <%
        if (request.getSession().getAttribute("id") == null) {
            response.sendRedirect("index.jsp");
        } else {
            String loginType = request.getSession().getAttribute("loginType").toString();
            String studentId = request.getSession().getAttribute("id").toString();
            List<AppointmentEntity> appointmentsList = AppointmentCrud.selectAllAppointment("studentId", studentId);
            List<OfficehourEntity> slotsInfo = new ArrayList<>();
            List<StaffmemberEntity> staffInfo = new ArrayList<>();
            for (AppointmentEntity appointmentEntity : appointmentsList) {
                slotsInfo.add(OfficeHourCrud.findOfficeHour(appointmentEntity.getOfficeHourId()));
                staffInfo.add(StaffMemberCrud.findStaffMember(appointmentEntity.getStaffId()));
            }
    %>
    <div class="card mb-5">
        <div class="card-header fw-bold">
            My appointments
        </div>
        <div class="card-body">
            <div class="d-flex justify-content-center" id="msg"></div>
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
                        int appointmentId = appointmentsList.get(i).getAppointmentId();
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
                        <button class="btn btn-danger" type="button" id="cancelReservation-btn"
                                onclick="cancelReservation('<%=appointmentId%>','student')">
                            Cancel
                        </button>
                    </td>
                </tr>
                <%
                        }     //   System.out.println(appointmentId +"idd");
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
