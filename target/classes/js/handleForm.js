var msgReceivec = [[${msg}]];
var errReceivec = [[${error}]];
function getVariable(){
    if (msgReceivec == null) {
        document.getElementById("demo").innerHTML = "";
    }else{
        document.getElementById("demo").innerHTML = msgReceivec;
    }
}

function getStudent(){
    if (errReceivec == null) {
        document.getElementById("demo").innerHTML = "";
    }else{
        document.getElementById("demo").innerHTML = errReceivec;
    }
}
