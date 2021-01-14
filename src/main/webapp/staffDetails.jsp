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
<div style="margin-top: 100px" class="px-5">
    <%
        if (loginType.equals("student")) {
    %>
    <div class="card mb-5">
        <div class="card-header font-weight-bold">
            Contact-info
        </div>
        <%
            String id = request.getParameter("id");
            if (id != null) {
                StaffmemberEntity staff = StaffMemberCrud.findStaffMember(id);
        %>
        <div class="card-body">
            <p class="card-text">
                <span class="font-weight-bold">Name: </span><%=staff.getStaffName()%>
            </p>
            <p class="card-text"><span class="font-weight-bold"> Phone number: </span><%=staff.getStaffNumber()%>
            </p>
            <p class="card-text"><span class="font-weight-bold">Email: </span><%=staff.getStaffEmail()%>
            </p>
        </div>
        <div class="card-footer text-muted">
            <button class="btn btn-success d-flex float-right" data-toggle="modal" data-target="#exampleModal1">Send
                message
            </button>
        </div>
    </div>
    <div class="card mb-5">
        <div class="card-header font-weight-bold">
            Office hours
        </div>

        <%
            List<OfficehourEntity> slots = OfficeHourCrud.selectStaffOfficeHour(id);
            List<AppointmentEntity> appointments = AppointmentCrud.selectAllAppointment("staffId", staff.getStaffId());
            List<OfficehourEntity> freeSlots = new ArrayList<>();
            boolean isExist = false;
            for (int i = 0; i < slots.size(); i++) {
                if (appointments.size() == 0) {
                    freeSlots = slots;
                } else {
                    for (AppointmentEntity appointment : appointments) {

                        if (appointment.getOfficeHourId().equals(slots.get(i).getId())) {
                            System.out.println("appoint" + appointment.getOfficeHourId());
                            System.out.println("slot" + slots.get(i).getId());
                            isExist = true;
                        }

                    }
                    if (!isExist) {
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


                        if (local1.compareTo(local2) >= 0) {
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
        <div class="card-header font-weight-bold">
            Contact-info
        </div>
        <%
            String id = request.getParameter("id");
            if (id != null) {
                StudentEntity student = StudentCrud.findStudent(id);
        %>
        <div class="card-body">
            <p class="card-text">
                <span class="font-weight-bold">ID: </span><%=student.getStudentId()%>
            </p>
            <p class="card-text">
                <span class="font-weight-bold">Name: </span><%=student.getStudentName()%>
            </p>
            <p class="card-text"><span class="font-weight-bold"> Phone number: </span><%=student.getStudentNumber()%>
            </p>
            <p class="card-text"><span class="font-weight-bold">Email: </span><%=student.getStudentEmail()%>
            </p>
        </div>
        <div class="card-footer text-muted">
            <button class="btn btn-success d-flex float-right" data-toggle="modal" data-target="#exampleModal1">Send
                message
            </button>
        </div>
    </div>

    <%
            }
        }
    %> <!-- Modal -->
    <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel1">Send message</h5>
                    <button type="button" class="close btn" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">x</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="text-danger" id="send-message-errors"></div>
                    <form action="#" method="POST" id="send-message" class="mt-2">
                        <div class="form-group mb-3">
                            <label class="mb-1" for="toEmail">To</label>
                            <%
                                String id = request.getParameter("id");
                                StudentEntity student = StudentCrud.findStudent(id);
                                if (loginType.equals("staff")) {
                            %>
                            <input type="email" class="form-control" id="toEmail"
                                   name="toEmail" readonly value="<%=student.getStudentEmail()%>">
                            <%
                            } else {
                                StaffmemberEntity staff = StaffMemberCrud.findStaffMember(id);
                            %>
                            <input type="email" class="form-control" id="toEmail"
                                   name="toEmail" readonly value="<%=staff.getStaffEmail()%>">
                            <%
                                }
                            %>
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-1" for="subject">Subject</label>
                            <input type="text" class="form-control" id="subject"
                                   required name="subject">
                        </div>
                        <div class="form-group">
                            <label class="mb-1" for="message">Message body</label>
                            <textarea class="form-control" id="message" rows="3"></textarea>
                        </div>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal"
                            onclick="closeModal('send-message','form-msg2')">Close
                    </button>
                    <button type="button" class="btn btn-success" onclick=""
                            style="width: 64px;height: 38px" id="cancel-btn">
                        <div class="spinner-border text-light spinner-border-sm d-none" role="status"
                             id="spinner3">
                            <span class="d-none">Loading...</span>
                        </div>
                        <div id="btn-text2">
                            Send
                        </div>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%
    }
%>
</body>
</html>
