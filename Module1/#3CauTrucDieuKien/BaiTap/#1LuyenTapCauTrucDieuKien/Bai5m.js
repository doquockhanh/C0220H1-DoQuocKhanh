function show() {
    let a = document.getElementById("f1");
    let b = document.getElementById("f2");
    let c = document.getElementById("f3");
    let total = (a.value * 1 + b.value * 2 + c.value * 2) / 5;
    if (total >= 8) {
        alert(" hoc sinh gioi " + total + " d");
    } else if (total >= 6.5) {
        alert(" hoc sinh kha " + total + " d");
    } else if (total >= 5) {
        alert(" hoc sinh trung binh " + total + " d");
    } else if (total >= 3) {
        alert("hoc sinh yeu " + total + " d");
    } else {
        alert( "hoc sinh kem " + total + " d")
    }
}