function validateLogin(id, password, login_type) {
    var xhttp = new XMLHttpRequest()
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $("#login-btn").prop('disabled', false)
            $("#spinner").addClass("visually-hidden")
            if (xhttp.responseText == "success") {
                window.location.href = 'home.jsp'
            } else {
                $('#validation_error').html(xhttp.responseText.toUpperCase())
            }
        }
    }
    xhttp.open("POST", "Login", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("id=" + id + "&password=" + password + "&login_type=" + login_type);
}

function validateRegister(userName, userID, email, phoneNumber, registerType, captchaToken) {
    $('#registrationErrors').empty()
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $("#register-btn").prop('disabled', false);
            $("#spinner").addClass("visually-hidden")
            if (xhttp.responseText == 'success') {
                $('#register-form').find('input,textarea').val('')
                window.location.href = 'index.jsp'
            } else {
                $('#registrationErrors').append('<li class="text-danger">' + xhttp.responseText.toUpperCase() + '</li>')
            }
        }
    }
    xhttp.open("POST", "Register", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("userName=" + userName + "&userID=" + userID + "&email=" + email + "&phoneNumber=" + phoneNumber + "&registerType=" + registerType + "&captchaToken=" + captchaToken);
}

function validateUpdateProfile(userName, email, password, phoneNumber) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $("#update-btn").prop('disabled', false)
            $("#spinner").addClass("visually-hidden")
            if (xhttp.responseText == "success") {
                window.location.href = 'profile.jsp'
            } else {
                $('#updateProfileErrors').html(xhttp.responseText.toUpperCase())
            }
        }
    }

    xhttp.open("POST", "UpdateProfile", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("userName=" + userName + "&password=" + password + "&email=" + email + "&phoneNumber=" + phoneNumber);
}

function loadLoginData() {
    $("#login-form").submit(function (e) {
        e.preventDefault()
    })
    var id = $('#exampleInputID').val()
    var password = $('#exampleInputPassword1').val()
    var loginType = $('#inputGroupSelect01').val()
    if (id != "" && password != "" && loginType != "") {
        if (id.length > 8 || id.length < 8) {
            $('#validation_error').html('User ID must be exactly 8 digits!')
        } else {
            $("#login-btn").prop('disabled', true)
            $("#spinner").removeClass("visually-hidden")
            validateLogin(id, password, loginType)
        }
    } else {
        $('#validation_error').html('Data fields cannot be empty!')
    }

}

function showRegistrationType() {
    var ssnText = $('#exampleInputSSN').val()
    if (ssnText.length >= 3) {
        var ssn = parseInt(ssnText.substr(0, 3))
        if (ssn <= 285 && ssn >= 250) {
            $('#register-type').attr('class', 'input-group mb-5')
            $('#inputGroupSelect02').prop('disabled', false)
        } else {
            $('#register-type').attr('class', 'input-group mb-5 visually-hidden')
            $('#inputGroupSelect02').prop('disabled', true)
        }

    } else {
        $('#register-type').attr('class', 'input-group mb-5 visually-hidden')
        $('#inputGroupSelect02').prop('disabled', true)
    }
}

function loadRegisterData() {

    $('#registrationErrors').empty()
    $('#register-form').submit(
        function (e) {
            e.preventDefault()
        }
    )
    // grecaptcha.ready(function () {
    //     grecaptcha.execute('6LcIIR0aAAAAAA7Ebm5naPBBBBJh5DwBxBHN8dda', {action: 'register'}).then(function (token) {
    //         // console.log(token)
    //         $('#recaptchaResponse').val(token);
    //
    //
    //     });
    // });
    var userName = $('#exampleInputUserName').val()
    var userID = $('#exampleInputUserID').val()
    var email = $('#exampleInputEmail1').val()
    var phoneNumber = $('#exampleInputPhoneNumber').val()
    var ssn = $('#exampleInputSSN').val()
    var registerType = $('#inputGroupSelect02').is(':disabled') == false ? $('#inputGroupSelect02').val() : null
    var captchaToken = grecaptcha.getResponse()
    if (captchaToken != "") {
        if (userName != "" && userID != "" && email != "" && phoneNumber != "" && ssn != "" && captchaToken != "") {
            var error_msg = []
            if (userID.length > 8 || userID.length < 8) {
                error_msg.push("User ID must be exactly 8 digits!")
            }
            if (phoneNumber.length > 11 || phoneNumber.length < 11) {
                error_msg.push("Phone number must be exactly 11 digits!")
            }
            if (ssn.length > 14 || ssn.length < 14) {
                error_msg.push("SSN must be exactly 14 digits!")
            }
            if (error_msg.length == 0) {
                $("#register-btn").prop('disabled', true)
                $("#spinner").removeClass("visually-hidden")
                validateRegister(userName, userID, email, phoneNumber, registerType, captchaToken)
            } else {
                for (var i = 0; i < error_msg.length; i++) {
                    $('#registrationErrors').append('<li class="text-danger">' + error_msg[i] + '</li>')
                }
            }

        } else {
            $('#registrationErrors').append('<li class="text-danger">Data fields cannot be empty!</li>')
        }
    } else {
        $('.g-recaptcha').addClass('border border-danger')
        $('#registrationErrors').append('<li class="text-danger">Please verify that you are not a robot!</li>')
    }
}

function loadProfileData() {
    $('#updateProfileErrors').empty()
    $('#profileDataForm').submit(function (e) {
        e.preventDefault();
    })
    var userName = $('#exampleInputName').val()
    var email = $('#exampleInputEmail').val()
    var phoneNumber = $('#exampleInputPhoneNumber').val()
    var password = $('#exampleInputPassword').val()

    if (userName != "" && email != "" && phoneNumber != "" && password != "") {
        if (phoneNumber.length != 11) {
            $('#updateProfileErrors').append('<li class="text-danger">Phone number must be exactly 11 digits!</li>')
        }
        $("#update-btn").prop('disabled', true)
        $("#spinner").removeClass("visually-hidden")
        validateUpdateProfile(userName, email, password, phoneNumber)

    } else {
        $('#updateProfileErrors').append('<li class="text-danger">Data fields cannot be empty!</li>')
    }
}

function logout() {
    $('#logout-btn').prop('disabled', 'true')
    $('#spinner1').removeClass('visually-hidden')
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (xhttp.responseText == 'success') {
                window.location.href = 'index.jsp'
            }
        }
    }
    xhttp.open("GET", "Logout", true);
    xhttp.send();
}

$(document).ready(function () {
    $('#example').DataTable({
        "scrollY": "200px",
    });
    $('#example1').DataTable({
        "scrollY": "200px",
    });
    $('#example2').DataTable({
        "scrollY": "200px",
    });
});

function test(value) {
    $('#card-header').html('Staff members teaching'+ value)
    var xhttp = new XMLHttpRequest()
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var json = JSON.parse(xhttp.responseText)
            // $('#staff-table-body').append('<tr><td>' + json.staffName + '</td><td>' + json.staffEmail + '</td><td>' + json.staffNumber + '</td><td>' + json.staffRole + '</td></tr>')
            var table = $('#example1').DataTable()
            table.row.add([
                json.staffName,
                json.staffEmail,
                json.staffNumber,
                json.staffRole
            ]).draw(true)
            $('#example1 tbody').on('click', 'tr', function () {
                var data = table.row(this).data()
                var form = document.createElement('form')
                form.action = 'staffDetails.jsp'
                form.method = 'POST'
                var input = document.createElement('input')
                input.value = json.staffId
                input.name = 'id'
                form.appendChild(input)
                document.body.appendChild(form)
                form.submit()
            })

        }
    }
    xhttp.open("POST", "Test", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("courseName=" + value);
}