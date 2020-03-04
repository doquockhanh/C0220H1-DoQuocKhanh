function clickYes() {
    alert("<3");
}

function clickNo() {
    //math.round lay gia tri nguyen gan nhat (ex : 2.5 = 3)
    var x = Math.round(Math.random() * window.innerWidth);
    var y = Math.round(Math.random() * window.innerHeight);
    document.getElementById('btnNo').style.left = x + 'px';
    document.getElementById('btnNo').style.top = y + 'px';
}