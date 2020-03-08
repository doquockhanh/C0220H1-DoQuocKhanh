let x = 0;
let array = Array();

function add_element_to_array() {
    array[x] = document.getElementById("txtValue").value;
    alert("Element: " + array[x] + " Added at index " + array);
    x++;
    // document.getElementById("txtValue ").value = "";
}

function display_array() {
    let last = array.length - 1;
    let first = 0;
    while (first < last) {
        let b = array[first];
        array[first] = array[last];
        array[last] = b;
        first++;
        last--;
    }
    document.getElementById("result").innerHTML = array;
}