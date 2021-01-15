<%@ page import="java.util.Map" %><%--
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
<%
    Map<Key, List<MessageEntity>> myInbox = RegisterationMail.retrieveMessages(request.getSession().getAttribute("id").toString());
    List<MessageEntity> chat = myInbox.get(new Key(request.getParameter("senderId"), request.getParameter("receiverId")));
%>
<div class="px-5" style="margin-top: 100px">
    <div class="container-fluid list-group">
        <%
            for (MessageEntity messageEntity : chat) {
                if (messageEntity.getSenderId().equals(request.getParameter("senderId"))) {
        %>
        <div class="row">
            <div class="col-6"></div>
            <div class="list-group-item mb-4 border-top rounded col-6" style="background-color: rgba(0,255,81,0.27)">
                <div class="font-weight-bold h5"><%=messageEntity.getSubject()%>
                </div>
                <div class="font-weight-lighter h6"><%=messageEntity.getMessageContent()%>
                </div>
                <div class="font-weight-lighter text-muted text-right"><%=messageEntity.getMessageDate()%>
                </div>
            </div>
        </div>
        <% } else {
        %>
        <div class="row">
            <div class="list-group-item mb-4 border-top rounded col-6">
                <div class="font-weight-bold h5"><%=messageEntity.getSubject()%>
                </div>
                <div class="font-weight-lighter h6"><%=messageEntity.getMessageContent()%>
                </div>
                <div class="font-weight-lighter text-muted text-right"><%=messageEntity.getMessageDate()%>
                </div>
            </div>
            <div class="col-6"></div>
        </div>
        <%
                }
            }
        %>
    </div>
</div>
<%
    }
%>
</body>
</html>
