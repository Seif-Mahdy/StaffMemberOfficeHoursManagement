<%@ page import="org.joda.time.DateTime" %>
<%@ page import="java.util.*" %>
<%@ page import="org.joda.time.LocalDate" %>
<%@ page import="java.sql.Timestamp" %><%--
  Created by IntelliJ IDEA.
  User: seif
  Date: 1/13/21
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<%
    List<AppointmentEntity> appointments=new ArrayList<>();
    NotificationEntity notification=new NotificationEntity();
    StudentEntity student=new StudentEntity();
    StaffmemberEntity staff=new StaffmemberEntity();

    if(loginType.equals("staff")) {
        staff=StaffMemberCrud.findStaffMember(request.getSession().getAttribute("id").toString()) ;
        appointments = AppointmentCrud.selectAllAppointment("staffId",request.getSession().getAttribute("id").toString());
        for(int i=0;i<appointments.size();i++)
        {
            OfficehourEntity slot = OfficeHourCrud.findOfficeHour(appointments.get(i).getOfficeHourId());
            DateTime meetingDate=new DateTime(slot.getFromDate());
            DateTime currentDate=new DateTime(new Date());
            LocalDate meeting_date = meetingDate.toLocalDate();
            LocalDate current_date = currentDate.toLocalDate();
            byte isNotified=appointments.get(i).getIsNotified();
            if(meeting_date.compareTo(current_date)==0 && isNotified==0 )
            {
                appointments.get(i).setIsNotified((byte) 1);
                AppointmentCrud.updateAppointment(appointments.get(i));
                student=StudentCrud.findStudent(appointments.get(i).getStudentId());
                String notificationContent="You have a meeting today with "+student.getStudentName()+" At "+ slot.getFromDate()+"";
                notification.setUserId(request.getSession().getAttribute("id").toString());
                notification.setNotificationContent(notificationContent);
                notification.setNotificationSubject("Meeting Alert");
                notification.setNotificationDate(new Timestamp(new Date().getTime()));
                NotificationCrud.addNotification(notification);
                RegisterationMail.sendMail(staff.getStaffEmail(),null,"Meeting Alert",notificationContent );
            }

        }
    }
    else if (loginType.equals("student"))
    {
        appointments = AppointmentCrud.selectAllAppointment("studentId",request.getSession().getAttribute("id").toString());
        student=StudentCrud.findStudent(request.getSession().getAttribute("id").toString());
        for(int i=0;i<appointments.size();i++)
        {
            OfficehourEntity slot = OfficeHourCrud.findOfficeHour(appointments.get(i).getOfficeHourId());
            DateTime meetingDate=new DateTime(slot.getFromDate());
            DateTime currentDate=new DateTime(new Date());
            LocalDate meeting_date = meetingDate.toLocalDate();
            LocalDate current_date = currentDate.toLocalDate();
            byte isNotified=appointments.get(i).getIsNotified();

            if(meeting_date.compareTo(current_date)==0 && isNotified==0 )
            {
                staff=StaffMemberCrud.findStaffMember(appointments.get(i).getStaffId());
                String notificationContent="You have a meeting today with "+staff.getStaffRole()+": "+staff.getStaffName()+" At "+ slot.getFromDate()+"";

                notification.setUserId(request.getSession().getAttribute("id").toString());
                notification.setNotificationContent(notificationContent);
                notification.setNotificationSubject("Meeting Alert");
                notification.setNotificationDate(new Timestamp(new Date().getTime()));

                NotificationCrud.addNotification(notification);

                RegisterationMail.sendMail(student.getStudentEmail(),null,"Meeting Alert",notificationContent);
            }
        }
    }
    Map<String,String> atte = new HashMap<>();
    atte.put("userId",request.getSession().getAttribute("id").toString());
   notifications=NotificationCrud.findNotificationByAtt(atte);
   //Collections.sort(notifications);




%>
<div class="px-5" style="margin-top: 100px">
    <%
    for(int i=0;i<notifications.size();i++)
    {
    %>
    <div class="alert alert-primary mb-3" role="alert">
        <div class="d-flex flex-row align-items-center justify-content-between">
            <div>
               <%=notifications.get(i).getNotificationContent()%>
            </div>
            <div style="cursor: pointer" onclick="removeNotification('<%=notifications.get(i).getNotificationId()%>')">X</div>
        </div>
        <div class="text-right text-muted mt-1"><%=notifications.get(i).getNotificationDate()%></div>
    </div>
    <% } %>


</div>
<%
    }
%>
</body>
</html>
