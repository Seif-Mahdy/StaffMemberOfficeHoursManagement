<%--
  Created by IntelliJ IDEA.
  User: seif
  Date: 1/12/21
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inbox</title>
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
    <div class="card">
        <div class="card-header">
            Compose message
        </div>
        <div class="card-body">
           <form>

           </form>
        </div>
    </div>
</div>
<%
    }
%>
</body>
</html>
