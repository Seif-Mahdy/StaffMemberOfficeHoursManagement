<%@ page import="java.util.List" %>
<%@ page import="com.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="org.joda.time.DateTime" %>
<%@ page import="org.joda.time.LocalDate" %><%--
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
    <%@include file="layout/includes.html" %>
</head>
<body>
<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    } else {
        String loginType = request.getSession().getAttribute("loginType").toString();
%>
<%@include file="layout/navbar.jsp" %>
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
            List<OfficehourEntity> freeSlots = new ArrayList<>();
            boolean isExist =false;
            for (int i = 0; i < slots.size(); i++) {
                if (appointments.size() == 0) {
                    freeSlots = slots;
                } else {
                    for (AppointmentEntity appointment : appointments) {

                        if (appointment.getOfficeHourId().equals(slots.get(i).getId())) {
                            System.out.println("appoint"+ appointment.getOfficeHourId());
                            System.out.println("slot"+ slots.get(i).getId());
                           isExist=true;
                        }

                    }
                    if(!isExist)
                    {
                        freeSlots.add(slots.get(i));
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
                    System.out.println(freeSlots.size());
                    for (OfficehourEntity slot : freeSlots) {

                        DateTime fromDate = new DateTime(slot.getFromDate());

                        Date date = new Date();
                        System.out.println(date);

                        long time = date.getTime();
                        DateTime dateTime = new DateTime(date);
                        org.joda.time.LocalDate local1 = fromDate.toLocalDate();
                        LocalDate local2 = dateTime.toLocalDate();


                        if (local1.compareTo(local2) >= 0)
                        {
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
        }
    %>
</div>
</div>
</body>
</html>
