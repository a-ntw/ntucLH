/* 200922 Web worker 2 */
var ctr = 1000;

function decrementCtr() {
    ctr = ctr - 1;
    postMessage(ctr);
    setTimeout("decrementCtr()", 1000);
}

decrementCtr();
