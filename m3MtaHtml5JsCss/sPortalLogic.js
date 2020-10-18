"use strict"  

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


