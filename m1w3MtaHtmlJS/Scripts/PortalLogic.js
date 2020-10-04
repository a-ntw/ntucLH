"use strict"    /* can not use undeclared variables. */

/* Employee No. random generate */
function generateEmpNo() {
    var vaempId = 0;
    var vaempNoPrefix = "";
    var vaempType = document.getElementById("EmpTypeInput").value;
    switch (vaempType) {
        case "Regular":
            vaempNoPrefix = "R";
            break;
        case "Temporary":
            vaempNoPrefix = "T";
            break;
        default:
            vaempNoPrefix = "C";
    }
    vaempId = vaempNoPrefix + Math.round(Math.random() * 100 + 1000); //concatenation
    document.getElementById("EmpNoInput").value = vaempId;
}

/* validate form from registration.html */
function validateForm() {
    var pinInput = $("#EmpPinInput").val();
    var confPinInput = $("#ConfirmPinInput").val();
    if (pinInput != confPinInput) {
        //var confPinError = document.getElementById("empCPinInput");
        // confPinError.setCustomValidity("PIN inputs don't match...");
        document.getElementById("ConfirmPinInput").style.color = "red";
        alert("PIN inputs don't match...");
        return false;
    }
    return true;
}

/* OffLine, @index,html <body onoffline="hideWhenOffline();"> */
function hideWhenOffline() {
    document.getElementById("multimedia").style.display = "none";
}
