let bar = new Image();
bar.src = "ImageSrc/bar.png";
let runMan = new Image();
runMan.src = "ImageSrc/runMan.png";
let backGround = new Image();
backGround.src = "ImageSrc/background.PNG";
let present = new Image();
present.src = "ImageSrc/giftBox.png";

let canvas = document.getElementById("gameCanvas");
let ctx = canvas.getContext("2d");
let game;


function thresh() {
    game = new Game();
    gameScore();
    for (let i = 0; i < 4; i++) {
        randomMap(game.map, i);
    }
    gamePlay();
    setTimeout(createGift, 10000);
}

function gamePlay() {
    game.draw();
    game.update();
    game.checkCollision();
    requestAnimationFrame(gamePlay);
}

function keyDown(event) {
    switch (event.keyCode) {
        case 38:
            game.onKeyUpDown();
            timeJump();
            break;
        case 32:
            if(game.status === GAME_PLAYING) {
                game.status = GAME_STOP;
            }else game.status = GAME_PLAYING;
            break;

    }
}