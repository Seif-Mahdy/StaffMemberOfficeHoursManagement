<%@ page import="java.util.List" %>
<%@ page import="com.*" %><%--
<%--
  Created by IntelliJ IDEA.
  User: seif
  Date: 1/12/21
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String url = request.getRequestURL().toString();
%>

<nav class="navbar navbar-expand navbar-light bg-light fixed-top shadow rounded">
    <div class="container-fluid d-flex align-items-center">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%
                    if (loginType.equals("student")) {
                        if (url.contains("home.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="home.jsp">Home</a>
                </li>
                <%
                    }
                    if (url.contains("profile.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="profile.jsp">Profile</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="profile.jsp">Profile</a>
                </li>
                <%
                    }
                    if (url.contains("appointments.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="appointments.jsp">My appointments</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="appointments.jsp">My appointments</a>
                </li>
                <%
                    }
                    if (url.contains("inbox.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="inbox.jsp">My inbox</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="inbox.jsp">My inbox</a>
                </li>
                <%
                    }
                    if (url.contains("notifications.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="notifications.jsp">Notifications center</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="notifications.jsp">Notifications center</a>
                </li>
                <%
                    }
                } else {
                    if (url.contains("home.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="home.jsp">Home</a>
                </li>
                <%
                    }
                    if (url.contains("profile.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="profile.jsp">Profile</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="profile.jsp">Profile</a>
                </li>
                <%
                    }
                    if (url.contains("appointments.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="staffAppointments.jsp">My appointments</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="staffAppointments.jsp">My appointments</a>
                </li>
                <%
                    }
                    if (url.contains("inbox.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="inbox.jsp">My inbox</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="inbox.jsp">My inbox</a>
                </li>
                <%
                    }
                    if (url.contains("notifications.jsp")) {
                %>
                <li class="nav-item rounded" style="background-color: lightgray">
                    <a class="nav-link active" aria-current="page" href="notifications.jsp">Notifications center</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item rounded">
                    <a class="nav-link" aria-current="page" href="notifications.jsp">Notifications center</a>
                </li>
                <%
                        }
                    }
                %>
            </ul>
            <div>
                <div class=" spinner-border text-primary spinner-border-sm invisible" role="status"
                     id="spinner1">
                    <span class="invisible">Loading...</span>
                </div>
                <button class="btn text-dark ms-4" onclick="logout()" id="logout-btn"
                        style="background-color:lightgray">Logout
                </button>
            </div>
        </div>
    </div>
</nav>