let banCo = [];
let nuoc = "X";
let check = "";
for (let i = 0; i < 8; i++) {
    banCo[i] = [];
    for (let j = 0; j < 8; j++) {
        banCo[i][j] = " ";
    }
}

veBanCo();

function veBanCo() {
    for (let i = 0; i < 8; i++) {
        for (let j = 0; j < 8; j++) {
            let btn = document.createElement("BUTTON");   // Create a <button> element
            btn.innerText = banCo[i][j];
            btn.style.width = "30px";
            btn.style.height = "30px";

            btn.onclick = function () {
                if (btn.value === "") {
                    banCo[i][j] = nuoc;
                    console.log(i + " " + j);
                    btn.innerText = nuoc;
                    // ketqua();
                    if (nuoc === "X") {
                        nuoc = "O";
                        btn.value = "O";
                        document.getElementById("luotdi").innerHTML = "Lượt đi : O";
                        checkDoc(i, j)
                    } else {
                        nuoc = "X";
                        btn.value = "X";
                        document.getElementById("luotdi").innerHTML = "Lượt đi : X"
                        checkDoc(i, j)
                    }
                }
            };
            document.body.appendChild(btn);               // Append <button> to <body>

        }
        let label = document.createElement("label");
        label.innerText = "\n";
        document.body.appendChild(label);
    }
}

function checkDoc(a, b) {
    let flag = "";
    for (b = 0; b < 8; b++) {
        for (a = 0; a < 8; a++) {
            check += banCo[a][b];
//             console.log(banCo[i][j]);
            if (check.lastIndexOf("00000") !== -1) {
                alert("O win");
            }
            if (check.lastIndexOf("XXXXX") !== -1) {
                alert("X win");
            }
        }
    }
}



