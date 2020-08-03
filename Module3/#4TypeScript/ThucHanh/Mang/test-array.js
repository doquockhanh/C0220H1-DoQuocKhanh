var __spreadArrays = (this && this.__spreadArrays) || function () {
    for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;
    for (var r = Array(s), k = 0, i = 0; i < il; i++)
        for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
            r[k] = a[j];
    return r;
};
var a = [];
function createArray() {
    for (var i = 0; i < 2; i++) {
        a.push(Math.random() * 100);
    }
    a.push(Number("a"));
}
function main() {
    createArray();
    for (var i = 0; i < a.length; i++) {
        console.log(a[i]);
    }
    var b = __spreadArrays(a);
    console.log(b.toString());
    var c = __spreadArrays(a, b);
    console.log(c.toString());
}
main();
