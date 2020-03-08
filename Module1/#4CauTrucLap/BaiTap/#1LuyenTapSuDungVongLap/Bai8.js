function show(){
     let min =  prompt("hãy nhập khoảng muốn đoán : từ");
     let max = prompt("đến");
     min = Math.ceil(min);
     max = Math.floor(max);
     return Math.floor(Math.random() * (max - min + 1)) + min;
}