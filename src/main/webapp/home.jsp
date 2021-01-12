<%@ page import="java.util.List" %>
<%@ page import="com.*" %><%--
  Created by IntelliJ IDEA.
  User: seifa
  Date: 1/3/2021
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

    <%@include file="layout/includes.html" %>
</head>
<body>
<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    } else {
        String loginType = request.getSession().getAttribute("loginType").toString();
        if (loginType.equals("student")) {
            List<CourseEntity> courses = CourseCrud.selectAllCourses();
%>
<%@include file="layout/navbar.jsp" %>
<%--TODO:replace all row click with dedicated buttons--%>
<div class="p-5" style="margin-top: 100px">
    <div class="card mb-5">
        <div class="card-header fw-bold">
            Subjects
        </div>
        <div class="card-body">
            <table id="example" class="cell-border hover" style="width:100%">
                <thead>
                <tr>
                    <th class="text-center">Name</th>
                    <th class="text-center">Staff members</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (CourseEntity course : courses) {
                %>
                <tr>
                    <td class="text-center"><%=course.getCourseName()%>
                    </td>
                    <td class="text-center">
                        <button onclick="showStaffMembers('<%=course.getCourseName()%>')" class="btn btn-primary">Show
                            staff members
                        </button>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card mb-5">
        <div class="card-header fw-bold" id="card-header">
            Staff members teaching
        </div>
        <div class="card-body">
            <table id="example1" class="cell-border hover" style="width:100%">
                <thead>
                <tr>
                    <th class="text-center">ID</th>
                    <th class="text-center">Name</th>
                    <th class="text-center">Email</th>
                    <th class="text-center">Phone number</th>
                    <th class="text-center">Role</th>
                </tr>
                </thead>
                <tbody id="t-body">

                </tbody>
            </table>
        </div>
    </div>
    <%
    } else {
    %>
    <%@include file="layout/navbar.jsp" %>
    <div class="p-5" style="margin-top: 100px">
        <div class="card mb-5">
            <div class="card-header fw-bold">
                Students
            </div>
            <div class="card-body">
                <table id="example2" class="cell-border hover" style="width:100%">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Number</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<StudentEntity> students = StudentCrud.selectAllStudents();
                        int counter = 0;
                        for (StudentEntity student : students) {
                    %>
                    <tr onclick="$('#'+<%=counter%>).submit()">
                        <td>
                            <form action="staffDetails.jsp" id="<%=counter%>" class="visually-hidden">
                                <input type="text" value="<%=student.getStudentId()%>" name="id">
                            </form>
                            <%=student.getStudentId()%>
                        </td>
                        <td><%=student.getStudentName()%>
                        </td>
                        <td><%=student.getStudentEmail()%>
                        </td>
                        <td><%=student.getStudentNumber()%>
                        </td>
                    </tr>
                    <%
                            counter++;
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%
            }
        }
    %>
</div>
</body>
</html>
