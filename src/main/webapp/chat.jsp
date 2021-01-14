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
    //TODO:Determine which is the sender and which is the receiver , the chat page is the same for both
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    } else {
        String loginType = request.getSession().getAttribute("loginType").toString();
        System.out.println(request.getParameter("senderId"));
%>
<%@include file="layout/navbar.jsp" %>
<%                    Map<Key, List<MessageEntity>> myInbox =RegisterationMail.retrieveMessages(request.getSession().getAttribute("id").toString());
List<MessageEntity>chat=myInbox.get(new Key(request.getParameter("senderId"),request.getParameter("receiverId")));
%>
<div class="px-5" style="margin-top: 100px">
    <ul class="list-group">
        <%
        for(int i=0;i<chat.size();i++)
        {



        %>
        <li class="list-group-item mb-4">
            <div class="d-flex justify-content-between mb-2">
                <div class="font-weight-bold h5"><%=chat.get(i).getSubject()%></div>
            </div>
            <div class="font-weight-lighter h6"><%=chat.get(i).getMessageContent()%>
            </div>
            <div class="font-weight-lighter text-muted float-right"><%=chat.get(i).getMessageDate()%></div>
        </li>

<% }

%>

    </ul>
</div>
<%
    }
%>
</body>
</html>
