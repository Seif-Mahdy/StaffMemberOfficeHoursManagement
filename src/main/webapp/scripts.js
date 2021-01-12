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
    $('#updateProfileErrors').empty()
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $("#update-btn").prop('disabled', false)
            $("#spinner").addClass("visually-hidden")
            if (xhttp.responseText == "success") {
                console.log('in success')
                window.location.href = 'profile.jsp'
                //$('#updateProfileSuccess').html('Profile updated successfully!')
            } else {
                console.log('in else')
                $('#updateProfileErrors').append('<li class="text-danger">' + xhttp.responseText.toUpperCase() + '</li>')
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
    if ($('#updateProfileSuccess').html() != '') {
        $('#updateProfileSuccess').empty()
    }
    $('#spinner').removeClass('visually-hidden')
    $('#update-btn').prop('disabled', 'true')
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
            $("#update-btn").prop('disabled', false)
            $("#spinner").addClass("visually-hidden")
        } else {
            validateUpdateProfile(userName, email, password, phoneNumber)
        }

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
        "columnDefs": [{
            "className": "text-center",
        }]
    });
    $('#example1').DataTable({
        "scrollY": "200px",
        "columnDefs": [{
            "targets": [0],
            "visible": false,
            "searchable": false,
            "className": "text-center",
        }],
    });
    $('#example2').DataTable({
        "scrollY": "200px",
        "columnDefs": [{
            "className": "text-center",
        }]
    });
});

function showStaffMembers(value) {
    $('#card-header').html('Staff members teaching ' + value)
    $("html, body").animate({scrollTop: $(document).height()}, "fast");
    var xhttp = new XMLHttpRequest()
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var json = JSON.parse(xhttp.responseText)
            var table = $('#example1').DataTable()
            table.clear()
            for (var i = 0; i < json.length; i++) {
                table.row.add([
                    json[i].staffId,
                    json[i].staffName,
                    json[i].staffEmail,
                    json[i].staffNumber,
                    json[i].staffRole
                ]).draw(true)
            }

            $('#example1 tbody').on('click', 'tr', function () {
                var data = table.row(this).data()
                var form = document.createElement('form')
                form.action = 'staffDetails.jsp'
                form.method = 'POST'
                var input = document.createElement('input')
                input.value = data[0]
                input.name = 'id'
                form.appendChild(input)
                document.body.appendChild(form)
                form.submit()
            })

        }
    }
    xhttp.open("POST", "ShowStaffMembers", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("courseName=" + value);
}

function reserveSlot(slotId, studentId, staffId) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            if (xhttp.responseText == 'success') {
                $('#' + slotId).empty()
                $('#' + slotId).append('<img src="images/check.svg" width="30" height="30">')
                $('#example2').removeClass('mt-4')
                $('#msg').addClass('text-success')
                $('#msg').html('Slot reserved successfully!')
            } else {
                $('#example2').removeClass('mt-4')
                $('#msg').addClass('text-danger')
                $('#msg').html('Failed to reserve this slot!')
            }

        }

    }

    xhttp.open("POST", "Reservation", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("slotId=" + slotId + "&studentId=" + studentId + "&staffId=" + staffId);

}

function validate_date() {
    $('#cancel-appointment').submit(function (e) {
        e.preventDefault()
    })
    var date = $('#appointment-date').val()
    var xhttp = new XMLHttpRequest()
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $("#login-btn").prop('disabled', false)
            $("#spinner").addClass("visually-hidden")
            if (xhttp.responseText == "success") {
                //
            } else {
                $('#validation_error').html(xhttp.responseText.toUpperCase())
            }
        }
    }
    // xhttp.open("POST", "Login", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("appointmentDate=" + date);

}

function cancelReservation(appointmentId, loginType) {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            if (xhttp.responseText == "success") {
                if (loginType == 'student') {
                    window.location.href = 'appointments.jsp'
                } else if (loginType == 'staff') {
                    window.location.href = 'staffAppointments.jsp'
                }
            } else {
                $('#msg').addClass('text-danger')
                $('#msg').html('Failed to cancel this appointment!')
            }

        }


    }

    xhttp.open("POST", "CancelReservation", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("appointmentId=" + appointmentId);

}

function addOfficeHour() {

    $('#spinner2').removeClass('visually-hidden')
    $('#add-btn').prop('disabled', true)
    $('#btn-text').addClass('visually-hidden')
    var date = $('#date').val()
    var fromTime = $('#from').val()
    var toTime = $('#to').val()
    var isOffline = $('#offline').val()
    var location = $('#location').val()
    if (location == '') {
        location = null
    }
    if (date != '' && toTime != '' && fromTime != '') {
        if (toTime <= fromTime) {
            $('#form-msg').attr('class', 'text-danger')
            $('#form-msg').html('To time must be after the from time!')
        } else {
            var xhttp = new XMLHttpRequest()
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState == 4 && xhttp.status == 200) {
                    $('#spinner2').addClass('visually-hidden')
                    $('#add-btn').prop('disabled', false)
                    $('#btn-text').removeClass('visually-hidden')
                    if (xhttp.responseText == 'success') {
                        $('#form-msg').attr('class', 'text-success')
                        $('#form-msg').html('Office hour added successfully!')
                    } else {
                        $('#form-msg').attr('class', 'text-danger')
                        $('#form-msg').html('Failed to add this office hour!')
                    }
                }
            }
            xhttp.open("POST", "AddOfficeHour", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("date=" + date + "&fromTime=" + fromTime + "&toTime=" + toTime + "&isOffline=" + isOffline + "&location=" + location);
        }
    } else {
        $('#spinner2').addClass('visually-hidden')
        $('#add-btn').prop('disabled', false)
        $('#btn-text').removeClass('visually-hidden')
        $('#form-msg').attr('class', 'text-danger')
        $('#form-msg').html('Fields cannot be empty!')
    }
}

function cancelAppointmentsOfDay() {
    $('#spinner3').removeClass('visually-hidden')
    $('#cancel-btn').prop('disabled', true)
    $('#btn-text2').addClass('visually-hidden')
    var date = $('#appointment-date').val()
    if (date != '') {
        var xhttp = new XMLHttpRequest()
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                $('#spinner3').addClass('visually-hidden')
                $('#cancel-btn').prop('disabled', false)
                $('#btn-text2').removeClass('visually-hidden')
                if (xhttp.responseText == 'success') {
                    $('#form-msg2').attr('class', 'text-success')
                    $('#form-msg2').html('ِAppointments cancelled successfully!')
                } else {
                    $('#form-msg2').attr('class', 'text-danger')
                    $('#form-msg2').html('No appointments at this day!')
                }
            }
        }
        xhttp.open("POST", "DeleteSlots", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("date=" + date);
    } else {
        $('#spinner3').addClass('visually-hidden')
        $('#cancel-btn').prop('disabled', false)
        $('#btn-text2').removeClass('visually-hidden')
        $('#form-msg2').attr('class', 'text-danger')
        $('#form-msg2').html('Fields cannot be empty!')
    }
}

function test() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0 so need to add 1 to make it 1!
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    today = yyyy + '-' + mm + '-' + dd;
    document.getElementById("date").setAttribute("min", today);
}