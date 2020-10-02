/* photo transfer, @ end of Registration.html*/
var dropzone;
dropzone = document.getElementById("dropOff");
dropzone.addEventListener("dragenter", dragenter, false);
dropzone.addEventListener("dragover", dragover, false);
dropzone.addEventListener("drop", drop, false);


//
function dragenter(e) {
    e.stopPropagation();
    e.preventDefault();
}
//

function dragover(e) {
    e.stopPropagation();
    e.preventDefault();
}

//
function drop(e) {
    e.stopPropagation();
    e.preventDefault();
    var preview = document.getElementById('ProfilePhoto');
    preview.style.backgroundColor = "blue";
    var dt = e.dataTransfer;
    var files = dt.files;
    var file = files[0];

    var reader = new FileReader(); //instantiation

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
    }

    reader.onloadend = function () {
        preview.src = reader.result; //actual image in binary format
    }

    reader.onerror = function () {
        alert("Something went wrong contact the admin...");
    }



}