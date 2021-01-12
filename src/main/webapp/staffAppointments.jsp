<%@ page import="java.util.List" %>
<%@ page import="com.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %><%--
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
<div class="p-5" style="margin-top: 100px">
    <div class="card mb-5">
        <div class="card-header fw-bold">
            My office hours
        </div>
        <div class="card-body">
            <%
                if (request.getSession().getAttribute("id") == null) {
                    response.sendRedirect("index.jsp");
                }
                String id = request.getSession().getAttribute("id").toString();
                List<OfficehourEntity> slots = OfficeHourCrud.selectStaffOfficeHour(id);
                List<AppointmentEntity> appointments = AppointmentCrud.selectAllAppointment("staffId", id);
                List<OfficehourEntity> modifiedSlots = new ArrayList<>();
                List<OfficehourEntity> reservedSlots = new ArrayList<>();
                for (int i = 0; i < slots.size(); i++) {
                    if (appointments.size() == 0) {
                        modifiedSlots = slots;
                    } else {
                        for (AppointmentEntity app : appointments) {

                            if (!(app.getOfficeHourId().equals(slots.get(i).getId()))) {
                                modifiedSlots.add(slots.get(i));
                            } else {
                                reservedSlots.add(slots.get(i));
                            }

                        }
                    }

                }
            %>
            <table id="example" class="cell-border hover" style="width:100%">
                <thead>
                <tr>
                    <th class="text-center">From</th>
                    <th class="text-center">To</th>
                    <th class="text-center">Reserved?</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (appointments.size() != 0) {
                        for (OfficehourEntity slot : reservedSlots
                        ) {
                            Date date = new Date();
                            long time = date.getTime();
                            Timestamp currentDate = new Timestamp(time);



                            if (currentDate.compareTo(slot.getFromDate()) <= 0)
                            {
                %>
                <tr>
                    <td class="text-center"><%=slot.getFromDate()%>
                    </td>
                    <td class="text-center"><%=slot.getToDate()%>
                    </td>
                    <td class="text-center"><img src="images/check.svg" alt="" width="20" height="20"></td>
                </tr>
                <%
                            }
                        }
                }
                %>
                <%
                    for (OfficehourEntity slot : modifiedSlots
                    ) {
                        Date date = new Date();
                        long time = date.getTime();
                        Timestamp currentDate = new Timestamp(time);


                        if (currentDate.compareTo(slot.getFromDate()) <= 0)
                        {
                %>
                <tr>
                    <td class="text-center"><%=slot.getFromDate()%>
                    </td>
                    <td class="text-center"><%=slot.getToDate()%>
                    </td>
                    <td class="text-center"><img src="images/close.svg" alt="" width="20" height="20"></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
        <div class="card-footer text-muted">
            <button class="btn btn-success d-flex float-end" data-toggle="modal" data-target="#exampleModal">Add office
                hour
            </button>
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
                <%
                    for (int i = 0; i < reservedSlots.size(); i++) {


                        Date date = new Date();
                        long time = date.getTime();
                        Timestamp currentDate = new Timestamp(time);


                        if (currentDate.compareTo(reservedSlots.get(i).getFromDate()) <= 0)
                        {
                %>
                <tr>
                    <td class="text-center"><%=reservedSlots.get(i).getFromDate()%>
                    </td>
                    <td class="text-center"><%=reservedSlots.get(i).getToDate()%>
                    </td>
                    <td class="text-center"><%
                        if (reservedSlots.get(i).getIsOffline() == 0) {%>
                        No
                        <%} else {%>
                        Yes
                        <%
                            }
                        %></td>
                    <td class="text-center"><%
                        if (reservedSlots.get(i).getLocation() == null) {%>
                        N/A
                        <%
                        } else {%>
                       <%= reservedSlots.get(i).getLocation()%>
                        <%

                                }

                        %>
                    </td>
                    <td class="text-center"><%=appointments.get(i).getStudentId()%>
                    </td>
                    <td class="text-center">
                        <button class="btn btn-danger"
                                onclick="cancelReservation('<%=appointments.get(i).getAppointmentId()%>','staff')">
                            Cancel
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
        <div class="card-footer text-muted">
            <button class="btn btn-danger d-flex float-end" data-toggle="modal" data-target="#exampleModal1">Cancel
                appointments of a day
            </button>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"
     onfocus="test()">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add office hour</h5>
                <button type="button" class="close btn" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <div class="modal-body">
                <div id="form-msg"></div>
                <form action="#" method="POST" id="add-office-hour" class="mt-2">
                    <div class="input-group d-flex flex-column mb-3">
                        <label for="date" class="mb-2 fw-bold"><span class="text-danger">*</span>Date:</label>
                        <div>
                            <input class="form-control" type="date" id="date"
                                   name="date" min="2021-01-11">
                        </div>

                    </div>
                    <div class="input-group d-flex flex-column mb-3">
                        <label for="from" class="mb-2 fw-bold"><span class="text-danger">*</span>From:</label>
                        <div>
                            <input class="form-control" type="time" id="from"
                                   name="from">
                        </div>

                    </div>
                    <div class="input-group d-flex flex-column mb-5">
                        <label for="to" class="mb-2 fw-bold"><span class="text-danger">*</span>To:</label>
                        <div>
                            <input class="form-control" type="time" id="to"
                                   name="to">
                        </div>

                    </div>
                    <div class="input-group mb-4">
                        <label class="input-group-text" for="offline"><span class="text-danger">*</span>Offline?</label>
                        <select class="form-select" id="offline" name="login_type">
                            <option value="1">Yes</option>
                            <option value="0">No</option>
                        </select>
                    </div>
                    <div class="input-group d-flex flex-column">
                        <label for="location" class="mb-2 fw-bold">Location:</label>
                        <div>
                            <input class="form-control" type="text" id="location"
                                   name="to">
                        </div>

                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-success" onclick="addOfficeHour()"
                        style="height: 38px;width: 55px" id="add-btn">
                    <div class="spinner-border text-light spinner-border-sm visually-hidden" role="status"
                         id="spinner2">
                        <span class="visually-hidden">Loading...</span>
                    </div>
                    <div id="btn-text">
                        Add
                    </div>
                </button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">Cancel
                    appointments of a day</h5>
                <button type="button" class="close btn" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <div class="modal-body">
                <div id="form-msg2"></div>
                <form action="#" method="POST" id="cancel-appointment" class="mt-2">
                    <div class="input-group d-flex flex-column mb-3">
                        <label for="appointment-date" class="mb-2 fw-bold"><span class="text-danger">*</span>Date of the
                            day:</label>
                        <div>
                            <input class="form-control" type="date" id="appointment-date"
                                   name="date">
                        </div>

                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" onclick="cancelAppointmentsOfDay()"
                        style="width: 200px;height: 38px" id="cancel-btn">
                    <div class="spinner-border text-light spinner-border-sm visually-hidden" role="status"
                         id="spinner3">
                        <span class="visually-hidden">Loading...</span>
                    </div>
                    <div id="btn-text2">
                        Cancel appointments
                    </div>
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
