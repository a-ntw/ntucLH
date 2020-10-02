/* display animated bar at top of Registration  */
function displayProgress(progress) {
    var c = document.getElementById("inputProgressBar");
    var ctx = c.getContext("2d");
    // Create gradient
    var grd = ctx.createLinearGradient(0, 0, progress, 0);
    grd.addColorStop(0, "red");
    grd.addColorStop(1, "white");
    // Fill with gradient
    ctx.fillStyle = grd;
    ctx.fillRect(10, 10, 1000, 80);
}