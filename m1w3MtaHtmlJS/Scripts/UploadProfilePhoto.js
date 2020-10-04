/* upload photo via Registration.html */
function uploadProfilePhoto() {
    var preview = document.getElementById('ProfilePhoto');
    var file = document.getElementById("SelectPhoto").files[0];
    var reader = new FileReader(); //instantiation

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
    }

    reader.onloadend = function () {
        preview.src = reader.result;
    }
    reader.onerror = function () {
        alert("Something went wrong upon image upload...");
    }
}