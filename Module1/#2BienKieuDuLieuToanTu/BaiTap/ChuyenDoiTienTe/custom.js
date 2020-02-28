function show() {
    let inputAmount = document.getElementById("amount");
    let fromCurrrency = document.getElementById("fromCurrency");
    let toCurrency = document.getElementById("toCurrency");
    let total;
    let amount = parseInt(inputAmount.value);

    if (fromCurrrency.value === "vietnam" && toCurrency.value === "usd") {
        total = amount / 23000;
    }
    else if (fromCurrrency.value === "usd" && toCurrency.value === "vietnam") {
        total = amount * 23000;
    }
    else if (fromCurrrency.value === "vietnam" && toCurrency.value=== "vietnam") {
        total = amount;
    }
    else if (fromCurrrency.value === "usd" && toCurrency.value === "usd") {
        total = amount;
    }
    result.innerText = total;
}