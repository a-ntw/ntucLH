/* Employee No generate, for Registration.html */
var Employee = function () { };
Employee.prototype.empNo = 0;

/* Counttry detect, for Registration.html */
Employee.prototype.detectCountry = function () {
    $.ajax({
        url: "https://ipapi.co/json"
    }).then(function (data) {
        $("#EmpCountryInput").val(data.country_name);
        $("#empRegion").val(data.region);
        //$("#empTimeZone").val(data.timezone);

        $("#empIp").val(data.ip);
        $("#empVersion").val(data.version);
        $("#empCity").val(data.city);
        $("#empCountry_name").val(data.country_name);
    });
}

/* create NEW object  */
var NTUCEmployee = function () { };
NTUCEmployee.prototype = Object.create(Employee.prototype); //inheritance
var NTUCLhubEmployee = new NTUCEmployee(); //instantiation
