let month = document.getElementById("month");
let text = "";

function show() {
    switch (month.value*1) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            text += "thang " + month.value + " co 31 ngay";
            break;

        case 2:
            text += "thang " + month.value + "  co 28 hoac 29 ngay";
            break;
        case 4:
        case 6:
        case 8:
        case 11:
            text += "thang " + month.value + "  co 30 ngay";
            break;
    }
    alert(text)  ;
}