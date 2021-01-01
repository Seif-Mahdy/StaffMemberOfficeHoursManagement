<%--
  Created by IntelliJ IDEA.
  User: seifa
  Date: 12/30/2020
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <%--    <script src="https://www.google.com/recaptcha/api.js"></script>--%>
    <script src="https://www.google.com/recaptcha/api.js?render=6LfJ5xsaAAAAAJb6TdCdY5PQiY_Zh3CSKkuWHHfq"></script>
    <script src="scripts.js"></script>
</head>
<body style="width: 100%;height: 100%;position: fixed">

<div class="container-fluid d-flex justify-content-center align-items-center"
     style="height: 100%;background-color:gainsboro">
    <div class="w-50 shadow p-5 bg-light rounded">
        <form action="#" method="POST" id="register-form">
            <ul id="registrationErrors">

            </ul>
<%--            <p class="text-danger" id="registration-errors"></p>--%>
            <div class="mb-3">
                <label for="exampleInputUserName" class="form-label">User name</label>
                <input type="text" class="form-control" id="exampleInputUserName" name="UserName" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputUserID" class="form-label">User ID</label>
                <input type="text" class="form-control" id="exampleInputUserID" name="UserID" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" name="email" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputPhoneNumber" class="form-label">Phone number</label>
                <input type="text" class="form-control" id="exampleInputPhoneNumber" name="phoneNumber" required>
            </div>
            <div class="mb-5">
                <label for="exampleInputSSN" class="form-label">SSN</label>
                <input type="text" class="form-control" id="exampleInputSSN" name="ssn" oninput="showRegistrationType()" required>
            </div>
            <div class="input-group mb-5 visually-hidden" id="register-type">
                <label class="input-group-text" for="inputGroupSelect02">Register as</label>
                <select class="form-select" id="inputGroupSelect02" name="register_type" disabled>
                    <option value="Doctor">Doctor</option>
                    <option value="TA">TA</option>
                </select>
            </div>
            <input type="hidden" id="g-recaptcha-response" name="g-recaptcha-response">
            <input type="hidden" name="action" value="validate_captcha">
            <div class="d-flex justify-content-between align-items-center">
                <button type="submit" class="btn btn-primary" onclick="loadRegisterData()">Register</button>
                <a href="index.jsp">Already a user?</a>
            </div>

        </form>
    </div>
</div>
</body>
</html>
