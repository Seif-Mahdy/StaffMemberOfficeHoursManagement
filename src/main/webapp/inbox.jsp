<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %><%--
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
<div class="px-5" style="margin-top: 100px">
    <div class="card mb-5">
        <div class="card-header font-weight-bold">
            Compose message
        </div>
        <div class="card-body">
            <div class="text-danger mb-2" id="send-message-errors"></div>
            <form id="send-message-form">
                <div class="form-group mb-3">
                    <label class="mb-1" for="toEmail">To</label>
                    <input type="email" class="form-control" id="toEmail"
                           required name="toEmail">
                </div>
                <div class="form-group mb-3">
                    <label class="mb-1" for="subject">Subject</label>
                    <input type="text" class="form-control" id="subject"
                           required name="subject">
                </div>
                <div class="form-group">
                    <label class="mb-1" for="message">Message body</label>
                    <textarea class="form-control" id="message" rows="5"></textarea>
                </div>
            </form>
        </div>
        <div class="card-footer text-muted">
            <div class="d-flex flex-row float-right align-items-center">
                <div class="spinner-border text-primary spinner-border-sm invisible" role="status"
                     id="spinner">
                </div>
                <div>
                    <button type="submit" class="btn btn-success ml-4"
                            id="send-btn" onclick="sendMessage()">
                        <img src="images/check.svg" width="30" height="30" class="d-none" id="img">
                        <div id="btn-text">Send</div>
                    </button>
                </div>
            </div>
        </div>
    </div>


    <div class="card">
        <div class="card-header font-weight-bold">
            Conversations
        </div>
        <div class="card-body">
            <ul class="list-group">
                <%
                    Key key = null;
                    List<MessageEntity> chat = new ArrayList<>();
                    String receiverName = "";
                    String[] initials;
                    String ini = "";
                    Map<Key, List<MessageEntity>> myInbox = RegisterationMail.retrieveMessages(request.getSession().getAttribute("id").toString());

                    for (Map.Entry<Key, List<MessageEntity>> entry : myInbox.entrySet()) {
                        key = entry.getKey();

                        chat = entry.getValue();
                        List<StudentEntity> tempStudent = StudentCrud.findStudentByAtt("studentId", key.getReceiver());
                        List<StaffmemberEntity> tempStuff = StaffMemberCrud.findStaffByAtt("staffId", key.getReceiver());

                        if (tempStudent.size() > 0) {
                            receiverName = tempStudent.get(0).getStudentName();
                            initials = receiverName.split(" ");
                            if (initials.length > 1) {
                                ini = initials[0].charAt(0) + String.valueOf(initials[1].charAt(0));
                                ini = ini.toUpperCase();
                            } else {
                                ini = String.valueOf(initials[0].charAt(0) + initials[0].charAt(1));
                            }
                        } else if (tempStuff.size() > 0) {
                            receiverName = tempStuff.get(0).getStaffName();
                            initials = receiverName.split(" ");
                            if (initials.length > 1) {
                                ini = initials[0].charAt(0) + String.valueOf(initials[1].charAt(0));
                                ini = ini.toUpperCase();
                            } else {
                                ini = String.valueOf(initials[0].charAt(0) + initials[0].charAt(1));
                            }
                        }
                %>
                <li onclick="showChat(<%=key.getReceiver()%>,<%=key.getSender()%>)"
                    class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
                    <div class="d-flex flex-row align-items-center">
                        <div class="avatar-circle mr-3">
                            <span class=" initials"><%=ini%></span>
                        </div>
                        <%=receiverName%>
                    </div>
                    <span class="badge badge-primary badge-pill"><%=chat.size()%></span>
                        <% } %>
            </ul>

        </div>
    </div>
</div>
<%
    }
%>
</body>
</html>
