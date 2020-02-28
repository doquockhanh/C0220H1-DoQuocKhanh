let firstNum = document.getElementById("firstNum");
let secondNum = document.getElementById("secondNum");
let total;
let result = document.getElementById("result")

function add() {
    total = firstNum.value * 1 + secondNum.value * 1;
    result.innerText = total;
}

function sub() {
    total = firstNum.value - secondNum.value;
    result.innerText = total;
}

function mul() {
    total = firstNum.value * secondNum.value;
    result.innerText = total;
}

function div() {
    total = firstNum.value / secondNum.value;
    result.innerText = total;
}