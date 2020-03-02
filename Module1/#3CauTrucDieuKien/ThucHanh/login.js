function show(){
    let nameAccount = document.getElementById("nameAccount");
    let passWord = "TheMaster";
    let inputPassWord;
    if (nameAccount.value == "Admin") {
        inputPassWord = prompt("Nhap mat khau !");
        if (passWord = inputPassWord) {
            alert("Welcom!")
        } else if (inputPassWord == "") {
            alert("Cancerled!")
        } else {
            alert("Wrong password!")
        }
    } else if (nameAccount.value == "") {
        alert("Cancerled")
    } else {
        alert("I don't know you!")
    }

}