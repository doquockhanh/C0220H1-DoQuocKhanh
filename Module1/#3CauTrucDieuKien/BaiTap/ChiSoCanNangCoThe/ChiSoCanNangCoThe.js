
let weight = document.getElementById("weight");
let height = document.getElementById("height");

function show() {
    let bmi = weight.value / (height.value * height.value);
    if (bmi > 30) {
        document.write("Obese " + bmi);
    } else if (bmi > 25) {
        document.write("Over weight " + bmi);
    } else if (bmi > 18.5) {
        document.write("Nomal " + bmi);
    } else {
        document.write("under weight " + bmi);
    }
}
