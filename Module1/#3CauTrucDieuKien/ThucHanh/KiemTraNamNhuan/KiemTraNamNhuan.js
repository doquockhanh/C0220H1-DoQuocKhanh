function show() {
    let inputNam = document.getElementById("inputNam");
    let nam = parseInt(inputNam.value);
    let total = document.getElementById("kq");
    if (nam % 4 == 0) {
        if (nam % 100 == 0 && nam % 400 != 0) {
            alert("nam khong nhuan");
        } else {
            alert("nam nhuan")
        }
    } else {
        alert("nam khong nhuan")
    }
}

