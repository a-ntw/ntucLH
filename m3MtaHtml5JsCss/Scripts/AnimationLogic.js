/* animate Email click at index.html, script at bottom */
var inquiryElement = document.getElementById("emailSupport");
inquiryElement.addEventListener("animationend", onAnimationend, true);

function sendMail() {
    inquiryElement.className = "clickEmail";
}


function onAnimationend(e) {
    inquiryElement.className = " ";
}