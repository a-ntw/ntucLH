/* Employee No generate, for Registration.html */
var Employee = function () { };
Employee.prototype.empNo = 0;
Employee.prototype.empName = " ";
Employee.prototype.empType = " ";
Employee.prototype.nric = " ";
Employee.prototype.emailAdd = " ";
Employee.prototype.generateEmpNo = function () {
    var vaempNoPrefix = "";
    Employee.prototype.empType = document.getElementById("EmpTypeInput").value;
    switch (Employee.prototype.empType) {
        case "Regular":
            vaempNoPrefix = "R";
            break;
        case "Temporary":
            vaempNoPrefix = "T";
            break;
        default:
            vaempNoPrefix = "C";
    }
    Employee.prototype.empNo = vaempNoPrefix + Math.round(Math.random() * 100 + 1000); //concatenation
    document.getElementById("EmpNoInput").value = Employee.prototype.empNo;
}

/* Counttry detect, for Registration.html */
Employee.prototype.detectCountry = function () {
    $.ajax({
        url: "https://ipapi.co/json"
    }).then(function (data) {
        $("#EmpCountryInput").val(data.country_name);
        //$("#empRegion").val(data.region);
        //$("#empTimeZone").val(data.timezone);
    });
}

/*  SAVE and restore data, for Registration.html */
Employee.prototype.saveToLocalStorage = function () {
    NTUCLhubEmployeeJson.empNo = $("#EmpNoInput").val();
    NTUCLhubEmployeeJson.empName = $("#EmpNameInput").val();
    NTUCLhubEmployeeJson.empType = $("#EmpTypeInput").val();
    NTUCLhubEmployeeJson.nric = $("#EmpNRICInput").val();
    NTUCLhubEmployeeJson.emailAdd = $("#EmpEmailInput").val();
    NTUCLhubEmployeeJson.country = $("#EmpCountryInput").val();

    if (typeof (Storage) !== "undefined") {
        localStorage.setItem("Employee", JSON.stringify(NTUCLhubEmployeeJson));
        alert("Records has been saved...");
    } else {
        alert("Sorry, your browser does not support Web Storage...");
    }
}

Employee.prototype.getFromLocalStorage = function () {
    var savedEmpRec = JSON.parse(localStorage.getItem("Employee"));
    $("#EmpNoInput").val(savedEmpRec.empNo);
    $("#EmpNameInput").val(savedEmpRec.empName);
    $("#EmpTypeInput").val(savedEmpRec.empType);
    $("#EmpNRICInput").val(savedEmpRec.nric);
    $("#EmpEmailInput").val(savedEmpRec.emailAdd);
    $("#EmpCountryInput").val(savedEmpRec.country);
}

/* create NEW object  */
var NTUCEmployee = function () { };
NTUCEmployee.prototype = Object.create(Employee.prototype); //inheritance

var NTUCLhubEmployee = new NTUCEmployee(); //instantiation

NTUCLhubEmployeeJson = {
    empNo: 0,
    empName: " ",
    empType: " ",
    nric: " ",
    emailAdd: " ",
    country: " "
};