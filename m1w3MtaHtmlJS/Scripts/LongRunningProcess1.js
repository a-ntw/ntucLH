/* 200922 Web worker A */
var ctr = 0;

function incrementCtr() {
    ctr = ctr + 1;
    postMessage(ctr);
    setTimeout("incrementCtr()", 1000);
}

incrementCtr();
