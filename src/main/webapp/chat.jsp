<%--
  Created by IntelliJ IDEA.
  User: seif
  Date: 1/13/21
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conversation</title>
    <%@include file="layout/includes.html" %>
</head>
<body>
<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    } else {
        String loginType = request.getSession().getAttribute("loginType").toString();
        System.out.println(request.getParameter("senderId"));
%>
<%@include file="layout/navbar.jsp" %>
<div class="px-5" style="margin-top: 100px">
    <ul class="list-group">
        <li class="list-group-item mb-4">
            <div class="d-flex justify-content-between mb-2">
                <div class="font-weight-bold h5">Subject</div>
            </div>
            <div class="font-weight-lighter h6">this is the message content this is the message contentthis is the
                message contentthis is the message content
            </div>
            <div class="font-weight-lighter text-muted float-right">2020-1-14 14:00</div>
        </li>
        <li class="list-group-item mb-4 border-top rounded">
            <div class="d-flex justify-content-between mb-2">
                <div class="font-weight-bold h5">Subject</div>
            </div>
            <div class="font-weight-lighter h6">this is the message content this is the message contentthis is the
                message contentthis is the message content
            </div>
            <div class="font-weight-lighter text-muted float-right">2020-1-14 14:00</div>
        </li>
        <li class="list-group-item mb-4 border-top rounded">
            <div class="d-flex justify-content-between mb-2">
                <div class="font-weight-bold h5">Subject</div>
            </div>
            <div class="font-weight-lighter h6">this is the message content this is the message contentthis is the
                message contentthis is the message content
            </div>
            <div class="font-weight-lighter text-muted float-right">2020-1-14 14:00</div>
        </li>
        <li class="list-group-item mb-4 border-top rounded">
            <div class="d-flex justify-content-between mb-2">
                <div class="font-weight-bold h5">Subject</div>
            </div>
            <div class="font-weight-lighter h6">this is the message content this is the message contentthis is the
                message contentthis is the message content
            </div>
            <div class="font-weight-lighter text-muted float-right">2020-1-14 14:00</div>
        </li>
    </ul>
</div>
<%
    }
%>
</body>
</html>
