<%--
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
    <script>
        $(document).ready(function () {

            $('.toast').toast('show')
        })
    </script>
</head>
<body>
<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    } else {
        String loginType = request.getSession().getAttribute("loginType").toString();
%>
<%@include file="layout/navbar.jsp" %>
<div class="px-5" style="margin-top: 100px">
    <div class="alert alert-primary mb-3 d-flex flex-row align-items-center justify-content-between" role="alert">
        <div>
            A simple secondary alert—check it out!
        </div>
        <div style="cursor: pointer">X</div>
    </div>
    <div class="alert alert-primary mb-3 d-flex flex-row align-items-center justify-content-between" role="alert">
        <div>
            A simple secondary alert—check it out!
        </div>
        <div style="cursor: pointer">X</div>
    </div>
    <div class="alert alert-primary mb-3 d-flex flex-row align-items-center justify-content-between" role="alert">
        <div>
            A simple secondary alert—check it out!
        </div>
        <div style="cursor: pointer">X</div>
    </div>
</div>
<%
    }
%>
</body>
</html>
