let number = document.getElementById("number");

function caculator(a){
    number.innerText = number.value + a;

}

function result(){
    number.innerText = eval(number.value)

}

function clr(){
    number.innerText = "";
}