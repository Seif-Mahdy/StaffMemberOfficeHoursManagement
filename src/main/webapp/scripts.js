function validate_login(id, password) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        $('#validation_error').val(xhttp.getResponseHeader("error"))
    }
    xhttp.open("POST", "validate_login.java", true);
    xhttp.send();
}