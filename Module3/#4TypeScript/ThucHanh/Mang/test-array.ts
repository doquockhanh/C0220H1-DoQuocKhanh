let a: number[] = [];
function createArray() {
    for (let i = 0; i < 2; i++) {
        a.push(Math.random()*100);
    }
    a.push(Number("a"));
}

function main() {
    createArray();
    for (let i = 0; i < a.length; i++) {
        console.log(a[i]);
    }
    let b = [...a];
    console.log(b.toString());
    let c = [...a,...b];
    console.log(c.toString());
}

main();